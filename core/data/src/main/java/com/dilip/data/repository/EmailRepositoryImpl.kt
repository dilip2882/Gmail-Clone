package com.dilip.data.repository

import com.dilip.common.error.Failure
import com.dilip.common.functional.Either
import com.dilip.data.mapper.EmailDetailsMapper
import com.dilip.data.mapper.EmailListMapper
import com.dilip.data.remote.api.ApiService
import com.dilip.data.remote.handler.safeApiCall
import com.dilip.domain.model.emaillist.EmailListItemModel
import com.dilip.domain.repository.EmailRepository
import javax.inject.Inject

class EmailRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val emailListMapper: EmailListMapper,
    private val emailDetailsMapper: EmailDetailsMapper
) : EmailRepository {
    override suspend fun getEmailList(): Either<Failure, List<EmailListItemModel>> = safeApiCall(
        apiCall = { apiService.getEmailList() },
        mapper = { emailListMapper.map(it) }
    )

    override suspend fun getEmailDetails() = safeApiCall(
        apiCall = { apiService.getEmailDetail() },
        mapper = { emailDetailsMapper.map(it) }
    )
}
