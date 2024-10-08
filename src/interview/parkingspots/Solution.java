package interview.parkingspots;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Solution {

    public static List<String> parkingSystem(
            int n, List<List<String>> instructions) {

        Lot lot = new Lot(n);

        List<String> result = new ArrayList<>();

        for (List<String> instr : instructions) {
            String op = instr.get(0);
            switch (op) {
                case "park" :
                    lot.parkCar(Integer.parseInt(instr.get(1)),
                            new Car(instr.get(2), instr.get(3), instr.get(4)));
                    break;
                case "remove" :
                    lot.removeCar(Integer.parseInt(instr.get(1)));
                    break;
                case "print" :
                    result.add(lot.printCar(Integer.parseInt(instr.get(1))));
                    break;
                case "print_free_spots" :
                    result.add(String.valueOf(lot.printFreeSpots()));
                    break;
            }

        }

        return result;
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    public static class Car {

        private String size;
        private String color;
        private String brand;

        public Car(String size, String color, String brand) {
            this.size = size;
            this.color = color;
            this.brand = brand;
        }

        @Override
        public String toString() {
            return size + " " + color + " " + brand;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Car car = (Car) o;
            return Objects.equals(size, car.size) &&
                    Objects.equals(color, car.color) &&
                    Objects.equals(brand, car.brand);
        }

        @Override
        public int hashCode() {
            return Objects.hash(size, color, brand);
        }
    }

    public static class Lot {

        private Car[] arr;
        private int freeSpots;

        public Lot(int size) {
            arr = new Car[size];
            freeSpots = size;
        }

        public void parkCar(int spot, Car car) {
            for (int i = spot; i < arr.length; i++) {
                if (isSpotAvailable(i)) {
                    arr[i] = car;
                    freeSpots--;
                    return;
                }
            }
        }

        private boolean isSpotAvailable(int spot) {
            return arr[spot] == null;
        }

        public void removeCar(int spot) {
            if (arr[spot] != null) {
                freeSpots++;
            }
            arr[spot] = null;
        }

        public String printCar(int spot) {
            return arr[spot] != null ?
                    arr[spot].toString() : "Empty";
        }

        public int printFreeSpots() {
            return freeSpots;
        }

        @Override
        public String toString() {
            StringBuilder s = new StringBuilder();
            for (Car car : arr) {
                s.append(car).append("\n");
            }
            return s.toString();
        }
    }

    public static void main(String[] args) {
        Lot lot = new Lot(10);
        lot.parkCar(0, new Car("Small","Silver","BMW"));
        lot.parkCar(0, new Car("Medium","Green","Ford"));
        System.out.println(lot);
    }
}