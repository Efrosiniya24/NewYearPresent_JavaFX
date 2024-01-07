package Controller.Admin;

import Model.Candy.*;

public class FacadeAddMenu {

    public All addBiscuitMenu(String name, double weight) {
        All biscuit = new Biscuit();
        biscuit.setName(name);
        biscuit.setWeight(weight);
        return biscuit;
    }

    public All addChocolateMenu(String name, double weight) {
        All chocolate = new Chocolate();
        chocolate.setName(name);
        chocolate.setWeight(weight);
        return chocolate;
    }

    public All addMarshmallowMenu(String name, double weight) {
        All marshmallow = new Marshmallow();
        marshmallow.setName(name);
        marshmallow.setWeight(weight);
        return marshmallow;
    }

    public All addSweetMenu(String name, double weight) {
        All sweet = new Sweet();
        sweet.setName(name);
        sweet.setWeight(weight);
        return sweet;
    }
}
