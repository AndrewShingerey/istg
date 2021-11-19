package com.istg.config;

import com.istg.dao.Interface.*;
import com.istg.dao.implementations.*;
import com.istg.service.implementations.*;
import com.istg.service.interfaces.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.sql.DataSource;

@Configuration
public class AppConfig extends WebMvcConfigurerAdapter {
    @Value("${upload_image.path}")
    private String uploadPath;
    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:postgresql://ec2-54-195-195-81.eu-west-1.compute.amazonaws.com:5432/d9i69tcca9157l");
        dataSource.setUsername("fsllsyiimakfjp");
        dataSource.setPassword("76a5ed592286547acd238b38e3c604a4b69f8d4bec9eee6eae367e85a39f7f6f");
        dataSource.setDriverClassName("org.postgresql.Driver");
        return dataSource;
    }

    @Bean
    public TableGamesDao getTableGamesDaoImpl(){
        return new TableGameDaoImpl(getDataSource());
    }

    @Bean
    public TableGameService getTableGameServiceImpl(){
        return new TableGameSericeImpl();
    }

    @Bean
    public UserDao getUserDaoImpl(){
        return new UserDaoImpl(getDataSource());
    }

    @Bean
    public UserService getUserServiceImpl(){
        return new UserServiceImpl();
    }

    @Bean
    public CardProductDao getCardProductDaoImpl(){
        return new CardProductDaoImpl(getDataSource());
    }

    @Bean
    public CardProductService getCardProductServiceImpl(){
        return new CardProductServiceImpl();
    }

    @Bean
    public FeedBackDao getFeedBackDaoImpl(){
        return new FeedBackDaoImpl(getDataSource());
    }

    @Bean
    public FeedBackService getFeedBackServiceImpl(){
        return new FeedBackServiceImpl();
    }

    @Bean
    public ContactUsDao getContactUsDaoImpl(){
        return new ContactUsDaoImpl(getDataSource());
    }

    @Bean
    public ContactUsService getContactUsServiceImpl(){
        return new ContactUsServiceImpl();
    }

    @Bean
    public CheckoutOrderDao getCheckoutOrderDaoImpl(){
        return new CheckoutOrderDaoImpl(getDataSource());
    }

    @Bean
    public CheckoutOrderService getCheckoutOrderServiceImpl(){
        return new CheckoutOrderServiceImpl();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/img/**")
                .addResourceLocations("file:///" + uploadPath + "/");
    }

}