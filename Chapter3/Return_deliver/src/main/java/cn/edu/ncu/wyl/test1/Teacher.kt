package cn.edu.ncu.wyl.test1

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Teacher(val id:String,val name:String,val workTime:Int): Parcelable