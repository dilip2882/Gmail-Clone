package com.dilip.data.repository

import com.dilip.data.dto.emaillist.EmailListItemDto
import com.dilip.data.dto.emaillist.Payload
import com.dilip.common.error.Failure
import com.dilip.common.functional.Either
import com.dilip.data.dto.emaildetails.Body
import com.dilip.data.dto.emaildetails.EmailDetailsDto
import com.dilip.data.dto.emaildetails.SenderInfo
import com.dilip.data.mapper.EmailDetailsMapper
import com.dilip.data.mapper.EmailListMapper
import com.dilip.data.remote.api.ApiService
import com.dilip.data.remote.handler.safeApiCall
import com.dilip.domain.model.emaillist.EmailListItemModel
import com.dilip.domain.repository.EmailRepository
import kotlinx.coroutines.runBlocking
import retrofit2.Response
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

/*fun main() =
    runBlocking {
        // Create mock instances
        val apiService = MockApiService()
        val emailListMapper = EmailListMapper()
        val emailDetailsMapper = EmailDetailsMapper()

        // Initialize EmailRepositoryImpl with mock dependencies
        val emailRepository = EmailRepositoryImpl(apiService, emailListMapper, emailDetailsMapper)

        // Test getEmailList
        val emailListResult = emailRepository.getEmailList()
        println("Email List Result: $emailListResult")

        // Test getEmailDetails
        val emailDetailsResult = emailRepository.getEmailDetails()
        println("Email Details Result: $emailDetailsResult")
    }

class MockApiService : ApiService {
    override suspend fun getEmailList(): Response<ArrayList<EmailListItemDto>> {
        val mockEmailList = arrayListOf(
            EmailListItemDto(
                hasAttachments = false,
                id = "1",
                isImportant = true,
                isPromotional = false,
                payload = Payload("", "", "Dilip Patel", "", ""),
                snippet = "Mock snippet",
                subject = "Mock subject",
                threadId = "thread-1",
                timestamp = 1
            )
        )
        return Response.success(mockEmailList)
    }

    override suspend fun getEmailDetail(): Response<ArrayList<EmailDetailsDto>> {
        val mockEmailDetails = arrayListOf(
            EmailDetailsDto(
                id = "1",
                body = Body("", ""),
                timestamp = 2,
                isPromotional = false,
                hasAttachments = false,
                isImportant = false,
                labels = emptyList(),
                snippet = "",
                threadId = "",
                payload = com.dilip.data.dto.emaildetails.Payload(
                    date = "",
                    attachments = emptyList(),
                    subject = "",
                    cc = emptyList(),
                    to = emptyList(),
                    bcc = emptyList(),
                    senderInfo = SenderInfo(
                        profileImage = "",
                        email = "coroutinelab@test.com",
                        name = "coroutinelab"
                    )
                )
            )
        )
        return Response.success(mockEmailDetails)
    }
}*/

