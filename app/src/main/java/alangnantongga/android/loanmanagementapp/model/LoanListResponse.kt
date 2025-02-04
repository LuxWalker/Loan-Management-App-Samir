package alangnantongga.android.loanmanagementapp.model

import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

@Parcelize
data class LoanListResponse(

	@field:SerializedName("LoanListResponse")
	val loanListResponse: List<LoanListResponseItem>
) : Parcelable

@Parcelize
data class LoanListResponseItem(

	@field:SerializedName("interestRate")
	val interestRate: Int,

	@field:SerializedName("amount")
	val amount: Int,

	@field:SerializedName("purpose")
	val purpose: String,

	@field:SerializedName("documents")
	val documents: List<DocumentsItem>,

	@field:SerializedName("borrower")
	val borrower: Borrower,

	@field:SerializedName("term")
	val term: Int,

	@field:SerializedName("id")
	val id: String,

	@field:SerializedName("collateral")
	val collateral: Collateral,

	@field:SerializedName("repaymentSchedule")
	val repaymentSchedule: RepaymentSchedule,

	@field:SerializedName("riskRating")
	val riskRating: String
) : Parcelable

@Parcelize
data class Collateral(

	@field:SerializedName("type")
	val type: String,

	@field:SerializedName("value")
	val value: Int
) : Parcelable

@Parcelize
data class InstallmentsItem(

	@field:SerializedName("amountDue")
	val amountDue: Int,

	@field:SerializedName("dueDate")
	val dueDate: String
) : Parcelable

@Parcelize
data class Borrower(

	@field:SerializedName("creditScore")
	val creditScore: Int,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("id")
	val id: String,

	@field:SerializedName("email")
	val email: String
) : Parcelable

@Parcelize
data class DocumentsItem(

	@field:SerializedName("type")
	val type: String,

	@field:SerializedName("url")
	val url: String
) : Parcelable

@Parcelize
data class RepaymentSchedule(

	@field:SerializedName("installments")
	val installments: List<InstallmentsItem>
) : Parcelable
