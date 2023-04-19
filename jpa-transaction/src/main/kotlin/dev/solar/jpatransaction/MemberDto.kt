package dev.solar.jpatransaction

data class MemberDto(
    val userName: String
) {
    fun toMember(): Member {
        return Member(username = userName)
    }
}
