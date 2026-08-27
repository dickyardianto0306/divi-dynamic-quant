package com.example.data.repository

import com.example.data.local.FierlDao
import com.example.data.model.FierlReport
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class FierlRepository(private val dao: FierlDao) {
    
    val latestReport: Flow<FierlReport?> = dao.getLatestSnapshotFlow().map { snapshot ->
        if (snapshot == null) return@map null
        
        val metrics = dao.getLayerMetricsForSnapshot(snapshot.timestamp)
        val events = dao.getHistoricalEventsForSnapshot(snapshot.timestamp)
        val evaluations = dao.getSystemEvaluationsForSnapshot(snapshot.timestamp)
        
        FierlReport(snapshot, metrics, events, evaluations)
    }

    suspend fun insertReport(report: FierlReport) {
        dao.insertFullReport(
            snapshot = report.snapshot,
            metrics = report.metrics,
            events = report.events,
            evaluations = report.evaluations
        )
    }

    suspend fun hasData(): Boolean {
        return dao.getLatestSnapshot() != null
    }
}
