package org.superbiz.struts;

import com.opensymphony.sitemesh.webapp.SiteMeshFilter;
import org.apache.struts2.dispatcher.filter.StrutsPrepareAndExecuteFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import javax.servlet.DispatcherType;
import java.util.Arrays;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    @Bean
    public FilterRegistrationBean siteMeshFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new SiteMeshFilter());
        registration.setEnabled(true);
        registration.addUrlPatterns("/*");
        registration.setOrder(1);
        registration.setDispatcherTypes(DispatcherType.ERROR, DispatcherType.FORWARD, DispatcherType.REQUEST);
        return registration;
    }
    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean<StrutsPrepareAndExecuteFilter> registrationBean = new FilterRegistrationBean<>();
        StrutsPrepareAndExecuteFilter struts = new StrutsPrepareAndExecuteFilter();
        registrationBean.setFilter(struts);
        registrationBean.setUrlPatterns(Arrays.asList("/","/addUserForm.action","/addUser.action",
                "/findUserForm.action","/findUser.action","/listAllUsers.action"));
        registrationBean.setOrder(2);
        return registrationBean;
    }
}
