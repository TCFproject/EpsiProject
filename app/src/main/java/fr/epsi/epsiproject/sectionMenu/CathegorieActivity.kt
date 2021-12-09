package fr.epsi.epsiproject.sectionMenu

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import fr.epsi.epsiproject.BaseActivity
import fr.epsi.epsiproject.R

class CathegorieActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cathegorie)
        showBtnBack()
        setTitle("Rayons")


    }

    companion object{
        fun startCathegorieActivity(con:Context){
            con.startActivity(Intent(con,CathegorieActivity::class.java))
        }
    }
}