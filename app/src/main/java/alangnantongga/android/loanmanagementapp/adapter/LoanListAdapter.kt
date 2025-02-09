package alangnantongga.android.loanmanagementapp.adapter

import alangnantongga.android.loanmanagementapp.Constant.AMOUNT_DUE
import alangnantongga.android.loanmanagementapp.Constant.BORROWER_NAME
import alangnantongga.android.loanmanagementapp.Constant.COLLATERAL_TYPE
import alangnantongga.android.loanmanagementapp.Constant.COLLATERAL_VALUE
import alangnantongga.android.loanmanagementapp.Constant.CREDIT_SCORE
import alangnantongga.android.loanmanagementapp.Constant.DOCUMENT_URL
import alangnantongga.android.loanmanagementapp.Constant.DUE_DATE
import alangnantongga.android.loanmanagementapp.Constant.EMAIL
import alangnantongga.android.loanmanagementapp.databinding.ItemLoanListBinding
import alangnantongga.android.loanmanagementapp.domain.Loan
import alangnantongga.android.loanmanagementapp.presentation.detailloan.DetailLoanActivity
import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import javax.inject.Inject

class LoanListAdapter @Inject constructor(private val allLoans: ArrayList<Loan>) :
    RecyclerView.Adapter<LoanListAdapter.ViewHolder>() {

    private val displayedLoans = ArrayList<Loan>()

    init {
        displayedLoans.addAll(allLoans)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setData(dataList: List<Loan>) {
        allLoans.clear()
        allLoans.addAll(dataList)
        updateLoans(dataList)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        ItemLoanListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val loan = displayedLoans[position]
        with(holder.view) {
            tvName.text = loan.borrower.name
            tvLoanAmount.text = loan.amount.toString()
            tvTerm.text = loan.term.toString()
            tvPurpose.text = loan.purpose
            tvInterestRate.text = loan.interestRate.toString()
            tvRiskRating.text = loan.riskRating
            btnDetail.setOnClickListener {
                val intent = Intent(it.context, DetailLoanActivity::class.java).apply {
                    putExtra(BORROWER_NAME, loan.borrower.name)
                    putExtra(EMAIL, loan.borrower.email)
                    putExtra(CREDIT_SCORE, loan.borrower.creditScore)
                    putExtra(COLLATERAL_TYPE, loan.collateral.type)
                    putExtra(COLLATERAL_VALUE, loan.collateral.value)
                    putExtra(DUE_DATE, loan.repaymentSchedule!!.installments[0].dueDate)
                    putExtra(AMOUNT_DUE, loan.repaymentSchedule.installments[0].amountDue)
                    putExtra(DOCUMENT_URL, loan.documents[0].url)
                }
                it.context.startActivity(intent)
            }
        }
    }

    override fun getItemCount(): Int = displayedLoans.size

    class ViewHolder(val view: ItemLoanListBinding) : RecyclerView.ViewHolder(view.root)

    fun updateLoans(newLoans: List<Loan>) {
        displayedLoans.clear()
        displayedLoans.addAll(newLoans)
        notifyDataSetChanged()
    }

    fun filterAndSortLoans(query: String, sortBy: String) {
        val filteredLoans = allLoans.filter { it.borrower.name.contains(query, ignoreCase = true) }

        val sortedLoans = when (sortBy.lowercase()) {
            "name" -> filteredLoans.sortedBy { it.borrower.name }
            "amount" -> filteredLoans.sortedBy { it.amount }
            "term" -> filteredLoans.sortedByDescending  { it.term }
            "purpose" -> filteredLoans.sortedBy { it.purpose }
            else -> filteredLoans
        }

        updateLoans(sortedLoans)
    }
}