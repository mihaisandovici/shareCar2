package com.example.sharecar2

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.DatePicker
import android.widget.LinearLayout
import android.widget.TimePicker
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_search.*
import java.lang.NullPointerException
import java.util.*

class SearchActivity : AppCompatActivity(), DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {

    var day=0
    var month=0
    var year=0
    var hour=0
    var minute=0

    var savedDay=0
    var savedMonth=0
    var savedYear=0
    var savedHour=0
    var savedMinute=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        pickDate()
        showData()
        schimb()
        redirectCurse()

        val layoutManager = LinearLayoutManager(this)
        
        lista_curse.layoutManager = layoutManager
        lista_curse.adapter = AdapterCursa(listaDeCurse)
    }


    private fun getDateTimeCalendar(){
        val cal : Calendar = Calendar.getInstance()

        day =cal.get(Calendar.DAY_OF_MONTH)
        month =cal.get(Calendar.MONTH)
        year =cal.get(Calendar.YEAR)
        hour =cal.get(Calendar.HOUR)
        minute=cal.get(Calendar.MINUTE)
    }

    private fun pickDate(){
        cand.setOnClickListener {
            getDateTimeCalendar()

            DatePickerDialog(this,this, year,month,day).show()
        }
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        savedDay=dayOfMonth
        savedMonth=month
        savedYear=year

        getDateTimeCalendar()
        TimePickerDialog(this,this,hour,minute,true).show()
    }

    override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
        savedHour=hourOfDay
        savedMinute=minute

        cand.text="În data de: $savedDay/$savedMonth/$savedYear, de la ora: $savedHour:$savedMinute"
    }

    private fun showData(){

        cauta.setOnClickListener() {
//            verificaCampurile()

        }
    }
    private fun schimb()
    {
        schimba.setOnClickListener() {
            val aux=plecare.text
            plecare.text=destinatie.text
            destinatie.text=aux
        }
    }

    private fun verificaCampurile() {
        var p = false
        var d = false
        var c = false
        if (plecare.getText().toString().equals("")) {
            val plecnul = Toast.makeText(
                applicationContext,
                "Completați câmpul Plecare!",
                Toast.LENGTH_SHORT
            )
            plecnul.show()
            p = true
        }

        if (destinatie.getText().toString().equals("")) {
            val destnul = Toast.makeText(
                applicationContext,
                "Completați câmpul Destinație!",
                Toast.LENGTH_SHORT
            )
            destnul.show()
            d = true
        }

        if (savedDay == 0 && savedMonth == 0 && savedYear == 0 && savedHour == 0 && savedMinute == 0) {
            val candnul = Toast.makeText(
                applicationContext,
                "Completați câmpul \"Când?\"!",
                Toast.LENGTH_SHORT
            )
            candnul.show()
            c = true
        }

        if (p == false && d == false && c == false) {
            val toast = Toast.makeText(
                applicationContext,
                "Plecare din: " + plecare.text + "\nCu destinație în: " + destinatie.text + "\nÎn data de: $savedDay/$savedMonth/$savedYear, de la ora: $savedHour:$savedMinute",
                Toast.LENGTH_SHORT
            )
            toast.setGravity(Gravity.CENTER, 0, 200)
            toast.show()
        }
    }
    
    val listaDeCurse = listOf<Cursa>(
        Cursa("Ploiesti", "Brasov", "05:55"),
        Cursa("Ploiesti", "Brasov", "05:55"),
        Cursa("Ploiesti", "Brasov", "05:55"),
        Cursa("Ploiesti", "Brasov", "05:55"),
        Cursa("Ploiesti", "Brasov", "05:55"),
        Cursa("Ploiesti", "Brasov", "05:55"),
        Cursa("Ploiesti", "Brasov", "05:55"),
        Cursa("Ploiesti", "Brasov", "05:55"),
        Cursa("Ploiesti", "Brasov", "05:55")
    )
    private fun redirectCurse(){
        cauta2.setOnClickListener() {


            val intent = Intent(this, CurseActivity::class.java)
            startActivity(intent)
        }
    }

}