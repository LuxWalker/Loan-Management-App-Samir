package alangnantongga.android.loanmanagementapp.module

import alangnantongga.android.loanmanagementapp.adapter.LoanListAdapter
import alangnantongga.android.loanmanagementapp.domain.Loan
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
object LoanModule {
    @Provides
    fun provideLoanList(): ArrayList<Loan> = arrayListOf()

    @Provides
    fun provideLoanListAdapter(loans: ArrayList<Loan>): LoanListAdapter {
        return LoanListAdapter(loans)
    }
}