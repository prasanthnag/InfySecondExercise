package com.infy.newsmvvm.repository

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.infy.newsmvvm.R
import com.infy.newsmvvm.model.NewsDetails
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException
import java.io.InputStream
import java.nio.charset.Charset

class Repository(private val context: Context) {
    private var mNewsDetails: ArrayList<NewsDetails> = arrayListOf()
    private var mutableLiveData: MutableLiveData<ArrayList<NewsDetails>> = MutableLiveData()

    fun getNewsData(): MutableLiveData<ArrayList<NewsDetails>> {
        mNewsDetails = getJSONItems()
        mutableLiveData.value = mNewsDetails

        return mutableLiveData
    }

    private fun getJSONItems(): ArrayList<NewsDetails> {
        val newsDetailsList : ArrayList<NewsDetails> = arrayListOf()
        try {
            val jsonObject = JSONObject(readJSON())
            var newsDetails: NewsDetails
            val jsonArray = jsonObject.getJSONArray("rows")
            for (i in 0 until jsonArray.length()) {
                val itemObj = jsonArray.getJSONObject(i)
                val title = if (!itemObj.isNull("title")) itemObj.getString("title") else null
                val description =
                    if (!itemObj.isNull("description")) itemObj.getString("description") else null
                val imageRef =
                    if (!itemObj.isNull("imageHref")) itemObj.getString("imageHref") else null
                if (title != null || description != null || imageRef != null) {
                    newsDetails = NewsDetails(title, description, imageRef)
                    newsDetailsList.add(newsDetails)
                }
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return newsDetailsList
    }

    private fun readJSON(): String {
        var jsonString: String? = null
        try {
            val inputStream: InputStream?
            inputStream = context.resources.openRawResource(R.raw.newsdetails)
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            jsonString = String(buffer, Charset.defaultCharset())
        } catch (e: IOException) {
            e.printStackTrace()
        }

        return jsonString ?: ""
    }


}