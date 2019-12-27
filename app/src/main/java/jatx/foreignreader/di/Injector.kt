package jatx.foreignreader.di

interface Injector<T> {
    fun inject(target: T)
}