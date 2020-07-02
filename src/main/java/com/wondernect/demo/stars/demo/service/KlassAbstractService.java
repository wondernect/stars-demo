package com.wondernect.demo.stars.demo.service;

import com.wondernect.demo.stars.demo.dto.KlassResponseDTO;
import com.wondernect.demo.stars.demo.dto.ListKlassRequestDTO;
import com.wondernect.demo.stars.demo.dto.PageKlassRequestDTO;
import com.wondernect.demo.stars.demo.dto.SaveKlassRequestDTO;
import com.wondernect.demo.stars.demo.model.Klass;
import com.wondernect.elements.common.exception.BusinessException;
import com.wondernect.elements.common.utils.ESBeanUtils;
import com.wondernect.elements.common.utils.ESObjectUtils;
import com.wondernect.elements.rdb.base.service.BaseStringService;
import com.wondernect.elements.rdb.criteria.Criteria;
import com.wondernect.elements.rdb.response.PageResponseData;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 班级服务抽象实现类
 *
 * @author chenxun 2020-06-29 19:14:06
 **/
@Service
public abstract class KlassAbstractService extends BaseStringService<KlassResponseDTO, Klass> implements KlassInterface {

    @Transactional
    @Override
    public KlassResponseDTO create(SaveKlassRequestDTO saveKlassRequestDTO) {
//TODO:判断对象是否存在

        Klass klass = new Klass();
        ESBeanUtils.copyProperties(saveKlassRequestDTO, klass);
        return super.save(klass);
    }

    @Transactional
    @Override
    public KlassResponseDTO update(String id, SaveKlassRequestDTO saveKlassRequestDTO) {
        Klass klass = super.findEntityById(id);
        if (ESObjectUtils.isNull(klass)) {
            throw new BusinessException("班级不存在");
        }
        ESBeanUtils.copyWithoutNullAndIgnoreProperties(saveKlassRequestDTO, klass);
        return super.save(klass);
    }

    @Override
    public List<KlassResponseDTO> list(ListKlassRequestDTO listKlassRequestDTO) {
        Criteria<Klass> klassCriteria = new Criteria<>();
//TODO:添加列表筛选条件

        return super.findAll(klassCriteria, listKlassRequestDTO.getSortDataList());
    }

    @Override
    public PageResponseData<KlassResponseDTO> page(PageKlassRequestDTO pageKlassRequestDTO) {
        Criteria<Klass> klassCriteria = new Criteria<>();
//TODO:添加分页筛选条件

        return super.findAll(klassCriteria, pageKlassRequestDTO.getPageRequestData());
    }

    @Override
    public KlassResponseDTO generate(Klass klass) {
        KlassResponseDTO klassResponseDTO = new KlassResponseDTO();
        ESBeanUtils.copyProperties(klass, klassResponseDTO);
        klassResponseDTO.setId(klass.getId());
        return klassResponseDTO;
    }
}