package alangnantongga.android.loanmanagementapp.adapter

import alangnantongga.android.loanmanagementapp.data.LoanItemResponse
import alangnantongga.android.loanmanagementapp.databinding.ItemLoanListBinding
import alangnantongga.android.loanmanagementapp.domain.Loan
import alangnantongga.android.loanmanagementapp.presentation.LoanListMapper.toDomainModel
import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class LoanListAdapter(
): RecyclerView.Adapter<LoanListAdapter.ViewHolder>(){

    private var data = ArrayList<Loan>()

    @SuppressLint("NotifyDataSetChanged")
    fun setData(dataList: List<Loan>) {
        data.clear()
        data.addAll(dataList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        ItemLoanListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder.view) {
            val data = data[position]

            tvName.text = data.borrower.name
            tvLoanAmount.text = data.amount.toString()
            tvTerm.text = data.term.toString()
            tvPurpose.text = data.purpose
            tvInterestRate.text = data.interestRate.toString()
            tvRiskRating.text = data.riskRating
        }
    }

    override fun getItemCount(): Int = data.size

    class ViewHolder(val view: ItemLoanListBinding) : RecyclerView.ViewHolder(view.root)
}