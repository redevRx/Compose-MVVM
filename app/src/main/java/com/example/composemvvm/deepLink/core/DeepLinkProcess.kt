package com.example.composemvvm.deepLink.core

import android.net.Uri

interface DeepLinkProcess {

    fun isMatch(deepLink:Uri):Boolean
    fun process(deepLink: Uri):String
}