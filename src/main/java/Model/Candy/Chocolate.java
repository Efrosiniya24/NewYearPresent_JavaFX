package Model.Candy;

import Model.User.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.Serializable;
import java.util.*;

public class Chocolate extends All implements Serializable {
    static List<All> chocolate = new ArrayList<>();
    public static List<All> chocolateGift = new ArrayList<>();

    public static List<All> getChocolate() {
        return chocolate;
    }

    @Override
    public ObservableList<All> view(List<All> all) {
        for (All alls : all)
            if (alls instanceof Biscuit)
                chocolate.add(alls);

        ObservableList<All> biscuitObservableList = FXCollections.observableArrayList(chocolate);
        return biscuitObservableList;
    }

    @Override
    public void changeCandyMenu(List<All> all, All chocolate, int num) {
        all.set(num, chocolate);
    }

    @Override
    public List<All> present() {
        return chocolate;
    }

    @Override
    public void addGift(int i, All all, User user) {
        if (chocolateGift.isEmpty()) {
            for (int u = 0; u < user.getPresent().size(); u++)
                if (user.getPresent().get(u) instanceof Chocolate)
                    chocolateGift.add(user.getPresent().get(u));
        }
        if (!chocolateGift.contains(all.getName())) {
            chocolateGift.add(all);
        }
    }

    @Override
    public void viewGift(User user) {
        List<String> name = new ArrayList<>();
        List<Double> allWeight = new ArrayList<>();
        chocolateGift.clear();
        int sizee = user.getPresent().size();
        for (int i = 0; i < sizee; i++) {
            if (user.getPresent().get(i) instanceof Chocolate)
                chocolateGift.add(user.getPresent().get(i));
        }
        int size = chocolateGift.size();
        if (size == 0)
            System.out.println("Шоколада нет");
        else {
            for (All all : chocolateGift) {
                if (!name.contains(all.getName())) {
                    name.add(all.getName());
                    allWeight.add(all.getAllWeightPresent());
                } else
                    for (int u = 0; u < name.size(); u++)
                        if (name.get(u).equals(all.getName()))
                            allWeight.set(u, (allWeight.get(u) + all.getWeight()));
            }
            chocolateGift.clear();
            for (int i = 0; i < name.size(); i++) {
                Chocolate chocolate = new Chocolate();
                chocolate.setName(name.get(i));
                chocolate.setWeight(allWeight.get(i));
                chocolateGift.add(chocolate);
            }
            System.out.println(chocolateGift);
        }
    }

    public static List<All> getChocolateGift() {
        return chocolateGift;
    }

    @Override
    public void delete(List<All> all, String name) {
        int u = 0;
        for (All alls : all)
            if (alls instanceof Chocolate) {
                if (alls.getName().toLowerCase().equals(name)) {
                    all.remove(alls);
                    return;
                }
                u++;
            }
    }

    @Override
    public int chooseNumber() {
        if (!chocolate.isEmpty()) {
            Scanner sc = new Scanner(System.in);
            int number = 0;
            while (true) {
                System.out.print("Введите номер печенья: ");
                try {
                    number = sc.nextInt();
                    if (number > chocolate.size())
                        System.out.println("Такого шоколада нет( Повторите ввод...");
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
    public double choose(List<All> all, User user, int quantity, String name) throws ArrayIndexOutOfBoundsException {
        double allWeihgt = 0;
        int j = -1;
        int i = 0;
        int size = all.size();
        for (i = 0; i < size; i++) {
            if (all.get(i) instanceof Chocolate) {
                j++;
                if (all.get(i).getName().equals(name))
                    break;
            }
        }
        if (j > -1) {
            addGift(i, all.get(i), user);
            allWeihgt += (quantity * all.get(i).getWeight());
            all.get(i).setAllWeightPresent(allWeihgt);
            return allWeihgt;
        }
        return 0;
    }

}
