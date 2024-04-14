package com.example.artspaceapp

import android.os.Bundle
import android.print.PrintAttributes.Margins
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspaceapp.ui.theme.ArtSpaceAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    MainLayout()
                }
            }
        }
    }
}

@Composable
fun ContainerImage(modifier: Modifier = Modifier) {
    var image = painterResource(id = R.drawable.pict_1)
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        modifier = Modifier
            .fillMaxWidth()
    ){
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .height(400.dp)
        )
    }
}

@Preview(showBackground = true, name = "Container")
@Composable
fun ContainerImagePreview() {
    ArtSpaceAppTheme {
        ContainerImage()
    }
}

//===========================================

@Composable
fun ArtistTitle(name: String, modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .background(Color.LightGray)
            .fillMaxSize()
            .clip(RoundedCornerShape(18.dp))
    ) {
        Text(
            text = "WO : Long Game",
            modifier = modifier
        )
    }
}

@Preview(showBackground = true, name = "Fajar")
@Composable
fun ArtistTitlePreview() {
    ArtSpaceAppTheme {
        ArtistTitle("Android")
    }
}

//=============================================

@Composable
fun ActionButton(modifier: Modifier = Modifier) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .weight(1f)
        ) {
            Text(
                text = stringResource(id = R.string.prev_btn)
            )
        }

        Spacer(modifier = Modifier.width(16.dp))

        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .weight(1f)
        ) {
            Text(
                text = stringResource(id = R.string.next_btn)
            )
        }
    }
}

@Preview(showBackground = true, name = "Container")
@Composable
fun ActionButtonPreview() {
    ArtSpaceAppTheme {
        ActionButton()
    }
}

//============================================

@Composable
fun MainLayout(modifier: Modifier = Modifier){
    Column(
        modifier = Modifier
            .fillMaxSize() // Fill the maximum available size
            .background(Color.White) // Set background color
            .padding(18.dp)
            .verticalScroll(rememberScrollState()),
        Arrangement.spacedBy(32.dp)
    ){
        ContainerImage()

        ArtistTitle(
            name = "John Doe",
            modifier = Modifier.padding(16.dp)
        )

        ActionButton()
    }
}

@Preview(name = "Main Layout")
@Composable
fun MainLayoutPreview(){
    MainLayout()
}