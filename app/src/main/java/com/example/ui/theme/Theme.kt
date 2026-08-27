package com.example.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val TerminalColorScheme =
  darkColorScheme(
    primary = TerminalCyan,
    secondary = TerminalGreen,
    tertiary = TerminalYellow,
    background = TerminalBlack,
    surface = TerminalBlack,
    onPrimary = TerminalBlack,
    onSecondary = TerminalBlack,
    onTertiary = TerminalBlack,
    onBackground = TerminalText,
    onSurface = TerminalText,
    surfaceVariant = TerminalBorder,
    onSurfaceVariant = TerminalDimText,
    outline = TerminalBorder
  )

@Composable
fun MyApplicationTheme(
  darkTheme: Boolean = true, // Force dark theme for terminal
  // Dynamic color is available on Android 12+
  dynamicColor: Boolean = false, // Disable dynamic color to maintain terminal look
  content: @Composable () -> Unit,
) {
  val colorScheme = TerminalColorScheme

  MaterialTheme(colorScheme = colorScheme, typography = Typography, content = content)
}
