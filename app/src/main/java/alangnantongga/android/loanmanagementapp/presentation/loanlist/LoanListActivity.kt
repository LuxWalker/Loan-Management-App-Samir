package alangnantongga.android.loanmanagementapp.presentation.loanlist

import alangnantongga.android.loanmanagementapp.adapter.LoanListAdapter
import alangnantongga.android.loanmanagementapp.databinding.ActivityLoanListBinding
import alangnantongga.android.loanmanagementapp.domain.Loan
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.SearchView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class LoanListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoanListBinding
    private val viewModel: LoanListViewModel by viewModels()
    private var loanList = ArrayList<Loan>()
    private var selectedSortOption: String = ""

    @Inject
    lateinit var adapter: LoanListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoanListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = LoanListAdapter(loanList)
        binding.rvList.layoutManager = LinearLayoutManager(this)
        binding.rvList.adapter = adapter

        setupSearchView()
        setupFilterDropdown()
        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.loanList.observe(this) { loans ->
            loanList.clear()
            loanList.addAll(loans)
            adapter.setData(loans)
        }
        viewModel.getLoanListData()
    }

    private fun setupSearchView() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                adapter.filterAndSortLoans(query.orEmpty(), selectedSortOption)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                adapter.filterAndSortLoans(newText.orEmpty(), selectedSortOption)
                return true
            }
        })
    }

    private fun setupFilterDropdown() {
        val sortOptions = arrayOf("Amount", "Term", "Purpose")
        val spinnerAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, sortOptions)
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        binding.sortSpinner.adapter = spinnerAdapter

        binding.sortSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                selectedSortOption = sortOptions[position].lowercase()
                adapter.filterAndSortLoans(binding.searchView.query.toString(), selectedSortOption)
            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }
    }
}