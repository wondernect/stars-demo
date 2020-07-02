package com.wondernect.demo.stars.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wondernect.elements.rdb.request.SortData;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 班级列表请求DTO
 *
 * @author chenxun 2020-06-29 19:14:06
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "班级列表请求对象")
public class ListKlassRequestDTO {

    @JsonProperty("sort_data_list")
    @ApiModelProperty(notes = "列表请求参数")
    private List<SortData> sortDataList;
}