interface Trainable {
    void performTrick();
}

abstract class Pet {
    String name;
    int age;

    Pet(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void displayInfo() {
        System.out.println("Pet Name: " + name + ", Age: " + age);
    }

    abstract void makeSound();
}

class Dog extends Pet implements Trainable {
    Dog(String name, int age) {
        super(name, age);
    }

    void makeSound() {
        System.out.println(name + " says: Woof! Woof!");
    }

    public void performTrick() {
        System.out.println("Training " + name + ": Sits and shakes hands");
    }
}

class Cat extends Pet {
    Cat(String name, int age) {
        super(name, age);
    }

    void makeSound() {
        System.out.println(name + " says: Meow! Meow!");
    }
}

class Bird extends Pet implements Trainable {
    Bird(String name, int age) {
        super(name, age);
    }

    void makeSound() {
        System.out.println(name + " says: Tweet! Tweet!");
    }

    public void performTrick() {
        System.out.println("Training " + name + ": Flies in circles and lands on perch");
    }
}