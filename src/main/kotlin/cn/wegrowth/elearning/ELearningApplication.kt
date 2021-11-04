package cn.wegrowth.elearning

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EnableJpaRepositories(considerNestedRepositories = true)
@EnableDiscoveryClient
class ELearningApplication

fun main(args: Array<String>) {
    runApplication<ELearningApplication>(*args)
}
