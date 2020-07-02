package com.wondernect.demo.stars.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wondernect.elements.rdb.request.PageRequestData;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * 班级分页请求DTO
 *
 * @author chenxun 2020-06-29 19:14:06
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "班级分页请求对象")
public class PageKlassRequestDTO {

    @NotNull(message = "分页请求参数不能为空")
    @JsonProperty("page_request_data")
    @ApiModelProperty(notes = "分页请求参数")
    private PageRequestData pageRequestData;
}