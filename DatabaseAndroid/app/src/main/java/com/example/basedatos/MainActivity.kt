package com.example.basedatos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.basedatos.Adapters.StudentsAdapter
import com.example.basedatos.Data.StudentsDb
import com.example.basedatos.Data.StudentsEntity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val studentsDb = StudentsDb(this)
    private lateinit var studentsList:ArrayList<StudentsEntity>
    private lateinit var studentsAdapter: StudentsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        studentsList = studentsDb.stundetsGetAll2()
        studentsAdapter = StudentsAdapter(studentsList,this@MainActivity)

        val linearLayoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL,false)

        rvwStudents.layoutManager = linearLayoutManager
        rvwStudents.setHasFixedSize(true)
        rvwStudents.adapter = studentsAdapter

    }
}
