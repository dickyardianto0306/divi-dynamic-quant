package com.example.data.repository

import com.example.data.model.FierlReport
import com.example.data.model.HistoricalEventEntity
import com.example.data.model.LayerMetricEntity
import com.example.data.model.SnapshotEntity
import com.example.data.model.SystemEvaluationEntity

object FierlSeeder {

    fun getInitialReport(): FierlReport {
        val timestamp = System.currentTimeMillis()

        val snapshot = SnapshotEntity(
            timestamp = timestamp,
            sessionId = "SESSION-01-INITIAL",
            instrument = "XAU/USD (CFD pada Emas)",
            timeframe = "H4 / M15 (Sinkronisasi Orbit Mikro-Makro)",
            dataSource = "Realtime Feed & Quantum Synthetic Calculation",
            activeLayers = "45 Layer (Teknikal, Kuantitatif, Kosmik, Makro, Saintifik)",
            syncData = "Senin, 27 Juli 2026 — 06:50 WIB (Sesi Asia)",
            systemStatus = "AKTIF – OBSERVATIONAL / DEFENSIVE SELL MODE",
            dataValidity = "✔ Mekanis • ⚠ Divergen • ✔ Terkalibrasi"
        )

        val metrics = listOf(
            // 2. Ringkasan Integrasi Semua Layer
            LayerMetricEntity(snapshotTimestamp = timestamp, metricType = "INTEGRATION_SUMMARY", col1 = "Inti Teknis & Struktur (PQC, FMM, QSF)", col2 = "✅ LOLOS", col3 = "⬇ Bearish", col4 = "58.0%"),
            LayerMetricEntity(snapshotTimestamp = timestamp, metricType = "INTEGRATION_SUMMARY", col1 = "Makro & Fundamental (MFL, NVS)", col2 = "✅ LOLOS", col3 = "↔ Netral", col4 = "68.0%"),
            LayerMetricEntity(snapshotTimestamp = timestamp, metricType = "INTEGRATION_SUMMARY", col1 = "Siklus & Kosmik (CHR, AFL, ATG, CRR)", col2 = "⚠ WASPADA", col3 = "↔ Transisi", col4 = "60.0%"),
            LayerMetricEntity(snapshotTimestamp = timestamp, metricType = "INTEGRATION_SUMMARY", col1 = "Rezim & Chaos Saintifik (SFL, WMD, HMRD)", col2 = "✅ LOLOS", col3 = "🔄 Range Bound", col4 = "72.0%"),
            LayerMetricEntity(snapshotTimestamp = timestamp, metricType = "INTEGRATION_SUMMARY", col1 = "Kuantum & Matematis (QMIL, HFQI, DDQCS)", col2 = "⚠ DIVERGEN", col3 = "↔ Discard", col4 = "43.0%"),
            LayerMetricEntity(snapshotTimestamp = timestamp, metricType = "INTEGRATION_SUMMARY", col1 = "Risiko & Likuiditas (QRFM, QLPM, QOFI)", col2 = "✅ LOLOS", col3 = "↔ Moderat / Wait", col4 = "64.0%"),
            LayerMetricEntity(snapshotTimestamp = timestamp, metricType = "INTEGRATION_SUMMARY", col1 = "Sentimen & Energi (CSE, MEHF)", col2 = "⚠ WASPADA", col3 = "↔ Disharmoni", col4 = "10.2%"),
            LayerMetricEntity(snapshotTimestamp = timestamp, metricType = "INTEGRATION_SUMMARY", col1 = "Adaptif, Sintesis & Eksekusi (BPI, AEF)", col2 = "✅ LOLOS", col3 = "⬇ Limit Entry / Wait", col4 = "65.0%"),
            LayerMetricEntity(snapshotTimestamp = timestamp, metricType = "INTEGRATION_SUMMARY", col1 = "TOTAL SINKRONISASI SISTEMIK", col2 = "DIVERGENT", col3 = "Defensive Sell", col4 = "50.4% (EAR)"),

            // 3. Parameter Numerik Utama (Estimasi Real-Time)
            LayerMetricEntity(snapshotTimestamp = timestamp, metricType = "NUMERICAL_PARAM", col1 = "Pivot Utama", col2 = "4.165,35", col3 = "Basis struktur harian (Titik Keseimbangan)"),
            LayerMetricEntity(snapshotTimestamp = timestamp, metricType = "NUMERICAL_PARAM", col1 = "Fractal Bias", col2 = "-0.64", col3 = "Dominasi struktur harga (Bearish)"),
            LayerMetricEntity(snapshotTimestamp = timestamp, metricType = "NUMERICAL_PARAM", col1 = "Delta Entropy", col2 = "0.12", col3 = "Perubahan Chaos rendah / stabil"),
            LayerMetricEntity(snapshotTimestamp = timestamp, metricType = "NUMERICAL_PARAM", col1 = "QES Index", col2 = "0.85", col3 = "Keseimbangan Chaos–Order (Sistem Stabil)"),
            LayerMetricEntity(snapshotTimestamp = timestamp, metricType = "NUMERICAL_PARAM", col1 = "MEI", col2 = "10.2 / 100", col3 = "Energi Momentum sangat lemah / ekuilibrium"),

            // 4. Interpretasi Multilayer
            LayerMetricEntity(snapshotTimestamp = timestamp, metricType = "INTERPRETATION", col1 = "Market Regime", col2 = "Range 72.0 %", col3 = "Konsolidasi dominan (HMRD-L)"),
            LayerMetricEntity(snapshotTimestamp = timestamp, metricType = "INTERPRETATION", col1 = "Entropy Market Index", col2 = "0.68 (Tinggi)", col3 = "Noise tinggi intraday, range-bound"),
            LayerMetricEntity(snapshotTimestamp = timestamp, metricType = "INTERPRETATION", col1 = "Quantum Resonance", col2 = "0.34 (Rendah)", col3 = "Rantai probabilitas terpecah (BRAC-L)"),
            LayerMetricEntity(snapshotTimestamp = timestamp, metricType = "INTERPRETATION", col1 = "Fractal Liquidity Bias", col2 = "Bearish (Target 4.024)", col3 = "Tekanan jual semu, institusi absen"),
            LayerMetricEntity(snapshotTimestamp = timestamp, metricType = "INTERPRETATION", col1 = "Macro Bias", col2 = "Sideways 0.51", col3 = "Kondisi fundamental netral"),
            LayerMetricEntity(snapshotTimestamp = timestamp, metricType = "INTERPRETATION", col1 = "Sentiment Polarity", col2 = "-0.15 (Bearish tipis)", col3 = "Retail tidak terarah"),
            LayerMetricEntity(snapshotTimestamp = timestamp, metricType = "INTERPRETATION", col1 = "Astro-Temporal Sync", col2 = "55.0 % (Peringatan)", col3 = "Resonansi waktu tidak sinkron"),
            LayerMetricEntity(snapshotTimestamp = timestamp, metricType = "INTERPRETATION", col1 = "Total Systemic Risk", col2 = "0.45 (Moderat)", col3 = "Risiko likuiditas asimetris namun terkendali"),

            // 5. Inter-Layer Correlation Matrix
            LayerMetricEntity(snapshotTimestamp = timestamp, metricType = "CORRELATION", col1 = "PQC (Pivot)", col2 = "FMM (Fractal)", col3 = "+0.72", col4 = "Strong / Selaras (Bearish)"),
            LayerMetricEntity(snapshotTimestamp = timestamp, metricType = "CORRELATION", col1 = "FMM (Fractal)", col2 = "QES (Entropy)", col3 = "+0.65", col4 = "Stabil"),
            LayerMetricEntity(snapshotTimestamp = timestamp, metricType = "CORRELATION", col1 = "MEI (Energi)", col2 = "QOFI (Flow)", col3 = "+0.34", col4 = "Lemah / Divergen"),
            LayerMetricEntity(snapshotTimestamp = timestamp, metricType = "CORRELATION", col1 = "HRG (Harmonic)", col2 = "GEL (Astro)", col3 = "-0.40", col4 = "Disharmoni / Transisi"),
            LayerMetricEntity(snapshotTimestamp = timestamp, metricType = "CORRELATION", col1 = "Macro", col2 = "Trend", col3 = "+0.10", col4 = "Netral / Disconnected"),
            LayerMetricEntity(snapshotTimestamp = timestamp, metricType = "CORRELATION", col1 = "Rata-rata Sistemik", col2 = "–", col3 = "0.42", col4 = "DIVERGENT / WAIT")
        )

        val events = listOf(
            // 7. Alasan & Pembenaran Singkat
            HistoricalEventEntity(snapshotTimestamp = timestamp, eventType = "REASONING", content = "Teknikal (Bearish-Range): Struktur H4 dan M15 membentuk lower highs, namun harga saat ini (4.090) tertahan di zona konsolidasi netral."),
            HistoricalEventEntity(snapshotTimestamp = timestamp, eventType = "REASONING", content = "Institusional Flow: QOFI mendeteksi ketidakhadiran institusi (IFR 0.35) dan dominasi aktivitas ritel, memicu volatilitas acak tanpa arah tren yang jelas."),
            HistoricalEventEntity(snapshotTimestamp = timestamp, eventType = "REASONING", content = "Matematis & Rezim: HMRD-L dan RSP-L mengunci probabilitas 72% pada rezim Range/Mean-Reversion. Sistem membatalkan skenario breakout agresif."),
            HistoricalEventEntity(snapshotTimestamp = timestamp, eventType = "REASONING", content = "Sintesis: Karena ketidakselarasan antara struktur teknikal (turun) dan momentum likuiditas (kosong), sistem mengaktifkan mode WAIT atau hanya mengambil risiko di zona premium (4.140 - 4.170) dengan lot defensif."),

            // 8. Feed Berita Terkini
            HistoricalEventEntity(snapshotTimestamp = timestamp, eventType = "NEWS_FEED", content = "Reuters: \"Aktivitas pasar Asia dibuka moderat; investor emas menanti kejelasan arah yield obligasi AS pekan ini.\" (Makro - Netral)"),
            HistoricalEventEntity(snapshotTimestamp = timestamp, eventType = "NEWS_FEED", content = "Bloomberg: \"Dinamika geopolitik global menunjukkan stabilisasi sementara, mengurangi tekanan akumulasi safe-haven secara instan.\" (Sentimen - Bearish Tipis)"),
            HistoricalEventEntity(snapshotTimestamp = timestamp, eventType = "NEWS_FEED", content = "CNBC: \"Fokus bergeser pada data ketenagakerjaan dan sinyal The Fed mendatang; logam mulia terjebak dalam rentang sempit.\" (Likuiditas - Netral)")
        )

        val evaluations = listOf(
            // 6. Rekomendasi Eksekusi Final
            SystemEvaluationEntity(snapshotTimestamp = timestamp, evaluationType = "EXECUTION_REC", key = "Waktu Research", value = "Senin, 27 Juli 2026 — 06:50 WIB (Sesi Asia)"),
            SystemEvaluationEntity(snapshotTimestamp = timestamp, evaluationType = "EXECUTION_REC", key = "Arah Dominan", value = "SELL LIMIT / WAIT"),
            SystemEvaluationEntity(snapshotTimestamp = timestamp, evaluationType = "EXECUTION_REC", key = "Entry 1", value = "4.140,00 – Batas bawah zona premium / resistance minor"),
            SystemEvaluationEntity(snapshotTimestamp = timestamp, evaluationType = "EXECUTION_REC", key = "Entry 2", value = "4.165,35 – Titik konfluensi Pivot Utama Klasik"),
            SystemEvaluationEntity(snapshotTimestamp = timestamp, evaluationType = "EXECUTION_REC", key = "Entry 3", value = "4.170,00 – Batas atas likuiditas jual (Supply Zone)"),
            SystemEvaluationEntity(snapshotTimestamp = timestamp, evaluationType = "EXECUTION_REC", key = "Stop Loss", value = "4.185,00 – Invalidasi struktural di atas liquidity pool"),
            SystemEvaluationEntity(snapshotTimestamp = timestamp, evaluationType = "EXECUTION_REC", key = "Take Profit 1", value = "4.080,00 – Area reaksi Point of Control (Kalman Target)"),
            SystemEvaluationEntity(snapshotTimestamp = timestamp, evaluationType = "EXECUTION_REC", key = "Take Profit 2", value = "4.024,50 – Swing low minor / Sell-side liquidity"),
            SystemEvaluationEntity(snapshotTimestamp = timestamp, evaluationType = "EXECUTION_REC", key = "Take Profit 3", value = "3.934,50 – Target ekspansi / Major demand zone"),
            SystemEvaluationEntity(snapshotTimestamp = timestamp, evaluationType = "EXECUTION_REC", key = "Risk-to-Reward", value = "1 : 2.5 hingga 1 : 3.5"),
            SystemEvaluationEntity(snapshotTimestamp = timestamp, evaluationType = "EXECUTION_REC", key = "Waktu Ideal Eksekusi", value = "14:00 – 19:30 WIB (Overlap London - New York)"),
            SystemEvaluationEntity(snapshotTimestamp = timestamp, evaluationType = "EXECUTION_REC", key = "Valid Duration", value = "Senin, 27 Juli 2026 – 06:50 WIB → 14:00 WIB"),
            SystemEvaluationEntity(snapshotTimestamp = timestamp, evaluationType = "EXECUTION_REC", key = "Confidence Final", value = "50.4 % (Low Conviction / Entropy Adjusted)"),
            SystemEvaluationEntity(snapshotTimestamp = timestamp, evaluationType = "EXECUTION_REC", key = "Sistem Konvergensi", value = "DIVERGENT (Hanya izinkan Limit Order, hindari market execution)"),

            // 9. Confidence Breakdown per Domain
            SystemEvaluationEntity(snapshotTimestamp = timestamp, evaluationType = "CONFIDENCE", key = "Teknikal & Struktur", value = "58.0", extra1 = "████████░░░░░░░", extra2 = "Tertahan di Resistance"),
            SystemEvaluationEntity(snapshotTimestamp = timestamp, evaluationType = "CONFIDENCE", key = "Siklus & Kosmik", value = "60.0", extra1 = "█████████░░░░░░", extra2 = "Oposisi planet membatasi"),
            SystemEvaluationEntity(snapshotTimestamp = timestamp, evaluationType = "CONFIDENCE", key = "Rezim & Chaos", value = "72.0", extra1 = "███████████░░░░", extra2 = "Range-bound dominan"),
            SystemEvaluationEntity(snapshotTimestamp = timestamp, evaluationType = "CONFIDENCE", key = "Kuantum Matematis", value = "43.0", extra1 = "██████░░░░░░░░░", extra2 = "Discard / Noise tinggi"),
            SystemEvaluationEntity(snapshotTimestamp = timestamp, evaluationType = "CONFIDENCE", key = "Risiko & Likuiditas", value = "64.0", extra1 = "█████████░░░░░░", extra2 = "Kompresi intraday"),
            SystemEvaluationEntity(snapshotTimestamp = timestamp, evaluationType = "CONFIDENCE", key = "Sentimen & Energi", value = "10.2", extra1 = "█░░░░░░░░░░░░░░", extra2 = "Disharmoni energi total"),
            SystemEvaluationEntity(snapshotTimestamp = timestamp, evaluationType = "CONFIDENCE", key = "Sintesis Eksekusi", value = "65.0", extra1 = "██████████░░░░░", extra2 = "Limit Sell Valid"),
            SystemEvaluationEntity(snapshotTimestamp = timestamp, evaluationType = "CONFIDENCE", key = "System Resilience", value = "50.4", extra1 = "🟡 Divergent", extra2 = "Mode Defensif / Wait"),

            // 10. Conflict Resolution Matrix
            SystemEvaluationEntity(snapshotTimestamp = timestamp, evaluationType = "CONFLICT_RES", key = "Teknis (Bearish)", value = "Flow (Netral/Weak)", extra1 = "⚠ Kurang Momentum", extra2 = "Prioritas Limit: Tunggu harga naik ke zona Supply (4140+) sebelum Sell."),
            SystemEvaluationEntity(snapshotTimestamp = timestamp, evaluationType = "CONFLICT_RES", key = "Makro (Sideways)", value = "Rezim (Range)", extra1 = "✅ Selaras", extra2 = "Aktifkan strategi Mean-Reversion. Hindari posisi di tengah range."),
            SystemEvaluationEntity(snapshotTimestamp = timestamp, evaluationType = "CONFLICT_RES", key = "Risiko (Moderat)", value = "Eksekusi (Limit)", extra1 = "✅ Selaras", extra2 = "Terapkan pemotongan lot sizing 50% sesuai protokol defensif."),

            // 11. Statistik Kuantitatif Eksekusi
            SystemEvaluationEntity(snapshotTimestamp = timestamp, evaluationType = "STATS", key = "Expected Move (24 h)", value = "± 45.000 poin", extra1 = "Kisaran kompresi harian"),
            SystemEvaluationEntity(snapshotTimestamp = timestamp, evaluationType = "STATS", key = "Historical Accuracy", value = "62.4 %", extra1 = "Backtest 5 tahun"),
            SystemEvaluationEntity(snapshotTimestamp = timestamp, evaluationType = "STATS", key = "Average R:R", value = "1 : 2.5", extra1 = "Efisiensi target tercapai"),
            SystemEvaluationEntity(snapshotTimestamp = timestamp, evaluationType = "STATS", key = "Time-to-Target", value = "12 – 24 jam", extra1 = "Intraday ke Swing transisi"),

            // 12. Market Thermometer
            SystemEvaluationEntity(snapshotTimestamp = timestamp, evaluationType = "THERMOMETER", key = "RESIST 3", value = "▒▒▒▒▒▒", extra1 = "4.768,75", extra2 = "Major Resistance Klasik R2"),
            SystemEvaluationEntity(snapshotTimestamp = timestamp, evaluationType = "THERMOMETER", key = "RESIST 2", value = "██████", extra1 = "4.333,00", extra2 = "Target Liquidity Atas"),
            SystemEvaluationEntity(snapshotTimestamp = timestamp, evaluationType = "THERMOMETER", key = "RESIST 1", value = "██████", extra1 = "4.170,00", extra2 = "Supply Zone / Upper Range"),
            SystemEvaluationEntity(snapshotTimestamp = timestamp, evaluationType = "THERMOMETER", key = "PIVOT", value = "██████", extra1 = "4.165,35", extra2 = "Key Balance Point"),
            SystemEvaluationEntity(snapshotTimestamp = timestamp, evaluationType = "THERMOMETER", key = "CURRENT", value = "░░░░░░", extra1 = "4.090,12", extra2 = "Harga Sekarang (No Trade Zone)"),
            SystemEvaluationEntity(snapshotTimestamp = timestamp, evaluationType = "THERMOMETER", key = "SUPPORT 1", value = "██████", extra1 = "4.024,50", extra2 = "Swing Low Minor"),
            SystemEvaluationEntity(snapshotTimestamp = timestamp, evaluationType = "THERMOMETER", key = "SUPPORT 2", value = "██████", extra1 = "3.934,50", extra2 = "Major Demand Pool"),

            // 13. Kondisi Pemicu dan Filter Otomatis
            SystemEvaluationEntity(snapshotTimestamp = timestamp, evaluationType = "TRIGGER", key = "Active If:", value = "Harga menyentuh zona 4.140,00 – 4.170,00."),
            SystemEvaluationEntity(snapshotTimestamp = timestamp, evaluationType = "TRIGGER", key = "Active If:", value = "Volatilitas intraday mereda saat sesi London dibuka."),
            SystemEvaluationEntity(snapshotTimestamp = timestamp, evaluationType = "TRIGGER", key = "Auto-Cancel If:", value = "H4 Close berada di atas 4.185,00."),
            SystemEvaluationEntity(snapshotTimestamp = timestamp, evaluationType = "TRIGGER", key = "Auto-Cancel If:", value = "Indeks Entropy berbalik arah melebihi 0.65 secara tiba-tiba (News shock)."),

            // 14. Validasi Sistem
            SystemEvaluationEntity(snapshotTimestamp = timestamp, evaluationType = "VALIDATION", key = "Integritas Data", value = "✅ Lolos", extra1 = "Fallback adaptif diaktifkan pada layer mikro"),
            SystemEvaluationEntity(snapshotTimestamp = timestamp, evaluationType = "VALIDATION", key = "Konvergensi Layer", value = "⚠ Peringatan", extra1 = "Divergensi lintas-sektor terdeteksi"),
            SystemEvaluationEntity(snapshotTimestamp = timestamp, evaluationType = "VALIDATION", key = "Risiko Entropi", value = "✅ Aman", extra1 = "Sistem meredam noise dengan mode WAIT"),
            SystemEvaluationEntity(snapshotTimestamp = timestamp, evaluationType = "VALIDATION", key = "Validasi Mekanis", value = "✅ Lolos", extra1 = "Filter Bayesian & Kalman tereksekusi"),

            // 15. Post-Validation Scoring
            SystemEvaluationEntity(snapshotTimestamp = timestamp, evaluationType = "SCORING", key = "Integritas Data", value = "0.25", extra1 = "85", extra2 = "High Reliability"),
            SystemEvaluationEntity(snapshotTimestamp = timestamp, evaluationType = "SCORING", key = "Konvergensi Layer", value = "0.25", extra1 = "42", extra2 = "Divergent"),
            SystemEvaluationEntity(snapshotTimestamp = timestamp, evaluationType = "SCORING", key = "Entropy Stability", value = "0.20", extra1 = "85", extra2 = "Very Stable (Range)"),
            SystemEvaluationEntity(snapshotTimestamp = timestamp, evaluationType = "SCORING", key = "Resonansi Astro-Geo", value = "0.15", extra1 = "55", extra2 = "Moderate"),
            SystemEvaluationEntity(snapshotTimestamp = timestamp, evaluationType = "SCORING", key = "Sentiment Polarity", value = "0.15", extra1 = "45", extra2 = "Neutral"),
            SystemEvaluationEntity(snapshotTimestamp = timestamp, evaluationType = "SCORING", key = "Skor Akhir", value = "1.00", extra1 = "63.5", extra2 = "Moderate (Caution)"),

            // 16. Auto-Reinforcement Command
            SystemEvaluationEntity(snapshotTimestamp = timestamp, evaluationType = "AUTO_REINFORCE", key = "Status Validasi", value = "PERINGATAN (Divergent)"),
            SystemEvaluationEntity(snapshotTimestamp = timestamp, evaluationType = "AUTO_REINFORCE", key = "Aksi", value = "Reduksi bobot Bayesian, hentikan eksekusi agresif."),
            SystemEvaluationEntity(snapshotTimestamp = timestamp, evaluationType = "AUTO_REINFORCE", key = "Prior Probability Baru", value = "0.635"),
            SystemEvaluationEntity(snapshotTimestamp = timestamp, evaluationType = "AUTO_REINFORCE", key = "Status Eksekusi", value = "Menunggu Trigger di batas atas (Limit Order Only) atau Observasi."),

            // 17. KESIMPULAN UTAMA
            SystemEvaluationEntity(snapshotTimestamp = timestamp, evaluationType = "CONCLUSION", key = "Keputusan", value = "WAIT / SELL LIMIT"),
            SystemEvaluationEntity(snapshotTimestamp = timestamp, evaluationType = "CONCLUSION", key = "Area Entry", value = "4.140,00 – 4.170,00"),
            SystemEvaluationEntity(snapshotTimestamp = timestamp, evaluationType = "CONCLUSION", key = "Stop Loss", value = "4.185,00"),
            SystemEvaluationEntity(snapshotTimestamp = timestamp, evaluationType = "CONCLUSION", key = "Take Profit", value = "4.080,00 → 4.024,50 → 3.934,50"),
            SystemEvaluationEntity(snapshotTimestamp = timestamp, evaluationType = "CONCLUSION", key = "Confidence", value = "50.4 % (EAR)"),
            SystemEvaluationEntity(snapshotTimestamp = timestamp, evaluationType = "CONCLUSION", key = "Valid Duration", value = "Senin, 27 Juli 2026 hingga 14:00 WIB (Sesi Asia).")
        )

        return FierlReport(snapshot, metrics, events, evaluations)
    }
}
