package alangnantongga.android.loanmanagementapp

fun emptyString(): String = ""

fun Int?.orZero(): Int {
    return this ?: 0
}