package com.kronos.router.model

import com.kronos.router.interceptor.Interceptor

/**
 * Created by zhangyang on 16/7/16.
 */
class RouterParams {
    var url: String = ""
    var weight: Int = 0
    var routerOptions: RouterOptions? = null
    var openParams: HashMap<String, String> = hashMapOf()
    val interceptors = mutableListOf<Interceptor>()

    val realPath: String
        get() {
            try {
                return url.let { it.subSequence(1, it.length).toString() }
            } catch (e: Exception) {
                e.printStackTrace()
            }
            return ""
        }

    fun put(key: String, value: String?) {
        value?.apply {
            openParams[key] = this
        }
    }

}
