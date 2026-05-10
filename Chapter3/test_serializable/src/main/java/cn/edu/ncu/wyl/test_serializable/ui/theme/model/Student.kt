package cn.edu.ncu.wyl.test_serializable.ui.theme.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * TODO 定义学生类
 *
 * @property id：学号
 * @property name：姓名
 * @property gender：性别
 */
@Parcelize
data class Student(val id: String, val name:String, val gender:String): Parcelable