package com.xiudoua.micro.utils;

import java.io.Serializable;

/**
 * 
 * @desc 自定义分页参数类
 * @author JustFresh
 * @time 2018年11月23日 下午4:36:51
 * @site http://www.xiudoua.com
 * @email justfresh@foxmail.com
 */
public class PageParam implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 5434944011783607030L;

	private Integer pageNum = 1;
    
    private Integer pageSize = 10;
    
    private String order;
    
    private String sort;

    /**
     * @return the pageNum
     */
    public Integer getPageNum() {
        return pageNum;
    }

    /**
     * @param pageNum the pageNum to set
     */
    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    /**
     * @return the pageSize
     */
    public Integer getPageSize() {
        return pageSize;
    }

    /**
     * @param pageSize the pageSize to set
     */
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}
}