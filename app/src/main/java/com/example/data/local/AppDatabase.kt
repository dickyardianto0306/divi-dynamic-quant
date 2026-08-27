package com.example.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.data.model.HistoricalEventEntity
import com.example.data.model.LayerMetricEntity
import com.example.data.model.SnapshotEntity
import com.example.data.model.SystemEvaluationEntity

@Database(
    entities = [
        SnapshotEntity::class,
        LayerMetricEntity::class,
        HistoricalEventEntity::class,
        SystemEvaluationEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun fierlDao(): FierlDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "fierl_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
