package cn.wegrowth.elearning.api

import mu.KotlinLogging
import org.joda.time.DateTime
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

private val logger = KotlinLogging.logger {}

@RestController
@RequestMapping("api")
class FooApi {
    @GetMapping("foo")
    fun getFoo(hello: String): String {
        return hello + DateTime.now()
    }

    @GetMapping("foo2")
    @PreAuthorize("hasRole('ADMIN')")
    fun getUserFoo(hello: String): String {
        return hello + " at " + DateTime.now()
    }

    @GetMapping("me")
    @PreAuthorize("hasRole('ADMIN')")
    fun getMe(): Any? {
        val principal = SecurityContextHolder.getContext().authentication.principal
        return principal
    }

}