package com.lokesh.basiccompose.quoteapp.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lokesh.basiccompose.R
import com.lokesh.basiccompose.quoteapp.storage.Quotes
import com.lokesh.basiccompose.quoteapp.storage.getQuoteList
import com.lokesh.basiccompose.quoteapp.view.QuoteDetailView
import com.lokesh.basiccompose.quoteapp.view.QuoteSingleView

class QuoteAppMainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PreviewView()
        }
    }
}

enum class Pages {
    LISTING, DETAIL
}

object DataManager {
    var currentPage = mutableStateOf(Pages.LISTING)
    var currentQuote: Quotes? = null

    fun switchPage(quote: Quotes?){
        if (currentPage.value == Pages.LISTING){
            currentQuote = quote
            currentPage.value = Pages.DETAIL
        }else{
            currentPage.value = Pages.LISTING
        }
    }
}

@Preview(showBackground = true, name = "preview_main", showSystemUi = true/*, widthDp = 300, heightDp = 400*/)
@Composable
private fun PreviewView() {
    ShowQuoteList()
}

@Composable
private fun ShowQuoteList(){
    Column {
        Card(
            modifier = Modifier.fillMaxWidth(1f),
            elevation = CardDefaults.cardElevation(8.dp),
            shape = RoundedCornerShape(0.dp),
            colors = CardDefaults.cardColors(Color.White),
        ) {
            Text(
                textAlign = TextAlign.Center,
                text = "Quote App",
                style = MaterialTheme.typography.headlineLarge,
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.roboto_regular)),
                modifier = Modifier
                    .padding(0.dp, 13.dp)
                    .fillMaxWidth(1f)
            )
        }
        if (DataManager.currentPage.value == Pages.LISTING){
            QuoteListView {
                DataManager.switchPage(it)
            }
        }else{
            DataManager.currentQuote?.let { QuoteDetailView(quotes = it) }
        }
    }
}

@Composable
private fun QuoteListView(onClick: (quote: Quotes) -> Unit) {
    LazyColumn(content = {
        items(getQuoteList()){
            QuoteSingleView(it, onClick)
        }
    })
}