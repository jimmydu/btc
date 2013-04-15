package com.btc.sys;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.theme.ThemeChangeInterceptor;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.btc.sys.interceptor.SecurityInterceptor;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.btc")
public class MvcConfig extends WebMvcConfigurerAdapter {

	
	@Bean
	public InternalResourceViewResolver configInternalResourceViewResolver() {
		System.out.println(InternalResourceViewResolver.class.getName());
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	@Override
	  public void addInterceptors(InterceptorRegistry registry) {
	    registry.addInterceptor(new LocaleChangeInterceptor());
	    registry.addInterceptor(new ThemeChangeInterceptor()).addPathPatterns("/**").excludePathPatterns("/admin/**");
	    registry.addInterceptor(new SecurityInterceptor()).addPathPatterns("/*");
	 }
	
	@Override  
	  public void addResourceHandlers(ResourceHandlerRegistry registry) {  
	    registry.addResourceHandler("/js/**").addResourceLocations("/js/");  
	  }  
}
