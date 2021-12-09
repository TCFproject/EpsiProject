package fr.epsi.epsiproject.sectionMenu

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import fr.epsi.epsiproject.BaseActivity
import fr.epsi.epsiproject.R

class ProduitDetailActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_produit_detail)
    }

    companion object{
        fun startProduitDetailActivity(con: Context, nomCate:String, desc:String, url:String){
            con.startActivity(
                Intent(con,ProduitDetailActivity::class.java)
                .putExtra("desc", desc)
                .putExtra("nom",nomCate)
                .putExtra("url", url))
        }
    }
}