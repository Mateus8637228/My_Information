package com.example.myinformation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                MyInformationApp(
                    modifier = Modifier.padding(innerPadding)
                )
            }
        }
    }
}

@Composable
fun MyInformationApp(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Верхний блок: Фото, имя и статус
        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.my_profile_pic),
                contentDescription = "Фото профиля",
                modifier = Modifier.size(180.dp) // <-- ЗДЕСЬ УВЕЛИЧЕН РАЗМЕР КАРТИНКИ
            )
            Text(
                text = "Дорошкевич\nМатвей",
                fontSize = 42.sp,
                textAlign = TextAlign.Center,
                lineHeight = 44.sp,
                modifier = Modifier.padding(top = 16.dp)
            )
            Text(
                text = "Student",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.padding(top = 8.dp)
            )
        }

        // Нижний блок: Контактные данные
        Column(
            modifier = Modifier.padding(bottom = 32.dp)
        ) {
            ContactRow(imageId = R.drawable.ic_phone, text = "+7 903 047 61 61")
            ContactRow(imageId = R.drawable.ic_share, text = "@motocross8637")
            ContactRow(imageId = R.drawable.ic_email, text = "matrac2k20@gmail.com")
        }
    }
}

@Composable
fun ContactRow(imageId: Int, text: String) {
    Row(
        modifier = Modifier.padding(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = imageId),
            contentDescription = null,
            modifier = Modifier
                .padding(end = 16.dp)
                .size(28.dp)
        )
        Text(
            text = text,
            fontSize = 18.sp
        )
    }
}