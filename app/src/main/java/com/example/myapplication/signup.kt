package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.values

class signup : AppCompatActivity() {

    // stap 3 database input

    lateinit var databas : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        // stap 1
        val signupbutton= findViewById<Button>(R.id.btnsignup)
        val etxname= findViewById<TextInputEditText>(R.id.idfirstname)
        val etxuserid= findViewById<TextInputEditText>(R.id.idlastname)
        val etxemail= findViewById<TextInputEditText>(R.id.idemail)
        val etxnumber= findViewById<TextInputEditText>(R.id.idnumber)
        val etxpassword= findViewById<TextInputEditText>(R.id.idpassword)
        // stap 2
        signupbutton.setOnClickListener {
            val intent= Intent(this, login::class.java)
            startActivity(intent)
            val Name= etxname.text.toString()
            val UserID= etxuserid.text.toString()
            val Email= etxemail.text.toString()
            val Number= etxnumber.text.toString()
            val Password= etxpassword.text.toString()

            // stap 5 create a object

            val user= User(Name, UserID, Email, Number, Password)

            // stap 4 next stap child userid set

            databas= FirebaseDatabase.getInstance().getReference("User")

            // use class

            databas.child(UserID).setValue(user).addOnCanceledListener {

                // stap 7

                etxname.text?.clear()
                Toast.makeText(this, "Registration Complete", Toast.LENGTH_SHORT).show()
            }.addOnCanceledListener {
                Toast.makeText(this, "Registration Failed", Toast.LENGTH_SHORT).show()
            }
        }
    }
}