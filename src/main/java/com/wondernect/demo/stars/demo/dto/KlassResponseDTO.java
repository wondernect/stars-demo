package com.wondernect.demo.stars.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 班级响应DTO
 *
 * @author chenxun 2020-06-29 19:14:06
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "班级响应对象")
public class KlassResponseDTO {

    @JsonProperty("id")
    @ApiModelProperty(notes = "班级id")
    private String id;

    @JsonProperty("name")
    @ApiModelProperty(notes = "名称")
    private String name;
}