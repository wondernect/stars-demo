package com.wondernect.demo.stars.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 学生班级响应DTO
 *
 * @author chenxun 2020-06-29 19:14:38
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "学生班级响应对象")
public class StudentKlassResponseDTO {

    @JsonProperty("id")
    @ApiModelProperty(notes = "学生班级id")
    private String id;

    @JsonProperty("student_id")
    @ApiModelProperty(notes = "学生id")
    private String studentId;

    @JsonProperty("klass_id")
    @ApiModelProperty(notes = "班级id")
    private String klassId;
}