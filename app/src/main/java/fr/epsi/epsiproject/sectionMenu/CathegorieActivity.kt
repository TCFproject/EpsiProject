package fr.epsi.epsiproject.sectionMenu

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import fr.epsi.epsiproject.BaseActivity
import fr.epsi.epsiproject.R
import fr.epsi.epsiproject.adapter.Adapter
import fr.epsi.epsiproject.sectionMenu.obj.Cathegorie
import okhttp3.*
import org.json.JSONObject
import java.io.IOException

class CathegorieActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cathegorie)
        showBtnBack()
        setTitle("Rayons")

        val okHttpClient = OkHttpClient.Builder().build()
        val request = Request.Builder()
            .url("http://djemam.com/epsi/categories.json")
            .get()
            .cacheControl(CacheControl.FORCE_NETWORK)
            .build()

        val recycler:RecyclerView = findViewById(R.id.rcRayons)
        recycler.layoutManager = LinearLayoutManager(this)

        val listTest = ArrayList<Cathegorie>()
        val adapter = Adapter(listTest)
        recycler.adapter = adapter

        okHttpClient.newCall(request).enqueue(object:Callback{
            override fun onResponse(call: Call, response: Response) {
                val respons = response.body?.string()
                if(respons != null){
                    val jsobj = JSONObject(respons)
                    val jsArray =jsobj.getJSONArray("items")
                    for (i in 0 until jsArray.length()){
                        val jsCathegorie = jsArray.getJSONObject(i)
                        val libelle = jsCathegorie.optString("title","Echec")
                        val url = jsCathegorie.optString("products_url","Echec")

                        listTest.add(Cathegorie(libelle,url))
                    }
                    runOnUiThread(Runnable {
                        adapter.notifyDataSetChanged()
                    })
                }
            }

            override fun onFailure(call: Call, e: IOException) {
                TODO("Not yet implemented")
            }
        })
    }

    companion object{
        fun startCathegorieActivity(con:Context){
            con.startActivity(Intent(con,CathegorieActivity::class.java))
        }
    }
}