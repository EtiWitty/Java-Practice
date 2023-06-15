package Factory;
// ============ Factory Design Pattern ============

// Factory.Product interface
public class Product {
  void doSomething() {
    System.out.println("Factory.Product does something.");
  };
}

// Concrete product class A
public class ConcreteProductA implements Product {
  public void doSomething() {
    System.out.println("Factory.Product A does something.");
  }
}

public class ConcreteProductB implements Product {
  public void doSomething() {
    System.out.println("product B does something");
  }
}

//Factory class
public class ProductFactory {
  public static Product createProduct(String type) {
    if(type.equals("A")) {
      return new ConcreteProductA();
    } else if (type.equals("B")) {
      return new ConcreteProductB();
    }
    return null;
  }
}

// Factory.Client code
public class Client {
  public static void main(String[] args) {
    Product productA = ProductFactory.createProduct("A");
    productA.doSomething(); // Output: Factory.Product A does something.

    Product productB = ProductFactory.createProduct("B");
    productB.doSomething(); // Output: Factory.Product B does something.
  }
}

