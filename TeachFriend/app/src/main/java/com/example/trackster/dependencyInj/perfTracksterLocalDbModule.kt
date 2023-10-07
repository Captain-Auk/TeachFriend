package com.example.trackster.dependencyInj


import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.trackster.perfTracker.localData.StratumDao
import com.example.trackster.perfTracker.localData.StratumRepository
import com.example.trackster.perfTracker.localData.PerfTrackerLocalDb
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn

import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {
    private var INSTANCE: PerfTrackerLocalDb? = null

    @Provides
    @Singleton
    fun provideContext(application: Application): Context {
        return application
    }

    @Provides
    fun providesDatabaseInstance(context: Context): PerfTrackerLocalDb {
        return INSTANCE ?: synchronized(this) {
            val instance = Room.databaseBuilder(
                context.applicationContext,
                PerfTrackerLocalDb::class.java,
                "trackster_database"
            )
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
        fun provideStratumDao(database: PerfTrackerLocalDb): StratumDao {
            return database.StratumDao()
        }
        @Provides
        fun providesStratumRepository(stratumDao: StratumDao): StratumRepository {
            return StratumRepository(stratumDao)
        }
}

