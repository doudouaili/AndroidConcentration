package com.concentration;

import com.concentration.domain.service.IUserService;
import com.concentration.domain.jpa.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * Created by ali on 2017/3/21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext.xml")
public class text extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    IUserService iUserService;

    @Test
    public void show() {
       /* ApplicationContext context =new AnnotationConfigApplicationContext(Application.class);
        System.out.println(context.containsBean("IUserService"));*/
        User user = new User();
        user.setUser_photo("12312312");
        user.setUser_phone("182931");
        user.setUser_password("123213");
        user.setUser_code("123");
        user.setUser_name("asd");
        int i = iUserService.insertUser(user);
    }
}
