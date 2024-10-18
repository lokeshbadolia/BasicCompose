package com.lokesh.basiccompose

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PreviewFuns()
        }
    }
}

@Preview(showBackground = true, name = "fun_preview", showSystemUi = true/*, widthDp = 300, heightDp = 400*/)
@Composable
private fun PreviewFuns() {
    Column {
        //PrintName(name = "Lokesh")
        //ShowImage(drawableId = R.drawable.dummy)
        //ButtonView()
        //ShowDesc()
        //ShowDynamicDesc()
        //VerticalLayout()
        //HorizontalLayout()
        //FrameLayout()
        //BoxColumnRowUIExample(imgId = R.drawable.ic_user, name = "Lokesh Badolia", designation = "Coder")
        //BoxColumnRowUIListExample()
        //ModifierExample()
        ButtonComposeStateUpdate()
        CircularImage(R.drawable.dummy,
            Modifier
                .size(150.dp)
                .clip(CircleShape)
                .border(3.dp, Color.Blue, CircleShape))
    }
}

@Composable
private fun PrintName(name: String = "Default") {
    Text(
        text = "Good Morning $name",
        fontStyle = FontStyle.Italic,
        fontWeight = FontWeight.Medium,
        color = Color.Gray,
        fontSize = 25.sp,
        textAlign = TextAlign.Center
    )
}

@Composable
private fun ShowImage(drawableId: Int){
    Image(painter = painterResource(id = drawableId),
        contentDescription = "Dummy Image",
        contentScale = ContentScale.Crop,
        colorFilter = ColorFilter.tint(Color.Black
        ))
}

@Composable
private fun ButtonView(){
    Button(
        onClick = {
            //show toast
        },
        colors = ButtonDefaults.buttonColors(
            contentColor = Color.White,
        ),
        enabled = true,
        border = BorderStroke(width = 2.dp, color = Color.Black)
        ) {
        Text(text = "Click Me")
        Image(
            painter = painterResource(id = R.drawable.ic_heart),
            contentDescription = "Button Icon",
            colorFilter = ColorFilter.tint(Color.White)
        )
    }
}

@Composable
private fun ButtonComposeStateUpdate(){
    val state = remember { mutableStateOf(0.0) }
    Button(onClick = { state.value = Math.random() }) {
        Text(text = "${state.value}")
        Log.d("Enfy", "State Updated = ${state.value}")
    }
}

@Composable
private fun ShowDesc(message: String = "Default message"){
    TextField(value = message,
        label = { Text(text = "description")},
        placeholder = { Text(text = "some text here")},
        onValueChange = {
            Log.d("Espe", "ShowDesc: $it")
        })
}

@Composable
private fun ShowDynamicDesc(){
    val state = remember {
        mutableStateOf("")
    }
    TextField(value = state.value,
        label = { Text(text = "Dynamic Text Field")},
        onValueChange = {
            state.value = it
            Log.d("Espe", it)
        })
}

@Composable
private fun VerticalLayout(){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(text = "A", fontSize = 20.sp)
        Text(text = "B", fontSize = 20.sp)
    }
}

@Composable
private fun HorizontalLayout(){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Absolute.SpaceAround
    ) {
        Text(text = "A", fontSize = 20.sp)
        Text(text = "B", fontSize = 20.sp)
    }
}

@Composable
private fun FrameLayout(){
    Box(contentAlignment = Alignment.Center) {
        Image(painter = painterResource(id = R.drawable.dummy), contentDescription = "Dummy")
        Image(
            painter = painterResource(id = R.drawable.ic_heart),
            contentDescription = "Dummy",
            colorFilter = ColorFilter.tint(Color.White),
        )
    }
}

@Composable
private fun BoxColumnRowUIExample(imgId:Int, name:String, designation: String) {
    Row(
        Modifier.padding(5.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = imgId),
            contentDescription = "profile",
            modifier = Modifier
                .size(45.dp)
                .padding(5.dp),
        )
        Column {
            Text(
                text = name,
                fontWeight = FontWeight.Bold,
                color = Color.DarkGray,
                fontSize = 15.sp
            )
            Text(
                text = designation,
                fontWeight = FontWeight.Normal,
                color = Color.Gray,
                fontSize = 12.sp
            )

        }
    }
}

@Composable
private fun BoxColumnRowUIListExample(){
    Column {
        for (item in 0 until 3){
            BoxColumnRowUIExample(imgId = R.drawable.ic_user, name = "Lokesh Badolia", designation = "Coder")
        }
    }
}

@Composable
private fun ModifierExample() {
    Text(
        text = "Lokesh",
        color = Color.White,
        textAlign = TextAlign.Center,
        fontWeight = FontWeight.Bold,
        fontSize = 25.sp,
        modifier = Modifier
            .clickable { }
            .background(Color.DarkGray)
            .padding(30.dp)
            .size(200.dp)
            .border(4.dp, Color.Blue)
            .clip(CircleShape)
            .background(Color.Green)
    )
}

@Composable
private fun CircularImage(imgId:Int, modifier: Modifier) {
    Image(
        painter = painterResource(id = imgId),
        contentScale = ContentScale.Crop,
        contentDescription = "Profile",
        modifier = modifier
    )
}


































