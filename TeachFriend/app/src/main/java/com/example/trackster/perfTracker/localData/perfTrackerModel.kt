package com.example.trackster.perfTracker.localData

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "stratum")
data class StratumEntity(
    @PrimaryKey(autoGenerate = true)
    val stratumId: Int?,
    val className: String,
    val courseName: String,
    val totalTasks: Int,
    val breakPoints: Int
)
@Entity(tableName = "students")
data class StudentEntity(
    @PrimaryKey val studentId: Int,
    val studentName: String,
    val stratumID: Int
)

@Entity(tableName = "courses")
data class CourseEntity(
    @PrimaryKey (autoGenerate = true)
    val courseId: Int,
    val courseName: String,
    val stratumId: Int
)

@Entity(tableName = "tasks")
data class TaskEntity(
    @PrimaryKey val taskId: Int,
    val taskName: String,
    val stratumId: Int
)

@Entity(tableName = "scores")
data class ScoreEntity(
    @PrimaryKey val scoreId: Int,
    val stratumId: Int,
    val studentId: Int,
    val taskId: Int,
    val score: Double,
)