package com.yangf.pub_libs.jxi;

import android.content.Context;
import android.content.IntentFilter;

import com.yangf.pub_libs.log.Log4j;
import com.yangf.pub_libs.util.FileUtil;
import com.yangf.pub_libs.util.TimeUtil;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import java.io.OutputStream;
import java.util.List;

import jxl.Workbook;
import jxl.format.Colour;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import lombok.Data;

/**
 * 项目负责人： 杨帆
 * 包名：      com.yangf.pub_libs.jxi
 * 描述：      TODO
 * 编译环境：  JDK-1_8、SDK-8.0
 * 创建时间：  2021年 02月 03日 16时 50分
 */
@Data
public class ExcelUtil {

    private final static String TAG = "com.yangf.pub_libs.jxi.ExcelUtil";

    File file;
    WritableWorkbook wwb;

    // 添加第一个工作表并设置第一个Sheet的名字
    public ExcelUtil(Context context, String name) {
        file = FileUtil.getCacheFile(context, name);
    }

    /**
     * 如果File不存在，则创建excel表头
     *
     * @param title 标题栏
     */
    public void createExcel(List<String> title) {
        try {
            if (!FileUtil.isExistFile(file)){
                Log4j.d(TAG,"createExcel不存在所以创建");
                OutputStream os = new FileOutputStream(file);
                wwb = Workbook.createWorkbook(os);
                WritableSheet sheet = wwb.createSheet(TimeUtil.modernClock(), 0);
                Label label;
                for (int i = 0; i < title.size(); i++) {
                    // Label(x,y,z) 代表单元格的第x+1列，第y+1行, 内容z
                    label = new Label(i, 0, title.get(i) + "", getHeader());
                    // 将定义好的单元格添加到工作表中
                    sheet.addCell(label);
                }
                wwb.write();
                wwb.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void bodyExcel(List<String> resource) {
        try {
            if (FileUtil.isExistFile(file)){
                Log4j.d(TAG,"bodyExcel存在");
                FileInputStream in = new FileInputStream(file);
                Workbook oldWwb = Workbook.getWorkbook(in);
                WritableWorkbook wwb = Workbook.createWorkbook(file, oldWwb);
                WritableSheet sheet = wwb.getSheet(0);
                int row = sheet.getRows();
                for (int i = 0; i < resource.size(); i++) {
                    Label label = new Label(i, row, resource.get(i) + "");
                    sheet.addCell(label);
                }
                wwb.write();
                wwb.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private WritableCellFormat getHeader() {
        WritableFont font = new WritableFont(WritableFont.TIMES, 10, WritableFont.BOLD);// 定义字体
        try {
            font.setColour(Colour.BLUE);// 蓝色字体
        } catch (WriteException e1) {
            e1.printStackTrace();
        }
        WritableCellFormat format = new WritableCellFormat(font);
        try {
            format.setAlignment(jxl.format.Alignment.CENTRE);// 左右居中
            format.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);// 上下居中
        } catch (WriteException e) {
            e.printStackTrace();
        }
        return format;
    }

}
