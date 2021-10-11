package cn.wegrowth.elearning

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient

@SpringBootApplication
@EnableDiscoveryClient
class ELearningApplication

fun main(args: Array<String>) {
    runApplication<ELearningApplication>(*args)
}
