package cn.edu.ncu.wyl.test1

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultCallback
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
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import cn.edu.ncu.wyl.test1.ui.theme.Chapter3Theme

class MainActivity : ComponentActivity() {
    val resultLauncher: ActivityResultLauncher<Intent> = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult(),
        ActivityResultCallback {
            if (it.resultCode == 1) {
                Toast.makeText(
                    this, "from-first:${it.data?.getStringExtra("value")} ",
                    Toast.LENGTH_LONG
                ).show()
            } else if (it.resultCode == 2) {
                Toast.makeText(
                    this, "from-second:${it.data?.getStringExtra("value")} ",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Chapter3Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    HomeScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }


    fun turnToFirst(){
        val intent = Intent(this, FirstActivity::class.java)
        val bundle = Bundle()
        bundle.putInt("intValue",23)
        bundle.putString("strValue","Hello from Main")
        bundle.putSerializable("objectValue", Student("001","张三","男"))

        intent.putExtras(bundle)
        resultLauncher.launch(intent)
    }

    fun turToSecond(){

        val intent = Intent("cn.edu.ncu.Second")
//        intent.setPackage("cn.edu.ncu.wyl.test1.activity")
        intent.putExtra("intValue",6666)
        intent.putExtra("strValue","WELCOME TO ANDROID")
        intent.putExtra("objValue", Teacher("002","王老师",8))

        resultLauncher.launch(intent)
    }
}
@Composable
fun HomeScreen(modifier:Modifier){
    val context = LocalContext.current as MainActivity
    var textState =remember{ mutableIntStateOf(0)}
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("实例应用", fontSize = 42.sp)


        Button(onClick = {
            context.turnToFirst()
        }) {
            Text("Press Btn to First")
        }


        Button(onClick = {
            context.turToSecond()
        }) {
            Text("Press Btn to Second")
        }
        Text("结果：${textState.value}", fontSize = 28.sp)
    }
}


