package com.example.thirtydaysofstitching

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.thirtydaysofstitching.ui.theme.ThirtyDaysOfStitchingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ThirtyDaysOfStitchingTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ThirtyDaysOfStitchingApp()
                }
            }
        }
    }
}

@Composable
fun ThirtyDaysOfStitchingApp() {
    val stitchingTopics = listOf(
        StitchingTopic(
            day = 1,
            title = "Basic Running Stitch",
            description = "Learn the fundamental running stitch, perfect for beginners.",
            icon = Icons.Filled.Build
        ),
        StitchingTopic(
            day = 2,
            title = "Backstitch Embroidery",
            description = "Discover the versatile backstitch, great for outlines and decorative stitching.",
            icon = Icons.Filled.Check
        ),
        StitchingTopic(
            day = 3,
            title = "Cross Stitch Basics",
            description = "Master the cross stitch, a staple for creating decorative patterns.",
            icon = Icons.Filled.AddCircle
        )
        // Me faltaría añadir más días
    )

    LazyColumn(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(stitchingTopics) { topic ->
            StitchingTopicCard(topic)
        }
    }
}


@Composable
fun StitchingTopicCard(topic: StitchingTopic) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFF5F5F5),
            contentColor = MaterialTheme.colorScheme.onSurface
        )
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Day ${topic.day}",
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF7B1FA2)
                    )
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = topic.title,
                    style = MaterialTheme.typography.titleLarge.copy(
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Bold
                    )
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = topic.description,
                    style = MaterialTheme.typography.bodyLarge.copy(
                        color = Color(0xFF757575)
                    )
                )
            }
            Icon(
                imageVector = topic.icon,
                contentDescription = topic.title,
                modifier = Modifier.size(50.dp),
                tint = Color(0xFF7B1FA2)
            )
        }
    }
}

data class StitchingTopic(
    val day: Int,
    val title: String,
    val description: String,
    val icon: androidx.compose.ui.graphics.vector.ImageVector
)

@Preview(showBackground = true)
@Composable
fun ThirtyDaysOfStitchingAppPreview() {
    ThirtyDaysOfStitchingTheme {
        ThirtyDaysOfStitchingApp()
    }
}
