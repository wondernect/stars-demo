package com.wondernect.demo.stars.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wondernect.elements.rdb.request.ListRequestDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 学生列表请求DTO
 *
 * @author chenxun 2020-09-25 12:13:13
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "学生列表请求对象")
public class ListStudentRequestDTO extends ListRequestDTO {

    @JsonProperty("name")
    @ApiModelProperty(notes = "姓名")
    private String name;
}