package com.example.a23_07_aston

import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.Request

fun main() {
    DogAPI.getDogs().random().let {
        println("${it.breed} d'origine ${it.origin}\nNote:${it.meta.notes}\nphoto : ${it.img}")
    }

//    for (it in DogAPI.getDogs()){
//        println(it)
//    }
}

object DogAPI {

    fun getDogs2(): Array<DogBean> {
        Thread.sleep(4000)
        return arrayOf(DogBean(1, "a", "b", "c", "d", MetaBean("e", "f")))
    }

    //1 méthode par appel d'API
    fun getDogs(): Array<DogBean> {


        val client = OkHttpClient()
        val request = Request.Builder()
            .url("https://dog-breeds2.p.rapidapi.com/dog_breeds")
            .get()
            .addHeader("X-RapidAPI-Key", "93329c7cf9msha136bd696cd1040p10a1dejsnbc52cdb0746e")
            .addHeader("X-RapidAPI-Host", "dog-breeds2.p.rapidapi.com")
            .build()

        println("Avant requête")
        val json: String = client.newCall(request).execute().use {
            //use permet de fermer la réponse qu'il y ait ou non une exception
            //Analyse du code retour
            if (!it.isSuccessful) {
                it.close()
                throw Exception("Réponse du serveur incorrect :${it.code}")
            }

            it.body.string()
        }

        //Convertir en objet, je lui donne l'objet de départ (ici collection)
        val data = Gson().fromJson(json, Array<DogBean>::class.java)

        return data
    }

}

data class DogBean(var id: Int, var breed: String, var origin: String, var url: String, var img: String, var meta: MetaBean)

data class MetaBean(var other_names: String, var notes: String)