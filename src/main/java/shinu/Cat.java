package shinu;

public class Cat extends Animal {
    static int catCount;
    private int appetite;
    private boolean full;

    public Cat(String name, int appetite) {
        super(name, 200, 0);
        this.appetite = appetite;
        this.full = false;
        catCount++;
    }

    public void eat(Miska miska) {
        if (miska.eatFood(this.appetite)) {
            this.full = true;
            System.out.println("Кот поел!");
        } else  {
            System.out.println("Кот не поел и остался голодным!");
        }
    }

    public boolean isFull() {
        return this.full;
    }
}
