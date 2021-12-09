package fr.epsi.epsiproject.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import fr.epsi.epsiproject.R

class Adapter(private val objToAdapt:ArrayList<SetAdapter>, private val view:Int)
    : RecyclerView.Adapter<Adapter.ViewHolder>() {
    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val buttonCate:Button = v.findViewById(R.id.cathegorie)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val bindview = LayoutInflater.from(viewGroup.context)
            .inflate(this.view, viewGroup,false)
        return ViewHolder(bindview)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.buttonCate.text = objToAdapt.get(position).getTitle()
    }

    override fun getItemCount(): Int {
        return objToAdapt.size
    }
}