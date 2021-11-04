package cn.wegrowth.elearning.security

data class CurrentUser(
    val username: String,
    val userId: String,
    val loginType: String?
)