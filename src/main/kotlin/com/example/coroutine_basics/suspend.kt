package com.example.coroutine_basics

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

suspend fun main(){

    // suspend 함수를 일반 함수에서 호출 시
    // 1. runBlocking 함수를 사용
    // 2. 해당 일반 함수에도 suspend 키워드 사
    doSomething()

}

// suspend 키워드 : 일시중단/재개 가능 함수
// coroutineScope(thread 차단X) <> runBlocking(thread 차단O)
suspend fun doSomething() = coroutineScope{
    launch{
        delay(200)
        println("world!")
    }
    launch{
        printHello()
    }
}

fun printHello() = println("Hello")