package com.wondernect.demo.stars.demo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 学生班级请求DTO
 *
 * @author chenxun 2020-06-29 19:14:38
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "学生班级请求对象")
public class SaveStudentKlassRequestDTO {

    @JsonProperty("student_id")
    @ApiModelProperty(notes = "学生id")
    private String studentId;

    @JsonProperty("klass_id")
    @ApiModelProperty(notes = "班级id")
    private String klassId;
}