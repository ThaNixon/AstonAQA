package shinu;

public class Miska {
    private int food;

    public Miska (int food) {
        this.food = food;
    }

    public int addFood(int amount) {
        this.food  += amount;
        return food;
    }

    public boolean eatFood(int amount) {
        if (this.food >= amount) {
            this.food -= amount;
            return true;
        }
        else return false;
    }
}
