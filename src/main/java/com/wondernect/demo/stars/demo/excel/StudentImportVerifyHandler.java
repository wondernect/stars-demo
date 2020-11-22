package com.wondernect.demo.stars.demo.excel;

import com.wondernect.elements.common.error.BusinessError;
import com.wondernect.elements.common.response.BusinessData;
import com.wondernect.elements.common.utils.ESObjectUtils;
import com.wondernect.elements.common.utils.ESStringUtils;
import com.wondernect.elements.easyoffice.excel.ESExcelImportVerifyHandler;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Copyright (C), 2020, wondernect.com
 * FileName: UserVerifyHandler
 * Author: chenxun
 * Date: 2020-11-12 15:19
 * Description:
 */
@Service
public class StudentImportVerifyHandler extends ESExcelImportVerifyHandler {

    @Override
    public BusinessData verifyData(Map<String, Object> object) {
        Object sex = object.get("sex");
        if (ESObjectUtils.isNotNull(sex) && ESStringUtils.equals("男", sex.toString())) {
            return new BusinessData("男性不进行录入");
        }
        return new BusinessData(BusinessError.SUCCESS);
    }
}
