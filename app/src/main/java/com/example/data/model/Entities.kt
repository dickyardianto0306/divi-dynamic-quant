package com.example.data.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "snapshots")
data class SnapshotEntity(
    @PrimaryKey val timestamp: Long,
    val sessionId: String,
    val instrument: String,
    val timeframe: String,
    val dataSource: String,
    val activeLayers: String,
    val syncData: String,
    val systemStatus: String,
    val dataValidity: String
)

@Entity(
    tableName = "layer_metrics",
    foreignKeys = [
        ForeignKey(
            entity = SnapshotEntity::class,
            parentColumns = ["timestamp"],
            childColumns = ["snapshotTimestamp"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index("snapshotTimestamp")]
)
data class LayerMetricEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val snapshotTimestamp: Long,
    val metricType: String,
    val col1: String,
    val col2: String = "",
    val col3: String = "",
    val col4: String = ""
)

@Entity(
    tableName = "historical_events",
    foreignKeys = [
        ForeignKey(
            entity = SnapshotEntity::class,
            parentColumns = ["timestamp"],
            childColumns = ["snapshotTimestamp"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index("snapshotTimestamp")]
)
data class HistoricalEventEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val snapshotTimestamp: Long,
    val eventType: String,
    val content: String
)

@Entity(
    tableName = "system_evaluations",
    foreignKeys = [
        ForeignKey(
            entity = SnapshotEntity::class,
            parentColumns = ["timestamp"],
            childColumns = ["snapshotTimestamp"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index("snapshotTimestamp")]
)
data class SystemEvaluationEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val snapshotTimestamp: Long,
    val evaluationType: String,
    val key: String,
    val value: String,
    val extra1: String = "",
    val extra2: String = ""
)

data class FierlReport(
    val snapshot: SnapshotEntity,
    val metrics: List<LayerMetricEntity>,
    val events: List<HistoricalEventEntity>,
    val evaluations: List<SystemEvaluationEntity>
)
