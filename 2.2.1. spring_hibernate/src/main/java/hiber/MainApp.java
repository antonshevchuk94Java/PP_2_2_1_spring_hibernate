package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      userService.add(new User(new Car("Lada",99),
              "User1", "Lastname1", "user1@mail.ru"));
      userService.add(new User(new Car("Hyundai",99)
              ,"User2", "Lastname2", "user2@mail.ru"));
      userService.add(new User(new Car("Mercedes",200),
              "User3", "Lastname3", "user3@mail.ru"));
      userService.add(new User(new Car("BMW",6)
              ,"User4", "Lastname4", "user4@mail.ru"));
      userService.add(new User(new Car("BMW",6)
              ,"User5", "Lastname5", "user5@mail.ru"));

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println();
      }
      List<User> usersCar = userService.findUserByCar("BMW",6);
      for (User user : usersCar) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println();
      }
      userService.clearUsers();

      context.close();
         /* Не доконца понял задания...
         Вроде все 5 пунктов выполнил */

   }
}
