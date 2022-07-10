package com.example.composemvvm.navigation

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.StringRes
import androidx.navigation.NavController
import com.example.composemvvm.R

interface Destination

sealed class Screen(val route: String, @StringRes val resourceId: Int) {
    object Home: Screen("Home",R.string.app_name)
    object Login: Screen("Login",R.string.app_name)
    object Register: Screen("Register",R.string.app_name)
    object Store: Screen("Store",R.string.app_name)
}

object HomeNavigation:Destination
object StoreNavigation:Destination
object LoginNavigation:Destination
object RegisterNavigation:Destination

abstract class Router {
    var navController: NavController? = null
}

class HomeRouter: Router() {
    fun pushTo(destination: Destination,bundle: Bundle?) {
        navController?.let { navigation ->
            val destinationId = ConfigRouter[destination] ?: 0 // not found destination
            navigation.navigate(destinationId,bundle)
        }
    }
}

class Example :Fragment(){
    private lateinit var mRouter:Router

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater?,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    fun initRouter(){
//        mRouter.navController = findNavController
    }
}