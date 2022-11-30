package com.sales.appconfig;

import com.sales.repository.UserDao;
import com.sales.repository.UserDaoImpl;
import com.sales.service.MessageService;
import com.sales.service.UserService;
import org.hibernate.SessionFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public MessageService getMessageService(MessageSource messageSource) {
        return new MessageService(messageSource);
    }

    @Bean
    public UserDao getUserDao(SessionFactory sessionFactory) {
        return new UserDaoImpl(sessionFactory);
    }

    @Bean
    public UserService getUserService(UserDao userDao, MessageService messageService) {
        return new UserService(userDao, messageService);
    }
}
