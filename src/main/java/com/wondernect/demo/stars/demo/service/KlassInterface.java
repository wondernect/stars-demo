package com.wondernect.demo.stars.demo.service;

import com.wondernect.demo.stars.demo.dto.KlassResponseDTO;
import com.wondernect.demo.stars.demo.dto.ListKlassRequestDTO;
import com.wondernect.demo.stars.demo.dto.PageKlassRequestDTO;
import com.wondernect.demo.stars.demo.dto.SaveKlassRequestDTO;
import com.wondernect.elements.rdb.response.PageResponseData;

import java.util.List;

/**
 * 班级服务接口类
 *
 * @author chenxun 2020-06-29 19:14:06
 **/
public interface KlassInterface {

    /**
     * 创建
     **/
    KlassResponseDTO create(SaveKlassRequestDTO saveKlassRequestDTO);

    /**
     * 更新
     **/
    KlassResponseDTO update(String id, SaveKlassRequestDTO saveKlassRequestDTO);

    /**
     * 删除
     **/
    void deleteById(String id);

    /**
     * 获取详细信息
     **/
    KlassResponseDTO findById(String id);

    /**
     * 列表
     **/
    List<KlassResponseDTO> list(ListKlassRequestDTO listKlassRequestDTO);

    /**
     * 分页
     **/
    PageResponseData<KlassResponseDTO> page(PageKlassRequestDTO pageKlassRequestDTO);
}