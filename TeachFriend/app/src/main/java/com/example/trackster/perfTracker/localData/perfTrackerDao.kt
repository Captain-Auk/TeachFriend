package com.example.trackster.perfTracker.localData

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface StratumDao{
    @Insert
    /*suspend fun insertStratum(
                              className: String,
                              courseName: String,
                              totalTasks: Int,
                              breakPoints: Int)*/
    suspend fun insertStratum(stratum: StratumEntity)

    @Query("SELECT * FROM stratum WHERE stratumId= :stratumId")
    suspend fun getStratum(stratumId: Int): StratumEntity
}
/*
@Dao
interface StudentDao {
    @Insert
    suspend fun insertStudent(student: StudentEntity)

    @Query("SELECT * FROM students WHERE studentName = :studentName")
    suspend fun getStudent(studentName: String): StudentEntity
}
@Dao
interface CourseDao{
    @Insert
    suspend fun insertCourse(course: CourseEntity)

    @Query("SELECT * FROM courses WHERE courseId = :courseId")
    suspend fun getCourse(courseId: Int): CourseEntity
}

@Dao
interface TaskDao {
    @Insert
    suspend fun insertTask(task: TaskEntity)

    @Query("SELECT * FROM tasks WHERE stratumId = :stratumId")
    suspend fun getTasks(stratumId: Int): List<TaskEntity>
}

@Dao
interface ScoreDao {
    @Insert
    suspend fun insertScore(score: ScoreEntity)

    @Query("SELECT * FROM scores WHERE stratumId = :stratumId AND studentId = :studentId")
    suspend fun getScores(stratumId:Int, studentId:Int): List<ScoreEntity>
}
*/
