package com.example.trackster.perfTracker.localData


import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject


class StratumRepository @Inject constructor(
    private val stratumDao: StratumDao
) {
    suspend fun createStratum(stratum: StratumEntity) = withContext(Dispatchers.IO) {
       // val localDb = perfTrackerLocalDb.getInstance(context)
       // val stratumDao = localDb.stratumDao()
        stratumDao.insertStratum(stratum)
    }
   /*suspend fun createStratum(

        className:String,
        courseName:String,
        totalTasks: Int,
        breakPoints: Int
    ) {
        val localDb = perfTrackerLocalDb.getInstance(context)
        val stratumDao = localDb.stratumDao()
        stratumDao.insertStratum(
            className,
            courseName,
            totalTasks,
            breakPoints
        )
    }*/
}