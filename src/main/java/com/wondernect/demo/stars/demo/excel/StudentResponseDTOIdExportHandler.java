package com.wondernect.demo.stars.demo.excel;

import com.wondernect.elements.easyoffice.excel.ESExcelItemHandler;

/**
 * 学生id导出item handler
 *
 * @author chenxun 2020-11-13 16:02:24
 **/
public class StudentResponseDTOIdExportHandler extends ESExcelItemHandler<String> {

    public StudentResponseDTOIdExportHandler() {
        super("学生id", 0);
    }

    public StudentResponseDTOIdExportHandler(int itemOrder) {
        super("学生id", itemOrder);
    }

    public StudentResponseDTOIdExportHandler(String itemTitle, int itemOrder) {
        super(itemTitle, itemOrder);
    }

    @Override
    public String itemName() {
        return "id";
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