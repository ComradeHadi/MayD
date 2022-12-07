package com.hadi.maydapp.data.injections

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class HttpModule {
    @Singleton
    @Provides
    fun provideApiKeyInterceptor() = ApiKeyInterceptor()

    @Singleton
    @Provides
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        return logging
    }

    @Singleton
    @Provides
    fun getAuthorizedOkHttpClient(
        interceptor: ApiKeyInterceptor,
        loggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient {

        return OkHttpClient.Builder()
            .connectTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS) // write timeout
            .readTimeout(60, TimeUnit.SECONDS) // read timeout
            .addInterceptor(interceptor)
            .addInterceptor(loggingInterceptor)
            .build()
    }
}
