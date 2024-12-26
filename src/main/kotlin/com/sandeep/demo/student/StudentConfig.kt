package com.sandeep.demo.student

import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.time.LocalDate
import java.time.Month

@Configuration
class StudentConfig {
    @Bean
    fun commandLineRunner(repository: StudentRepository): CommandLineRunner {
        return CommandLineRunner { _: Array<String?>? ->
            val mariam = Student(
                name = "Amit",
                email = "amit@gmail.com",
                dob = LocalDate.of(2001, Month.JANUARY, 5)
            )
            val alex = Student(
                name = "Sharana",
                email = "sharana@gmail.com",
                dob = LocalDate.of(2009, Month.JANUARY, 5)
            )
            repository.saveAll(listOf(mariam, alex))
        }
    }
}