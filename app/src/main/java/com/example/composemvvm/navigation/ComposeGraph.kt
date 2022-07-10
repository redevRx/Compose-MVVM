package com.example.composemvvm.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navDeepLink
import androidx.navigation.navigation
import com.example.composemvvm.Home
import com.example.composemvvm.Login
import com.example.composemvvm.Register
import com.example.composemvvm.Store
import com.example.composemvvm.core.nav.Nav

fun NavGraphBuilder.navGraphMain(){
    navigation(startDestination = Screen.Login.route, route = "MainRouter"){
        composable(Screen.Register.route){ Register() }
        composable(Screen.Login.route, deepLinks = listOf(navDeepLink { uriPattern = "https://redev" })){ Login() }
    }
}

fun NavGraphBuilder.navGraphStore(){
    navigation(startDestination = Screen.Store.route, route = "StoreRouter"){
        composable(
            Screen.Store.route,
            arguments = listOf(navArgument("userId"){defaultValue = ""})){ Store() }
    }
}

@Composable
fun NavigationGraph(){
    NavHost(navController = Nav.current, startDestination = Screen.Home.route) {
        composable(Screen.Home.route){ Home() }
        navGraphMain()
        navGraphStore()
    }
}