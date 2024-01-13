package Model.Candy;

import Controller.SerializatorAuthorization;
import Model.User.User;
import com.example.laba5.NewYearApplication;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.Serializable;
import java.util.*;

public class Biscuit extends All implements Serializable {
    static List<All> biscuit = new ArrayList<>();
    public static List<All> biscuitsGift = new ArrayList<>();
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
            System.out.println(biscuitsGift);
        }
        if (!(biscuitsGift.contains(all.getName()))) {
            biscuitsGift.add(all);
        }
    }

    @Override
    public void viewGift(User user) {
        List<String> name = new ArrayList<>();
        List<Double> allWeight = new ArrayList<>();
        biscuitsGift.clear();
        for (int i = 0; i < user.getPresent().size(); i++)
            if (user.getPresent().get(i) instanceof Biscuit)
                biscuitsGift.add(user.getPresent().get(i));
        int size = biscuitsGift.size();
        if (size == 0)
            System.out.println("Печенья нет");
        else {
            for (All all : biscuitsGift) {
                if (!name.contains(all.getName())) {
                    name.add(all.getName());
                    allWeight.add(all.getAllWeightPresent());
                } else
                    for (int u = 0; u < name.size(); u++)
                        if (name.get(u).equals(all.getName()))
                            allWeight.set(u, (allWeight.get(u) + all.getAllWeightPresent()));
            }
            biscuitsGift.clear();
            for(int i = 0; i < name.size(); i++) {
                Biscuit biscuit = new Biscuit();
                biscuit.setName(name.get(i));
                biscuit.setWeight(allWeight.get(i));
                biscuitsGift.add(biscuit);
            }
            System.out.println(biscuitsGift);
        }
    }
    public static List<All> getBiscuitsGift() {
        return biscuitsGift;
    }

    @Override
    public void delete(List<All> all, String name) {
        int u = 0;
        for (All alls : all)
            if (alls instanceof Biscuit) {
                if (alls.getName().toLowerCase().equals(name)) {
                    all.remove(alls);
                    return;
                }
                u++;
            }
    }

    @Override
    public double choose(List<All> all, User user, int quantity, String name) throws ArrayIndexOutOfBoundsException {
        double allWeihgt = 0;
        int j = -1;
        int i = 0;
        int size = all.size();
        for (; i < size; i++) {
            if (all.get(i) instanceof Biscuit) {
                j++;
                if(all.get(i).getName().equals(name))
                    break;
            }
        }
        if (j>-1) {
            addGift(i, all.get(i), user);
            allWeihgt += (quantity * all.get(i).getWeight());
            all.get(i).setAllWeightPresent(allWeihgt);
            return allWeihgt;
        }
        return 0;
    }

    public int chooseNumber() {
//        if (!biscuit.isEmpty()) {
//            Scanner sc = new Scanner(System.in);
//            while (true) {
//                System.out.print("Введите номер печенья: ");
//                try {
//                    number = sc.nextInt();
//                    if (number > biscuit.size())
//                        System.out.println("Такого печенья нет( Повторите ввод...");
//                    else break;
//                } catch (InputMismatchException e) {
//                    System.out.print("Ошибка ввода( Повторите ввод: ");
//                }
//                sc.nextLine();
//            }
//            return number - 1;
//        }
        return -1;
    }

}



