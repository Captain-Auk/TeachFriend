package com.example.trackster.perfTracker.localData

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [
        LearnerGroupEntity::class,
        StudentEntity::class,
        CourseEntity::class,
        TaskEntity::class,
        ScoreEntity::class
    ], version = 2)
 abstract class PerfTrackerLocalDb : RoomDatabase() {


    abstract fun StratumDao(): LearnerGroupDao

    // abstract fun studentDao(): StudentDao
    //abstract fun subjectDao(): CourseDao
    //abstract fun taskDao(): TaskDao
    //abstract fun scoreDao(): ScoreDao

    /*companion object {
        @Volatile
        private var INSTANCE: perfTrackerLocalDb? = null

        fun getInstance(context: Context): perfTrackerLocalDb {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    perfTrackerLocalDb::class.java,
                    "trackster_database"
                )
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }*/
}

/*
what is the difference between these 2 codes.o
  companion object {
        @Volatile
        private var INSTANCE: SchoolDatabase? = null

        fun getInstance(context: Context): SchoolDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    SchoolDatabase::class.java,
                    "school_database"
                )
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    } and this:
     fun getInstance(context: Context): SchoolDatabase {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    MyDatabase::class.java, "school_database"
                ).build()
            }
            return instance!!
           }


           The difference between the two codes is that the first code uses a singleton pattern to
           create a single instance of the database, while the second code creates a new instance
           of the database each time it is called.

The singleton pattern is a design pattern that restricts the instantiation of a class to one object.
 This is useful for classes that are expensive to create or that need to be shared across multiple
 parts of the application.

To create a singleton, you need to make the constructor private and provide a public static method
that returns the singleton instance. The singleton instance is typically stored in a private static
 variable.

The first code example uses a singleton pattern to create a single instance of the database.
The INSTANCE variable is used to store the singleton instance. The getInstance() method returns
the singleton instance, or creates a new one if it does not exist.

The second code example does not use a singleton pattern. The getInstance() method simply creates
a new instance of the database each time it is called.

Here are the pros and cons of each approach:

Singleton

Pros:
Only one instance of the database is created, which can improve performance.
The database instance can be accessed from anywhere in the application.
Cons:
If the singleton instance is leaked, it can cause memory leaks.
It can be difficult to test code that uses a singleton.
New instance

Pros:
There is no risk of memory leaks.
It is easier to test code that uses a new instance.
Cons:
Creating a new instance of the database can be expensive.
Multiple instances of the database can be created, which can lead to performance problems.
Which approach you choose depends on your specific needs. If you need to improve performance
and you can avoid leaking the singleton instance, then using a singleton is a good option.
If you need to make it easier to test your code, then creating a new instance each time is
a good option.

In general, it is recommended to use a singleton for the database, unless you have a specific
reason not to.
 */