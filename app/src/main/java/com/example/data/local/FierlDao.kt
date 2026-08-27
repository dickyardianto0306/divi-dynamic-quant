package com.example.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.example.data.model.HistoricalEventEntity
import com.example.data.model.LayerMetricEntity
import com.example.data.model.SnapshotEntity
import com.example.data.model.SystemEvaluationEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FierlDao {
    @Insert
    suspend fun insertSnapshot(snapshot: SnapshotEntity)

    @Insert
    suspend fun insertLayerMetrics(metrics: List<LayerMetricEntity>)

    @Insert
    suspend fun insertHistoricalEvents(events: List<HistoricalEventEntity>)

    @Insert
    suspend fun insertSystemEvaluations(evaluations: List<SystemEvaluationEntity>)

    @Transaction
    suspend fun insertFullReport(
        snapshot: SnapshotEntity,
        metrics: List<LayerMetricEntity>,
        events: List<HistoricalEventEntity>,
        evaluations: List<SystemEvaluationEntity>
    ) {
        insertSnapshot(snapshot)
        insertLayerMetrics(metrics)
        insertHistoricalEvents(events)
        insertSystemEvaluations(evaluations)
    }

    @Query("SELECT * FROM snapshots ORDER BY timestamp DESC LIMIT 1")
    fun getLatestSnapshotFlow(): Flow<SnapshotEntity?>

    @Query("SELECT * FROM snapshots ORDER BY timestamp DESC LIMIT 1")
    suspend fun getLatestSnapshot(): SnapshotEntity?

    @Query("SELECT * FROM layer_metrics WHERE snapshotTimestamp = :timestamp")
    suspend fun getLayerMetricsForSnapshot(timestamp: Long): List<LayerMetricEntity>

    @Query("SELECT * FROM historical_events WHERE snapshotTimestamp = :timestamp")
    suspend fun getHistoricalEventsForSnapshot(timestamp: Long): List<HistoricalEventEntity>

    @Query("SELECT * FROM system_evaluations WHERE snapshotTimestamp = :timestamp")
    suspend fun getSystemEvaluationsForSnapshot(timestamp: Long): List<SystemEvaluationEntity>
}
