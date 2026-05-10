package cn.edu.ncu.wyl.test_serializable

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cn.edu.ncu.wyl.test_serializable.ui.theme.Chapter3Theme
import cn.edu.ncu.wyl.test_serializable.ui.theme.model.Student
import cn.edu.ncu.wyl.test_serializable.ui.theme.model.Teacher

class FirstActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val intent = intent
            //  这种方法已弃用，使用Parcelable接口来替代Serializable，更高效性能好/bundle
            val receivedStu: Student? = intent.getParcelableExtra("Student")
            Chapter3Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    FirstScreen(
                        name = "${receivedStu.toString()}",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun FirstScreen(name: String, modifier: Modifier = Modifier) {
    Box (modifier=modifier.fillMaxSize(),
        contentAlignment = Alignment.Center){
        Column (modifier=modifier,
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally){
            Text(
                text = "这是FirstSecond",
                fontSize = 24.sp
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "$name",
                modifier = modifier,
                fontSize = 24.sp,
                color = colorResource(R.color.teal_700)
            )
        }
    }
}