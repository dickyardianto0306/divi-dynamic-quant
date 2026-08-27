package com.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.ui.theme.MyApplicationTheme

import androidx.activity.viewModels
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.data.model.FierlReport
import com.example.ui.TerminalViewModel

class MainActivity : ComponentActivity() {
  private val viewModel: TerminalViewModel by viewModels { TerminalViewModel.Factory }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      val uiState by viewModel.uiState.collectAsStateWithLifecycle()
      
      MyApplicationTheme {
        Scaffold(
          modifier = Modifier.fillMaxSize(),
          containerColor = MaterialTheme.colorScheme.background
        ) { innerPadding ->
          TerminalScreen(
            report = uiState,
            modifier = Modifier.padding(innerPadding)
          )
        }
      }
    }
  }
}

@Composable
fun TerminalScreen(report: FierlReport?, modifier: Modifier = Modifier) {
  BoxWithConstraints(modifier = modifier) {
    val columns = when {
      maxWidth < 600.dp -> 2 // Portrait (Compact)
      maxWidth < 840.dp -> 4 // Landscape (Medium)
      else -> 6              // Tablet (Expanded)
    }

    val modules = listOf(
      "1. System Identification",
      "2. Ringkasan Integrasi 45 Layer",
      "3. Parameter Numerik Utama",
      "4. Interpretasi Multilayer",
      "5. Inter-Layer Correlation Matrix",
      "6. Rekomendasi Eksekusi",
      "7. Confidence Breakdown",
      "8. Conflict Resolution Matrix",
      "9. Statistik Kuantitatif",
      "10. Market Thermometer",
      "11. Kondisi Pemicu dan Filter",
      "12. Validasi Sistem",
      "13. Post-Validation Scoring",
      "14. Auto-Reinforce Command",
      "15. Feed Berita",
      "16. Kesimpulan Utama",
      "17. Live System Feed"
    )

    LazyVerticalGrid(
      columns = GridCells.Fixed(columns),
      modifier = Modifier
        .fillMaxSize()
        .background(MaterialTheme.colorScheme.background)
        .padding(4.dp),
      horizontalArrangement = Arrangement.spacedBy(4.dp),
      verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
      items(
        count = modules.size,
        span = { index ->
          val isFullWidth = when {
            maxWidth < 600.dp -> (index == 0 || index == 1 || index == 4 || index == 16)
            maxWidth < 840.dp -> (index == 0 || index == 4 || index == 16)
            else -> (index == 0) // Tablet mode: only System ID is full width
          }
          // Some modules can take 2 spans dynamically if needed, keeping simple for now
          val spanCount = if (isFullWidth) maxLineSpan else 1
          GridItemSpan(spanCount)
        }
      ) { index ->
        TerminalPanel(title = modules[index])
      }
    }
  }
}

@Composable
fun TerminalPanel(title: String, modifier: Modifier = Modifier) {
  Column(
    modifier = modifier
      .border(1.dp, MaterialTheme.colorScheme.outline)
      .defaultMinSize(minHeight = 120.dp)
      .padding(4.dp)
  ) {
    // Header
    Row(
      modifier = Modifier
        .fillMaxWidth()
        .background(MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.3f))
        .padding(horizontal = 4.dp, vertical = 2.dp),
      verticalAlignment = Alignment.CenterVertically
    ) {
      Box(
        modifier = Modifier
          .size(6.dp)
          .background(MaterialTheme.colorScheme.primary) // Cyan indicator
      )
      Spacer(modifier = Modifier.width(6.dp))
      Text(
        text = title.uppercase(),
        style = MaterialTheme.typography.labelSmall,
        color = MaterialTheme.colorScheme.primary,
        maxLines = 1
      )
      Spacer(modifier = Modifier.weight(1f))
      Text(
        text = "[+]",
        style = MaterialTheme.typography.labelSmall,
        color = MaterialTheme.colorScheme.onSurfaceVariant
      )
    }
    
    // Content Placeholder
    Box(
      modifier = Modifier
        .fillMaxWidth()
        .weight(1f)
        .padding(top = 4.dp),
      contentAlignment = Alignment.Center
    ) {
      Text(
        text = "--",
        style = MaterialTheme.typography.bodySmall,
        color = MaterialTheme.colorScheme.onSurfaceVariant,
        textAlign = TextAlign.Center
      )
    }
  }
}
