package com.example.sharecar2

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.DatePicker
import android.widget.TimePicker
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_search.*
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

    val auth = FirebaseAuth.getInstance()
    val database = FirebaseDatabase.getInstance().reference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        showData()
        pickDate()
        schimb()
        redirectCurse()
        orase()

        val layoutManager = LinearLayoutManager(this)
        
        lista_curse.layoutManager = layoutManager
        lista_curse.adapter = AdapterCursa(listaDeCurse)

        val email = intent.getStringExtra(LoginActivity.EMAIL_CODE)
        Toast.makeText(this, email, Toast.LENGTH_LONG).show()


    }

    private fun startUsersScreen()
    {
        val intent = Intent(this, UsersClass::class.java)
        startActivity(intent)
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
//            trebuie sa fie commentat
            startUsersScreen()
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
        var verificaPlecare = false
        var verificaDestinatie = false
        var verificaCand = false
        if (plecare.getText().toString().equals("")) {
            val plecnul = Toast.makeText(
                applicationContext,
                "Completați câmpul Plecare!",
                Toast.LENGTH_SHORT
            )
            plecnul.show()
            verificaPlecare = true
        }

        if (destinatie.getText().toString().equals("")) {
            val destnul = Toast.makeText(
                applicationContext,
                "Completați câmpul Destinație!",
                Toast.LENGTH_SHORT
            )
            destnul.show()
            verificaDestinatie = true
        }

        if (savedDay == 0 && savedMonth == 0 && savedYear == 0 && savedHour == 0 && savedMinute == 0) {
            val candnul = Toast.makeText(
                applicationContext,
                "Completați câmpul \"Când?\"!",
                Toast.LENGTH_SHORT
            )
            candnul.show()
            verificaCand = true
        }

        if (verificaPlecare == false && verificaDestinatie == false && verificaCand == false) {
            val toast = Toast.makeText(
                applicationContext,
                "Plecare din: " + plecare.text + "\nCu destinație în: " + destinatie.text + "\nÎn data de: $savedDay/$savedMonth/$savedYear, de la ora: $savedHour:$savedMinute",
                Toast.LENGTH_SHORT
            )
            toast.setGravity(Gravity.CENTER, 0, 200)
            toast.show()
        }
    }

    private fun orase(){
        cauta3.setOnClickListener {
            val intent = Intent(this, OraseActivity::class.java)
            startActivity(intent)
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