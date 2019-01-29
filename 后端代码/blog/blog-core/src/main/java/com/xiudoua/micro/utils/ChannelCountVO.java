package com.xiudoua.micro.utils;

import java.io.Serializable;

/**
 * 
 * @desc 含有栏目下文章统计数量的VO对象
 * @author JustFresh
 * @time 2018年12月22日 下午4:37:37
 * @site http://www.xiudoua.com
 * @email justfresh@foxmail.com
 */
public class ChannelCountVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7657259372871640177L;

	private Integer id;
	
	/**
	 * 栏目名称
	 */
	private String channelName;
	
	private Long count;
	
	public ChannelCountVO(){}
	
	public ChannelCountVO(Integer id,String channelName,Long count){
		this.id = id;
		this.channelName = channelName;
		this.count = count;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}
	
}