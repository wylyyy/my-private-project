package cn.edu.ncu.wyl.chapter3

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntRect
import androidx.compose.ui.unit.sp
import cn.edu.ncu.wyl.chapter3.ui.theme.Chapter3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Chapter3Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@SuppressLint("UnrememberedMutableState")
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    //this 上下文
    val context = LocalContext.current
    var nameState:MutableState<String> = remember{mutableStateOf("ANDROID")}
    Box(modifier= Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center) {
        Column {
            Text(
                text = "Hello ${nameState.value}!",
                color = colorResource(R.color.teal_700),
                fontSize = 30.sp,
                modifier = modifier
            )
            Button(onClick={
                nameState.value = "WELCOME"
                Log.d("Tag",nameState.value)

                //页面跳转
                val intent = Intent(context,FirstActivity::class.java)
                //传输一个数据
                intent.putExtra("strData","HELLO FROM MAIN")

                //一次性传输很多数据:创建Bundle数据包
                val bundle = Bundle()
                //配置传递数据的键值对
                bundle.putString("bundle-StringValue","From MainActivity")
                bundle.putInt("bundle-IntValue",101)
                intent.putExtras(bundle)

                context.startActivity(intent)

            }){
                Text(text = "Jump First--显示Intent",
                    fontSize = 20.sp,)
            }


            Button(onClick = {
                val intent = Intent("cn.edu.ncu.Second")
                context.startActivity(intent)
            }) {
                Text("Jump Second -- 隐式Intent",
                    fontSize = 20.sp
                )
            }
        }

    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Chapter3Theme {
        Greeting("Android")
    }
}