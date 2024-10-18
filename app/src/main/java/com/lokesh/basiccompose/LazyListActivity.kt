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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class LazyListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PreviewFun()
        }
    }
}

data class ItemsModel(val img: Int, val title: String, val desc: String)

fun getList(): MutableList<ItemsModel> {
    return mutableListOf(
        ItemsModel(R.drawable.ic_user, "Lokesh Badolia", "Coder"),
        ItemsModel(R.drawable.ic_user, "Kuldeep Kumavat", "CEO"),
        ItemsModel(R.drawable.ic_user, "Aniket Saini", "Programmer"),
        ItemsModel(R.drawable.ic_user, "Satyam Sen", "UI/UX Designer"),
        ItemsModel(R.drawable.ic_user, "Pankaj Jha", "Seo Analyst"),
        ItemsModel(R.drawable.ic_user, "Vidhupriya Agarwal", "Seo Analyst"),
        ItemsModel(R.drawable.ic_user, "Vaibhav Garg", "Seo Analyst"),
        ItemsModel(R.drawable.ic_user, "Rahul Mahajan", "Android Dev"),
        ItemsModel(R.drawable.ic_user, "Somit Aggarwal", "IOS Dev"),
        ItemsModel(R.drawable.ic_user, "Rahul Sharma", "Seo Analyst"),
        ItemsModel(R.drawable.ic_user, "Sonu Soni", "Marketing")
    )
}
val dataItemList = mutableListOf(
    ItemsModel(R.drawable.ic_user, "Lokesh Badolia", "Coder"),
    ItemsModel(R.drawable.ic_user, "Kuldeep Kumavat", "CEO"),
    ItemsModel(R.drawable.ic_user, "Aniket Saini", "Programmer"),
    ItemsModel(R.drawable.ic_user, "Satyam Sen", "UI/UX Designer"),
    ItemsModel(R.drawable.ic_user, "Pankaj Jha", "Seo Analyst"),
    ItemsModel(R.drawable.ic_user, "Vidhupriya Agarwal", "Seo Analyst"),
    ItemsModel(R.drawable.ic_user, "Vaibhav Garg", "Seo Analyst"),
    ItemsModel(R.drawable.ic_user, "Rahul Mahajan", "Android Dev"),
    ItemsModel(R.drawable.ic_user, "Somit Aggarwal", "IOS Dev"),
    ItemsModel(R.drawable.ic_user, "Rahul Sharma", "Seo Analyst"),
    ItemsModel(R.drawable.ic_user, "Sonu Soni", "Marketing"))

@Preview(showBackground = true, name = "fun_preview", showSystemUi = true)
@Composable
private fun PreviewFun() {
    LoadListByRecycler()
}

@Composable
private fun LazyList(img: Int, title: String, desc: String) {
    Card(elevation = CardDefaults.cardElevation(8.dp), modifier = Modifier.padding(8.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(8.dp)) {
            Image(
                painter = painterResource(id = img),
                contentDescription = "profile",
                modifier = Modifier
                    .size(55.dp)
                    .padding(5.dp)
                    .weight(.1f)
            )
            Column(verticalArrangement = Arrangement.Center, modifier = Modifier
                .padding(4.dp)
                .weight(.8f)) {
                Text(text = title, style = MaterialTheme.typography.titleMedium)
                Text(text = desc, style = MaterialTheme.typography.labelMedium, fontWeight = FontWeight.Normal)
            }
        }
    }
}

@Composable
private fun LoadListByColumn(){
    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        for (item in dataItemList){
            LazyList(item.img, item.title, item.desc)
        }
    }
}

@Composable
private fun LoadListByRecycler(){
    LazyColumn(modifier = Modifier.fillMaxSize(1f), content = {
        items(getList()) {item ->
            LazyList(item.img, item.title, item.desc)
        }
    })
}