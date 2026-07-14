package com.littleapp.pop.repository

import android.content.Context
import com.littleapp.pop.model.PopItem
import com.littleapp.pop.utils.DATA
import dagger.hilt.android.qualifiers.ApplicationContext
import org.json.JSONArray
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FunkoRepository @Inject constructor(
    @ApplicationContext private val context: Context
) {

    fun getFunkoPops(): MutableList<PopItem> {
        val listData = mutableListOf<PopItem>()
        try {
            val jsonString = context.assets.open(DATA.FILE_POP).bufferedReader().use {
                it.readText()
            }

            val jsonArray = JSONArray(jsonString)
            val limit = if (jsonArray.length() > 500) 500 else jsonArray.length()

            for (i in 0 until limit) {
                val item = jsonArray.getJSONObject(i)
                val img = item.optString("imageName", "")

                if (img.isEmpty() || img.contains("placeholder.png")) {
                    continue
                }

                val name = item.optString("title", DATA.Unknown)

                val seriesJson = item.optJSONArray("series")
                val series = if (seriesJson != null && seriesJson.length() > 0) {
                    val seriesList = mutableListOf<String>()
                    for (j in 0 until seriesJson.length()) {
                        seriesList.add(seriesJson.getString(j))
                    }
                    seriesList.joinToString(", ")
                } else {
                    DATA.Unknown
                }

                listData.add(PopItem(i, name, img, series))
            }

        } catch (e: Exception) {
            e.printStackTrace()
        }
        return listData
    }
}