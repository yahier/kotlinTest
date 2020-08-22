package com.example.kotlintest

import android.content.Context
import android.content.SharedPreferences
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.collection.arraySetOf
import androidx.core.content.contentValuesOf
import androidx.core.content.edit
import androidx.core.graphics.blue
import androidx.core.graphics.createBitmap
import androidx.core.os.bundleOf
import androidx.core.os.postAtTime
import androidx.core.text.htmlEncode
import androidx.core.text.isDigitsOnly
import androidx.core.view.postDelayed

/**
 * ktx list
 * https://developer.android.google.cn/kotlin/ktx/extensions-list
 */
class MainActivity : AppCompatActivity() {
    lateinit var sharedPreferences: SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPreferences = getSharedPreferences("test", Context.MODE_PRIVATE)

        testCollections()
        testSp()
        testMix()
    }

    /**
     * 测试ktx的集合
     */
    private fun testCollections() {
        val combinedArraySet = arraySetOf(1, 2, 3) + arraySetOf(4, 5, 6, 7)
        Log.e("MainActivity", "set直接想加后的数量是" + combinedArraySet.size)
    }

    private fun testSp() {
        sharedPreferences.edit {
            putString("name", "bingo")
        }

    }

    /**
     * 混合测试
     */
    private fun testMix() {
        val contentValus = contentValuesOf(Pair<String, String>("", ""))

//        val bitmap = BitmapFactory.decodeResource(resources, R.drawable.abc_ab_share_pack_mtrl_alpha)
//        bitmap.applyCanvas {
//            drawLine(0F, 0F, 200F, 200F)
//        }

        val bitmap2 = createBitmap(200, 400)

        val blue1 = 100.blue
        val blue2 = Color.blue(100)
        Log.e("testMix", "blue1 is $blue1") //值还是100 没有明白这个方法的意义


        /** 挺厉害的 */
//        val uri = Uri.parse("")
//        val file1 = uri.toFile()

        //不错啊
        val bundle = bundleOf(Pair("date", "08-21"))

        val handler = Handler()

        //和原本的postAtTime方法，调换了顺序
        handler.postAtTime(200) {
            //doSomething()
        }

        val str1 = "1234567"
        val isDigitsOnly = str1.isDigitsOnly()

        val str2 = "name=bingo&age=12"
        val htmlEncoded = str2.htmlEncode()
        Log.e("testMix", "htmlEncoded is $htmlEncoded") //name=bingo&amp;age=12

        val view1 = window.decorView
        //val bitmap1 = view1.drawToBitmap()

        //打印了view.postDelayed  即使没有使用返回的runnable
        val runnable = view1.postDelayed(100) {
            Log.e("testMix", "view.postDelayed")
        }


    }
}
