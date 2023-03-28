import java.util.LinkedList;

/**
 *  학습한 것:
 *  개와 고양이만 분양하는 분양소가 있다.
 *  분양 받은 사람은 동물의 한 종류만 고를 수 있고,
 *  분양소에서 가장 오래있은 순서대로 자동으로 분양될 동물이 정해지는 클래스를 구현하시오.
 *  (단, 자바에서 제공하는 LinkedList로 구현하시오)

 *  학습한 것 : add와 addLast는 반환타입만 다를뿐 동일하게 작동한다.
 *  offer와 add또한 동일한 동작을 한다.
 *  poll()과 pop()의 차이또한 exception을 리턴하냐 안하냐의 차이. pop()은 exception을, poll()은 null을 리턴한다.
 */
enum AnimalType {
    DOG, CAT,
}

abstract class Animal {
    AnimalType type;
    String name;
    int order;

    public Animal(AnimalType type, String name) {
        this.type = type;
        this.name = name;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getOrder() {
        return order;
    }

    public String info() {
        return order + ") type: " + type + ", name: " + name;
    }
}

class Dog extends Animal {
    public Dog(String name) {
        super(AnimalType.DOG, name);
    }
}

class Cat extends Animal {
    public Cat(String name) {
        super(AnimalType.CAT, name);
    }
}

class AnimalShelter {
    LinkedList<Dog> dogs = new LinkedList<>();
    LinkedList<Cat> cats = new LinkedList<>();

    int order;

    public AnimalShelter() {
        order = 1;
    }

    void enqueue(Animal animal) {
        animal.setOrder(order);
        order++;
        if (animal.type == AnimalType.DOG) {
            dogs.addLast((Dog) animal);
        } else if (animal.type == AnimalType.CAT){
            cats.addLast((Cat) animal);
        }
    }

    Animal dequeueDog() {
        return dogs.poll();
    }

    Animal dequeueCat() {
        return cats.poll();
    }
    Animal dequeue() {
        if (dogs.size() == 0 && cats.size() == 0) {
            return null;
        } else if (dogs.size() == 0) {
            return cats.poll();
        } else if (cats.size() == 0) {
            return dogs.poll();
        }

        // 둘다 있는 경우
        Animal dog = dogs.peek();
        Animal cat = cats.peek();
        // 오래 있던거 먼저 나가게 (order가 낮은것이 먼저 나가게)
        if (cat.order < dog.order) {
            return cats.poll();
        } else {
            return dogs.poll();
        }
    }
}
public class QueueUsingLinkedList {
    public static void main(String[] args) {
        Dog dog1 = new Dog("puppy");
        Dog dog2 = new Dog("jaja");
        Dog dog3 = new Dog("haha");

        Cat cat1 = new Cat("caca");
        Cat cat2 = new Cat("mumu");
        Cat cat3 = new Cat("gigi");

        AnimalShelter shelter = new AnimalShelter();
        shelter.enqueue(dog1);
        shelter.enqueue(cat1);
        shelter.enqueue(dog2);
        shelter.enqueue(cat2);
        shelter.enqueue(dog3);
        shelter.enqueue(cat3);

        System.out.println(shelter.dequeueCat().info());
        System.out.println(shelter.dequeueDog().info());
        System.out.println(shelter.dequeue().info());
        System.out.println(shelter.dequeue().info());
        System.out.println(shelter.dequeue().info());
        System.out.println(shelter.dequeue().info());
    }


}
