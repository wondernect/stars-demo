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
 * 分数请求DTO
 *
 * @author chenxun 2020-07-02 17:01:57
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "分数请求对象")
public class SaveScoreRequestDTO {

    @Length(max = 255, message = "学生id长度不能超过255字符(1汉字=2字符)")
    @NotBlank(message = "学生id不能为空")
    @JsonProperty("student_id")
    @ApiModelProperty(notes = "学生id")
    private String studentId;

    @NotNull(message = "分数不能为空")
    @JsonProperty("score")
    @ApiModelProperty(notes = "分数")
    private Integer score;
}