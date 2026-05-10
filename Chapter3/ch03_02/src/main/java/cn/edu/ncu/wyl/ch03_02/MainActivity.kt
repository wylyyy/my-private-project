package cn.edu.ncu.wyl.ch03_02

import android.R
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.sp
import cn.edu.ncu.wyl.ch03_02.ui.theme.Chapter3Theme
import kotlin.jvm.java

class MainActivity : ComponentActivity() {
    //  用于 Activity 结果回调 的变量
    lateinit var  resultLauncher: ActivityResultLauncher<Intent>//用于启动Activity并处理结果的启动器
    lateinit var result: MutableState<String>   //用于存储和观察返回结果
    // 当值改变时自动触发 UI 更新的响应式状态

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        resultLauncher = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult(),
            { it ->
                // 处理从其他活动返回的数据
                if (it.resultCode == RESULT_OK) {
                    val s = it.data?.getStringExtra("RETURN").toString()
                    result.value = if (s.isEmpty()) "" else s
                    Toast.makeText(
                        this,
                        "${it.data?.getStringExtra("RETURN")}",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        )
        enableEdgeToEdge()
        setContent {
            Chapter3Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    DisplayContent(Modifier.padding(innerPadding),
                        "MainActivity：${result.value}",
                        resultLauncher,
                        FirstActivity::class.java)
                }
            }
        }
    }
}

@Composable
fun<T> DisplayContent(modifier: Modifier,
                      content:String,
                      resultLauncher: ActivityResultLauncher<Intent>,
                      c:Class<T>){
    val context = LocalContext.current

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Text(text = content,
            fontSize = 30.sp,
            color = colorResource(R.color.holo_blue_dark)
        )

        Button(onClick = {
            val intent = Intent(context, c)
            intent.putExtra("Data","From Main!")
            resultLauncher.launch(intent)
        })
        {
            Text("传递数据-可返回传回的数据", fontSize = 24.sp)
        }
    }
}