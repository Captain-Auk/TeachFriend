package com.example.trackster.perfTracker.learnerGroup.domain

data class LearnerGroupModel(
    val learnerGroupId: Int?,
    val className: String,
    val courseName: String,
    val totalTasks: Int,
    val breakPoints: Int
)
