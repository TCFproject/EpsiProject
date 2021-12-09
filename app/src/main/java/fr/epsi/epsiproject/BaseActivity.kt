package fr.epsi.epsiproject

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

open class BaseActivity : AppCompatActivity() {
    fun showBtnBack(){
        val btnBack:ImageView = findViewById(R.id.btnBack)
        btnBack.visibility = View.VISIBLE
        btnBack.setOnClickListener(View.OnClickListener {
            finish()
        })
    }

    fun setTitle(txt:String){
        val title:TextView = findViewById(R.id.titleHeader)
        title.setText(txt)
    }
}