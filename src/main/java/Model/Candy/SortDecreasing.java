package Model.Candy;

import java.util.Comparator;
import static Controller.Customer.MakeGiftController.all2;
import static Controller.Customer.MakeGiftController.all3;


public class SortDecreasing extends Thread {
    @Override
    public void run() {
        Comparator<All> byWeight = Comparator.comparing(All::getWeight).reversed();
        all2.sort(byWeight);
        all3.clear();
        all3.addAll(all2);
    }
}
