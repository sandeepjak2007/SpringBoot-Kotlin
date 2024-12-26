package com.sandeep.demo.student

import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table
data class Student(
    @Id
    @SequenceGenerator(
        name = "student_sequence",
        sequenceName = "student_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "student_sequence"
    )
    val id: Long? = null,
    var name: String,
    var email: String,
    val dob: LocalDate,
    @Transient
    val age: Int = 0
)