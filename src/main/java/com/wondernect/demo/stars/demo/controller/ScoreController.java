package com.wondernect.demo.stars.demo.controller;

import com.wondernect.demo.stars.demo.dto.ListScoreRequestDTO;
import com.wondernect.demo.stars.demo.dto.PageScoreRequestDTO;
import com.wondernect.demo.stars.demo.dto.SaveScoreRequestDTO;
import com.wondernect.demo.stars.demo.dto.ScoreResponseDTO;
import com.wondernect.demo.stars.demo.service.ScoreService;
import com.wondernect.elements.common.error.BusinessError;
import com.wondernect.elements.common.response.BusinessData;
import com.wondernect.elements.rdb.response.PageResponseData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 分数接口
 *
 * @author chenxun 2020-07-02 17:01:59
 **/
@RequestMapping(value = "/v1/app/score")
@RestController
@Validated
@Api(tags = "分数接口")
public class ScoreController {

    @Autowired
    private ScoreService scoreService;

    @ApiOperation(value = "创建", httpMethod = "POST")
    @PostMapping(value = "/create")
    public BusinessData<ScoreResponseDTO> create(
            @ApiParam(required = true) @NotNull(message = "请求参数不能为空") @Validated @RequestBody(required = false) SaveScoreRequestDTO saveScoreRequestDTO
    ) {
        return new BusinessData<>(scoreService.create(saveScoreRequestDTO));
    }

    @ApiOperation(value = "更新", httpMethod = "POST")
    @PostMapping(value = "/{score_id}/update")
    public BusinessData<ScoreResponseDTO> update(
            @ApiParam(required = true) @NotBlank(message = "对象id不能为空") @PathVariable(value = "score_id", required = false) Long scoreId,
            @ApiParam(required = true) @NotNull(message = "请求参数不能为空") @Validated @RequestBody(required = false) SaveScoreRequestDTO saveScoreRequestDTO
    ) {
        return new BusinessData<>(scoreService.update(scoreId, saveScoreRequestDTO));
    }

    @ApiOperation(value = "删除", httpMethod = "POST")
    @PostMapping(value = "/{score_id}/delete")
    public BusinessData delete(
            @ApiParam(required = true) @NotBlank(message = "对象id不能为空") @PathVariable(value = "score_id", required = false) Long scoreId
    ) {
        scoreService.deleteById(scoreId);
        return new BusinessData(BusinessError.SUCCESS);
    }

    @ApiOperation(value = "获取详细信息", httpMethod = "GET")
    @GetMapping(value = "/{score_id}/detail")
    public BusinessData<ScoreResponseDTO> detail(
            @ApiParam(required = true) @NotBlank(message = "对象id不能为空") @PathVariable(value = "score_id", required = false) Long scoreId
    ) {
        return new BusinessData<>(scoreService.findById(scoreId));
    }

    @ApiOperation(value = "列表", httpMethod = "POST")
    @PostMapping(value = "/list")
    public BusinessData<List<ScoreResponseDTO>> list(
            @ApiParam(required = true) @NotNull(message = "列表请求参数不能为空") @Validated @RequestBody(required = false) ListScoreRequestDTO listScoreRequestDTO
    ) {
        return new BusinessData<>(scoreService.list(listScoreRequestDTO));
    }

    @ApiOperation(value = "分页", httpMethod = "POST")
    @PostMapping(value = "/page")
    public BusinessData<PageResponseData<ScoreResponseDTO>> page(
            @ApiParam(required = true) @NotNull(message = "分页请求参数不能为空") @Validated @RequestBody(required = false) PageScoreRequestDTO pageScoreRequestDTO
    ) {
        return new BusinessData<>(scoreService.page(pageScoreRequestDTO));
    }
}