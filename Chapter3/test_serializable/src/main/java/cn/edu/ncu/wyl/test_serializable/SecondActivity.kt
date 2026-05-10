package cn.edu.ncu.wyl.test_serializable

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cn.edu.ncu.wyl.test_serializable.ui.theme.Chapter3Theme

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
    val context = LocalContext.current as SecondActivity
    Box(modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center) {
        Column {
            Text(
                text = "这是$name",
                fontSize = 24.sp
            )
            Spacer(modifier = Modifier.height(20.dp))
            Button(onClick = {
                val intent = Intent(context, MainActivity::class.java)
                intent.putExtra("From","From SecondActivity")
                context.setResult(Activity.RESULT_OK,intent)
                context.finish()
            }){
                Text("RETURN MAIN",
                    fontSize = 24.sp)
            }
        }
    }
}
