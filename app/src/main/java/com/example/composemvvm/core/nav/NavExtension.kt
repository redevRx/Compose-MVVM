package com.example.composemvvm.core.nav

import android.util.Log
import androidx.compose.runtime.compositionLocalOf
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.composemvvm.navigation.ConfigRouterCompose
import com.example.composemvvm.navigation.Destination

val Nav = compositionLocalOf<NavHostController> {
    error("No LocalNavController provided")
}

fun NavController.push(destination: Destination){
    kotlin.runCatching {
        val destinationName = ConfigRouterCompose[destination]!!.route
        navigate(destinationName){
            popUpTo(backQueue.first().id) { saveState = true }
            launchSingleTop = false
            restoreState = true
        }
    }.onFailure {
        Log.e("navigation error","not found destination -> error $it")
    }
}

fun NavController.pop(){
    kotlin.runCatching {
        popBackStack()
    }.onFailure {
        Log.e("navigation error","not found destination -> error $it")
    }
}
