package com.example.composeproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.example.composeproject.ui.theme.ComposeProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeProjectTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFFD2E8D4) // Soft mint green background
                ) {
                    BusinessCard()
                }
            }
        }
    }
}


@Composable
fun BusinessCard() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 48.dp), // Adjust bottom padding for the contact info layout
        contentAlignment = Alignment.Center
    ) {
        // 1. Profile Section (Centered)
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Replace with your Android logo asset identifier if different
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = "Android Logo",
                modifier = Modifier
                    .size(120.dp)
                    .background(Color(0xFF073042)) // Dark blue background behind the logo
                    .padding(16.dp)
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = "Jennifer Doe",
                fontSize = 44.sp,
                fontWeight = FontWeight.Light,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Android Developer Extraordinaire",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF076736) // Dark green text color
            )
        }

        // 2. Contact Info Section (Bottom-aligned inside the Box)
        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(horizontal = 40.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            ContactRow(
                icon = Icons.Default.Phone,
                text = "+11 (123) 444 555 666"
            )
            ContactRow(
                icon = Icons.Default.Share,
                text = "@AndroidDev"
            )
            ContactRow(
                icon = Icons.Default.Email,
                text = "jen.doe@android.com"
            )
        }
    }
}

@Composable
fun ContactRow(icon: ImageVector, text: String, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Adjust spacing so icons line up cleanly
        Spacer(modifier = Modifier.width(36.dp))
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Color(0xFF076736), // Matching green color for icons
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(20.dp))
        Text(
            text = text,
            fontSize = 15.sp,
            color = Color.Black
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeProjectTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color(0xFFD2E8D4)
        ) {
            BusinessCard()
        }
    }
}