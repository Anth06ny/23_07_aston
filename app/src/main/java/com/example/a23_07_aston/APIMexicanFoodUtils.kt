package com.example.a23_07_aston

import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.Request

//object -> Singleton -> instance unique
object APIMexicanFoodUtils {

    val client = OkHttpClient()
    val gson = Gson()

    //1 méthode par appel d'API
    fun loadMexicanFood(): Array<MexicanFoodBean> {
        //Requête qui retourne du JSON sous forme String
        var json = sendGet("https://the-mexican-food-db.p.rapidapi.com/")
        //Convertir en objet, je lui donne l'objet de départ (ici collection)
        val data  = gson.fromJson(json, Array<MexicanFoodBean>::class.java)

        return data
    }

    fun loadMexicanFoodDetail(id:String): MexicanFoodDetailBean {
        //Requête qui retourne du JSON sous forme String
        var json = sendGet("https://the-mexican-food-db.p.rapidapi.com/$id")
        //Convertir en objet, je lui donne l'objet de départ (ici objet)
        val data  = gson.fromJson(json, MexicanFoodDetailBean::class.java)

        return data
    }

    //Appel générique sur la même API
    //Retourn le JSON / HTML
    fun sendGet(url : String): String {
        println("url=$url")
        //Création de la requête
        val request = Request.Builder()
            .url(url)
            .get()
            .addHeader("X-RapidAPI-Key", "93329c7cf9msha136bd696cd1040p10a1dejsnbc52cdb0746e")
            .addHeader("X-RapidAPI-Host", "the-mexican-food-db.p.rapidapi.com")
            .build()


        //Execution de la requête
        return RequestUtils.client.newCall(request).execute().use { //it:Response
            //use permet de fermer la réponse qu'il y ait ou non une exception
            //Analyse du code retour
            if (!it.isSuccessful) {
                throw Exception("Réponse du serveur incorrect :${it.code}")
            }
            //Résultat de la requête
            it.body.string()
        }
    }
}