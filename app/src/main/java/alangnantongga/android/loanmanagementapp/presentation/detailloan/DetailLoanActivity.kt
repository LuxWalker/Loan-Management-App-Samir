package alangnantongga.android.loanmanagementapp.presentation.detailloan

import alangnantongga.android.loanmanagementapp.BuildConfig.BASE_URL
import alangnantongga.android.loanmanagementapp.Constant.AMOUNT_DUE
import alangnantongga.android.loanmanagementapp.Constant.BORROWER_NAME
import alangnantongga.android.loanmanagementapp.Constant.COLLATERAL_TYPE
import alangnantongga.android.loanmanagementapp.Constant.COLLATERAL_VALUE
import alangnantongga.android.loanmanagementapp.Constant.CREDIT_SCORE
import alangnantongga.android.loanmanagementapp.Constant.DOCUMENT_URL
import alangnantongga.android.loanmanagementapp.Constant.DUE_DATE
import alangnantongga.android.loanmanagementapp.Constant.EMAIL
import alangnantongga.android.loanmanagementapp.databinding.ActivityDetailLoanBinding
import alangnantongga.android.loanmanagementapp.presentation.documentViewer.DocumentViewActivity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class DetailLoanActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailLoanBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =  ActivityDetailLoanBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent.getStringExtra(BORROWER_NAME)
        val email = intent.getStringExtra(EMAIL)
        val score = intent.getIntExtra(CREDIT_SCORE, 0)
        val clType = intent.getStringExtra(COLLATERAL_TYPE)
        val clValue = intent.getIntExtra(COLLATERAL_VALUE, 0)
        val dueDate = intent.getStringExtra(DUE_DATE)
        val amountDue = intent.getIntExtra(AMOUNT_DUE, 0)
        val documentPath = intent.getStringExtra(DOCUMENT_URL)

        binding.tvName.text = name
        binding.tvEmail.text = email.toString()
        binding.tvCreditScore.text = score.toString()
        binding.tvCollateralType.text = clType.toString()
        binding.tvCollateralValue.text = clValue.toString()
        binding.tvDueDate.text = dueDate.toString()
        binding.tvAmountDue.text = amountDue.toString()

        binding.btnViewDocuments.setOnClickListener {
            val intent = Intent(this, DocumentViewActivity::class.java).apply {
                putExtra("IMAGE_PATH", BASE_URL + "refs/heads/main" + documentPath)
            }
            startActivity(intent)
        }

    }

}