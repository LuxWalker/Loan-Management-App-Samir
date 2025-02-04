package alangnantongga.android.loanmanagementapp.presentation

import alangnantongga.android.loanmanagementapp.adapter.LoanListAdapter
import alangnantongga.android.loanmanagementapp.databinding.ActivityLoanListBinding
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var activityMainBinding: ActivityLoanListBinding
    private lateinit var viewModel: LoanListViewModel
    private lateinit var adapter: LoanListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityLoanListBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)
    }

}