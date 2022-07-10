package com.example.composemvvm

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.*
import com.example.composemvvm.api.ktorClient.Client
import com.example.composemvvm.core.activity.CoreCompose
import com.example.composemvvm.core.genaricType.*
import com.example.composemvvm.core.genaricType.ok
import com.example.composemvvm.core.json.toData
import com.example.composemvvm.core.modifier.onClick
import com.example.composemvvm.core.nav.Nav
import com.example.composemvvm.core.nav.push
import com.example.composemvvm.deepLink.DeepLinkLauncher
import com.example.composemvvm.model.ToDoResponse
import com.example.composemvvm.navigation.*
import com.example.composemvvm.ui.theme.ComposeMVVMTheme
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import org.koin.androidx.compose.get


class MainActivity: CoreCompose() {
    private val launchProcess:DeepLinkLauncher by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeMVVMTheme {
                NavigationGraph()
                nav = Nav.current
            }
        }
       getToDo()
    }

    private fun getToDo(){
        Client.build().use {
            mainScope.launch {
                kotlin.runCatching {
                    it.get("https://jsonplaceholder.typicode.com/todos/1")
                }.onSuccess { response ->
                   Hero.success(response.bodyAsText().toData<ToDoResponse>())
                        .ok {
                            println("call api data:${it}")
                        }.not {
                           println("error call api:${it}")
                        }
                    it.close()
                }.onFailure { ex ->
                    println("error call api:${ex}")
                    it.close()
                }
            }
        }
    }

    override fun onBackPressed() {
        if(nav.backQueue.size > 2) {
            super.onBackPressed()
        }
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        intent?.let { handleDeepLink(it) }
    }

    private fun handleDeepLink(data:Intent){
       //adb shell am start -d 'https://redev'
        println("new deeplink :${data.data.toString()}")
        when(val it = launchProcess.process(data.data ?: Uri.parse(""))){
           "" -> {
               nav.push(HomeNavigation)
           }
            else -> {
                val newIntent = Intent()
                newIntent.data = Uri.parse(it)
                nav.handleDeepLink(newIntent)
            }
        }
//       launchProcess.process(data.data ?: Uri.parse(""))?.also {
//            if(it != ""){
//                val newIntent = Intent()
//                newIntent.data = Uri.parse(it)
//                nav.handleDeepLink(newIntent)
//            }else{
//                nav.push(HomeNavigation)
//            }
//        }
    }
}


@Composable
fun Home(navController: NavController = Nav.current,name:String = get()){
    Scaffold(Modifier.fillMaxSize()) {
        navController.createDeepLink()
        Text(text = name,Modifier.onClick { navController.push(LoginNavigation)})
    }
}


@Composable
fun Login(navController: NavController = Nav.current){
    Scaffold(Modifier.fillMaxSize()) {
        Text(text = "Login",Modifier.onClick { navController.push(RegisterNavigation)})
    }
}


@Composable
fun Register(navController: NavController = Nav.current){
    Scaffold(Modifier.fillMaxSize()) {
        Text(text = "Register",Modifier.onClick { navController.push(StoreNavigation)})
    }
}

@Composable
fun Store(navController: NavController = Nav.current){
    Scaffold(Modifier.fillMaxSize()) {
        Text(text = "Store",Modifier.onClick { navController.push(HomeNavigation)})
    }
}

private var result:Hero<ToDoResponse> = Hero.success(ToDoResponse())

fun example(){
    result.ok {

    }.not {

    }
    snakeHero {
        10 + 10
    }.ok {
        println("result :${it}")
    }.not {
        println("error :${it}")
    }
}


