package shinu;

public class Main {
    public static void main(String[] args) {
        Miska miska = new Miska(20);

        Cat barsik = new Cat("Барсик", 15);
        Cat murzik = new Cat("Мурзик", 10);
        Cat balbesik = new Cat("Балбесик", 5);

        Cat[] cats = {barsik, murzik, balbesik};
        for (Cat cat : cats) {
            cat.eat(miska);
        }

        System.out.println("\n--- Отчет о сытости ---");
        for (Cat cat : cats) {
            System.out.println(cat.getName() + " сытость: " + (cat.isFull() ? "Сыт" : "Голоден"));
        }

        System.out.println("\n--- Отчет о тренировках ---");

        Dog bobik = new Dog("Бобик");
        Dog sharik = new Dog("Шарик");
        Dog tarelkin = new Dog("Тарелкин");

        barsik.run(100); barsik.swim(30);
        System.out.println("--------------------");
        murzik.run(0);  murzik.swim(30);
        System.out.println("--------------------");
        balbesik.run(250);  balbesik.swim(30);
        System.out.println("--------------------");

        bobik.run(300);   bobik.swim(30);
        System.out.println("--------------------");
        tarelkin.run(600);  tarelkin.swim(10);
        System.out.println("--------------------");
        sharik.run(50);   sharik.swim(0);
        System.out.println("--------------------");

        System.out.println("Всего животных: " + Animal.totalCount);
        System.out.println("Всего кошек: " +  Cat.catCount);
        System.out.println("Всего псов: " +  Dog.dogCount);
        }
    }