package com.wondernect.demo.stars.demo.service;

import com.wondernect.demo.stars.demo.dto.ListStudentKlassRequestDTO;
import com.wondernect.demo.stars.demo.dto.PageStudentKlassRequestDTO;
import com.wondernect.demo.stars.demo.dto.SaveStudentKlassRequestDTO;
import com.wondernect.demo.stars.demo.dto.StudentKlassResponseDTO;
import com.wondernect.demo.stars.demo.model.StudentKlass;
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
 * 学生班级服务抽象实现类
 *
 * @author chenxun 2020-06-29 19:14:38
 **/
@Service
public abstract class StudentKlassAbstractService extends BaseStringService<StudentKlassResponseDTO, StudentKlass> implements StudentKlassInterface {

    @Transactional
    @Override
    public StudentKlassResponseDTO create(SaveStudentKlassRequestDTO saveStudentKlassRequestDTO) {
//TODO:判断对象是否存在

        StudentKlass studentKlass = new StudentKlass();
        ESBeanUtils.copyProperties(saveStudentKlassRequestDTO, studentKlass);
        return super.save(studentKlass);
    }

    @Transactional
    @Override
    public StudentKlassResponseDTO update(String id, SaveStudentKlassRequestDTO saveStudentKlassRequestDTO) {
        StudentKlass studentKlass = super.findEntityById(id);
        if (ESObjectUtils.isNull(studentKlass)) {
            throw new BusinessException("学生班级不存在");
        }
        ESBeanUtils.copyWithoutNullAndIgnoreProperties(saveStudentKlassRequestDTO, studentKlass);
        return super.save(studentKlass);
    }

    @Override
    public List<StudentKlassResponseDTO> list(ListStudentKlassRequestDTO listStudentKlassRequestDTO) {
        Criteria<StudentKlass> studentKlassCriteria = new Criteria<>();
//TODO:添加列表筛选条件

        return super.findAll(studentKlassCriteria, listStudentKlassRequestDTO.getSortDataList());
    }

    @Override
    public PageResponseData<StudentKlassResponseDTO> page(PageStudentKlassRequestDTO pageStudentKlassRequestDTO) {
        Criteria<StudentKlass> studentKlassCriteria = new Criteria<>();
//TODO:添加分页筛选条件

        return super.findAll(studentKlassCriteria, pageStudentKlassRequestDTO.getPageRequestData());
    }

    @Override
    public StudentKlassResponseDTO generate(StudentKlass studentKlass) {
        StudentKlassResponseDTO studentKlassResponseDTO = new StudentKlassResponseDTO();
        ESBeanUtils.copyProperties(studentKlass, studentKlassResponseDTO);
        studentKlassResponseDTO.setId(studentKlass.getId());
        return studentKlassResponseDTO;
    }
}