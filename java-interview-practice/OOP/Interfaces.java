interface Payable {
 double calculatePay(); // abstract by default
 default String currency() { return "LKR"; } // Java 8+: default method
 static Payable zero() { return () -> 0; } // Java 8+: static method
}
abstract class Employee {
 protected final String name; // can hold state
 Employee(String name) { this.name = name; } // can have a constructor
 abstract double calculatePay();
 String describe() { return name + " earns " + calculatePay(); } // shared code
}
class Manager extends Employee implements Payable, Comparable<Manager> {
 Manager(String n) { super(n); }
 public double calculatePay() { return 150_000; }
 public int compareTo(Manager o) { return name.compareTo(o.name); }
