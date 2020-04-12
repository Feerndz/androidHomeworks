package com.example.basedatos.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.basedatos.Data.StudentsEntity
import com.example.basedatos.R
import kotlinx.android.synthetic.main.item_student.view.*
import java.util.zip.Inflater

class StudentsAdapter(val studentList:ArrayList<StudentsEntity>, val context: Context): RecyclerView.Adapter<StudentsHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentsHolder {
        val inflater = LayoutInflater.from(parent.context)
        return StudentsHolder(inflater.inflate(R.layout.item_student,parent,false))
    }

    override fun getItemCount(): Int {
        return studentList.size
    }

    override fun onBindViewHolder(holder: StudentsHolder, position: Int) {
        holder.txvName.text = "${studentList[position].name} ${studentList[position].lastName}"
        holder.txvGender.text = if (studentList[position].gender == 1) "Masculino" else "Femenino"
        holder.txvBirthday.text = studentList[position].birthday

        holder.ibtEdit.setOnClickListener{
            Toast.makeText(context,"Botón edit ${studentList[position].name}",Toast.LENGTH_LONG).show()
        }

        holder.ibtDelete.setOnClickListener {
            Toast.makeText(context,"Botón delete ${studentList[position].name}",Toast.LENGTH_LONG).show()
        }
    }

}

class StudentsHolder(view: View): RecyclerView.ViewHolder(view){

    val imvLogoItem = view.imvLogoItem
    val txvName = view.txvName
    val txvGender = view.txvGender
    val txvBirthday = view.txvBirthday
    val ibtEdit = view.ibtEdit
    val ibtDelete = view.ibtDelete

}