package alangnantongga.android.loanmanagementapp.presentation.loanlist

import alangnantongga.android.loanmanagementapp.domain.Loan
import alangnantongga.android.loanmanagementapp.repository.ListRepository
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class LoanListViewModel @Inject constructor() : ViewModel() {
    private val repository = ListRepository()
    val loanList: LiveData<List<Loan>> get() = repository.loanList

    fun getLoanListData(){
        viewModelScope.launch {
            repository.getLoanList()
        }
    }
}