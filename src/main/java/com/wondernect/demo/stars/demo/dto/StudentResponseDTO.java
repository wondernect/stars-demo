package com.wondernect.demo.stars.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wondernect.elements.rdb.response.BaseStringResponseDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 学生响应DTO
 *
 * @author chenxun 2020-11-17 13:43:28
 **/
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "学生响应对象")
public class StudentResponseDTO extends BaseStringResponseDTO {

    @JsonProperty("name")
    @ApiModelProperty(notes = "姓名")
    private String name;

    @JsonProperty("sex")
    @ApiModelProperty(notes = "性别")
    private Integer sex;

    @JsonProperty("age")
    @ApiModelProperty(notes = "年龄")
    private Integer age;
}