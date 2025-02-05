package alangnantongga.android.loanmanagementapp.domain

import alangnantongga.android.loanmanagementapp.emptyString

data class Loan(
    val interestRate: Double = 0.0,
    val amount: Int = 0,
    val purpose: String = emptyString(),
    val documents: List<Document>,
    val borrower: Borrower,
    val term: Int = 0,
    val id: String = emptyString(),
    val collateral: Collateral,
    val repaymentSchedule: RepaymentSchedule?,
    val riskRating: String = emptyString()
)

data class Borrower(
    val creditScore: Int = 0,
    val name: String = emptyString(),
    val id: String = emptyString(),
    val email: String = emptyString()
)

data class Document(
    val type: String = emptyString(),
    val url: String = emptyString()
)

data class Collateral(
    val type: String = emptyString(),
    val value: Int = 0
)

data class RepaymentSchedule(
    val installments: List<Installment> =  emptyList()
)

data class Installment(
    val amountDue: Int = 0,
    val dueDate: String = emptyString()
)