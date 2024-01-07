package Model.Candy;

import Model.User.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Marshmallow extends All implements Serializable {
    static List<All> marshmallow = new ArrayList<>();
    static List<All> marshmallowGift = new ArrayList<>();
    static boolean b = true;

    @Override
    public ObservableList<All> view(List<All> all) {
        for (All alls : all)
            if (alls instanceof Biscuit)
                marshmallow.add(alls);

        ObservableList<All> biscuitObservableList = FXCollections.observableArrayList(marshmallow);
        return biscuitObservableList;
    }

    @Override
    public void addGift(int i, All all, User user) {
        if(marshmallowGift.isEmpty()) {
            for (int u = 0; u < user.getPresent().size(); u++) {
                b =  false;
                if (user.getPresent().get(u) instanceof Biscuit) {
                    marshmallowGift.add(user.getPresent().get(u));
                }
            }
        }
        if (!marshmallowGift.contains(all.getName())) {
            marshmallowGift.add(all);
        }
    }

    @Override
    public void changeCandyMenu(List<All> all, All marshmallow, int num) {
        all.set(num, marshmallow);
    }

    @Override
    public List<All> present() {
        return marshmallow;
    }

    @Override
    public void viewGift(User user) {
        List<String> name = new ArrayList<>();
        List<Double> allWeight = new ArrayList<>();
        System.out.println("\n___Зефир___: ");
        marshmallowGift.clear();
        for (int i = 0; i < user.getPresent().size(); i++) {
            if (user.getPresent().get(i) instanceof Marshmallow)
                marshmallowGift.add(user.getPresent().get(i));
        }
        if (marshmallowGift.isEmpty())
            System.out.println("Зефира нет");
        else {
            for(int i = 0; i <marshmallowGift.size(); i++){
                if(!name.contains(marshmallowGift.get(i).getName())) {
                    name.add(marshmallowGift.get(i).getName());
                    allWeight.add(marshmallowGift.get(i).getAllWeightPresent());
                }
                else
                {
                    for(int u = 0; u<name.size();u++){
                        if(name.get(u).equals(marshmallowGift.get(i).getName())){
                            allWeight.set(u, (allWeight.get(u)+marshmallowGift.get(i).getAllWeightPresent()));
                        }
                    }
                }
            }
            for (int i = 0; i < name.size(); i++)
                System.out.println((i + 1) + ") " + name.get(i) + " " + allWeight.get(i) + "г");    }
    }

    @Override
    public void delete(List<All> all, String name) {
        int u = 0;
        for (All alls : all)
            if (alls instanceof Marshmallow) {
                if (alls.getName().toLowerCase().equals(name)) {
                    all.remove(alls);
                    return;
                }
                u++;
            }
    }

    @Override
    public int chooseNumber() {
        if (!marshmallow.isEmpty()) {
            Scanner sc = new Scanner(System.in);
            int number;
            while (true) {
                System.out.print("Введите номер зефира: ");
                try {
                    number = sc.nextInt();
                    if (number > marshmallow.size())
                        System.out.println("Такого зефира нет( Повторите ввод...");
                    else break;
                } catch (InputMismatchException e) {
                    System.out.print("Ошибка ввода( Повторите ввод: ");
                }
                sc.nextLine();
            }
            return number - 1;
        }
        return -1;
    }

    @Override
    public double choose(List<All> all, User user) {
        Scanner sc = new Scanner(System.in);
        int operation;
        int amount;
        double allWeihgt = 0;
//        boolean t = view(all);
//        if (t) {
//            while (true) {
//                System.out.print("Номер зефира: ");
//                while (true) {
//                    try {
//                        operation = sc.nextInt();
//                        break;
//                    } catch (InputMismatchException e) {
//                        System.out.println("Повторите ввод");
//                        sc.next();
//                    }
//                }
//
//                System.out.println("Укажите количество: ");
//
//                while (true) {
//                    try {
//                        amount = sc.nextInt();
//                        break;
//                    } catch (InputMismatchException e) {
//                        System.out.println("Повторите ввод");
//                        sc.next();
//                    }
//                }
//
//                addGift(operation, marshmallow.get(operation - 1), user);
//                allWeihgt += (amount * marshmallow.get(operation - 1).getWeight());
//                marshmallow.get(operation - 1).setAllWeightPresent(allWeihgt);
//                System.out.println("Продолжить?\n 1)Да\n 2)Нет");
//
//                while (true) {
//                    try {
//                        operation = sc.nextInt();
//                        if (operation == 2)
//                            return allWeihgt;
//                        else break;
//                    } catch (InputMismatchException e) {
//                        System.out.print("Повторите ввод: ");
//                    }
//                }
//            }
//        }
        return 0;
    }


}
