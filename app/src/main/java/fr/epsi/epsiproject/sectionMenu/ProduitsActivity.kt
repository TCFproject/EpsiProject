package fr.epsi.epsiproject.sectionMenu

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import fr.epsi.epsiproject.BaseActivity
import fr.epsi.epsiproject.R
import fr.epsi.epsiproject.adapter.AdapterProduit
import fr.epsi.epsiproject.sectionMenu.obj.Produit
import okhttp3.*
import org.json.JSONObject
import java.io.IOException
import java.net.URI
import java.net.URL
import java.util.ArrayList

class ProduitsActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_produits)
        val inte:Intent = intent
        showBtnBack()
        setTitle(inte.getStringExtra("nom").toString())
        val recProduit:RecyclerView = findViewById(R.id.produitId)
        recProduit.layoutManager = LinearLayoutManager(this)

        val listProd = ArrayList<Produit>()
        val adapterProd = AdapterProduit(listProd)
        recProduit.adapter = adapterProd

        val okHttpClient = OkHttpClient.Builder().build()
        val request = Request.Builder()
            .url(inte.getStringExtra("url").toString())
            .get()
            .cacheControl(CacheControl.FORCE_NETWORK)
            .build()
        okHttpClient.newCall(request).enqueue(object: Callback {
            override fun onResponse(call: Call, response: Response) {
                val respons = response.body?.string()
                if (respons != null){
                    val jsobj = JSONObject(respons)
                    val jsArray =jsobj.getJSONArray("items")
                    for (i in 0 until jsArray.length()){
                        val json = jsArray.getJSONObject(i)
                        val nom = json.optString("name","Echec")
                        val desc = json.optString("description", "Echec")
                        val url = json.optString("picture_url","echec")

                        listProd.add(Produit(nom, desc, url))
                    }
                    runOnUiThread(Runnable {
                        adapterProd.notifyDataSetChanged()
                    })
                }
            }

            override fun onFailure(call: Call, e: IOException) {
                TODO("Not yet implemented")
            }
        })
    }

    companion object{
        fun startProduitsActivity(con: Context, nomCate:String, url:String){
            con.startActivity(Intent(con,ProduitsActivity::class.java)
                .putExtra("nom",nomCate)
                .putExtra("url", url))
        }
    }
}