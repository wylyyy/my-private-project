package cn.edu.ncu.wyl.test1

import java.io.Serializable

/**
 * TODO 定义学生类
 *
 * @property id：学号
 * @property name：姓名
 * @property gender：性别
 */
data class Student(val id: String,
                   val name:String,
                   val gender:String): Serializable