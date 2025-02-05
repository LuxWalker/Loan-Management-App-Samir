package alangnantongga.android.loanmanagementapp.presentation

import alangnantongga.android.loanmanagementapp.data.BorrowerItemResponse
import alangnantongga.android.loanmanagementapp.data.CollateralResponse
import alangnantongga.android.loanmanagementapp.data.DocumentsItemResponse
import alangnantongga.android.loanmanagementapp.data.InstallmentsItemResponse
import alangnantongga.android.loanmanagementapp.data.LoanItemResponse
import alangnantongga.android.loanmanagementapp.data.RepaymentScheduleResponse
import alangnantongga.android.loanmanagementapp.domain.Borrower
import alangnantongga.android.loanmanagementapp.domain.Collateral
import alangnantongga.android.loanmanagementapp.domain.Document
import alangnantongga.android.loanmanagementapp.domain.Installment
import alangnantongga.android.loanmanagementapp.domain.Loan
import alangnantongga.android.loanmanagementapp.domain.RepaymentSchedule

object LoanListMapper {

    fun LoanItemResponse.toDomainModel(): Loan =
        Loan(
            interestRate = interestRate.orZero(),
            amount =  amount.orZero(),
            purpose = purpose.orEmpty(),
            documents = documents?.map { it.toDomainModel() } ?: emptyList(),
            borrower = borrower?.toDomainModel() ?: Borrower(0, "", "", ""),
            term = term.orZero(),
            id = id.orEmpty(),
            collateral = collateral?.toDomainModel() ?: Collateral("",0),
            repaymentSchedule = repaymentSchedule?.toDomainModel(),
            riskRating = riskRating.orEmpty()
        )

    fun BorrowerItemResponse.toDomainModel(): Borrower =
        Borrower(
            creditScore = creditScore.orZero(),
            name = name.orEmpty(),
            id = id.orEmpty(),
            email = email.orEmpty()
        )
    fun DocumentsItemResponse.toDomainModel(): Document =
        Document(
            type = type.orEmpty(),
            url = url.orEmpty()
        )

    fun CollateralResponse.toDomainModel(): Collateral =
        Collateral(
            type = type.orEmpty(),
            value = value.orZero()
        )

    fun RepaymentScheduleResponse.toDomainModel(): RepaymentSchedule =
        RepaymentSchedule(
            installments = installments?.map { it.toDomainModel() } ?: emptyList()
        )

    fun InstallmentsItemResponse.toDomainModel(): Installment =
        Installment(
            amountDue = amountDue.orZero(),
            dueDate = dueDate.orEmpty()
        )

    private fun Int?.orZero(): Int = this ?: 0
    private fun Double?.orZero(): Double = this ?: 0.0
}