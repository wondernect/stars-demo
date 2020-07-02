package com.wondernect.demo.stars.demo.service;

import com.wondernect.demo.stars.demo.dto.ListScoreRequestDTO;
import com.wondernect.demo.stars.demo.dto.PageScoreRequestDTO;
import com.wondernect.demo.stars.demo.dto.SaveScoreRequestDTO;
import com.wondernect.demo.stars.demo.dto.ScoreResponseDTO;
import com.wondernect.demo.stars.demo.model.Score;
import com.wondernect.elements.common.exception.BusinessException;
import com.wondernect.elements.common.utils.ESBeanUtils;
import com.wondernect.elements.common.utils.ESObjectUtils;
import com.wondernect.elements.rdb.base.service.BaseService;
import com.wondernect.elements.rdb.criteria.Criteria;
import com.wondernect.elements.rdb.response.PageResponseData;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 分数服务抽象实现类
 *
 * @author chenxun 2020-07-02 17:01:58
 **/
@Service
public abstract class ScoreAbstractService extends BaseService<ScoreResponseDTO, Score, Long> implements ScoreInterface {

    @Transactional
    @Override
    public ScoreResponseDTO create(SaveScoreRequestDTO saveScoreRequestDTO) {
//TODO:判断对象是否存在

        Score score = new Score();
        ESBeanUtils.copyProperties(saveScoreRequestDTO, score);
        return super.save(score);
    }

    @Transactional
    @Override
    public ScoreResponseDTO update(Long scoreId, SaveScoreRequestDTO saveScoreRequestDTO) {
        Score score = super.findEntityById(scoreId);
        if (ESObjectUtils.isNull(score)) {
            throw new BusinessException("分数不存在");
        }
        ESBeanUtils.copyWithoutNullAndIgnoreProperties(saveScoreRequestDTO, score);
        return super.save(score);
    }

    @Override
    public List<ScoreResponseDTO> list(ListScoreRequestDTO listScoreRequestDTO) {
        Criteria<Score> scoreCriteria = new Criteria<>();
//TODO:添加列表筛选条件

        return super.findAll(scoreCriteria, listScoreRequestDTO.getSortDataList());
    }

    @Override
    public PageResponseData<ScoreResponseDTO> page(PageScoreRequestDTO pageScoreRequestDTO) {
        Criteria<Score> scoreCriteria = new Criteria<>();
//TODO:添加分页筛选条件

        return super.findAll(scoreCriteria, pageScoreRequestDTO.getPageRequestData());
    }

    @Override
    public ScoreResponseDTO generate(Score score) {
        ScoreResponseDTO scoreResponseDTO = new ScoreResponseDTO();
        ESBeanUtils.copyProperties(score, scoreResponseDTO);
        return scoreResponseDTO;
    }
}