package Model.Candy;

import Model.User.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.Serializable;
import java.util.*;

public class Marshmallow extends All implements Serializable {
    static List<All> marshmallow = new ArrayList<>();
    public static List<All> marshmallowGift = new ArrayList<>();
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
        marshmallowGift.clear();
        for (int i = 0; i < user.getPresent().size(); i++) {
            if (user.getPresent().get(i) instanceof Marshmallow)
                marshmallowGift.add(user.getPresent().get(i));
        }
        int size = marshmallowGift.size();
        if (size == 0)
            System.out.println("Печенья нет");
        else {
            for (All all : marshmallowGift) {
                if (!name.contains(all.getName())) {
                    name.add(all.getName());
                    allWeight.add(all.getAllWeightPresent());
                } else
                    for (int u = 0; u < name.size(); u++)
                        if (name.get(u).equals(all.getName()))
                            allWeight.set(u, (allWeight.get(u) + all.getAllWeightPresent()));
            }
            marshmallowGift.clear();
            for (int i = 0; i < name.size(); i++) {
                Marshmallow marshmallow = new Marshmallow();
                marshmallow.setName(name.get(i));
                marshmallow.setWeight(allWeight.get(i));
                marshmallowGift.add(marshmallow);
            }
            System.out.println(marshmallowGift);
        }
    }

    public static List<All> getMarshmallowGift() {
        return marshmallowGift;
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
    public double choose(List<All> all, User user, int quantity, String name) throws ArrayIndexOutOfBoundsException {
        double allWeihgt = 0;
        int j = -1;
        int i = 0;
        int size = all.size();
        for (i = 0; i < size; i++) {
            if (all.get(i) instanceof Marshmallow) {
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
