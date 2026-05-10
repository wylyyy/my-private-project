package cn.edu.ncu.wyl.test1.ui.theme.screen

import android.R
import android.content.Intent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource


import androidx.compose.ui.unit.sp

@Composable
fun<T> DisplayConten(modifier: Modifier,content:String,c:Class<T>){
    val context = LocalContext.current

    Column (modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        Text(text=content, fontSize=30.sp, color= colorResource(R.color.holo_blue_dark))
        Button(onClick = {
            val intent = Intent(context,c)
            context.startActivity(intent)
        })
        {
            Text("传递数据", fontSize = 24.sp)
        }
    }
}