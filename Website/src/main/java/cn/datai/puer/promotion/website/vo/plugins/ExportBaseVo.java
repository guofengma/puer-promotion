package cn.datai.puer.promotion.website.vo.plugins;

import org.apache.poi.hssf.usermodel.*;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/7/1.
 */
public class ExportBaseVo implements Serializable{

    private HSSFWorkbook wb;

    private HSSFSheet sheet;

    private HSSFRow row;

    private HSSFCellStyle style;

    private HSSFCell cell;

    private int cellSize;

    public ExportBaseVo(){

    }

    public ExportBaseVo(HSSFWorkbook wb, HSSFSheet sheet, HSSFRow row, HSSFCellStyle style, HSSFCell cell, int cellSize) {
        this.wb = wb;
        this.sheet = sheet;
        this.row = row;
        this.style = style;
        this.cell = cell;
        this.cellSize = cellSize;
    }

    public HSSFWorkbook getWb() {
        return wb;
    }

    public void setWb(HSSFWorkbook wb) {
        this.wb = wb;
    }

    public HSSFSheet getSheet() {
        return sheet;
    }

    public void setSheet(HSSFSheet sheet) {
        this.sheet = sheet;
    }

    public HSSFRow getRow() {
        return row;
    }

    public void setRow(HSSFRow row) {
        this.row = row;
    }

    public HSSFCellStyle getStyle() {
        return style;
    }

    public void setStyle(HSSFCellStyle style) {
        this.style = style;
    }

    public HSSFCell getCell() {
        return cell;
    }

    public void setCell(HSSFCell cell) {
        this.cell = cell;
    }

    public int getCellSize() {
        return cellSize;
    }

    public void setCellSize(int cellSize) {
        this.cellSize = cellSize;
    }
}
