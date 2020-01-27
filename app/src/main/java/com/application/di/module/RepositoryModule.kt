package com.application.di.module

import android.app.Application
import androidx.room.Room
import com.application.net.RestApi
import com.application.repository.LocalDataRepository
import com.application.repository.LocalDatabase
import com.application.repository.MyRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideRepository(restApi: RestApi): MyRepository = MyRepository(restApi)

    @Provides
    @Singleton
    fun provideLocalDatabase(application: Application): LocalDatabase =
        Room.databaseBuilder(
            application.applicationContext,
            LocalDatabase::class.java,
            "database-name"
        )
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    @Singleton
    fun provideLocalDataRepository(localDatabase: LocalDatabase): LocalDataRepository =
        LocalDataRepository(localDatabase)
}