package com.wondernect.demo.stars.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 学生响应DTO
 *
 * @author chenxun 2020-06-29 19:14:22
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "学生响应对象")
public class StudentResponseDTO {

    @JsonProperty("id")
    @ApiModelProperty(notes = "学生id")
    private String id;

    @JsonProperty("name")
    @ApiModelProperty(notes = "姓名")
    private String name;
}