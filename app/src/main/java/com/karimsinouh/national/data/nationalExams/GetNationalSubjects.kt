package com.karimsinouh.national.data.nationalExams

import android.os.AsyncTask
import com.karimsinouh.national.data.Subject
import okio.IOException
import org.jsoup.Jsoup
import javax.inject.Inject

class GetNationalSubjects @Inject constructor() {



    suspend operator fun invoke(
        listener:(Result<List<Subject>>)->Unit
    ){
        Execute(listener).execute()
    }

    private inner class Execute(
        val listener:(Result<List<Subject>>)->Unit
    ):AsyncTask<Void,Void,List<Subject>>(){

        override fun doInBackground(vararg p0: Void?): List<Subject> {

            try {
                val doc=Jsoup.connect("$BASE_URL/examens-2bac/").get()

                val elements=doc.body().getElementsByClass("mada")

                val subjects=elements.map {

                    val name= it.getElementsByTag("a")[0].text()?:""
                    val icon= it.getElementsByTag("img")[0].attr("src")?:""
                    val url= it.getElementsByTag("a")[0].attr("href")?:""


                    Subject(name,url, BASE_URL+icon)
                }

                listener(Result.success(subjects))
            }catch (e:IOException){
                listener(Result.failure(e))
            }
            return emptyList()
        }

    }

}