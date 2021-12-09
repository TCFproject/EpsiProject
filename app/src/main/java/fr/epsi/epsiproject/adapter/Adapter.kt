package fr.epsi.epsiproject.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import fr.epsi.epsiproject.R
import fr.epsi.epsiproject.sectionMenu.obj.Cathegorie

open class Adapter(protected val objToAdapt:ArrayList<Cathegorie>)
    : RecyclerView.Adapter<Adapter.ViewHolder>() {
    class ViewHolder(v:View) : RecyclerView.ViewHolder(v) {
        val btn:Button = v.findViewById(R.id.cathegorie)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val bindview = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.rc_cathegorie, viewGroup,false)
        return ViewHolder(bindview)
    }

    override fun onBindViewHolder(view: ViewHolder, position: Int) {
        view.btn.text = objToAdapt.get(position).getTitle()
    }

    override fun getItemCount(): Int {
        return objToAdapt.size
    }
}