package com.example.coroutine_basics

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

fun main() = runBlocking<Unit>{

    // launch : thread 차단 없이 새로운 코루틴이 동작
    launch {
        delay(500)          // thread를 차단하지 않고 일시중단함.
//        Thread.sleep(500)      // thread를 차단한 상태에서 일시중단함.

        println("World!")
    }

    println("Hello")

    // launch은 병렬적 사용이 가능
    val job1: Job = launch {
        val elapsedTime = measureTimeMillis {
            delay(150)
        }
        println("async Task-1 $elapsedTime ms")
    }
    // launch의 리턴값인 Job은 취소, 시작 등의 컨트롤이 가능하다.
    job1.cancel()

    // 시점을 제어할 수 있다.
    val job2: Job = launch(start = CoroutineStart.LAZY) {
        val elapsedTime = measureTimeMillis {
            delay(100)
        }
        println("async Task-2 $elapsedTime ms")
    }

    println("start task-2")

    // LAZY를 선언한 후 나중에 start()를 통해 원하는 시점에 실행하게 할 수 있다.
    job2.start()
}