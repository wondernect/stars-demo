package com.wondernect.demo.stars.demo.excel;

import com.wondernect.elements.common.utils.ESDateTimeUtils;
import com.wondernect.elements.easyoffice.excel.ESExcelItemHandler;

/**
 * 姓名导出item handler
 *
 * @author chenxun 2020-11-13 16:02:24
 **/
public class StudentResponseDTOCreateTimeExportHandler extends ESExcelItemHandler<Long> {

    public StudentResponseDTOCreateTimeExportHandler() {
        super("创建时间", 0);
    }

    public StudentResponseDTOCreateTimeExportHandler(int itemOrder) {
        super("创建时间", itemOrder);
    }

    public StudentResponseDTOCreateTimeExportHandler(String itemTitle, int itemOrder) {
        super(itemTitle, itemOrder);
    }

    @Override
    public String itemName() {
        return "createTime";
    }

    public Object handleExcelExportItemObject(Long object) {
        return ESDateTimeUtils.formatDate(object, "yyyy-MM-dd");
    }

    public Long handleExcelImportItemObject(Object object) {
        return Long.valueOf(object.toString());
    }
}