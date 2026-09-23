class BankAccount {
    private double balance;

    public void deposit(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Amount must be positive");
        balance += amount;
    }

    public double getBalance() {
        return balance;
    }
}

abstract class Shape {
    abstract double area();
}

class Circle extends Shape {
    double r;

    Circle(double r) {
        this.r = r;
    }

    double area() {
        return Math.PI * r * r;
    }
}

class Square extends Shape {
    double s;

    Square(double s) {
        this.s = s;
    }

    double area() {
        return s * s;
    }
}

public class Pillars {
    public static void main(String[] args) {
        Shape[] shapes = { new Circle(1), new Square(2) };
        for (Shape sh : shapes) {
            System.out.println(sh.area());
        }

        BankAccount acc = new BankAccount();
        acc.deposit(5000);
        System.out.println("Balance: " + acc.getBalance());
    }
}