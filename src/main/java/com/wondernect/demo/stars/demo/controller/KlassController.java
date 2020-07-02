package com.wondernect.demo.stars.demo.controller;

import com.wondernect.demo.stars.demo.dto.KlassResponseDTO;
import com.wondernect.demo.stars.demo.dto.ListKlassRequestDTO;
import com.wondernect.demo.stars.demo.dto.PageKlassRequestDTO;
import com.wondernect.demo.stars.demo.dto.SaveKlassRequestDTO;
import com.wondernect.demo.stars.demo.service.KlassService;
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
 * 班级接口
 *
 * @author chenxun 2020-06-29 19:14:06
 **/
@RequestMapping(value = "/v1/app/klass")
@RestController
@Validated
@Api(tags = "班级接口")
public class KlassController {

    @Autowired
    private KlassService klassService;

    @ApiOperation(value = "创建", httpMethod = "POST")
    @PostMapping(value = "/create")
    public BusinessData<KlassResponseDTO> create(
            @ApiParam(required = true) @NotNull(message = "请求参数不能为空") @Validated @RequestBody(required = false) SaveKlassRequestDTO saveKlassRequestDTO
    ) {
        return new BusinessData<>(klassService.create(saveKlassRequestDTO));
    }

    @ApiOperation(value = "更新", httpMethod = "POST")
    @PostMapping(value = "/{id}/update")
    public BusinessData<KlassResponseDTO> update(
            @ApiParam(required = true) @NotBlank(message = "对象id不能为空") @PathVariable(value = "id", required = false) String id,
            @ApiParam(required = true) @NotNull(message = "请求参数不能为空") @Validated @RequestBody(required = false) SaveKlassRequestDTO saveKlassRequestDTO
    ) {
        return new BusinessData<>(klassService.update(id, saveKlassRequestDTO));
    }

    @ApiOperation(value = "删除", httpMethod = "POST")
    @PostMapping(value = "/{id}/delete")
    public BusinessData delete(
            @ApiParam(required = true) @NotBlank(message = "对象id不能为空") @PathVariable(value = "id", required = false) String id
    ) {
        klassService.deleteById(id);
        return new BusinessData(BusinessError.SUCCESS);
    }

    @ApiOperation(value = "获取详细信息", httpMethod = "GET")
    @GetMapping(value = "/{id}/detail")
    public BusinessData<KlassResponseDTO> detail(
            @ApiParam(required = true) @NotBlank(message = "对象id不能为空") @PathVariable(value = "id", required = false) String id
    ) {
        return new BusinessData<>(klassService.findById(id));
    }

    @ApiOperation(value = "列表", httpMethod = "POST")
    @PostMapping(value = "/list")
    public BusinessData<List<KlassResponseDTO>> list(
            @ApiParam(required = true) @NotNull(message = "列表请求参数不能为空") @Validated @RequestBody(required = false) ListKlassRequestDTO listKlassRequestDTO
    ) {
        return new BusinessData<>(klassService.list(listKlassRequestDTO));
    }

    @ApiOperation(value = "分页", httpMethod = "POST")
    @PostMapping(value = "/page")
    public BusinessData<PageResponseData<KlassResponseDTO>> page(
            @ApiParam(required = true) @NotNull(message = "分页请求参数不能为空") @Validated @RequestBody(required = false) PageKlassRequestDTO pageKlassRequestDTO
    ) {
        return new BusinessData<>(klassService.page(pageKlassRequestDTO));
    }
}