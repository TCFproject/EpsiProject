package fr.epsi.epsiproject.sectionMenu.obj

class Cathegorie(private val libelle:String, private val url:String) {
     fun getTitle(): String {
        return this.libelle
     }

     fun geturl(): String {
        return url
    }
}