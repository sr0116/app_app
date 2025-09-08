package com.example.app19

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class SQLiteHelper(context: Context) :
    SQLiteOpenHelper(context, "memo.db", null, 1) {

    override fun onCreate(db: SQLiteDatabase) {
        val createTable = """
            CREATE TABLE memo (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                content TEXT,
                datetime LONG
            )
        """.trimIndent()
        db.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS memo")
        onCreate(db)
    }

    fun insertMemo(content: String, datetime: Long) {
        val values = ContentValues().apply {
            put("content", content)
            put("datetime", datetime)
        }
        writableDatabase.insert("memo", null, values)
    }

    fun listMemo(): List<Memo> {
        val list = mutableListOf<Memo>()
        val cursor = readableDatabase.rawQuery("SELECT * FROM memo ORDER BY id DESC", null)
        while (cursor.moveToNext()) {
            val id = cursor.getLong(cursor.getColumnIndexOrThrow("id"))
            val content = cursor.getString(cursor.getColumnIndexOrThrow("content"))
            val datetime = cursor.getLong(cursor.getColumnIndexOrThrow("datetime"))
            list.add(Memo(id, content, datetime))
        }
        cursor.close()
        return list
    }

    fun updateMemo(memo: Memo) {
        val values = ContentValues().apply {
            put("content", memo.content)
            put("datetime", memo.datetime)
        }
        writableDatabase.update("memo", values, "id=?", arrayOf(memo.id.toString()))
    }

    fun deleteMemo(id: Long) {
        writableDatabase.delete("memo", "id=?", arrayOf(id.toString()))
    }
}
