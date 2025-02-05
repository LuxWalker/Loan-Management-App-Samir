package alangnantongga.android.loanmanagementapp.repository

import alangnantongga.android.loanmanagementapp.data.LoanItemResponse
import alangnantongga.android.loanmanagementapp.data.LoanListResponse
import alangnantongga.android.loanmanagementapp.domain.Loan
import alangnantongga.android.loanmanagementapp.networking.RetrofitBuilder
import alangnantongga.android.loanmanagementapp.presentation.LoanListMapper
import alangnantongga.android.loanmanagementapp.presentation.LoanListMapper.toDomainModel
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class ListRepository @Inject constructor(){

    private val _loanList = MutableLiveData<List<Loan>>()
    val loanList: LiveData<List<Loan>> get() = _loanList

    suspend fun getLoanList(){
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = RetrofitBuilder.apiService.getLoanList()
                val mappedLoan = response.map { it.toDomainModel() }
                _loanList.postValue(mappedLoan)
            } catch (e: Exception) {
                _loanList.postValue(emptyList())
            }
        }
    }
}