package com.example.composemvvm.deepLink

import android.net.Uri
import com.example.composemvvm.deepLink.core.DeepLinkProcess

class DeepLinkMainProcess :DeepLinkProcess{
    override fun isMatch(deepLink: Uri): Boolean {
        return checkHeader(deepLink.toString())
    }

    private fun checkHeader(url:String) :Boolean{
        return url.contains("https") or
                url.contains("http") or
                url.contains("redev")
    }

    override fun process(deepLink: Uri): String {
        val url = deepLink.toString()
        if(url.contains("redev"))
        {
            return "https://redev"
        }
        return ""
    }
}