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

class FirstActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val received = intent.getStringExtra("strData")
        //接收方：接收数据方法1:根据bundle来获得数据
        val intent = intent
        val bundle: Bundle?=intent.extras
        val strBundleDate = bundle?.getString("bundle-StringValue",null)
        val intBundleDate = bundle?.getInt("bundle-IntValue")

        //方法2：直接调用启动该活动的意图的方法，根据Intent直接获得数据
        val strData = intent.getStringExtra("bundle-StringValue")
        val intData = intent.getIntExtra("bundle-IntValue",0)

        setContent {
            Chapter3Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting2(
                        name = "FirstActivity get***Extra():${received}          " +
                                "调用FirstActivity的意图方法：${strData}-${intData}          " +
                                "根据bundle获得数据：${strBundleDate}-${intBundleDate}",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting2(name: String, modifier: Modifier = Modifier) {
    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center){
        Text(
            text = "Hello $name!",
            modifier = modifier,
            fontSize = 20.sp,
            color = colorResource(R.color.teal_700)
        )
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    Chapter3Theme {
        Greeting2("Android")
    }
}