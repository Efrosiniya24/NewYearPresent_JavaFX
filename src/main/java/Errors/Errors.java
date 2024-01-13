package Errors;

import Controller.Alerts;
import Model.Candy.All;
import Model.User.User;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Errors {
    public static boolean nameOfCandy(List<All> all, String name) {
        for (All candy : all)
            if (candy.getName().toLowerCase().equals(name))
                return true;
        Alerts.warningAlert("Таких сладостей нет(");
        return false;
    }

    public static boolean weight(String weight) {
        Pattern pattern = Pattern.compile("[0-9]");
        Matcher matcher = pattern.matcher(weight);
        if (!matcher.find()) {
            Alerts.warningAlert("Неправильно введена масса");
            return false;
        } else return true;
    }


    public static boolean weightMM(String min, String max) {
        Pattern pattern = Pattern.compile("[0-9]");
        Matcher matcher = pattern.matcher(min);
        Matcher matcher2 = pattern.matcher(max);

        if (!matcher.find() || !matcher2.find()) {
            Alerts.warningAlert("Неправильно введена масса");
            return false;
        } else return true;
    }

    public static boolean category(String category) {
        if (!category.equals("печенье") && !category.equals("шоколад") && !category.equals("зефир") && !category.equals("конфеты")) {
            Alerts.warningAlert("Такой категории нет. Будьте внимательны)");
            return false;
        } else return true;
    }

    public static boolean printPasswort(String newPasswordRepeat, String newPassword) {
        if (!newPasswordRepeat.equals(newPassword)) {
            Alerts.warningAlert("Повторный пароль был введен неверно. Повторите операции заново");
            return false;
        }
        return true;
    }

    public static boolean loginOfUser(List<User> users, String login) {
        for (User user : users)
            if (user.getLogin().equals(login))
                return true;
        Alerts.warningAlert("Пользователя с таким логином нет(");
        return false;
    }

    public static boolean quantity(String weight) {
        Pattern pattern = Pattern.compile("[А-Я][а-я]");
        Matcher matcher = pattern.matcher(weight);
        if (!matcher.matches()) {
            Alerts.warningAlert("Количество введено неверно");
            return false;
        } else return true;
    }

}
