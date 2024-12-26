package com.sandeep.demo.student

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface StudentRepository : JpaRepository<Student, Long> {

    fun findStudentByEmail(email: String): Optional<Student>

}