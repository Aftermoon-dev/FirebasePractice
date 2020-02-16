package dev.aftermoon.firebasepractice

interface BasePresenter<T> {
    fun createView(view: T)
    fun destroyView()
}