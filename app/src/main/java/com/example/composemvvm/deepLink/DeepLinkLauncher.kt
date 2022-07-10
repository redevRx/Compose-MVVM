package com.example.composemvvm.deepLink

import android.net.Uri
import com.example.composemvvm.deepLink.core.DeepLinkLaunchProcess
import com.example.composemvvm.deepLink.core.DeepLinkProcess

class DeepLinkLauncher(private val processes: List<DeepLinkProcess>):DeepLinkLaunchProcess {
    override fun process(deepLink: Uri): String {
        processes.forEach {
            if(it.isMatch(deepLink)){
                return it.process(deepLink)
            }
        }
        return ""
    }
}