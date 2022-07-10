package com.example.composemvvm.core.activity

import androidx.activity.ComponentActivity
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController

abstract class CoreCompose: ComponentActivity() {
    protected val mainScope get() = lifecycleScope
    protected lateinit var nav: NavController
}