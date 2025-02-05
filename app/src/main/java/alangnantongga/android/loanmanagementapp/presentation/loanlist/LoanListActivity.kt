package alangnantongga.android.loanmanagementapp.presentation.loanlist

import alangnantongga.android.loanmanagementapp.adapter.LoanListAdapter
import alangnantongga.android.loanmanagementapp.databinding.ActivityLoanListBinding
import alangnantongga.android.loanmanagementapp.presentation.LoanListViewModel
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoanListBinding
    private val viewModel: LoanListViewModel by viewModels()
    private lateinit var adapter: LoanListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoanListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = LoanListAdapter()

        viewModel.loanList.observe(this) { loan ->
            adapter.setData(loan)
        }
        viewModel.getLoanListData()

        binding.rvList.layoutManager = LinearLayoutManager(this)
        binding.rvList.adapter = adapter

    }

}