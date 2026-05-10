package cn.edu.ncu.wyl.test1

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import cn.edu.ncu.wyl.test1.ui.theme.Chapter3Theme

class FirstActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val bundle = intent.extras
        val receivedInt = bundle?.getInt("intValue")
        val receivedStr = bundle?.getString("strValue")
        val receivedObj = bundle?.getSerializable("objectValue", Student::class.java)

        setContent {
            Chapter3Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting2(
                        name = "int:${receivedInt}  str:${receivedStr}  obj:${receivedObj}",
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
    Column (modifier=modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally){
        Text(
            text = "$name!",
            fontSize = 20.sp,
            modifier = modifier
        )

        Button(onClick={
            val intent = Intent(context, MainActivity::class.java)
            intent.putExtra("value","Hello")
            context.setResult(1,intent)
            context.finish()})
        {
            Text("RETURN",fontSize = 24.sp)
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