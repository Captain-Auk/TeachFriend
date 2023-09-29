package com.example.trackster.dependencyInj

import com.example.trackster.DataLayer.RemoteDataSource
import com.example.trackster.DataLayer.authRepositoryImp
import com.example.trackster.DomainLayer.authRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class authRepoModule {
    @Provides
    @Singleton
    //below both are same
   /* fun providesAuthRepository(authRepositoryImp: authRepositoryImp): authRepository{
        return authRepositoryImp*/
        fun providesAuthRepository( remoteDataSource: RemoteDataSource): authRepository{
            return authRepositoryImp(remoteDataSource)
    }
}