package org.cornell.fieldmonitor.config;

import org.cornell.fieldmonitor.common.JacksonObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.List;


@Slf4j
@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {
    /**
     *
     * set static resource mapping
     *
     */
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        log.info("start mapping...");
        registry.addResourceHandler("/demo1/**").addResourceLocations("classpath:/demo1/");
        //registry.addResourceHandler("/front/**").addResourceLocations("classpath:/front/");
    }


    /**
     * expand MVC msg converter
     * @param converters
     */
    @Override
    protected void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        //new message converter
        MappingJackson2HttpMessageConverter messageConverter = new MappingJackson2HttpMessageConverter();
        //set object converter, use Jackson make java to json
        messageConverter.setObjectMapper(new JacksonObjectMapper());
        //put into container of converter collection
        converters.add(0,messageConverter);
    }
}
