package fr.epsi.epsiproject

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        showBtnBack()
        setTitle("Epsi")
    }

    companion object{
        fun startMainActivity(con:Context){
            con.startActivity(Intent(con,MainActivity::class.java))
        }
    }
}