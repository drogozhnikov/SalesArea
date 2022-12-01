package com.sales.appconfig;

import com.sales.repository.*;
import com.sales.service.*;
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
    public PositionDao getPositionDao(SessionFactory sessionFactory) {
        return new PositionDaoImpl(sessionFactory);
    }

    @Bean
    public PositionService getItemService(PositionDao positionDao, MessageService messageService) {
        return new PositionService(positionDao, messageService);
    }

    @Bean
    public ItemDao getItemDao(SessionFactory sessionFactory) {
        return new ItemDaoImpl(sessionFactory);
    }

    @Bean
    public ItemService getItemService(ItemDao itemDao, MessageService messageService) {
        return new ItemService(itemDao, messageService);
    }

    @Bean
    public CategoryDao getCategoryDao(SessionFactory sessionFactory) {
        return new CategoryDaoImpl(sessionFactory);
    }

    @Bean
    public CategoryService getCategoryService(CategoryDao categoryDao, MessageService messageService) {
        return new CategoryService(categoryDao, messageService);
    }

    @Bean
    public UserDao getUserDao(SessionFactory sessionFactory) {
        return new UserDaoImpl(sessionFactory);
    }

    @Bean
    public UserService getUserService(UserDao userDao, MessageService messageService) {
        return new UserService(userDao, messageService);
    }

    @Bean
    public CompanyDao getCompanyDao(SessionFactory sessionFactory) {
        return new CompanyDaoImpl(sessionFactory);
    }

    @Bean
    public CompanyService getCompanyService(CompanyDao companyDao, MessageService messageService) {
        return new CompanyService(companyDao, messageService);
    }


}
