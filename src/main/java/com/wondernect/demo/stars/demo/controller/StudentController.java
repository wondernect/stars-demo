package com.wondernect.demo.stars.demo.controller;

import com.wondernect.demo.stars.demo.dto.ListStudentRequestDTO;
import com.wondernect.demo.stars.demo.dto.PageStudentRequestDTO;
import com.wondernect.demo.stars.demo.dto.SaveStudentRequestDTO;
import com.wondernect.demo.stars.demo.dto.StudentResponseDTO;
import com.wondernect.demo.stars.demo.service.StudentExcelExportResponseService;
import com.wondernect.demo.stars.demo.service.StudentExcelImportResponseService;
import com.wondernect.demo.stars.demo.service.StudentService;
import com.wondernect.elements.common.error.BusinessError;
import com.wondernect.elements.common.response.BusinessData;
import com.wondernect.elements.rdb.response.PageResponseData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 学生接口
 *
 * @author chenxun 2020-11-17 13:43:31
 **/
@RequestMapping(value = "/v1/star_demo/student")
@RestController
@Validated
@Api(tags = "学生接口")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentExcelExportResponseService studentExcelExportResponseService;

    @Autowired
    private StudentExcelImportResponseService studentExcelImportResponseService;

    @ApiOperation(value = "创建", httpMethod = "POST")
    @PostMapping(value = "/create")
    public BusinessData<StudentResponseDTO> create(
            @ApiParam(required = true) @NotNull(message = "请求参数不能为空") @Validated @RequestBody(required = false) SaveStudentRequestDTO saveStudentRequestDTO
    ) {
        return new BusinessData<>(studentService.create(saveStudentRequestDTO));
    }

    @ApiOperation(value = "更新", httpMethod = "POST")
    @PostMapping(value = "/{id}/update")
    public BusinessData<StudentResponseDTO> update(
            @ApiParam(required = true) @NotBlank(message = "对象id不能为空") @PathVariable(value = "id", required = false) String id,
            @ApiParam(required = true) @NotNull(message = "请求参数不能为空") @Validated @RequestBody(required = false) SaveStudentRequestDTO saveStudentRequestDTO
    ) {
        return new BusinessData<>(studentService.update(id, saveStudentRequestDTO));
    }

    @ApiOperation(value = "删除", httpMethod = "POST")
    @PostMapping(value = "/{id}/delete")
    public BusinessData delete(
            @ApiParam(required = true) @NotBlank(message = "对象id不能为空") @PathVariable(value = "id", required = false) String id
    ) {
        studentService.deleteById(id);
        return new BusinessData(BusinessError.SUCCESS);
    }

    @ApiOperation(value = "获取详细信息", httpMethod = "GET")
    @GetMapping(value = "/{id}/detail")
    public BusinessData<StudentResponseDTO> detail(
            @ApiParam(required = true) @NotBlank(message = "对象id不能为空") @PathVariable(value = "id", required = false) String id
    ) {
        return new BusinessData<>(studentService.findById(id));
    }

    @ApiOperation(value = "列表", httpMethod = "POST")
    @PostMapping(value = "/list")
    public BusinessData<List<StudentResponseDTO>> list(
            @ApiParam(required = true) @NotNull(message = "列表请求参数不能为空") @Validated @RequestBody(required = false) ListStudentRequestDTO listStudentRequestDTO
    ) {
        return new BusinessData<>(studentService.list(listStudentRequestDTO));
    }

    @ApiOperation(value = "分页", httpMethod = "POST")
    @PostMapping(value = "/page")
    public BusinessData<PageResponseData<StudentResponseDTO>> page(
            @ApiParam(required = true) @NotNull(message = "分页请求参数不能为空") @Validated @RequestBody(required = false) PageStudentRequestDTO pageStudentRequestDTO
    ) {
        return new BusinessData<>(studentService.page(pageStudentRequestDTO));
    }

    @ApiOperation(value = "excel导出", httpMethod = "POST")
    @PostMapping(value = "/excel_data_export")
    public void excelDataExport(
            @ApiParam(required = true) @NotBlank(message = "模板id不能为空") @RequestParam(value = "template_id", required = false) String templateId,
            @ApiParam(required = true) @NotNull(message = "列表请求参数不能为空") @Validated @RequestBody(required = false) ListStudentRequestDTO listStudentRequestDTO,
            HttpServletRequest request,
            HttpServletResponse response
    ) {
        studentExcelExportResponseService.exportDataResponse(templateId, listStudentRequestDTO, request, response);
    }

    @ApiOperation(value = "本地用户导入(请求响应)", httpMethod = "POST")
    @PostMapping(value = "/response/import_data", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void importResponseData(
            @ApiParam(required = true) @NotBlank(message = "模板id不能为空") @RequestParam(value = "template_id", required = false) String templateId,
            @ApiParam(required = true) @NotNull(message = "导入文件不能为空") @RequestPart(value = "file", required = false) MultipartFile file,
            HttpServletRequest request,
            HttpServletResponse response
    ) {
        try {
            studentExcelImportResponseService.importDataResponse(templateId, file.getInputStream(), request, response);
        } catch (Exception e) {
            BusinessData.error(e.getMessage(), response);
        }
    }
}