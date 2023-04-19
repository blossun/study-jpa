package dev.solar.jpatransaction

import mu.KotlinLogging
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class externalService {

    private val log = KotlinLogging.logger { }
    fun callApi() {
        try {
            Thread.sleep(5000)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
        log.info {"[end of callApi]====================="}
    }

    fun callApiReturnValue(): String {
        try {
            Thread.sleep(5000)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
        log.info {"[end of callApi]====================="}
        return "return Value"
    }

//    @Transactional(propagation = Propagation.NEVER) // 부모 Transactional이 있으면 exception
    @Transactional
    fun callApiReturnValueTransactional(): String {
        try {
            Thread.sleep(5000)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
        log.info {"[end of callApi]====================="}
        return "return Value"
    }
}
