package com.wondernect.demo.stars.demo.service;

import com.wondernect.demo.stars.demo.dto.ListStudentRequestDTO;
import com.wondernect.demo.stars.demo.dto.PageStudentRequestDTO;
import com.wondernect.demo.stars.demo.dto.SaveStudentRequestDTO;
import com.wondernect.demo.stars.demo.dto.StudentResponseDTO;
import com.wondernect.demo.stars.demo.model.Student;
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
 * 学生服务抽象实现类
 *
 * @author chenxun 2020-11-17 13:43:30
 **/
@Service
public abstract class StudentAbstractService extends BaseStringService<StudentResponseDTO, Student> implements StudentInterface {

    @Transactional
    @Override
    public StudentResponseDTO create(SaveStudentRequestDTO saveStudentRequestDTO) {
//TODO:判断对象是否存在

        Student student = new Student();
        ESBeanUtils.copyProperties(saveStudentRequestDTO, student);
        return super.save(student);
    }

    @Transactional
    @Override
    public StudentResponseDTO update(String id, SaveStudentRequestDTO saveStudentRequestDTO) {
        Student student = super.findEntityById(id);
        if (ESObjectUtils.isNull(student)) {
            throw new BusinessException("学生不存在");
        }
        ESBeanUtils.copyWithoutNullAndIgnoreProperties(saveStudentRequestDTO, student);
        return super.save(student);
    }

    @Override
    public List<StudentResponseDTO> list(ListStudentRequestDTO listStudentRequestDTO) {
        Criteria<Student> studentCriteria = new Criteria<>();
//TODO:添加列表筛选条件

        return super.findAll(studentCriteria, listStudentRequestDTO.getSortDataList());
    }

    @Override
    public PageResponseData<StudentResponseDTO> page(PageStudentRequestDTO pageStudentRequestDTO) {
        Criteria<Student> studentCriteria = new Criteria<>();
//TODO:添加分页筛选条件

        return super.findAll(studentCriteria, pageStudentRequestDTO.getPageRequestData());
    }

    @Override
    public StudentResponseDTO generate(Student student) {
        StudentResponseDTO studentResponseDTO = new StudentResponseDTO();
        ESBeanUtils.copyProperties(student, studentResponseDTO);
        return studentResponseDTO;
    }
}