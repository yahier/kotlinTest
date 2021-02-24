package com.example.kotlintest

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.corontine_test_act.*
import kotlinx.android.synthetic.main.corontine_test_act.tv1
import kotlinx.android.synthetic.main.corontine_test_act.tv2
import kotlinx.android.synthetic.main.corontine_test_act.tv3
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.produce


/**
 * 协程测试 参考文档 https://developer.android.google.cn/kotlin/coroutines/coroutines-adv
 */
class CoroutineTestAct : AppCompatActivity() {

    val TAG = "CoroutineTestAct"
    val scope = CoroutineScope(Job())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.corontine_test_act)

        //todo tv1和tv5的效果类似，都可以异步处理数据后，回到主线程
        tv1.setOnClickListener {
            test1()
        }

        tv2.setOnClickListener {
            test2()
        }

        tv3.setOnClickListener {
            test3()
        }

        tv4.setOnClickListener {
            tvResult.text = "点击了tv4"
        }

        tv5.setOnClickListener {
            test5()
        }

        tv6.setOnClickListener {
            test6()
        }
    }


    /**
     * 退出式，取消所有协程
     */
    override fun onStop() {
        super.onStop()
        scope.cancel()
    }


    private fun test1() {
        tvResult.text = "test1 方法被调用了"

        //Job 控制协程的生命周期
        val job = scope.launch(Dispatchers.Main) {
            fetchDocs()
        }

        //todo 只取消对应启动的协程，并不会像scope.cance那样，取消整个作用域
        //job.cancel()

        job.start()
    }


    //todo 没有挂起的效果
    private fun test2() {
        tvResult.text = "test2 方法被调用了"
        scope.launch(Dispatchers.Main) {
            getResult()
        }
    }


    /**
     * 哈哈 cancel后，不仅仅取消正在进行种的协程，但重新启动的协程都不执行了
     * todo 官方说明:已取消的作用域无法再创建协程
     */
    private fun test3() {
        tvResult.text = "test3 方法被调用了"
        scope.cancel()
    }


    private suspend fun fetchDocs() {
        val result = get()
        tvResult.text = result
    }


    //效果 执行耗时任务，但主线程不会卡顿啦
    //执行完成后，会恢复已经挂起的协程
    //withContext也是suspend方法，
    private suspend fun get(): String = withContext(Dispatchers.Default) {
        Thread.sleep(3000)
        "get结果 结果很好的啦"
    }


    private suspend fun getResult() {
        val result = get2()
        tvResult.text = result
    }


    private suspend fun get2(): String {
        //todo 没有挂起的效果
//        scope.launch(Dispatchers.Default) {
//            Thread.sleep(5000)
//            "从get2里面 返回结果了"
//        }

        //todo 没有挂起的效果
//        scope.produce<String>(Dispatchers.Default) {
//            Thread.sleep(5000)
//            "从get2里面 返回结果了"
//        }


        //加不加async都会卡顿主线程。
        coroutineScope {
            val defered = async {
                Thread.sleep(5000)
                "从get2里面 返回结果了"
            }

            defered.await()

        }
        return "从get2外面 返回结果了"
    }


    private fun test5() {
        scope.launch(Dispatchers.Main) {
            val result = test5_1()
            val data = result.await()
            tvResult.text = data
        }
    }


    private fun test5_1(): Deferred<String> {
        tvResult.text = "调用了test5"

        val result = scope.async(Dispatchers.Default) {
            Thread.sleep(3000)
            "结果回来了"
        }

        return result
    }


    /**
     * todo GlobalScope,  MainScope
     */
    private fun test6() {
        tvResult.text = "调用了test6"
        val globalJob = GlobalScope.launch(Dispatchers.Main) {
            tvResult.text = "调用了test6"
        }


        MainScope().launch {
            val result = test5_1()
            val data = result.await()
            tvResult.text = data
        }
    }
}