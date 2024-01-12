package Model.Candy;

import java.io.Serializable;
import java.util.*;

import Model.User.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Sweet extends All implements Serializable {
    static List<All> sweet = new ArrayList<>();
    public static List<All> sweetGift = new ArrayList<>();
    static boolean b = true;


    @Override
    public ObservableList<All> view(List<All> all) {
        for (All alls : all)
            if (alls instanceof Biscuit)
                sweet.add(alls);

        ObservableList<All> biscuitObservableList = FXCollections.observableArrayList(sweet);
        return biscuitObservableList;
    }

    @Override
    public void addGift(int i, All all, User user) {
        if (sweetGift.isEmpty()) {
            for (int u = 0; u < user.getPresent().size(); u++) {
                b = false;
                if (user.getPresent().get(u) instanceof Sweet) {
                    sweetGift.add(user.getPresent().get(u));
                }
            }
        }
        if (!sweetGift.contains(all.getName())) {
            sweetGift.add(all);
        }
    }

    @Override
    public void changeCandyMenu(List<All> all, All sweet, int num) {
        all.set(num, sweet);
    }

    @Override
    public List<All> present() {
        return sweet;
    }

    @Override
    public void viewGift(User user) {
        List<String> name = new ArrayList<>();
        List<Double> allWeight = new ArrayList<>();
        sweetGift.clear();
        for (int i = 0; i < user.getPresent().size(); i++) {
            if (user.getPresent().get(i) instanceof Sweet)
                sweetGift.add(user.getPresent().get(i));
        }
        int size = sweetGift.size();
        if (size == 0)
            System.out.println("Печенья нет");
        else {
            for (All all : sweetGift) {
                if (!name.contains(all.getName())) {
                    name.add(all.getName());
                    allWeight.add(all.getAllWeightPresent());
                } else
                    for (int u = 0; u < name.size(); u++)
                        if (name.get(u).equals(all.getName()))
                            allWeight.set(u, (allWeight.get(u) + all.getAllWeightPresent()));
            }
            sweetGift.clear();
            for (int i = 0; i < name.size(); i++) {
                Sweet sweet = new Sweet();
                sweet.setName(name.get(i));
                sweet.setWeight(allWeight.get(i));
                sweetGift.add(sweet);
            }
            System.out.println(sweetGift);
        }
    }

    public static List<All> getSweetGift() {
        return sweetGift;
    }

    @Override
    public void delete(List<All> all, String name) {
        int size = all.size();
        for (int u = 0; u < size; u++) {
            if (all.get(u) instanceof Sweet) {
                if (all.get(u).getName().toLowerCase().equals(name)) {
                    all.remove(all.get(u));
                    return;
                }
            }
        }
    }

    @Override
    public int chooseNumber() {
        if (!sweet.isEmpty()) {
            Scanner sc = new Scanner(System.in);
            int number;
            while (true) {
                System.out.print("Введите номер печенья: ");
                try {
                    number = sc.nextInt();
                    if (number > sweet.size())
                        System.out.println("Таких конфет нет( Повторите ввод...");
                    else break;
                } catch (InputMismatchException e) {
                    System.out.print("Ошибка ввода( Повторите ввод: ");
                }
                sc.nextLine();
            }
            return number - 1;
        }
        System.out.println("Корзина пустая");
        return -1;
    }

    @Override
    public double choose(List<All> all, User user, int quantity, String name) throws ArrayIndexOutOfBoundsException {
        double allWeihgt = 0;
        int j = -1;
        int i = 0;
        int size = all.size();
        for (i = 0; i < size; i++) {
            if (all.get(i) instanceof Sweet) {
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
}
