package com.wondernect.demo.stars.demo.service;

import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQuery;
import com.wondernect.demo.stars.demo.dto.StudentResponseDTO;
import com.wondernect.demo.stars.demo.model.QStudent;
import com.wondernect.demo.stars.demo.model.QStudentKlass;
import com.wondernect.demo.stars.demo.model.Student;
import com.wondernect.elements.rdb.request.PageRequestData;
import com.wondernect.elements.rdb.response.PageResponseData;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 学生服务
 *
 * @author chenxun 2020-06-29 19:14:23
 **/
@Service
public class StudentService extends StudentAbstractService {

    public List<StudentResponseDTO> list(String klassId) {
        QStudent qStudent = QStudent.student;
        QStudentKlass qStudentKlass = QStudentKlass.studentKlass;
        JPAQuery<Student> studentJPAQuery = getJpaQueryFactory()
                .select(qStudent)
                .from(qStudent)
                .where(
                        qStudent.id.in(
                                JPAExpressions.select(qStudentKlass.studentId).from(qStudentKlass).where(qStudentKlass.klassId.eq(klassId))
                        )
                );
        return super.findAll(studentJPAQuery);
    }

    public PageResponseData<StudentResponseDTO> page(String klassId, PageRequestData pageRequestData) {
        QStudent qStudent = QStudent.student;
        QStudentKlass qStudentKlass = QStudentKlass.studentKlass;
        JPAQuery<Student> studentJPAQuery = getJpaQueryFactory()
                .select(qStudent)
                .from(qStudent)
                .where(
                        qStudent.id.in(
                                JPAExpressions.select(qStudentKlass.studentId).from(qStudentKlass).where(qStudentKlass.klassId.eq(klassId))
                        )
                );
        return super.findAll(studentJPAQuery, pageRequestData);
    }
}