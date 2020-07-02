package com.wondernect.demo.stars.demo.service;

import com.wondernect.demo.stars.demo.dto.ListStudentRequestDTO;
import com.wondernect.demo.stars.demo.dto.PageStudentRequestDTO;
import com.wondernect.demo.stars.demo.dto.SaveStudentRequestDTO;
import com.wondernect.demo.stars.demo.dto.StudentResponseDTO;
import com.wondernect.elements.rdb.response.PageResponseData;

import java.util.List;

/**
 * 学生服务接口类
 *
 * @author chenxun 2020-06-29 19:14:22
 **/
public interface StudentInterface {

    /**
     * 创建
     **/
    StudentResponseDTO create(SaveStudentRequestDTO saveStudentRequestDTO);

    /**
     * 更新
     **/
    StudentResponseDTO update(String id, SaveStudentRequestDTO saveStudentRequestDTO);

    /**
     * 删除
     **/
    void deleteById(String id);

    /**
     * 获取详细信息
     **/
    StudentResponseDTO findById(String id);

    /**
     * 列表
     **/
    List<StudentResponseDTO> list(ListStudentRequestDTO listStudentRequestDTO);

    /**
     * 分页
     **/
    PageResponseData<StudentResponseDTO> page(PageStudentRequestDTO pageStudentRequestDTO);
}