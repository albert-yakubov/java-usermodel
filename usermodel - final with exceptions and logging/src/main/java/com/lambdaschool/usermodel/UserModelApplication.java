package com.lambdaschool.usermodel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@EnableJpaAuditing
@SpringBootApplication
public class UserModelApplication
{

    public static void main(String[] args)
    {
        //todo 8 adjust the context to spring
        ApplicationContext ctx = SpringApplication.run(UserModelApplication.class,
                                                       args);

        //todo 8.1 find the specific bean and set our own (name sure to add annotation on top EnableWebMvc)
        DispatcherServlet dispatcherServlet = (DispatcherServlet) ctx.getBean("dispatcherServlet");
        dispatcherServlet.setThrowExceptionIfNoHandlerFound(true);
    }
}
