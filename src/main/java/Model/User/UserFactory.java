package Model.User;

import Model.Candy.All;

import java.util.List;

public class UserFactory {
    public User createUser(String name, String login, String password, boolean ban, List<All> present) {
        if(name.equals("customer"))
            return new Customer(login,password, ban, present);
        else if(name.equals("administrator"))
            return new Administrator(login,password, ban, null);
        else return null;
    }
}
