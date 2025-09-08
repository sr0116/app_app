package com.example.app19

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity4 : AppCompatActivity() {

    private lateinit var dbHelper: SQLiteHelper
    private lateinit var adapter: RecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sqlite)
// 데이터 베이스 사용을 위해
        dbHelper = SQLiteHelper(this) // 이미 SQLHelper 에 정의 해둠

//        val editId = findViewById<EditText>(R.id.editId)
        val editContent = findViewById<EditText>(R.id.editContent)
        val btnInsert = findViewById<Button>(R.id.btnInsert)
//        val btnSelect = findViewById<Button>(R.id.btnSelect)
//        val btnUpdate = findViewById<Button>(R.id.btnUpdate)
//        val btnDelete = findViewById<Button>(R.id.btnDelete)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        // RecyclerView + Adapter 세팅
        adapter = RecyclerAdapter()
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        // C : Insert
        btnInsert.setOnClickListener {
            val text = editContent.text.toString()
            if (text.isNotEmpty()) {
                dbHelper.insertMemo(text, System.currentTimeMillis())
                Toast.makeText(this, "메모 저장 완료!", Toast.LENGTH_SHORT).show()
                editContent.text.clear()
                loadMemos()
            } else {
                Toast.makeText(this, "내용을 입력하세요", Toast.LENGTH_SHORT).show()
            }
        }

        // R : Select
//        btnSelect.setOnClickListener { loadMemos() }

        // U : Update
//        btnUpdate.setOnClickListener {
//            val idText = editId.text.toString()
//            val newContent = editContent.text.toString()
//            if (idText.isNotEmpty() && newContent.isNotEmpty()) {
//                val id = idText.toLong()
//                val memo = Memo(id, newContent, System.currentTimeMillis())
//                dbHelper.updateMemo(memo)
//                Toast.makeText(this, "메모 수정 완료!", Toast.LENGTH_SHORT).show()
//                loadMemos()
//            } else {
//                Toast.makeText(this, "ID와 내용을 입력하세요", Toast.LENGTH_SHORT).show()
//            }
//        }

        // D : Delete
//        btnDelete.setOnClickListener {
//            val idText = editId.text.toString()
//            if (idText.isNotEmpty()) {
//                val id = idText.toLong()
//                dbHelper.deleteMemo(id)
//                Toast.makeText(this, "메모 삭제 완료!", Toast.LENGTH_SHORT).show()
//                editId.text.clear()
//                loadMemos()
//            } else {
//                Toast.makeText(this, "삭제할 ID를 입력하세요", Toast.LENGTH_SHORT).show()
//            }
//        }

        // 실행 시 목록 불러오기
        loadMemos()
    }

    private fun loadMemos() {
        val list = dbHelper.listMemo()
        adapter.updateData(list)   //  Memo 객체 그대로 전달
    }
}
