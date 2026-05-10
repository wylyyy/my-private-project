package cn.edu.ncu.wyl.ch03_02

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import cn.edu.ncu.wyl.ch03_02.ui.theme.Chapter3Theme

class FirstActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Chapter3Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting2(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting2(name: String, modifier: Modifier = Modifier) {
    val context = LocalContext.current as FirstActivity
    Column {
        Text(
            text = "Hello $name!",
            modifier = modifier
        )
        Button(onClick = {
            val intent = Intent(context, MainActivity::class.java)
            intent.putExtra("RETURN","From First!")
            context.setResult(Activity.RESULT_OK,intent)
            context.finish()
        })
        {
            Text("Back", fontSize = 30.sp)
        }
    }


}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    Chapter3Theme {
        Greeting2("Android")
    }
}