package fr.epsi.epsiproject.sectionMenu

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import fr.epsi.epsiproject.BaseActivity
import fr.epsi.epsiproject.R

class ProduitDetailActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_produit_detail)
        val titleSize:TextView = findViewById(R.id.titleHeader)
        titleSize.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14F)

        val recIntent:Intent = intent
        showBtnBack()
        setTitle(recIntent.getStringExtra("nom").toString())

        val imgBigProduit:ImageView = findViewById(R.id.imgUnProduit)
        val descProduit:TextView = findViewById(R.id.descComplet)

        Picasso.get().load(recIntent.getStringExtra("url")).into(imgBigProduit)
        descProduit.text = recIntent.getStringExtra("desc")
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