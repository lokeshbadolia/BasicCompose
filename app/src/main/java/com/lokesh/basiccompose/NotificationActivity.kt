package com.lokesh.basiccompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class NotificationActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PreviewFunc()
        }
    }
}

@Preview(showBackground = true, name = "fun_preview", showSystemUi = true/*, widthDp = 300, heightDp = 400*/)
@Composable
private fun PreviewFunc() {

    val count = rememberSaveable { mutableIntStateOf(0) } //rememberSaveable stores value in bundle so it dosen't reset when screen rotates

    Column(verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize(1f)) {
        NotificationCount(num = count.intValue, { count.intValue++ })
        MessageBar(num = count.intValue)
    }
}

@Composable
private fun NotificationCount(num: Int, increment: () -> Unit){
    Column(verticalArrangement = Arrangement.Center) {
        Text(text = "You have $num Notifications", modifier = Modifier.padding(10.dp))
        Button(onClick = { increment() }) {
            Text(text = "Send Notification")
        }
    }
}

@Composable
private fun MessageBar(num: Int) {
    Card(elevation = CardDefaults.cardElevation(8.dp), modifier = Modifier.padding(5.dp)) {
        Row(modifier = Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically) {
            Image(imageVector =  Icons.Outlined.Favorite, contentDescription = "Heart", modifier = Modifier.padding(5.dp))
            Text(text = "Message sent so far - $num", fontWeight = FontWeight.Medium, modifier = Modifier.padding(5.dp, 7.dp, 7.dp, 7.dp))
        }
    }

}