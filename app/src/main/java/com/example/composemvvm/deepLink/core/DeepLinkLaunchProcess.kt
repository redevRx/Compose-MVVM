package com.example.composemvvm.deepLink.core

import android.net.Uri

interface DeepLinkLaunchProcess {
    fun process(deepLink:Uri):String
}