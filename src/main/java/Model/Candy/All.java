package Model.Candy;



import Model.User.User;
import javafx.collections.ObservableList;

import java.io.Serializable;
import java.util.*;

public abstract class All implements Serializable {
    protected String name;
    protected double weight;
    protected double AllWeightPresent;

    public abstract void addGift(int i, All all, User user);

    public abstract double choose(List<All> all, User user, int quantity, String name);

    public abstract ObservableList<All> view(List<All> all);

    public abstract void viewGift(User user);

    public abstract void changeCandyMenu(List<All> all, All candy, int num);

    public abstract List<All> present();

    public All() {
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public double getAllWeightPresent() {
        return AllWeightPresent;
    }

    public void setAllWeightPresent(double allWeightPresent) {
        AllWeightPresent = allWeightPresent;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }


    public abstract void delete(List<All> all, String name);

    public abstract int chooseNumber();

    @Override
    public String toString() {
        return "All{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }
}
