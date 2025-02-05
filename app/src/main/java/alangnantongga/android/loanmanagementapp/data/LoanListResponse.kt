package alangnantongga.android.loanmanagementapp.data

import kotlinx.parcelize.Parcelize
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

@Parcelize
data class LoanListResponse(

	@field:SerializedName("LoanListResponse")
	val loanListResponse: List<LoanItemResponse>? = null
) : Parcelable

@Parcelize
data class LoanItemResponse(

	@field:SerializedName("interestRate")
	val interestRate: Double? = null,

	@field:SerializedName("amount")
	val amount: Int? = null,

	@field:SerializedName("purpose")
	val purpose: String? = null,

	@field:SerializedName("documents")
	val documents: List<DocumentsItemResponse>? = null,

	@field:SerializedName("borrower")
	val borrower: BorrowerItemResponse? = null,

	@field:SerializedName("term")
	val term: Int? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("collateral")
	val collateral: CollateralResponse? = null,

	@field:SerializedName("repaymentSchedule")
	val repaymentSchedule: RepaymentScheduleResponse? = null,

	@field:SerializedName("riskRating")
	val riskRating: String? = null
) : Parcelable

@Parcelize
data class CollateralResponse(

	@field:SerializedName("type")
	val type: String? = null,

	@field:SerializedName("value")
	val value: Int? = null
) : Parcelable

@Parcelize
data class InstallmentsItemResponse(

	@field:SerializedName("amountDue")
	val amountDue: Int? = null,

	@field:SerializedName("dueDate")
	val dueDate: String? = null
) : Parcelable

@Parcelize
data class BorrowerItemResponse(

	@field:SerializedName("creditScore")
	val creditScore: Int? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("email")
	val email: String? = null
) : Parcelable

@Parcelize
data class DocumentsItemResponse(

	@field:SerializedName("type")
	val type: String? = null,

	@field:SerializedName("url")
	val url: String? = null
) : Parcelable

@Parcelize
data class RepaymentScheduleResponse(

	@field:SerializedName("installments")
	val installments: List<InstallmentsItemResponse>? = null
) : Parcelable
