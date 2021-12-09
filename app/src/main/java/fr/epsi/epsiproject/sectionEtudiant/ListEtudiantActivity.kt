package fr.epsi.epsiproject.sectionEtudiant

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import fr.epsi.epsiproject.BaseActivity
import fr.epsi.epsiproject.R

class ListEtudiantActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_etudiant)
        showBtnBack()
        setTitle("Infos")
        val button1:Button = findViewById(R.id.etudiant1)
        val button2:Button = findViewById(R.id.etudiant2)
        val button3:Button = findViewById(R.id.etudiant3)

        button1.setOnClickListener(View.OnClickListener {
            EtudiantActivity.startEtudiantActivity(application,"CHANG-FONG"
                ,"Thierry"
                ,"thierry.changfong@epsi.fr"
                ,"G2"
                ,"https://upload.wikimedia.org/wikipedia/commons/thumb/6/6f/Tony_stark_%283261723587%29.jpg/450px-Tony_stark_%283261723587%29.jpg")
        })
    }

    companion object{
        fun startListEtudiantActivity(con: Context){
            con.startActivity(Intent(con,ListEtudiantActivity::class.java))
        }
    }
}