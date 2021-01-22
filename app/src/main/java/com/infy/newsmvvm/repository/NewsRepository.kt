package com.infy.newsmvvm.repository

import android.content.Context
import com.infy.newsmvvm.R
import com.infy.newsmvvm.model.NewsDetails
import com.infy.newsmvvm.util.Constants
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException
import java.io.InputStream
import java.nio.charset.Charset

class NewsRepository(private val context: Context) {

    fun getJSONItems(): ArrayList<NewsDetails> {
        val newsDetailsList: ArrayList<NewsDetails> = arrayListOf()
        try {
            val jsonObject = JSONObject(readJSON())
            var newsDetails: NewsDetails
            val jsonArray = jsonObject.getJSONArray("rows")
            for (i in 0 until jsonArray.length()) {
                val itemObj = jsonArray.getJSONObject(i)
                val title = if (!itemObj.isNull(Constants.KEY_TITLE)) itemObj.getString(Constants.KEY_TITLE) else null
                val description =
                    if (!itemObj.isNull(Constants.KEY_DESCRIPTION)) itemObj.getString(Constants.KEY_DESCRIPTION) else null
                val imageRef =
                    if (!itemObj.isNull(Constants.KEY_IMAGE_URL)) itemObj.getString(Constants.KEY_IMAGE_URL) else null
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