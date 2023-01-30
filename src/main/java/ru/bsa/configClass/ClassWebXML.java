package ru.bsa.configClass;

import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;


public class ClassWebXML extends AbstractAnnotationConfigDispatcherServletInitializer {                       // web.xml

    // позволяет запускать контекст приложения сервлета, а также контекст корневого приложения,
    // ClassConfig класс используются для настройки компонентов в корневой и контекстной области сервлета
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {ClassConfig.class};                                              // class with configuration
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }


    /* Фильтры являются частью веб-сервера, а не Spring framework.Для входящих запросов мы можем использовать
     фильтры для манипулирования и даже блокировать доступ запросов к любому сервлету. И наоборот, мы также
     можем блокировать получение ответов от клиента. */
    @Override
    public void onStartup(ServletContext aServletContext) throws ServletException {
        super.onStartup(aServletContext);
        registerHiddenFieldFilter(aServletContext);
    }

    private void registerHiddenFieldFilter(ServletContext aContext) {
        aContext.addFilter("hiddenHttpMethodFilter",
                new HiddenHttpMethodFilter()).addMappingForUrlPatterns(null ,true, "/*");
    }

}
