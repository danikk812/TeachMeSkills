package by.tms.petstorejpa.configuration;

import by.tms.petstorejpa.interceptor.AdminAuthInterceptor;
import by.tms.petstorejpa.interceptor.UserAuthInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class WebConfiguration implements WebMvcConfigurer {
    @Autowired
    private AdminAuthInterceptor adminInterceptor;

    @Autowired
    private UserAuthInterceptor userInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(userInterceptor)
                .addPathPatterns("/store/order");

        registry.addInterceptor(adminInterceptor)
                .addPathPatterns("/pet/*")
                .addPathPatterns("/store/inventory");
    }
}
