package com.example.trackster.perfTracker.learnerGroup.domain

interface ILearnerGroupRepository {
    suspend fun createLearnerGroup(learnerGroupModel: LearnerGroupModel)
    suspend fun getLearnerGroup(): List<LearnerGroupModel>
}