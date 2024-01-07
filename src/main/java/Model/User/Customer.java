package Model.User;



import Model.Candy.All;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class Customer extends User {
    public Customer(String login, String password, boolean ban, List<All> present) {
        super(login, password, ban, present);
    }

    @Override
    public User reviewMenu(User user) throws InterruptedException, IOException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        int operation = 0;
        while (true) {
            System.out.println("""
                    Меню:
                     1)Собрать подарок
                     2)Посмотреть вес подарка
                     3)Посмотреть новорогодний подарок
                     4)Выход""");
            try {
                operation = sc.nextInt();
            } catch (InputMismatchException e) {
                sc.next();
            }
//            Candy candy = new Candy();
//
//            switch (operation) {
//                case 1 -> user = candy.makeGift(user);
//                case 2 -> candy.count(user);
//                case 3 -> candy.view(user);
//                case 4 -> {
//                    return user;
//                }
//            }
//        }
//    }

        }
    }
}