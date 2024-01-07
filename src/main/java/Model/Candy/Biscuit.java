package Model.Candy;

import Model.User.User;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Biscuit extends All implements Serializable {
    static List<All> biscuit = new ArrayList<>();
    static List<All> biscuitsGift = new ArrayList<>();
    static boolean b = true;

    public static List<All> getBiscuit() {
        return biscuit;
    }

    @Override
    public ObservableList<All> view(List<All> all) {
        for (All alls : all)
            if (alls instanceof Biscuit)
                biscuit.add(alls);

        ObservableList<All> biscuitObservableList = FXCollections.observableArrayList(biscuit);
       return biscuitObservableList;

//        int i = 1;
//        for (All alls : all)
//            if (alls instanceof Biscuit) {
//                System.out.println((i) + ") " + alls.getName() + " вес: " + alls.getWeight());
//                biscuit.add(alls);
//                i++;
//            }
//        if (i == 1) {
//            System.out.println("Печенья нет");
//            return false;
//        } else return true;
    }

    @Override
    public void changeCandyMenu(List<All> all, All biscuit, int num) {
        all.set(num, biscuit);
    }

    @Override
    public List<All> present() {
        return biscuit;
    }

    @Override
    public void addGift(int i, All all, User user) {
        if (biscuitsGift.isEmpty()) {
            for (int u = 0; u < user.getPresent().size(); u++) {
                b = false;
                if (user.getPresent().get(u) instanceof Biscuit) {
                    biscuitsGift.add(user.getPresent().get(u));
                }
            }
        }
        if (!(biscuitsGift.contains(all.getName()))) {
            biscuitsGift.add(all);
        }
    }

    @Override
    public void viewGift(User user) {
        List<String> name = new ArrayList<>();
        List<Double> allWeight = new ArrayList<>();
        System.out.println("\n___Печенье___: ");
        biscuitsGift.clear();
        for (int i = 0; i < user.getPresent().size(); i++) {
            if (user.getPresent().get(i) instanceof Biscuit)
                biscuitsGift.add(user.getPresent().get(i));
        }
        int size = biscuitsGift.size();
        if (size == 0)
            System.out.println("Печенья нет");
        else {
            for (int i = 0; i < biscuitsGift.size(); i++) {
                if (!name.contains(biscuitsGift.get(i).getName())) {
                    name.add(biscuitsGift.get(i).getName());
                    allWeight.add(biscuitsGift.get(i).getAllWeightPresent());
                } else {
                    for (int u = 0; u < name.size(); u++) {
                        if (name.get(u).equals(biscuitsGift.get(i).getName())) {
                            allWeight.set(u, (allWeight.get(u) + biscuitsGift.get(i).getAllWeightPresent()));
                        }
                    }
                }
            }
            for (int i = 0; i < name.size(); i++)
                System.out.println((i + 1) + ") " + name.get(i) + " " + allWeight.get(i) + "г");
        }
    }

    @Override
    public void delete(List<All> all, int i) {
        int u = 0;
        for (All alls : all)
            if (alls instanceof Biscuit) {
                if (u == i) {
                    all.remove(alls);
                    break;
                }
                u++;
            }
    }

    @Override
    public double choose(List<All> all, User user) throws ArrayIndexOutOfBoundsException {
        Scanner sc = new Scanner(System.in);
        int operation;
        int amount;
        double allWeihgt = 0;
//        boolean t = view(all);
//        if (t) {
//            while (true) {
//                System.out.print("Номер печенья: ");
//                while (true) {
//                    try {
//                        operation = sc.nextInt();
//                        break;
//                    } catch (ArrayIndexOutOfBoundsException | InputMismatchException e) {
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
//                addGift(operation, biscuit.get(operation - 1), user);
//                allWeihgt += (amount * biscuit.get(operation - 1).getWeight());
//                biscuit.get(operation - 1).setAllWeightPresent(allWeihgt);
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

    public int chooseNumber() {
        if (!biscuit.isEmpty()) {
            Scanner sc = new Scanner(System.in);
            int number;
            while (true) {
                System.out.print("Введите номер печенья: ");
                try {
                    number = sc.nextInt();
                    if (number > biscuit.size())
                        System.out.println("Такого печенья нет( Повторите ввод...");
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

}



