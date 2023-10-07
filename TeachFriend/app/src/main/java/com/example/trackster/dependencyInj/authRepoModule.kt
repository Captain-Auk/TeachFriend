package com.example.trackster.dependencyInj


import com.example.trackster.userAuthentication.data.authRemoteDataSource
import com.example.trackster.userAuthentication.data.authRepositoryImp
import com.example.trackster.userAuthentication.data.authRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
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
        fun providesAuthRepository(authRemoteDataSource: authRemoteDataSource): authRepository {
            return authRepositoryImp(authRemoteDataSource)
    }
}