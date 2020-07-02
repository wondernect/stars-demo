package com.wondernect.demo.stars.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 分数响应DTO
 *
 * @author chenxun 2020-07-02 17:01:57
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "分数响应对象")
public class ScoreResponseDTO {

    @JsonProperty("score_id")
    @ApiModelProperty(notes = "分数id")
    private Long scoreId;

    @JsonProperty("student_id")
    @ApiModelProperty(notes = "学生id")
    private String studentId;

    @JsonProperty("score")
    @ApiModelProperty(notes = "分数")
    private Integer score;
}