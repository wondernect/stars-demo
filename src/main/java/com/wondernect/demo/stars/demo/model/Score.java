package com.wondernect.demo.stars.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wondernect.elements.rdb.base.model.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Copyright (C), 2017-2018, 西安电视广播大学
 * FileName: Student
 * Author: chenxun
 * Date: 2018/6/3 下午2:43
 * Description:
 */
@Entity
@Table(name = "score")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "分数")
public class Score extends BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "varchar(255) not null")
    @JsonProperty("score_id")
    @ApiModelProperty(value = "分数id")
    private Long scoreId;

    @Column(columnDefinition = "varchar(255) not null")
    @JsonProperty("student_id")
    @ApiModelProperty(value = "学生id")
    private String studentId;

    @Column(columnDefinition = "integer not null")
    @JsonProperty("score")
    @ApiModelProperty(value = "分数")
    private Integer score;
}

