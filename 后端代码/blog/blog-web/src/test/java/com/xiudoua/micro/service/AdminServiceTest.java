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
import com.xiudoua.micro.model.AdminVO;

/**
 * 
 * @desc 管理员数据单元测试
 * @author JustFresh
 * @time 2018年11月24日 下午3:43:36
 * @site http://www.xiudoua.com
 * @email justfresh@foxmail.com
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=InitApp.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AdminServiceTest {

	protected Logger logger = LoggerFactory.getLogger(AdminServiceTest.class);
    
    @Autowired
    private IAdminService adminService;
    
    private static AdminVO admin = null;
    
    /**
     * 初始化测试数据
     */
    public void initData() {
    	admin = new AdminVO();
    	admin.setUsername("zhangsan");
    	admin.setPassword("111111");
    	admin.setNickName("张三");
    	admin.setLoginNum(0);
    	admin.setDescription("管理员");
    }
    
    @Test
    public void test1Save() {
        initData();
        try {
        	admin = this.adminService.save(admin);
            Assert.assertNotNull(admin);
        } catch (FormException e) {
            logger.error(e.getErrorEnum().message());
        }
    }
    
    @Test
    public void test2GetOne() {
        if(admin != null && !StringUtils.isEmpty(admin.getId())) {
            try {
                AdminVO vo = this.adminService.findOne(admin.getId());
                Assert.assertNotNull(vo);
            } catch (FormException e) {
                logger.error(e.getErrorEnum().message());
            }
        }
    }
    
    @Test
    public void test3Update() {
        if(admin != null && !StringUtils.isEmpty(admin.getId())) {
        	admin.setDescription("测试修改属性");
            try {
            	admin = this.adminService.update(admin);
                Assert.assertNotNull(admin);
            } catch (FormException e) {
                logger.error(e.getErrorEnum().message());
            }
        }
    }
    
    @Test
    public void test4GetList(){
        List<AdminVO> list = this.adminService.findAll();
        Assert.assertNotNull(list);
    }
    
    @Test
    public void test5Delete() {
        if(admin != null && !StringUtils.isEmpty(admin.getId())) {
            try {
                this.adminService.delete(admin.getId());
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