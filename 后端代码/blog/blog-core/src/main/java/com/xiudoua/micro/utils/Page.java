package com.xiudoua.micro.utils;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @desc 自定义分页工具类
 * @author JustFresh
 * @time 2018年11月23日 下午4:35:26
 * @site http://www.xiudoua.com
 * @email justfresh@foxmail.com
 */
public class Page<T> implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = -6404812132686603568L;
	private List<T> rows; // 保存查询的结果集合
    private int total; // 总记录数
    private int pageSize = 10; // 页面显示的数目
    private int pageNum = 1; // 当前页码
    /**
     * @return the rows
     */
    public List<T> getRows() {
        return rows;
    }
    /**
     * @param rows the rows to set
     */
    public void setRows(List<T> rows) {
        this.rows = rows;
    }
    /**
     * @return the total
     */
    public int getTotal() {
        return total;
    }
    /**
     * @param total the total to set
     */
    public void setTotal(int total) {
        this.total = total;
    }
    /**
     * @return the pageSize
     */
    public int getPageSize() {
        return pageSize;
    }
    /**
     * @param pageSize the pageSize to set
     */
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
    /**
     * @return the pageNum
     */
    public int getPageNum() {
        return pageNum;
    }
    /**
     * @param pageNum the pageNum to set
     */
    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

}