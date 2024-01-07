package Model.User;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class IteratorUser<User> implements Iterator<User> {
    private List<User> users;
    private int position;

    public IteratorUser(List<User> users, int position) {
        this.users = users;
        this.position = position;
    }

    @Override
    public boolean hasNext() {
        return position < users.size();
    }

    @Override
    public User next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return users.get(position++);
    }
}

