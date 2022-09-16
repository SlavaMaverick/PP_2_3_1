package web;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import web.config.AppConfig;
//import web.config.AppInit;
//import web.config.WebConfig;
import web.model.User;
import web.service.UserService;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        List<User> users = userService.getAllUsers();

        for (User user : users) {
            System.out.println("Id = "+user.getId());
            System.out.println("First Name = "+user.getFirstName());
            System.out.println("Last Name = "+user.getLastName());
            System.out.println("Age = "+user.getAge());
            System.out.println();
        }

        context.close();
    }
}

