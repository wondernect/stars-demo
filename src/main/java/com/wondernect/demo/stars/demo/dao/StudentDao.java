package com.wondernect.demo.stars.demo.dao;

import com.wondernect.demo.stars.demo.model.Student;
import com.wondernect.elements.rdb.base.dao.BaseStringDao;
import org.springframework.stereotype.Repository;

/**
 * 学生数据库操作类
 *
 * @author chenxun 2020-11-17 13:43:27
 **/
@Repository
public class StudentDao extends BaseStringDao<Student> {
}