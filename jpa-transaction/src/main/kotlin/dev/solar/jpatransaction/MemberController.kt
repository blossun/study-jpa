package dev.solar.jpatransaction

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class MemberController(
    val memberService: MemberService
) {
    @GetMapping("/member/{merchantId}")
    fun get(@PathVariable merchantId: Long): Member? {
        return memberService.get(merchantId)
    }

    @PutMapping("member/default")
    fun putDefault(@RequestBody memberDto: MemberDto): Member {
        val member = memberService.putDefault(memberDto.toMember())
        println("savedMember => $member")
        return member
    }

    @PutMapping("member/returnValue")
    fun putReturnValue(@RequestBody memberDto: MemberDto): Member {
        val member = memberService.putReturnValue(memberDto.toMember())
        println("savedMember => $member")
        return member
    }

    @PutMapping("member/transactional")
    fun putTransactional(@RequestBody memberDto: MemberDto): Member {
        val member = memberService.putTransactional(memberDto.toMember())
        println("savedMember => $member")
        return member
    }

    @PutMapping("member/tt")
    fun putTT(@RequestBody memberDto: MemberDto): Member {
        val member = memberService.putTT(memberDto.toMember())
        println("savedMember => $member")
        return member
    }
}
