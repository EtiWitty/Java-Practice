package Observer;

import java.util.ArrayList;
import java.util.List;

// Subject interface
interface Subject {
  void attach(Observer observer);
  void detach(Observer observer);
  void notifyObservers();
}

// Concrete subject class
class ConcreteSubject implements Subject {
  private List<Observer> observers = new ArrayList<>();
  private int state;

  public int getState() {
    return state;
  }

  public void setState(int state) {
    this.state = state;
    notifyObservers();
  }

  public void attach(Observer observer) {
    observers.add(observer);
  }

  public void detach(Observer observer) {
    observers.remove(observer);
  }

  public void notifyObservers() {
    for (Observer observer : observers) {
      observer.update();
    }
  }
}

// Observer interface
interface Observer {
  void update();
}

// Concrete observer classes

// The ConcreteObserverA and ConcreteObserverB classes are concrete implementations of the Observer interface.
// They register themselves with the subject during construction and implement the update() method to define
// their specific behavior when notified.
class ConcreteObserverA implements Observer {
  private ConcreteSubject subject;

  public ConcreteObserverA(ConcreteSubject subject) {
    this.subject = subject;
    subject.attach(this);
  }

  public void update() {
    System.out.println("ConcreteObserverA received update. New state: " + subject.getState());
  }
}

class ConcreteObserverB implements Observer {
  private ConcreteSubject subject;

  public ConcreteObserverB(ConcreteSubject subject) {
    this.subject = subject;
    subject.attach(this);
  }

  public void update() {
    System.out.println("ConcreteObserverB received update. New state: " + subject.getState());
  }
}

// Usage example

// In the Main class, we create a ConcreteSubject instance and two observers (ConcreteObserverA and ConcreteObserverB).
// We attach the observers to the subject and then change the subject's state. As a result, both observers are notified
// and execute their update behavior. Finally, we detach one of the observers and change the state again to see that
// only the remaining observer receives the update notification.

class Main {
  public static void main(String[] args) {
    ConcreteSubject subject = new ConcreteSubject();

    ConcreteObserverA observerA = new ConcreteObserverA(subject);
    ConcreteObserverB observerB = new ConcreteObserverB(subject);

    subject.setState(5);
    subject.setState(10);

    subject.detach(observerA);

    subject.setState(15);
  }
}
