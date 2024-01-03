package com.abyxcz.mad_imagesasync

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.rememberAsyncImagePainter
import com.abyxcz.mad_imagesasync.ui.theme.MADImagesAsyncTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MADImagesAsyncTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun DisplayImageFromUrl(imageUrl: String) {
    Image(
        painter = rememberAsyncImagePainter(model = imageUrl,
            error = painterResource(R.drawable.error),
            placeholder = painterResource(R.drawable.placeholder)),
        contentDescription = "Loaded image",
        modifier = Modifier.fillMaxWidth(),  // Or any modifier you require
        contentScale = ContentScale.Crop  // Or any content scale you prefer
    )
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MADImagesAsyncTheme {
        Greeting("Android")
    }
}