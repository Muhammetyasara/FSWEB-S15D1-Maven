package org.example.models;

import java.util.*;

public class Grocery {

    public static List<String> groceryList = new ArrayList<>();

    public static void main(String[] args) {
        startGrocery();
    }

    public static void startGrocery() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("=== Grocery Uygulaması ===");
            System.out.println("0 - Çıkış");
            System.out.println("1 - Ürün ekleme");
            System.out.println("2 - Ürün çıkarma");
            System.out.print("Seçim: ");

            int choice;

            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine();
            } else {
                System.out.println("Geçersiz giriş!");
                scanner.nextLine();
                continue;
            }

            switch (choice) {
                case 0:
                    running = false;
                    System.out.println("Çıkılıyor...");
                    break;

                case 1:
                    System.out.print("Eklenecek ürünler (örn: tomato, orange): ");
                    addItems(scanner.nextLine());
                    break;

                case 2:
                    System.out.print("Silinecek ürünler (örn: tomato, orange): ");
                    removeItems(scanner.nextLine());
                    break;

                default:
                    System.out.println("Geçersiz seçim!");
            }

            Collections.sort(groceryList);
            printSorted();
        }

        scanner.close();
    }

    public static void addItems(String input) {
        String[] items = input.split(",");

        for (String item : items) {
            String product = item.trim().toLowerCase();

            if (!product.isEmpty() && !checkItemsIsInList(product)) {
                groceryList.add(product);
            }
        }

        Collections.sort(groceryList);
    }

    public static void removeItems(String input) {
        String[] items = input.split(",");

        for (String item : items) {
            String product = item.trim().toLowerCase();

            if (checkItemsIsInList(product)) {
                groceryList.remove(product);
            }
        }
    }

    public static boolean checkItemsIsInList(String product) {
        return groceryList.contains(product);
    }

    public static void printSorted() {
        Collections.sort(groceryList);
        System.out.println("Liste: " + groceryList);
    }
}