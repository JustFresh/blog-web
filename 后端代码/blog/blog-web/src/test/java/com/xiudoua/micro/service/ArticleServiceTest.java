package com.xiudoua.micro.service;

import org.junit.FixMethodOrder;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xiudoua.micro.InitApp;

/**
 * 
 * @desc 文章数据单元测试
 * @author JustFresh
 * @time 2018年11月24日 下午4:01:02
 * @site http://www.xiudoua.com
 * @email justfresh@foxmail.com
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=InitApp.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ArticleServiceTest {

}
