package com.wondernect.demo.stars.demo.excel;

import com.wondernect.elements.easyoffice.excel.ESExcelIDItemHandler;

import java.util.Map;

/**
 * 性别导入导出item handler
 *
 * @author chenxun 2020-11-17 13:43:51
 **/
public class StudentResponseDTOSexHandler extends ESExcelIDItemHandler<Integer> {

    public StudentResponseDTOSexHandler(String itemName, String itemTitle, int itemOrder, Map<Integer, String> dictionary) {
        super(itemName, itemTitle, itemOrder, dictionary);
    }
}