package lk.ijse.dep11.edupanel;

import org.springframework.web.filter.FormContentFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{WebRootConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebAppConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) { //multipart form data ekka wd krnna mek oni
        registration.setMultipartConfig(new MultipartConfigElement("/tmp"));
    }

    @Override
    protected Filter[] getServletFilters() {  //patch, delete, put ekka multipart form data wd krn oni nisa
        return new Filter[]{new FormContentFilter()};
    }
}
