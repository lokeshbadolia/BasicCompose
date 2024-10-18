package com.lokesh.basiccompose.quoteapp.view

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lokesh.basiccompose.R
import com.lokesh.basiccompose.quoteapp.screens.DataManager
import com.lokesh.basiccompose.quoteapp.storage.Quotes
import com.lokesh.basiccompose.quoteapp.storage.getQuoteList

/*@Preview(showBackground = true, name = "preview_detail", showSystemUi = true*//*, widthDp = 300, heightDp = 400*//*)
@Composable
fun QuoteDetailViewPreview() {
    QuoteDetailView(getQuoteList()[7])
}*/

@Composable
fun QuoteDetailView(quotes: Quotes){
    BackHandler {
        DataManager.switchPage(null)
    }
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .clickable { DataManager.switchPage(null) }
            .fillMaxSize(1f)
            .background(
                Brush.sweepGradient(
                    colors = listOf(
                        Color(0xFFffffff),
                        Color(0xFFE3E3E3)
                    )
                )
            )
    ) {
        Card(
            modifier = Modifier.padding(30.dp),
            elevation = CardDefaults.cardElevation(8.dp),
            shape = RoundedCornerShape(7.dp),
            colors = CardDefaults.cardColors(Color.White)
        ) {
            Column(modifier = Modifier.padding(15.dp)) {
                Image(
                    alignment = Alignment.TopStart,
                    painter = painterResource(id = R.drawable.ic_quote),
                    contentDescription = "quote_img",
                    modifier = Modifier
                        .size(40.dp)
                        .rotate(180F)
                )
                Text(
                    text = quotes.head,
                    style = MaterialTheme.typography.bodyMedium,
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.roboto_regular)),
                    modifier = Modifier.padding(0.dp, 10.dp)
                )
                Text(
                    text = quotes.desc,
                    style = MaterialTheme.typography.bodyLarge,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Light,
                    textAlign = TextAlign.End,
                    modifier = Modifier.fillMaxWidth(1f)
                )
            }
        }
    }
}