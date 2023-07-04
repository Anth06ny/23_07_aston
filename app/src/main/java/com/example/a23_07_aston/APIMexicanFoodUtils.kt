package com.example.a23_07_aston

import okhttp3.Request

object APIMexicanFoodUtils {

    fun lodaMexicanFood(): Array<MexicanFoodBean> {

        var json = sendGet()

        val data  = RequestUtils.gson.fromJson(json, Array<MexicanFoodBean>::class.java)

        return data
    }

    fun sendGet(): String {
        println()
        //Création de la requête
        val request = Request.Builder()
            .url("https://the-mexican-food-db.p.rapidapi.com/")
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