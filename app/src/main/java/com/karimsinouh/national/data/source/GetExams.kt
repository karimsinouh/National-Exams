package com.karimsinouh.national.data.source

import android.os.AsyncTask
import android.util.Log
import com.karimsinouh.national.data.Exam
import okio.IOException
import org.jsoup.Jsoup
import javax.inject.Inject

class GetExams @Inject constructor() {

    operator fun invoke(
        url: String,
        listener:(Result<List<Exam>>)->Unit
    ){
        val executer=Execute(url,listener)
        executer.execute()
    }


    private inner class Execute(private val url:String,private val listener: (Result<List<Exam>>) -> Unit)
        :AsyncTask<Void,Void,List<Exam>>(){

        override fun doInBackground(vararg p0: Void?): List<Exam> {

            try {

                val doc=Jsoup.connect(url).get()

                val trs=doc.select("tbody tr")

                val exams=trs.map {tr->

                    val tds=tr.getElementsByTag("td")


                    //name
                    val name =try {
                        tds.first()?.text()
                    }catch (e:Exception){
                        null
                    }


                    //normal
                    val normal=  try {
                        tr.getElementsByTag("a")[0]?.attr("href")
                    }catch (e:Exception){
                        null
                    }


                    //rattrapage
                    val rattrapage=  try {
                        tr.getElementsByTag("a")[1]?.attr("href")
                    }catch (e:Exception){
                        null
                    }

                    Log.d("rattrapage",rattrapage?:"no")
                    Log.d("normal",normal?:"no")

                    Exam(
                        name=name?:"NOT AVAILABLE",
                        normal = normal,
                        rattrapage = rattrapage
                    )
                }

                listener(Result.success(exams))


            }catch (e:IOException){
                listener(Result.failure(e))
            }

            return emptyList()
        }

    }

}