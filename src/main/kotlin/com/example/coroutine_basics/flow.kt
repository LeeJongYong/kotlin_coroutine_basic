package com.example.coroutine_basics

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {

    val flow = simple()

    // reactiveStream의 subscribe 같이 flow는 collect 함수를 호출해야 flow 코드가 동작한다
    flow.collect{ value -> println(value)}
    println(flow)       // collect함수를 사용하지 않아 flow가 동작하지 않고 주소값만 출력된다.

}

fun simple(): Flow<Int> = flow {
    println("Flow started")

    for (i in 1 .. 3){
        delay(100)
        emit(i)
    }
}