package com.example.trackster.dependencyInj


import com.example.trackster.userAuthentication.data.AuthRemoteDataSource
import com.example.trackster.userAuthentication.data.IAuthRepositoryImp
import com.example.trackster.userAuthentication.data.IAuthRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class AuthRepoModule {

    @Provides
    @Singleton
    //below both are same
   /* fun providesAuthRepository(authRepositoryImp: authRepositoryImp): authRepository{
        return authRepositoryImp*/
        fun providesAuthRepository(authRemoteDataSource: AuthRemoteDataSource): IAuthRepository {
            return IAuthRepositoryImp(authRemoteDataSource)
    }
}