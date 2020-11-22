package com.wondernect.demo.stars.demo.dto;

import com.wondernect.elements.rdb.request.PageRequestDTO;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 学生分页请求DTO
 *
 * @author chenxun 2020-11-17 13:43:29
 **/
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@ApiModel(value = "学生分页请求对象")
public class PageStudentRequestDTO extends PageRequestDTO {

}