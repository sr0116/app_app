package com.example.app19


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.text.SimpleDateFormat
import java.util.*

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.Holder>() {

    private val memoList = mutableListOf<Memo>()

    // 데이터 갱신 메서드
    fun updateData(newList: List<Memo>) {
        memoList.clear()
        memoList.addAll(newList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_memo, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val memo = memoList[position]
        holder.setMemo(memo)   // setMemo 호출
    }

    override fun getItemCount(): Int = memoList.size

    // 뷰홀더
    class Holder(view: View) : RecyclerView.ViewHolder(view) {
        private val textNo: TextView = view.findViewById(R.id.textNo)
        private val textContent: TextView = view.findViewById(R.id.textContent)
        private val textDateTime: TextView = view.findViewById(R.id.textDateTime)

        fun setMemo(memo: Memo) {
            textNo.text = "${memo.id}"
            textContent.text = memo.content
            val sdf = SimpleDateFormat("yyyy/MM/dd HH:mm", Locale.getDefault())
            textDateTime.text = sdf.format(memo.datetime)
        }
    }
}
