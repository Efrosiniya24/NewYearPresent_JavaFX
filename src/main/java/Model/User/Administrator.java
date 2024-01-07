package Model.User;

import Model.Candy.All;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Administrator extends User {

    public Administrator(String login, String password, boolean ban, List<All> present) {
        super(login, password, ban, present);
    }

    @Override
    public User reviewMenu(User user) throws IOException, ClassNotFoundException {
        Scanner sc = new Scanner(System.in);
        int operation = 0;
        while (true) {
            System.out.println("""
                    Меню:
                    1)Добавить сладости в меню
                    2)Удалить сладости из меню
                    3)Изменить данные в меню
                    4)Изменить данные о пользователе
                    5)Удалить пользователя
                    6)Блоктровать пользователей
                    7)Выход из функционала администратора""");
            try {
                operation = sc.nextInt();
            } catch (InputMismatchException e) {
                sc.next();
            }
//
        }
    }
}
