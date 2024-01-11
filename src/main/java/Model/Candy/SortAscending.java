package Model.Candy;


import static Controller.Customer.MakeGiftController.all2;
import java.util.Comparator;


public class SortAscending implements Runnable {
    public Thread threadSort;
    public SortAscending(){
        threadSort = new Thread(this);
        threadSort.start();
    }
    @Override
    public void run() {
        Comparator<All> byWeight = Comparator.comparing(All::getWeight);
        all2.sort(byWeight);
    }
}
