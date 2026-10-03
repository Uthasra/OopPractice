// Inheritance: Dog IS an Animal
class Animal { void eat() { System.out.println("eating"); } }
class Dog extends Animal { void bark() { System.out.println("woof"); } }
// Composition: Car HAS an Engine
interface Engine { void start(); }
class PetrolEngine implements Engine { public void start()
{ System.out.println("petrol engine on"); } }
class ElectricEngine implements Engine { public void start()
{ System.out.println("electric motor on"); } }
class Car {
 private final Engine engine;
 Car(Engine engine) { this.engine = engine; } // engine is passed in
 void drive() { engine.start(); }
}
new Car(new PetrolEngine()).drive();
new Car(new ElectricEngine()).drive(); // swapped without touching Car
