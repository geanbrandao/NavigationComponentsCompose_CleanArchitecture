package com.geanbrandao.compose.cleanarchitecture.navigationcomponents.di

import com.geanbrandao.compose.cleanarchitecture.navigationcomponents.network.ApiService
import com.geanbrandao.compose.cleanarchitecture.navigationcomponents.network.ApiServiceImpl
import com.geanbrandao.compose.cleanarchitecture.navigationcomponents.repository.Repository
import com.geanbrandao.compose.cleanarchitecture.navigationcomponents.repository.RepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApi(): ApiService {
        return ApiServiceImpl(
            client = HttpClient(Android) {
                install(Logging) {
                    level = LogLevel.BODY
                }
                install(JsonFeature) {
                    serializer = KotlinxSerializer()
                }
            }
        )
    }

    @Provides
    @Singleton
    fun provideRepository(api: ApiService): Repository {
        return RepositoryImpl(api = api)
    }
}