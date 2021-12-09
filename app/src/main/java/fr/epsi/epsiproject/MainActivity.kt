package fr.epsi.epsiproject

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import fr.epsi.epsiproject.sectionEtudiant.ListEtudiantActivity
import fr.epsi.epsiproject.sectionMenu.CathegorieActivity

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setTitle("Epsi")

        val buttonZone1:Button = findViewById(R.id.zone1)
        val buttonZone2:Button = findViewById(R.id.zone2)

        buttonZone1.setOnClickListener(View.OnClickListener {
            ListEtudiantActivity.startListEtudiantActivity(application)
        })

        buttonZone2.setOnClickListener(View.OnClickListener {
            CathegorieActivity.startCathegorieActivity(application)
        })
    }

    companion object{
        fun startMainActivity(con:Context){
            con.startActivity(Intent(con,MainActivity::class.java))
        }
    }
}