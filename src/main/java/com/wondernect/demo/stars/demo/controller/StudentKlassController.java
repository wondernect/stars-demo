package com.wondernect.demo.stars.demo.controller;

import com.wondernect.demo.stars.demo.dto.ListStudentKlassRequestDTO;
import com.wondernect.demo.stars.demo.dto.PageStudentKlassRequestDTO;
import com.wondernect.demo.stars.demo.dto.SaveStudentKlassRequestDTO;
import com.wondernect.demo.stars.demo.dto.StudentKlassResponseDTO;
import com.wondernect.demo.stars.demo.service.StudentKlassService;
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
 * 学生班级接口
 *
 * @author chenxun 2020-06-29 19:14:38
 **/
@RequestMapping(value = "/v1/app/student_klass")
@RestController
@Validated
@Api(tags = "学生班级接口")
public class StudentKlassController {

    @Autowired
    private StudentKlassService studentKlassService;

    @ApiOperation(value = "创建", httpMethod = "POST")
    @PostMapping(value = "/create")
    public BusinessData<StudentKlassResponseDTO> create(
            @ApiParam(required = true) @NotNull(message = "请求参数不能为空") @Validated @RequestBody(required = false) SaveStudentKlassRequestDTO saveStudentKlassRequestDTO
    ) {
        return new BusinessData<>(studentKlassService.create(saveStudentKlassRequestDTO));
    }

    @ApiOperation(value = "更新", httpMethod = "POST")
    @PostMapping(value = "/{id}/update")
    public BusinessData<StudentKlassResponseDTO> update(
            @ApiParam(required = true) @NotBlank(message = "对象id不能为空") @PathVariable(value = "id", required = false) String id,
            @ApiParam(required = true) @NotNull(message = "请求参数不能为空") @Validated @RequestBody(required = false) SaveStudentKlassRequestDTO saveStudentKlassRequestDTO
    ) {
        return new BusinessData<>(studentKlassService.update(id, saveStudentKlassRequestDTO));
    }

    @ApiOperation(value = "删除", httpMethod = "POST")
    @PostMapping(value = "/{id}/delete")
    public BusinessData delete(
            @ApiParam(required = true) @NotBlank(message = "对象id不能为空") @PathVariable(value = "id", required = false) String id
    ) {
        studentKlassService.deleteById(id);
        return new BusinessData(BusinessError.SUCCESS);
    }

    @ApiOperation(value = "获取详细信息", httpMethod = "GET")
    @GetMapping(value = "/{id}/detail")
    public BusinessData<StudentKlassResponseDTO> detail(
            @ApiParam(required = true) @NotBlank(message = "对象id不能为空") @PathVariable(value = "id", required = false) String id
    ) {
        return new BusinessData<>(studentKlassService.findById(id));
    }

    @ApiOperation(value = "列表", httpMethod = "POST")
    @PostMapping(value = "/list")
    public BusinessData<List<StudentKlassResponseDTO>> list(
            @ApiParam(required = true) @NotNull(message = "列表请求参数不能为空") @Validated @RequestBody(required = false) ListStudentKlassRequestDTO listStudentKlassRequestDTO
    ) {
        return new BusinessData<>(studentKlassService.list(listStudentKlassRequestDTO));
    }

    @ApiOperation(value = "分页", httpMethod = "POST")
    @PostMapping(value = "/page")
    public BusinessData<PageResponseData<StudentKlassResponseDTO>> page(
            @ApiParam(required = true) @NotNull(message = "分页请求参数不能为空") @Validated @RequestBody(required = false) PageStudentKlassRequestDTO pageStudentKlassRequestDTO
    ) {
        return new BusinessData<>(studentKlassService.page(pageStudentKlassRequestDTO));
    }
}