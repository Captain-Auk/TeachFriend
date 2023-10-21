package com.example.trackster.dependencyInj


import android.content.Context
import androidx.room.Room
import com.example.trackster.perfTracker.learnerGroup.domain.ILearnerGroupRepository
import com.example.trackster.perfTracker.localData.LearnerGroupDao
import com.example.trackster.perfTracker.learnerGroup.domain.LocalLearnerGroupRepositoryImp
import com.example.trackster.perfTracker.localData.PerfTrackerLocalDb
import com.example.trackster.perfTracker.learnerGroup.LearnerGroupMapper.LearnerGroupMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext

import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {
    private var INSTANCE: PerfTrackerLocalDb? = null

//    @Provides
//    @Singleton
//    fun provideContext(application: Application): Context {
//        return application
//    }

    @Provides
    fun providesDatabaseInstance(@ApplicationContext context: Context): PerfTrackerLocalDb {
        return INSTANCE ?: synchronized(this) {
            val instance = Room.databaseBuilder(
                context.applicationContext,
                PerfTrackerLocalDb::class.java,
                "trackster_database"
            )
                .fallbackToDestructiveMigration()
                .build()
            INSTANCE = instance
            return instance
        }
    }
      /*  @Provides
        @Singleton
        fun providesDatabaseInstance(context: Context): perfTrackerLocalDb =
            Room.databaseBuilder(
            context.applicationContext,
            perfTrackerLocalDb::class.java,
            "trackster_database"
        )
            .build()*/

        @Provides
        fun provideStratumDao(database: PerfTrackerLocalDb): LearnerGroupDao {
            return database.StratumDao()
        }

//        @Provides
////        fun providesStratumRepository(stratumDao: StratumDao): LocalStratumRepositoryImp {
////            return LocalStratumRepositoryImp(stratumDao)
////        }

    @Provides
    fun provideLocalStratumRepository(learnerGroupDao: LearnerGroupDao,
                                      learnerGroupMapper: LearnerGroupMapper): ILearnerGroupRepository {
        return LocalLearnerGroupRepositoryImp(learnerGroupDao, learnerGroupMapper)
    }

//    @Provides
//    fun provideRemoteStratumRepository(): IStratumRepository {
//        return RemoteStratumRepository()
//    }
}

