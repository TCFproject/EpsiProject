package fr.epsi.epsiproject.sectionMenu.obj

import fr.epsi.epsiproject.adapter.SetAdapter

class Cathegorie(private val libelle:String, private val url:String) : SetAdapter {
    override fun getTitle(): String {
        return this.libelle
    }

    override fun getInfo(): HashMap<String, String> {
        val item = HashMap<String,String>()
        item["url"] = url
        return item
    }
}