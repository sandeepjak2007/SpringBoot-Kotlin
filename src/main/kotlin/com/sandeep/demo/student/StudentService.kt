package com.sandeep.demo.student

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class StudentService {

    @Autowired
    private lateinit var studentRepository: StudentRepository


    fun getStudents(): List<Student> {
        return studentRepository.findAll()
    }

    fun addNewStudent(student: Student) {
        val studentByEmail = studentRepository.findStudentByEmail(student.email)

        check(!studentByEmail.isPresent) { "Email taken" }
        studentRepository.save(student)
    }

    fun deleteStudent(studentId: Long) {
        val exists = studentRepository.existsById(studentId)
        check(exists) { "Student with id $studentId doesn't exists" }
        studentRepository.deleteById(studentId)
    }

    @Transactional
    fun updateStudent(studentId: Long, name: String?, email: String?) {
        val student = studentRepository.findById(studentId)
            .orElseThrow {
                IllegalStateException(
                    "Student with id $studentId doesn't exists"
                )
            }
        if (!name.isNullOrEmpty() && (student.name != name)) {
            student.name = name
        }
        if (!email.isNullOrEmpty() && (student.email != email)) {
            val studentOptional = studentRepository.findStudentByEmail(email)
            check(!studentOptional.isPresent) { "Email already taken" }
            student.email = email
        }
    }

}