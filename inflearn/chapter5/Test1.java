class Test1 {
    public static void main(String[] args) {
        FireEngine fireEngine = new FireEngine();
        System.out.println(fireEngine instanceof Car);
        Car car = new Car();
        System.out.println(car instanceof FireEngine);
        System.out.println(car instanceof Car);
        System.out.println(car instanceof Object);
        System.out.println(fireEngine instanceof FireEngine);
        System.out.println(fireEngine instanceof Car);
        System.out.println(fireEngine instanceof Object);
    }
}

class Car { }

class FireEngine extends Car {
}