package com.lokesh.basiccompose.quoteapp.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lokesh.basiccompose.R
import com.lokesh.basiccompose.quoteapp.storage.Quotes

@Composable
fun QuoteSingleView(quotes: Quotes, onClick: (quote: Quotes) -> Unit){
    Card(
        elevation = CardDefaults.cardElevation(5.dp),
        colors = CardDefaults.cardColors(Color.White),
        shape = RoundedCornerShape(7.dp),
        modifier = Modifier
            .clickable { onClick(quotes) }
            .padding(10.dp)
            .background(Color.White)
    ) {
        Row(modifier = Modifier.padding(7.dp)) {
            Image(
                painter = painterResource(id = R.drawable.ic_quote),
                contentDescription = "quote_icon",
                modifier = Modifier
                    .size(40.dp)
                    .rotate(180F)
            )
            Column(modifier = Modifier
                .weight(1f)
                .padding(5.dp, 0.dp)) {
                Text(
                    text = quotes.head,
                    style = MaterialTheme.typography.bodyMedium,
                    fontFamily = FontFamily(Font(R.font.roboto_regular)),
                    fontSize = 14.sp
                )
                Spacer(modifier = Modifier.padding(2.dp))
                Box(
                    modifier = Modifier
                        .background(Color.LightGray)
                        .fillMaxWidth(.4f)
                        .height(1.dp)
                )
                Spacer(modifier = Modifier.padding(2.dp))
                Text(
                    text = quotes.desc, style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Light,
                    fontSize = 12.sp
                )
            }
        }
    }
}