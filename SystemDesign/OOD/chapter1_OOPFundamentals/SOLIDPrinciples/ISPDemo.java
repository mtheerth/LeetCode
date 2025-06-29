interface Workable {
    void work();
}

interface Eatable {
    void eat();
}

class Human implements Workable, Eatable {
    public void work() {
        System.out.println("Human is working");
    }

    public void eat() {
        System.out.println("Human is eating");
    }
}

class Robot implements Workable {
    public void work() {
        System.out.println("Robot is working");
    }
}

public class ISPDemo {
    public static void main(String[] args) {
        Workable human = new Human();
        human.work();

        Eatable humanEat = new Human();
        humanEat.eat();

        Workable robot = new Robot();
        robot.work();
    }
}

