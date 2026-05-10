package cn.edu.ncu.wyl.chapter3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import cn.edu.ncu.wyl.chapter3.ui.theme.Chapter3Theme

class SecondActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Chapter3Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting3(
                        name = "SecondActivity",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting3(name: String, modifier: Modifier = Modifier) {
    Box (modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center){
        Text(
            text = "Hello $name!",
            modifier = modifier,
            fontSize = 30.sp,
            color = colorResource(R.color.teal_700)
        )
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview3() {
    Chapter3Theme {
        Greeting3("Android")
    }
}