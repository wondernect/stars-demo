package com.wondernect.demo.stars.demo.dto;

import com.wondernect.elements.rdb.request.ListRequestDTO;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 学生列表请求DTO
 *
 * @author chenxun 2020-11-17 13:43:29
 **/
@Data
@NoArgsConstructor
@ApiModel(value = "学生列表请求对象")
public class ListStudentRequestDTO extends ListRequestDTO {

}