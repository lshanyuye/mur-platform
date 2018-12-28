package com.mur.menu;

import com.mur.platform.menus.builder.MenuBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @ClassName BuildMenuBeanTest
 * @Description TODO
 * @Author Administrator
 * @Date 2018/12/22 11:18
 **/
@RunWith(SpringRunner.class)
//@SpringBootTest(classes = WebApplication.class)
public class BuildMenuBeanTest {

    @Autowired
    private MenuBuilder menuBuilder;

    @Test
    public void testBuilder(){
        menuBuilder.buildResourceByMenuConfig();
    }
}
