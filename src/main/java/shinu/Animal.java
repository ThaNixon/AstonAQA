package shinu;

public abstract class Animal {
    private  String name;
    private int runLimit;
    private int swimLimit;

    static int totalCount;

    public Animal(String name,
                  int runLimit,
                  int swimLimit)
    {
        this.name = name;
        this.runLimit = runLimit;
        this.swimLimit = swimLimit;
        totalCount++;
    }

    void run(int x){
        if (x <= runLimit)
            System.out.println(this.name + " пробежал " + x + "м.");
        else
            System.out.println(this.name + " не смог пробежать");
    }

    void swim(int x) {
        if (swimLimit == 0)
            System.out.println(this.name + " не умеет плавать");
        else if (x <= swimLimit) {
            System.out.println(this.name + " Проплыл дистанцию " + x);
        } else System.out.println(this.name + " не смог проплыть");
    }

    public String getName() {
        return name;
    }
}
