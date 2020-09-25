package com.wondernect.demo.stars.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wondernect.elements.rdb.request.PageRequestDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 学生分页请求DTO
 *
 * @author chenxun 2020-09-25 12:13:14
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "学生分页请求对象")
public class PageStudentRequestDTO extends PageRequestDTO {

    @JsonProperty("name")
    @ApiModelProperty(notes = "姓名")
    private String name;
}