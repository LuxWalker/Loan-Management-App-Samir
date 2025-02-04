package alangnantongga.android.loanmanagementapp.networking

import alangnantongga.android.loanmanagementapp.model.LoanListResponse
import alangnantongga.android.loanmanagementapp.model.LoanListResponseItem
import android.database.Observable
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("andreascandle/p2p_json_test/main/api/json/loans.json")
    fun getLoanList(): Observable<List<LoanListResponseItem>>
}