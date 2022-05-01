package xyz.yiui.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import xyz.yiui.dao.userDao;

@Configuration
public class MyMVCconfig implements WebMvcConfigurer {

    @Autowired
    private MyInterceptor myInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(myInterceptor)
                .addPathPatterns("/***")
                .excludePathPatterns("/login", "/login_check","/login.html","/regist");
    }
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login.html");
        registry.addViewController("/index").setViewName("index.html");
        registry.addViewController("/admin").setViewName("admin.html");
        registry.addViewController("/regist").setViewName("registration.html");
        registry.addViewController("/car_add").setViewName("CarAdd.html");
        registry.addViewController("/user_add").setViewName("UserAdd.html");
        registry.addViewController("/car_update").setViewName("CarUpdate.html");
        registry.addViewController("/user_update").setViewName("UserUpdate.html");
    }

}
