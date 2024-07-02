package com.example.coroutine_basics

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun sum(a: Int, b: Int) = a+b

fun main() = runBlocking<Unit>{

    // async : launch와 다르게 비동기 결과값을 가져올 수 있다.
    val res: Deferred<Int> = async{
        delay(100)
        sum(1,3)
    }

    // 비동기 처리 시작은 async, 결과 값은 await
    println("result = ${res.await()}")

    val res2 = async{
        delay(100)
        sum(1,3)
    }

    // 비동기 처리 시작은 async, 결과 값은 await
    println("result2 = ${res2.await()}")
}