package com.dilip.domain.repository

import com.dilip.common.error.Failure
import com.dilip.common.functional.Either
import com.dilip.domain.model.emaildetails.EmailDetailsModel
import com.dilip.domain.model.emaillist.EmailListItemModel

interface EmailRepository {
    suspend fun getEmailList() : Either<Failure, List<EmailListItemModel>>
    suspend fun getEmailDetails() : Either<Failure, EmailDetailsModel>
}
