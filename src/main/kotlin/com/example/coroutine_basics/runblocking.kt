package com.example.coroutine_basics

import kotlinx.coroutines.runBlocking

fun main(){

    // runBlocking을 사용하면 비동기가 아닌 동기식으로 처리된다(첫번째 thread 종료 후 다음 thread가 실행)
    runBlocking {
        println("Hello")
        println(Thread.currentThread().name)
    }
    println("World")
    println(Thread.currentThread().name)
}