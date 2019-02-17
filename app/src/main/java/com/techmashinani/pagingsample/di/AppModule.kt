package com.techmashinani.pagingsample.di

import com.techmashinani.pagingsample.viewmodels.MainViewModel
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val appModule = module {
    viewModel { MainViewModel(get()) }
}