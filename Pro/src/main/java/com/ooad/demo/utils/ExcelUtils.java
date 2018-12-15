package com.ooad.demo.utils;

import com.ooad.demo.entity.User;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import java.io.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author: WinstonDeng
 * @Description: POI处理Excel 各类版本兼容（.xls / .xlsx）
 * @Date: Created in 9:19 2018/12/13
 * @Modified by:
 */
public class ExcelUtils {

    /**
     * Description: 处理读取的excel,返回用户set集合
     * @Author: WinstonDeng
     * @Date: 9:25 2018/12/13
     */
    public static Set<User> transExcelToSet(String filePath){
        Set<User> students=new HashSet<>();
        User student=null;
        Workbook wb=null;
        Sheet sheet=null;
        Row row=null;
        try{
            wb=readExcel(filePath);
            if(wb!=null){
                //获取第一个sheet
                sheet = wb.getSheetAt(0);
                //获取最大行数
                int rowNum = sheet.getPhysicalNumberOfRows();
                for(int i=1;i<rowNum;i++){
                    row=sheet.getRow(i);
                    if(row!=null){
                        student=new User();
                        String account=(String)getCellFormatValue(row.getCell(0));//学号)
                        String name=(String)getCellFormatValue(row.getCell(1));//姓名
                        //所属系
                        //所属专业
                        student.setAccount(account);
                        student.setName(name);
                        students.add(student);
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return students;
    }

    /**
     * Description: 读取excel，返回工作簿
     * @Author: WinstonDeng
     * @Date: 9:22 2018/12/13
     */
    public static Workbook readExcel(String filePath){
        Workbook wb = null;
        if(filePath==null){
            return null;
        }
        String extString = filePath.substring(filePath.lastIndexOf("."));
        InputStream is = null;
        try {
            is = new FileInputStream(filePath);
            if(".xls".equals(extString)){
                return wb = new HSSFWorkbook(is);
            }else if(".xlsx".equals(extString)){
                return wb = new XSSFWorkbook(is);
            }else{
                return wb = null;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wb;
    }
    /**
     * Description: 获得单元格格式数据
     * @Author: WinstonDeng
     * @Date: 9:23 2018/12/13
     */
    public static Object getCellFormatValue(Cell cell){
        Object cellValue = null;
        if(cell!=null){
            //判断cell类型

            switch(cell.getCellType()){
                case Cell.CELL_TYPE_NUMERIC:{
                    cellValue = String.valueOf(cell.getNumericCellValue());
                    break;
                }
                case Cell.CELL_TYPE_FORMULA:{
                    //判断cell是否为日期格式
                    if(DateUtil.isCellDateFormatted(cell)){
                        //转换为日期格式YYYY-mm-dd
                        cellValue = cell.getDateCellValue();
                    }else{
                        //数字
                        cellValue = String.valueOf(cell.getNumericCellValue());
                    }
                    break;
                }
                case Cell.CELL_TYPE_STRING:{
                    cellValue = cell.getRichStringCellValue().getString();
                    break;
                }
                default:
                    cellValue = "";
            }
        }else{
            cellValue = "";
        }
        return cellValue;
    }

}