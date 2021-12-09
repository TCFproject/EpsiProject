package fr.epsi.epsiproject.sectionEtudiant

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import fr.epsi.epsiproject.BaseActivity
import fr.epsi.epsiproject.R

class EtudiantActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_etudiant)
        showBtnBack()
        val getIntent:Intent = intent
        setTitle(getIntent.getStringExtra("nom"))
        val textNomPrenom:TextView = findViewById(R.id.nomPrenomEtudiant)
        val textEmail:TextView = findViewById(R.id.emailEtudiant)
        val groupeEtudiant:TextView = findViewById(R.id.groupEtudiant)
        val etudiantImage:ImageView = findViewById(R.id.imageEtudiant)

        textNomPrenom.text = getIntent.getStringExtra("nom")+" "+getIntent.getStringExtra("prenom")
        textEmail.text = getIntent.getStringExtra("email")
        groupeEtudiant.text = getIntent.getStringExtra("groupe")
        Picasso.get().load(getIntent.getStringExtra("urlAvatar")).into(etudiantImage)
    }

    companion object{
        fun startEtudiantActivity(con: Context, nom:String,prenom:String,email: String,groupe:String, urlAvatar:String){
            con.startActivity(Intent( con,EtudiantActivity::class.java)
                .putExtra("nom",nom)
                .putExtra("prenom",prenom)
                .putExtra("email",email)
                .putExtra("groupe",groupe)
                .putExtra("urlAvatar",urlAvatar))
        }
    }
}