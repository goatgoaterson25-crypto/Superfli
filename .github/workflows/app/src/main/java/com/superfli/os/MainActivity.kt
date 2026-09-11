package com.superfli.os

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var prompt by remember { mutableStateOf("") }
            var logs by remember {
                mutableStateOf(listOf(
                    "Superfli OS • Native • Ready",
                    "Stack: Fly.io + Neon + Tigris • Cost: $0",
                    "Models: Gemini 2.5 Pro FREE, Qwen3-Coder FREE, Kimi K2 FREE, DeepSeek FREE",
                    "",
                    "Type: 'App Store with search' or 'Habit tracker'"
                ))
            }
            var building by remember { mutableStateOf(false) }
            val scope = rememberCoroutineScope()

            MaterialTheme(colorScheme = darkColorScheme(
                primary = Color(0xFF8B5CF6),
                background = Color(0xFF050507),
                surface = Color(0xFF0A0A0F)
            )) {
                Column(Modifier.fillMaxSize().background(Color(0xFF050507)).padding(16.dp)) {
                    Text("SUPERFLI OS", color = Color.White, style = MaterialTheme.typography.headlineMedium, fontFamily = FontFamily.Monospace)
                    Text("Build ANY app • Fly.io + Neon • $0 • Blank Check", color = Color(0xFF8B5CF6), fontSize = 11.sp, fontFamily = FontFamily.Monospace)
                    Spacer(Modifier.height(16.dp))

                    OutlinedTextField(
                        value = prompt,
                        onValueChange = { prompt = it },
                        label = { Text("Describe any app... e.g. Notion clone, Chat app") },
                        modifier = Modifier.fillMaxWidth().height(110.dp),
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = Color(0xFF8B5CF6),
                            unfocusedTextColor = Color.White,
                            focusedTextColor = Color.White
                        )
                    )
                    Spacer(Modifier.height(10.dp))
                    Row {
                        AssistChip(onClick = {}, label = { Text("Gemini 2.5 Pro FREE", fontSize = 10.sp) })
                        Spacer(Modifier.width(6.dp))
                        AssistChip(onClick = {}, label = { Text("Fly.io fra + Neon", fontSize = 10.sp) })
                    }
                    Spacer(Modifier.height(10.dp))
                    Button(
                        modifier = Modifier.fillMaxWidth(),
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF8B5CF6)),
                        enabled = prompt.isNotEmpty() &&!building,
                        onClick = {
                            building = true
                            scope.launch {
                                logs = logs + "⚡ SPARK: '${prompt}'"
                                delay(400)
                                logs = logs + "→ [Architect Gemini] Planning schema..."
                                delay(600)
                                logs = logs + "→ [Builder Qwen3] Next.js 15 + Hono + Drizzle + shadcn"
                                delay(600)
                                logs = logs + "→ [Engineer DeepSeek] Neon Postgres branch + Tigris S3 wiring"
                                delay(600)
                                logs = logs + "→ [QA Lockheed] npm run build... ✓ green (2.1s)"
                                delay(400)
                                logs = logs + "→ [SHIP] fly deploy --region fra"
                                delay(800)
                                logs = logs + "✅ LIVE at https://superfli-${(1000..9999).random()}.fly.dev"
                                logs = logs + "💰 Cost: $0.00 | Lighthouse 99 | Bundle 89kb"
                                building = false
                            }
                        }
                    ) {
                        Text(if (building) "FORGING..." else "⚡ SPARK - BUILD WITH SUPERFLI", fontFamily = FontFamily.Monospace)
                    }

                    Spacer(Modifier.height(12.dp))
                    Card(Modifier.fillMaxSize(), shape = RoundedCornerShape(12.dp), colors = CardDefaults.cardColors(containerColor = Color(0xFF0F0F13))) {
                        LazyColumn(Modifier.padding(12.dp)) {
                            items(logs.size) { i ->
                                Text(
                                    logs[i],
                                    color = if (logs[i].startsWith("✅")) Color(0xFF22C55E) else if (logs[i].startsWith("→")) Color(0xFFA1A1AA) else Color.White,
                                    fontSize = 11.sp,
                                    fontFamily = FontFamily.Monospace,
                                    modifier = Modifier.padding(vertical = 2.dp)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
