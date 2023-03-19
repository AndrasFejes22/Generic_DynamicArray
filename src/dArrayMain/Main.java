package dArrayMain;

import dynamicArray.DynamicArray;

public class Main {
    public static void main(String[] args) {

        DynamicArray<String> dynamicArray = new DynamicArray<>(5);

        dynamicArray.add("Joe");
        dynamicArray.add("Karen");
        dynamicArray.add("Jim");
        dynamicArray.add("Anna");
        dynamicArray.add("William");

        System.out.println("initial capacity: "+dynamicArray.getCapacity());
        System.out.println("initial size: "+dynamicArray.getSize());
        System.out.println("empty: "+dynamicArray.isEmpty());
        System.out.println("dynamicArray: "+dynamicArray);
        System.out.println("--------------");
        System.out.println("add new item");
        dynamicArray.add("Jane");
        System.out.println("capacity: "+dynamicArray.getCapacity());
        System.out.println("size: "+dynamicArray.getSize());
        System.out.println("dynamicArray: "+dynamicArray);
        System.out.println("--------------");
        System.out.println("insert:");
        dynamicArray.insert(2, "Bela");
        System.out.println("dynamicArray: "+dynamicArray);
        System.out.println("--------------");
        System.out.println("addLast (Otto):");
        dynamicArray.addLast("Otto");
        System.out.println("dynamicArray: "+dynamicArray);
        System.out.println("--------------");
        System.out.println("swap Jim to Angus:");
        dynamicArray.swap("Jim", "Angus");
        System.out.println("dynamicArray: "+dynamicArray);
        System.out.println("--------------");
        System.out.println("get(6):");
        System.out.println("dynamicArray.get(6): "+dynamicArray.get(6));
        System.out.println("--------------");
        System.out.println("get non exist index (IndexOutOfBoundsException):");
        try {
            dynamicArray.get(20);
            //dynamicArray.add(3); // error in compile time <--generic!
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("--------------");
        System.out.println("addFirst (BILL):");
        dynamicArray.addFirst("BILL");
        System.out.println("dynamicArray: "+dynamicArray);
        System.out.println("--------------");
        System.out.println("search:");
        System.out.println("search Karen: "+dynamicArray.search("Karen"));
        System.out.println("--------------");
        System.out.println("clear:");
        dynamicArray.clear();
        System.out.println("dynamicArray: "+dynamicArray);
        System.out.println("search Karen: "+dynamicArray.search("Karen"));
    }
}
