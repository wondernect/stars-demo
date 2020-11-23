package com.wondernect.demo.stars.demo.excel;

import com.wondernect.elements.easyoffice.excel.ESExcelImportDataHandler;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Copyright (C), 2020, wondernect.com
 * FileName: UserExportHandler
 * Author: chenxun
 * Date: 2020-11-12 15:15
 * Description: 用户导入handler
 */
@Service
public class StudentImportDataHandler extends ESExcelImportDataHandler {

    public Map<String, String> getDataPropertyMapping() {
        Map<String, String> dict = new HashMap<>();
        dict.put("姓名", "name");
        dict.put("性别", "sex");
        dict.put("年龄", "age");
        dict.put("学生id", "id");
        dict.put("创建时间", "createTime");
        return dict;
    }
}
