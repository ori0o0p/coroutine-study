import kotlinx.coroutines.*
import org.slf4j.LoggerFactory


suspend fun main() {
    val log = LoggerFactory.getLogger("MainLogger")
    log.info("start")
    val example = Example()
    example.main()
    log.info("end")
}

class Example {
    private val log = LoggerFactory.getLogger(this::class.java)
    suspend fun main() = minjuRoutineContext()

    suspend fun minjuRoutineContext() {
        coroutineScope {
            launch(CoroutineName("아일릿-민주") + Dispatchers.Default) {
                log.info("Hello, Minju!")
                launch {
                    log.info("Lovely Minju!")
                }
            }
        }
    }
    
    suspend fun cancelMinjuRoutine() {
        coroutineScope { 
            val minjuJob = launch {
                minjuIsComing()
            }
            launch {
                delay(400L)
                minjuJob.cancel()
                minjuJob.join()
                log.info("민주가 사라졌어요..")
            }
        }
    }
    
    suspend fun minjuRoutineAsync() {
        coroutineScope {
            val minju: Deferred<String> = async {
                minju()
            }
            val findMinju: Deferred<Int> = async {
                findMinju()
            }
            log.info("${minju.await()}를 ${findMinju.await()}일 만에 찾았습니다!")
        }
    }

    suspend fun minju(): String {
        log.info("민주 생성 중~~")
        delay(500L)
        log.info("생성 완료!")
        return "민주"
    }

    suspend fun findMinju(): Int {
        log.info("민주 찾는 중~~")
        delay(1000L)
        log.info("찾았습니다!")
        return 511
    }

    suspend fun minjuRoutineJob() {
        coroutineScope {
            coroutineScope {
                launch {
                    minjuIsComing()
                }
                launch {
                    minjuIsGoing()
                }
            }
            launch {
                minjuStartAndEnd()
            }
        }
    }

    suspend fun minjuRoutineGlobal() {
        GlobalScope.launch {
            minjuIsComing()
        }
        GlobalScope.launch {
            minjuIsGoing()
        }
        delay(1500L);
    }

    suspend fun minjuRoutineLaunch() {
        coroutineScope {
            launch {
                minjuIsComing()
            }
            launch {
                minjuIsGoing()
            }
        }
    }

    suspend fun minjuRoutine() {
        coroutineScope {
            minjuIsComing()
        }
        coroutineScope {
            minjuIsGoing()
        }
    }

    suspend fun minjuStartAndEnd() {
        log.info("민주가 시작했어요!")
        delay(500L)
        log.info("민주가 끝났어요!")
    }

    suspend fun minjuIsComing() {
        log.info("민주가 오고 있어요!")
        delay(500L)
        log.info("민주가 도착했어요!")
    }

    suspend fun minjuIsGoing() {
        log.info("민주가 가고 있어요ㅜㅜ")
        delay(1000L)
        log.info("민주가 가버렸어요ㅜㅜ")
    }

}