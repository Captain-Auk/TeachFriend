package com.example.trackster.perfTracker.learnerGroup.LearnerGroupMapper

import com.example.trackster.perfTracker.learnerGroup.domain.LearnerGroupModel
import com.example.trackster.perfTracker.localData.LearnerGroupEntity
import javax.inject.Inject

/**
 * the StratumMapper class is used to map the Domain StratumModel object to the Data StratumEntity
 object in perfTrackerEntity.kt file
 * This allows us to keep the logic for mapping data between the two formats in a single place,
 making our code more modular and easier to maintain.
 */
class LearnerGroupMapper @Inject constructor() {
    fun mapFromEntityToModel(learnerGroupEntity: LearnerGroupEntity): LearnerGroupModel {
        return LearnerGroupModel(
            learnerGroupId = learnerGroupEntity.learnerGroupId,
            className = learnerGroupEntity.className,
            courseName = learnerGroupEntity.courseName,
            totalTasks = learnerGroupEntity.totalTasks,
            breakPoints = learnerGroupEntity.breakPoints
        )
    }

    fun mapFromModelToEntity(learnerGroupModel: LearnerGroupModel): LearnerGroupEntity {
        return LearnerGroupEntity(
            learnerGroupId = learnerGroupModel.learnerGroupId,
            className = learnerGroupModel.className,
            courseName = learnerGroupModel.courseName,
            totalTasks = learnerGroupModel.totalTasks,
            breakPoints = learnerGroupModel.breakPoints
        )
    }
}