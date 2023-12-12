package ru.easycode.zerotoheroandroidtdd

import android.app.Application

class App : Application() {

    val map = HashMap<Class<MainViewModel>, MainViewModel>()

    fun provideViewModel(clasz: Class<MainViewModel>): MainViewModel {
        if (map[clasz] == null) {
            map[clasz] = MainViewModel(LiveDataWrapper.Base(), Repository.Base())
        }
        return map[clasz]!!
    }
}