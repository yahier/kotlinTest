package com.example.kotlintest.grammer.androidx

import android.arch.lifecycle.LiveData
import android.arch.paging.DataSource
import android.arch.paging.LivePagedListBuilder
import android.arch.paging.PageKeyedDataSource
import android.arch.paging.PagedList
import android.os.Bundle
import android.support.v4.content.ContextCompat

/**
 * 测试分页，彻底的失败 对象都不知道怎么建立起来
 * 参考 https://developer.android.google.cn/reference/kotlin/androidx/paging/DataSource?hl=zh_cn
 */
fun testPageList() {

    //val listData = LiveData.
    //val sd = PageDataSourceFactory
    val list = listOf("", "")

//    val allStudents = LivePagedListBuilder(
//        dao.getAllStudent(), PagedList.Config.Builder()
//            .setPageSize(15)                         //配置分页加载的数量
//            .setEnablePlaceholders(false)     //配置是否启动PlaceHolders
//            .setInitialLoadSizeHint(30)              //初始化加载的数量
//            .build()
//    ).build()

   // val pa = PageKeyedDataSource()

    val bundle = Bundle()


}

//fun getDataSource(): DataSource.Factory<Int, String> {
//
//}
//
//class MyDataSource : DataSource.Factory<Int, String>() {
//    override fun create(): DataSource<Int, String> {
//
//    }
//
//}