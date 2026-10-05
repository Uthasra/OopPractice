interface Payable {
    double calculatePay();                        // implicitly public abstract
    default String currency() { return "LKR"; }   // Java 8+: default method
    static Payable zero() { return () -> 0; }     // Java 8+: static method
}

abstract class Employee {
    protected final String name;                  // can hold state
    Employee(String name) { this.name = name; }   // can have a constructor
    abstract double calculatePay();
    String describe() { return name + " earns " + calculatePay(); }
}

class Manager extends Employee implements Payable, Comparable<Manager> {
    Manager(String n) { super(n); }

    @Override
    public double calculatePay() { return 150_000; }

    @Override
    public int compareTo(Manager o) { return name.compareTo(o.name); }

    @Override
    public String describe() {                    // richer version using the default method
        return name + " earns " + calculatePay() + " " + currency();
    }
}

public class Demo {
    public static void main(String[] args) {
        Manager m = new Manager("Nimal");
        System.out.println(m.describe());              // Nimal earns 150000.0 LKR
        System.out.println(Payable.zero().calculatePay()); // 0.0
        System.out.println(Payable.zero().currency());     // LKR
    }
}