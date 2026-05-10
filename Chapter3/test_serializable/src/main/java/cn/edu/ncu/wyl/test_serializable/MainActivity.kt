package cn.edu.ncu.wyl.test_serializable

import android.R
import android.content.Intent
import android.os.Bundle
import android.widget.Space
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cn.edu.ncu.wyl.test_serializable.ui.theme.Chapter3Theme
import cn.edu.ncu.wyl.test_serializable.ui.theme.model.Student
import cn.edu.ncu.wyl.test_serializable.ui.theme.model.Teacher
import java.time.LocalDate

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val resultLauncher: ActivityResultLauncher<Intent> =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult(),
            {
                if(it.resultCode==RESULT_OK){
                    Toast.makeText(this,it.data?.getStringExtra("From"),
                        Toast.LENGTH_LONG).show()
                }
            })
        enableEdgeToEdge()
        setContent {
            Chapter3Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainScreen(
                        modifier = Modifier.padding(innerPadding),
                        resultLauncher
                    )
                }
            }
        }
    }
}

@Composable
fun MainScreen(modifier: Modifier = Modifier,resultLauncher: ActivityResultLauncher<Intent>) {
    val context = LocalContext.current
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column (modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally){
            Text(
                text = "这是MainActivity",
                modifier = modifier,
                fontSize = 40.sp
            )
            Button(onClick = {
                val student: Student = Student("001","张三","女")
                val teacher: Teacher = Teacher("002","李四",8)

                val intent = Intent(context, FirstActivity::class.java)

                intent.putExtra("Student",student)
                intent.putExtra("Teacher",teacher)
                context.startActivity(intent)
            }) {
                Text("发送Student对象到FirstActivity",
                    fontSize = 24.sp)
            }
            Spacer(modifier = Modifier.height(20.dp))

            Button(onClick = {
                val intent = Intent(context, SecondActivity::class.java)
                resultLauncher.launch(intent)
            }){
                Text("跳转到SecondActivity",
                    fontSize = 24.sp)
            }
        }
    }
}