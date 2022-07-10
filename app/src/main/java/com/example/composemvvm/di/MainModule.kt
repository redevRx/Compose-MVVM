package com.example.composemvvm.di

import com.example.composemvvm.deepLink.DeepLinkLauncher
import com.example.composemvvm.deepLink.DeepLinkMainProcess
import com.example.composemvvm.deepLink.core.DeepLinkProcess
import org.koin.dsl.module

val mainModule = module {
    single { "Home" }

    single<DeepLinkProcess> { DeepLinkMainProcess() }
    single { DeepLinkLauncher(processes = getAll()) }
}