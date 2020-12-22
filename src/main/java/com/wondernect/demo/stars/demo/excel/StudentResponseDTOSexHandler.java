package com.wondernect.demo.stars.demo.excel;

import com.wondernect.elements.easyoffice.excel.handler.ESExcelEnumItemHandler;

import java.util.HashMap;
import java.util.Map;

/**
 * Copyright (C), 2017-2020, wondernect.com
 * FileName: StudentResponseDTOSexHandler
 * Author: chenxun
 * Date: 2020/12/22 15:07
 * Description:
 */
public class StudentResponseDTOSexHandler extends ESExcelEnumItemHandler<Integer> {

    private static final Map<Integer, String> gender = new HashMap<>();

    static {
        gender.put(1, "男");
        gender.put(2, "女");
    }

    public StudentResponseDTOSexHandler(String itemName, String itemTitle, int itemOrder) {
        super(itemName, itemTitle, itemOrder, gender);
    }
}
