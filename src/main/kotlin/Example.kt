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
    suspend fun main() = minjuRoutineJob()

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