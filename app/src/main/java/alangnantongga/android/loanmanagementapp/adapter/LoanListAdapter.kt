package alangnantongga.android.loanmanagementapp.adapter

import alangnantongga.android.loanmanagementapp.databinding.ItemLoanListBinding
import alangnantongga.android.loanmanagementapp.model.LoanListResponseItem
import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class LoanListAdapter(
    private val selectLoan: (LoanListResponseItem?, seeDetails: Boolean?) -> Unit
): RecyclerView.Adapter<LoanListAdapter.ViewHolder>(){

    private var data = ArrayList<LoanListResponseItem>()

    @SuppressLint("NotifyDataSetChanged")
    fun setData(dataList: List<LoanListResponseItem>) {
        data.clear()
        data.addAll(dataList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        ItemLoanListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder.itemView) {
            val data = data.getOrNull(position)

            setOnClickListener {
                selectLoan.invoke(data, true)
            }
        }
    }

    override fun getItemCount(): Int = data.size

    class ViewHolder(val view: ItemLoanListBinding) : RecyclerView.ViewHolder(view.root)
}