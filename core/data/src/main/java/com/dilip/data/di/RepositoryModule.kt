package com.dilip.data.di

import com.dilip.data.repository.EmailRepositoryImpl
import com.dilip.domain.repository.EmailRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindEmailRepository(emailRepositoryImpl: EmailRepositoryImpl): EmailRepository
}
