package Model.User;

import Model.Candy.All;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

public abstract class User implements Serializable {
    private String login;
    private String password;
    private boolean ban;
    private List<All> present;

    public User(String login, String password, boolean ban, List<All> present) {
        this.login = login;
        this.password = password;
        this.ban = ban;
        this.present = present;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isBan() {
        return ban;
    }

    public List<All> getPresent() {
        return present;
    }

    public void setPresent(List<All> present) {
        this.present = present;
    }

    public String getLogin() {
        return login;
    }

    public boolean getBan() {
        return ban;
    }

    public void setBan(boolean ban) {
        this.ban = ban;
    }

    public String getPassword() {
        return password;
    }

    public abstract User reviewMenu(User user) throws InterruptedException, IOException, ClassNotFoundException;

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", ban=" + ban +
                ", present=" + present +
                '}';
    }
}
