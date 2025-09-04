package com.example.app19

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = findViewById<Button>(R.id.button1)
        btn.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }

//        // 버튼 1
//        val btn1 = findViewById<Button>(R.id.button1)
//        btn1.setOnClickListener {
//            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:01012345678"))
//            startActivity(intent)
//        }
//
//        // 버튼 2
//        val btn2 = findViewById<Button>(R.id.button2)
//        btn2.setOnClickListener {
//            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:01023456789"))
//            startActivity(intent)
//        }
//
//        // 버튼 3
//        val btn3 = findViewById<Button>(R.id.button3)
//        btn3.setOnClickListener {
//            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:01034567890"))
//            startActivity(intent)
//        }
//
//        // 버튼 4
//        val btn4 = findViewById<Button>(R.id.button4)
//        btn4.setOnClickListener {
//            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:01045678901"))
//            startActivity(intent)
//        }
//
//        // 버튼 5
//        val btn5 = findViewById<Button>(R.id.button5)
//        btn5.setOnClickListener {
//            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:01056789012"))
//            startActivity(intent)
//        }

//        val listView = findViewById<ListView>(R.id.myListView)
//
//        val items = ArrayList<String>()
//        items.add("첫 번째 아이템")
//        items.add("두 번째 아이템")
//        items.add("세 번째 아이템")
//
//        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items)
//        listView.adapter = adapter
//
//        listView.setOnItemClickListener{ _, view, position, id ->
//            val selectedItem = items[position]
//            Toast.makeText(this, "클릭한 항목: $selectedItem", Toast.LENGTH_SHORT).show()
//        }

    }
}