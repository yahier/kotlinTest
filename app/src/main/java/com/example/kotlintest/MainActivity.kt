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
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*

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
        testCoroutine()
        testCoroutine2()
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


    /**
     *测试协程
     * 备注 通常，您应使用 launch 从常规函数启动新协程，因为常规函数无法调用 await。只有在另一个协程内时，或在挂起函数内且正在执行并行分解时，才使用 async。
     */
    fun testCoroutine() {
        val scopeIo = CoroutineScope(Job() + Dispatchers.IO)
        println(" 1threadId is :" + Thread.currentThread().id)

        //todo 启动协程的方式1 可启动新协程而不将结果返回给调用方
        val job = scopeIo.launch {
            // New coroutine that can call suspend functions
            testTimeOutTask()
        }


        scopeIo.launch(Dispatchers.IO) {
            Thread.sleep(3000)
            tv1.text = "协程延迟后 来显示"
        }


        //todo 启动协程的方式2 启动一个新的协程，并允许您使用一个名为 await 的挂起函数返回结果
        val deferred = scopeIo.async {

        }


        //job.cancel()
    }


    fun testCoroutine2() {
        val scopeMain = CoroutineScope(Job() + Dispatchers.Main)

        scopeMain.launch(Dispatchers.IO) {
            Log.d("协程", "testCoroutine2---1")
            Thread.sleep(3000)
            Log.d("协程", "testCoroutine2---2")
        }


        //todo 启动协程的方式2 启动一个新的协程，并允许您使用一个名为 await 的挂起函数返回结果
        val deferred = scopeMain.async {

        }


        //job.cancel()

    }


    //打印的threadId和上面一样的
    suspend fun testTimeOutTask() {
        Thread.sleep(3000)
        Log.d("协程", "testTimeOutTask")
    }
}
