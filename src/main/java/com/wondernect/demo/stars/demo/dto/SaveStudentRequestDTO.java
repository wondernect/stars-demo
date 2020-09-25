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
 * 学生请求DTO
 *
 * @author chenxun 2020-09-25 12:13:13
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "学生请求对象")
public class SaveStudentRequestDTO {

    @JsonProperty("name")
    @ApiModelProperty(notes = "姓名")
    private String name;
}