package alangnantongga.android.loanmanagementapp.networking

import alangnantongga.android.loanmanagementapp.data.LoanItemResponse
import retrofit2.http.GET

interface ApiService {

    @GET("main/api/json/loans.json")
    suspend fun getLoanList(): List<LoanItemResponse>
}