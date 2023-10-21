package com.example.trackster.perfTracker.learnerGroup.domain


import com.example.trackster.perfTracker.learnerGroup.LearnerGroupMapper.LearnerGroupMapper
import com.example.trackster.perfTracker.localData.LearnerGroupDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject


class LocalLearnerGroupRepositoryImp @Inject constructor(
    private val learnerGroupDao: LearnerGroupDao,
    private val learnerGroupMapper: LearnerGroupMapper
): ILearnerGroupRepository {
    override suspend fun createLearnerGroup(learnerGroupModel: LearnerGroupModel) = withContext(Dispatchers.IO) {
        //mapping model got from ui to entity which will be stored in database
        //val stratumMapper= StratumMapper()
       val stratumEntity = learnerGroupMapper.mapFromModelToEntity(learnerGroupModel)
        learnerGroupDao.insertLearnerGroup(stratumEntity)

    }

//    override suspend fun createStratum(stratumModel: StratumModel) {
//        TODO("Not yet implemented")
//    }

    override suspend fun getLearnerGroup(): List<LearnerGroupModel> {
        val entities = learnerGroupDao.getLearnerGroup()
        return entities.map {
            learnerGroupMapper.mapFromEntityToModel(it)
        }
    }
}