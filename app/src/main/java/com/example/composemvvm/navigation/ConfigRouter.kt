package com.example.composemvvm.navigation

object ConfigRouter:Map<Destination,Int> by mapOf(
    HomeNavigation to 1,
    StoreNavigation to 2
)
/**
 * 1 is action id in navigation graph
 * R.id.action_to_home_screen = 1
 */


object ConfigRouterCompose:Map<Destination,Screen> by mapOf(
    HomeNavigation to Screen.Home,
    LoginNavigation to Screen.Login,
    RegisterNavigation to Screen.Register,
    StoreNavigation to Screen.Store
)