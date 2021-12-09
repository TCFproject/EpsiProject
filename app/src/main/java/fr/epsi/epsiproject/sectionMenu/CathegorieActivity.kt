package fr.epsi.epsiproject.sectionMenu

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import fr.epsi.epsiproject.BaseActivity
import fr.epsi.epsiproject.R
import fr.epsi.epsiproject.adapter.Adapter
import fr.epsi.epsiproject.adapter.SetAdapter
import fr.epsi.epsiproject.sectionMenu.obj.Cathegorie
import okhttp3.*
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

        val listTest = ArrayList<SetAdapter>()

        okHttpClient.newCall(request).enqueue(object:Callback{
            override fun onResponse(call: Call, response: Response) {
                TODO("Not yet implemented")
            }

            override fun onFailure(call: Call, e: IOException) {
                TODO("Not yet implemented")
            }
        })
        listTest.add(Cathegorie("Boisson","pppp"))
        val adapter = Adapter(listTest, R.layout.rc_cathegorie)
        recycler.adapter = adapter
    }

    companion object{
        fun startCathegorieActivity(con:Context){
            con.startActivity(Intent(con,CathegorieActivity::class.java))
        }
    }
}