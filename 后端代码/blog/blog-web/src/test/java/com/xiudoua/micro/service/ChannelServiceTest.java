package com.xiudoua.micro.service;

import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.StringUtils;

import com.xiudoua.micro.InitApp;
import com.xiudoua.micro.exceptions.FormException;
import com.xiudoua.micro.model.ChannelVO;

/**
 * 
 * @desc 栏目数据单元测试
 * @author JustFresh
 * @time 2018年11月24日 下午3:43:22
 * @site http://www.xiudoua.com
 * @email justfresh@foxmail.com
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=InitApp.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ChannelServiceTest {

	protected Logger logger = LoggerFactory.getLogger(ChannelServiceTest.class);
    
    @Autowired
    private IChannelService channelService;
    
    private static ChannelVO channel = null;
    
    /**
     * 初始化测试数据
     */
    public void initData() {
    	channel = new ChannelVO();
    	channel.setChannelName("测试");
    	channel.setReorder(5);
    	channel.setUri("#");
    	channel.setIsBlank((byte) 0);
    	channel.setDescription("测试");
    }
    
    @Test
    public void test1Save() {
        initData();
        try {
        	channel = this.channelService.save(channel);
            Assert.assertNotNull(channel);
        } catch (FormException e) {
            logger.error(e.getErrorEnum().message());
        }
    }
    
    @Test
    public void test2GetOne() {
        if(channel != null && !StringUtils.isEmpty(channel.getId())) {
            try {
                ChannelVO vo = this.channelService.findOne(channel.getId());
                Assert.assertNotNull(vo);
            } catch (FormException e) {
                logger.error(e.getErrorEnum().message());
            }
        }
    }
    
    @Test
    public void test3Update() {
        if(channel != null && !StringUtils.isEmpty(channel.getId())) {
        	channel.setDescription("测试修改属性");
            try {
            	channel = this.channelService.update(channel);
                Assert.assertNotNull(channel);
            } catch (FormException e) {
                logger.error(e.getErrorEnum().message());
            }
        }
    }
    
    @Test
    public void test4GetList(){
        List<ChannelVO> list = this.channelService.findAll();
        Assert.assertNotNull(list);
    }
    
    @Test
    public void test5Delete() {
        if(channel != null && !StringUtils.isEmpty(channel.getId())) {
            try {
                this.channelService.delete(channel.getId());
            } catch (FormException e) {
                logger.error(e.getErrorEnum().message());
            }
        }
        destoryTempData();
    }
    
    /**
     * 销毁测试产生的临时数据
     */
    public void destoryTempData() {
        
    }
	
}