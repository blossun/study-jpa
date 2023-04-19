package dev.solar.jpatransaction

import mu.KotlinLogging
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class MemberService(
    val memberRepository: MemberRepository,
    val externalService: externalService
) {
    private val log = KotlinLogging.logger { }
    fun get(id: Long): Member? {
        return memberRepository.findById(id).orElseThrow { RuntimeException("Not founded $id") }
    }

    fun putDefault(member: Member): Member {
        log.info { "start putDefault =============================" }
        val savedMember = memberRepository.save(member)
        log.info { "call api =============================" }
        externalService.callApi()
        log.info { "end api =============================" }
        log.info { "before save =============================" }
        return savedMember
    }

    fun putReturnValue(member: Member): Member {
        log.info { "start putReturnValue =============================" }
        val savedMember = memberRepository.save(member)
        log.info { "call api =============================" }
        val result = externalService.callApiReturnValue()
        log.info { "return => $result" }
        log.info { "end api =============================" }
        log.info { "before save =============================" }
        return savedMember
    }

    @Transactional
    fun putTransactional(member: Member): Member {
        log.info { "start putReturnValue =============================" }
        val savedMember = memberRepository.save(member)
        log.info { "call api =============================" }
        val result = externalService.callApiReturnValue()
        log.info { "return => $result" }
        log.info { "end api =============================" }
        log.info { "before save =============================" }
        return savedMember
    }

    @Transactional
    fun putTT(member: Member): Member {
        log.info { "start putDefault =============================" }
        val savedMember = memberRepository.save(member)
        log.info { "call api =============================" }
        val result = externalService.callApiReturnValueTransactional()
        log.info { "return => $result" }
        log.info { "end api =============================" }
        log.info { "before save =============================" }
        return savedMember
    }
}
