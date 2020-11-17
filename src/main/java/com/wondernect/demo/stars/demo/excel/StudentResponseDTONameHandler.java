package com.wondernect.demo.stars.demo.excel;

import com.wondernect.elements.easyoffice.excel.ESExcelItemHandler;

/**
 * 姓名导入导出item handler
 *
 * @author chenxun 2020-11-17 13:43:51
 **/
public class StudentResponseDTONameHandler extends ESExcelItemHandler<String> {

    public StudentResponseDTONameHandler() {
        super("name", 0);
    }

    public StudentResponseDTONameHandler(int itemOrder) {
        super("name", itemOrder);
    }

    public StudentResponseDTONameHandler(String itemTitle, int itemOrder) {
        super(itemTitle, itemOrder);
    }

    @Override
    public String itemName() {
        return "name";
    }

    @Override
    public Object handleExcelExportItemObject(String object) {
        return object;
    }

    @Override
    public String handleExcelImportItemObject(Object object) {
        return object.toString();
    }
}