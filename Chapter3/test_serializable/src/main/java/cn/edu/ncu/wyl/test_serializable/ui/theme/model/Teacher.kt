package cn.edu.ncu.wyl.test_serializable.ui.theme.model
import android.os.Parcel
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Teacher(val id:String,val name:String,val workTime:Int): Parcelable


//data class Teacher(val id:String,val name:String,val workTime:Int): Parcelable {
//    /**
//     * 辅助构造器
//     * 将parcel生成共享数据块
//     */
//    constructor(parcel: Parcel):this(parcel.readString()!!,
//        parcel.readString()!!,parcel.readInt()!!){}
//
//    override fun describeContents(): Int  = 0
//
//    /**
//     * TODO 分解数据
//     *
//     * @param dest
//     * @param flags
//     */
//    override fun writeToParcel(dest: Parcel, flags: Int) {
//        dest.writeString(id)
//        dest.writeString(name)
//        dest.writeInt(workTime)
//    }
//
//    /**
//     * Creator:定义伴随对象
//     */
//    companion object CREATOR: Parcelable.Creator<Teacher>{
//        /**
//         * TODO 重组数据
//         *
//         * @param source
//         * @return
//         */
//        override fun createFromParcel(source: Parcel?): Teacher?=Teacher(source!!)
//        override fun newArray(size: Int): Array<out Teacher?>? = arrayOfNulls(size)
//    }
//}