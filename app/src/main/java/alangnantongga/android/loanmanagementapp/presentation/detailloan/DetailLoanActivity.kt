package alangnantongga.android.loanmanagementapp.presentation.detailloan

import alangnantongga.android.loanmanagementapp.Constant
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import alangnantongga.android.loanmanagementapp.R
import alangnantongga.android.loanmanagementapp.databinding.ActivityDetailLoanBinding
import android.content.Context
import android.content.Intent

class DetailLoanActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailLoanBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =  ActivityDetailLoanBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra("BORROWER_NAME")
        val email = intent.getStringExtra("EMAIL")
        val score = intent.getIntExtra("CREDIT_SCORE", 0)
        val clType = intent.getStringExtra("COLLATERAL_TYPE")
        val clValue = intent.getIntExtra("COLLATERAL_VALUE", 0)

        binding.tvName.text = name
        binding.tvEmail.text = email.toString()
        binding.tvCreditScore.text = score.toString()
        binding.tvCollateralType.text = clType.toString()
        binding.tvCollateralValue.text = clValue.toString()

    }

}