package com.wondernect.demo.stars.demo.model;

import com.wondernect.elements.rdb.base.model.BaseStringModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Copyright (C), 2017-2018, 西安电视广播大学
 * FileName: Student
 * Author: chenxun
 * Date: 2018/6/3 下午2:43
 * Description:
 */
@Entity
@Table(name = "student_klass")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "学生班级")
public class StudentKlass extends BaseStringModel {

    @ApiModelProperty(value = "学生id")
    private String studentId;

    @ApiModelProperty(value = "班级id")
    private String klassId;
}

