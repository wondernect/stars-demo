package com.wondernect.demo.stars.demo.excel;

import com.wondernect.elements.easyoffice.excel.ESExcelItemHandler;

/**
 * 年龄导入导出item handler
 *
 * @author chenxun 2020-11-17 13:43:52
 **/
public class StudentResponseDTOAgeHandler extends ESExcelItemHandler<Integer> {

    public StudentResponseDTOAgeHandler() {
        super("age", 0);
    }

    public StudentResponseDTOAgeHandler(int itemOrder) {
        super("age", itemOrder);
    }

    public StudentResponseDTOAgeHandler(String itemTitle, int itemOrder) {
        super(itemTitle, itemOrder);
    }

    @Override
    public String itemName() {
        return "age";
    }

    @Override
    public Object handleExcelExportItemObject(Integer object) {
        return object;
    }

    @Override
    public Integer handleExcelImportItemObject(Object object) {
        return Integer.valueOf(object.toString());
    }
}