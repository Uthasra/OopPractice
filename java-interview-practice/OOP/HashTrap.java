import java.util.*;
class Student {
 String id;
 Student(String id) { this.id = id; }
 @Override public boolean equals(Object o) {
 return o instanceof Student s && id.equals(s.id);
 }
 // hashCode() NOT overridden <-- the bug
}
public class HashTrap {
 public static void main(String[] args) {
 Map<Student, Integer> marks = new HashMap<>();
 marks.put(new Student("SC001"), 85);
 System.out.println(marks.get(new Student("SC001"))); // prints null !
 }
}
