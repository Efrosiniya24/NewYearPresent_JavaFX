package Model.Candy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static Controller.Customer.MakeGiftController.all2;

public class Filter {
    private double max;
    private double min;
    private String name;
    public Filter(String name) {
        this.name = name;
    }

    public Filter(double max, double min) {
        this.max = max;
        this.min = min;
    }

    public List<All> filterByWeight() {
        all2 = (List<All>) all2.stream()
                .filter(all -> (all.getWeight() >= this.min))
                .filter(all -> all.getWeight() <= this.max)
                .collect(Collectors.toList());
        return all2;
    }

    public List<All> filterByWord() {
        all2 = (List<All>) all2.stream()
                .filter(all -> (all.getName().contains(name.substring(0, 4))))
                .collect(Collectors.toList());
        return all2;
    }

}

