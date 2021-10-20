package com.geanbrandao.compose.cleanarchitecture.navigationcomponents.di

import com.geanbrandao.compose.cleanarchitecture.navigationcomponents.network.ApiService
import com.geanbrandao.compose.cleanarchitecture.navigationcomponents.network.ApiServiceImpl
import com.geanbrandao.compose.cleanarchitecture.navigationcomponents.repository.Repository
import com.geanbrandao.compose.cleanarchitecture.navigationcomponents.repository.RepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.features.logging.Logging
import io.ktor.client.features.logging.LogLevel
import kotlinx.serialization.json.Json
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
                    serializer = KotlinxSerializer(json = Json {
                        isLenient = true
                        ignoreUnknownKeys = true
                    })
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