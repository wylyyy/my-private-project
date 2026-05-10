package cn.edu.ncu.wyl.test1

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.sp
import cn.edu.ncu.wyl.test1.ui.theme.Chapter3Theme

class SecondActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val receivedInt = intent.getIntExtra("intValue",0)
        val receivedStr = intent.getStringExtra("strValue")
        val receivedObj = intent.getParcelableExtra("objValue", Teacher::class.java)
        setContent {
            Chapter3Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting3(
                        name = "${receivedInt}  ${receivedStr}    ${receivedObj}",
                        modifier = Modifier
                            .padding(innerPadding)
                            .background(colorResource(id = android.R.color.darker_gray))
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting3(name: String, modifier: Modifier = Modifier) {
    val context = LocalContext.current as SecondActivity
    Column(modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        Text(text = "$name!", fontSize = 20.sp, modifier = modifier)
        Button(onClick = {
            val intent = Intent(context, MainActivity::class.java)
            intent.putExtra("value", "Welcome")
            context.setResult(2, intent)
            context.finish()
        }) {
            Text("RETURN", fontSize = 28.sp)
        }
    }
}
