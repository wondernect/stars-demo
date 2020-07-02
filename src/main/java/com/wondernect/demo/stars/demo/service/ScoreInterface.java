package com.wondernect.demo.stars.demo.service;

import com.wondernect.demo.stars.demo.dto.ListScoreRequestDTO;
import com.wondernect.demo.stars.demo.dto.PageScoreRequestDTO;
import com.wondernect.demo.stars.demo.dto.SaveScoreRequestDTO;
import com.wondernect.demo.stars.demo.dto.ScoreResponseDTO;
import com.wondernect.elements.rdb.response.PageResponseData;

import java.util.List;

/**
 * 分数服务接口类
 *
 * @author chenxun 2020-07-02 17:01:58
 **/
public interface ScoreInterface {

    /**
     * 创建
     **/
    ScoreResponseDTO create(SaveScoreRequestDTO saveScoreRequestDTO);

    /**
     * 更新
     **/
    ScoreResponseDTO update(Long scoreId, SaveScoreRequestDTO saveScoreRequestDTO);

    /**
     * 删除
     **/
    void deleteById(Long scoreId);

    /**
     * 获取详细信息
     **/
    ScoreResponseDTO findById(Long scoreId);

    /**
     * 列表
     **/
    List<ScoreResponseDTO> list(ListScoreRequestDTO listScoreRequestDTO);

    /**
     * 分页
     **/
    PageResponseData<ScoreResponseDTO> page(PageScoreRequestDTO pageScoreRequestDTO);
}