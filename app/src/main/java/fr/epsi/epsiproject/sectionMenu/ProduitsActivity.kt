package fr.epsi.epsiproject.sectionMenu

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import fr.epsi.epsiproject.BaseActivity
import fr.epsi.epsiproject.R

class ProduitsActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_produits)
        showBtnBack()
        val inte:Intent = intent
        val recProduit:RecyclerView = findViewById(R.id.produitId)
        recProduit.layoutManager = LinearLayoutManager(this)

        setTitle(inte.getStringExtra("nom"))
    }

    companion object{
        fun startProduitsActivity(con: Context, nomCate:String, url:String){
            con.startActivity(Intent(con,ProduitsActivity::class.java)
                .putExtra("nom",nomCate)
                .putExtra("url", url))
        }
    }
}