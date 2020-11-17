package com.wondernect.demo.stars.demo.excel;

import com.wondernect.elements.common.utils.ESStringUtils;
import com.wondernect.elements.easyoffice.excel.ESExcelItemHandler;

/**
 * 性别导入导出item handler
 *
 * @author chenxun 2020-11-17 13:43:51
 **/
public class StudentResponseDTOSexHandler extends ESExcelItemHandler<Integer> {

    public StudentResponseDTOSexHandler() {
        super("sex", 0);
    }

    public StudentResponseDTOSexHandler(int itemOrder) {
        super("sex", itemOrder);
    }

    public StudentResponseDTOSexHandler(String itemTitle, int itemOrder) {
        super(itemTitle, itemOrder);
    }

    @Override
    public String itemName() {
        return "sex";
    }

    @Override
    public Object handleExcelExportItemObject(Integer object) {
        if (object == 1) {
            return "男";
        } else {
            return "女";
        }
    }

    @Override
    public Integer handleExcelImportItemObject(Object object) {
        if (ESStringUtils.equals("男", object.toString())) {
            return 1;
        } else {
            return 2;
        }
    }
}