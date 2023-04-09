package stackandqueue;

import java.util.LinkedList;

// TODO: LinkedList 메서드 정리하기
public class StackAndQueue6 {
    /**
     * 동물 보호소 :
     * 먼저 들어온 동물이 먼저 나가는 동물 보호소가 있다. -> 순서만 정해주면 된다..
     * <p>
     * 이 보호소는 개와 고양이만 수용한다.
     * 보호소에서 가장 오래된 동물부터 입양 가능하다.
     * 개와 고양이 중에 선택할 수 있지만 특정 동물 지정해 갈 수는 없다.
     * enqueue, dequeueAny, dequeueDog, dequecat 사용
     * 기존의 linkedlist 사용해도 좋다.

     * 내풀이
     * 별거 아닌 문제인데
     * linkedList에 메서드가 너무 많다..
     * 뭐가 뭐인지 정리좀 하자
     */

    enum Type {
        DOG, CAT,
    }

    static class Animal {
        String name;
        int order;
        Type type;

        public Animal(String name, Type type) {
            this.name = name;
            this.type = type;
        }

        public void setOrder(int order) {
            this.order = order;
        }

        public int getOrder() {
            return order;
        }
    }

    static class Cat extends Animal {
        public Cat(String name) {
            super(name, Type.CAT);

        }
    }

    static class Dog extends Animal {
        public Dog(String name) {
            super(name, Type.DOG);
        }

    }

    private final LinkedList<Dog> dogs = new LinkedList<>();
    private final LinkedList<Cat> cats = new LinkedList<>();
    static int order = 0;

    void enqueue(Animal animal) {
        animal.setOrder(order++);
        if (animal instanceof Cat) {
            cats.addLast((Cat) animal);
        }
        if (animal instanceof Dog) {
            dogs.addLast((Dog) animal);
        }
    }

    Dog dequeueDog() {
        return dogs.removeFirst();
    }

    Cat dequeueCat() {
        return cats.removeFirst();
    }

    Animal dequeueAny() {
        if (dogs.isEmpty()) {
            return dequeueCat();
        }
        if (cats.isEmpty()) {
            return dequeueDog();
        }

        int dogOrder = dogs.getFirst().getOrder();
        int catOrder = cats.getFirst().getOrder();
        if (dogOrder >= catOrder) {
            return dogs.removeFirst();
        }
        return cats.removeFirst();
    }

    public static void main(String[] args) {
        Cat cat1 = new Cat("야옹1");
        Dog dog1 = new Dog("멍멍1");
        Cat cat2 = new Cat("야옹2");
        Dog dog2 = new Dog("멍멍2");
        Cat cat3 = new Cat("야옹3");
        Cat cat4 = new Cat("야옹4");
        Dog dog3 = new Dog("멍멍3");
        Dog dog4 = new Dog("멍멍4");

        StackAndQueue6 animalShelter = new StackAndQueue6();

        animalShelter.enqueue(cat1);
        animalShelter.enqueue(dog1);
        animalShelter.enqueue(cat2);
        animalShelter.enqueue(dog2);
        animalShelter.enqueue(cat3);
        animalShelter.enqueue(cat4);
        animalShelter.enqueue(dog3);
        animalShelter.enqueue(dog4);
    }

}
