package com.example;

import java.util.ArrayList;
import java.util.Scanner;

public class GestionTienda {

    static ArrayList<String> nombresProductos = new ArrayList<>();
    static ArrayList<Double> preciosProductos = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int opcion;

        // Menu Principal

        do {
            mostrarMenu();
            System.out.print(" PorFavor Ingrese su opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    agregarProducto(sc, nombresProductos, preciosProductos);

                    break;
                case 2:
                    mostrarProductos(nombresProductos, preciosProductos);
                    break;
                case 3:
                    double total = calcularValorTotal(preciosProductos);

                    System.out.printf("El valor total del inventario es: $%.2f\n", total);
                    break;
                case 4:
                    buscarProducto(sc, nombresProductos);
                    break;
                case 5:
                    System.out.println("Que termines de pasar un buen día. Hasta luego");
                    break;
                default:
                    System.out.println("Opción errada. Intenta de nuevo.");
            }
        } while (opcion != 5);

        sc.close();
    }

    public static void mostrarMenu() {
        System.out.println("\n** Menú de Gestión de Tienda **");
        System.out.println("1. Agregar nuevo producto");
        System.out.println("2. Mostrar todos los productos");
        System.out.println("3. Calcular valor total del inventario");
        System.out.println("4. Buscar producto por nombre");
        System.out.println("5. Salir");
        System.out.println("************************************************");
    }

    // Opción 1 -- Agregar producto

    public static void agregarProducto(Scanner sc, ArrayList<String> nombresProductos,
            ArrayList<Double> preciosProductos) {
        System.out.print("Nombre del producto: ");
        String nombre = sc.nextLine();
        System.out.print("Precio del producto: ");
        double precio = sc.nextDouble();

        nombresProductos.add(nombre);
        preciosProductos.add(precio);
        System.out.println("Se agrego el producto correctamente");
    }

    // Opción 2 -- Mostrar los productos

    public static void mostrarProductos(ArrayList<String> nombresProductos, ArrayList<Double> preciosProductos) {

        if (nombresProductos.isEmpty()) {
            System.out.println("No hay productos registrados");
        } else {
            System.out.println("\nLista de productos:");
            for (int i = 0; i < nombresProductos.size(); i++) {
                System.out.printf("Producto: %s | Precio: $%.2f\n", nombresProductos.get(i), preciosProductos.get(i));
            }
        }
    }

    // Opción 3 -- Calcular valor total

    public static double calcularValorTotal(ArrayList<Double> preciosProductos) {

        double total = 0.0;

        for (double precio : preciosProductos) {
            total += precio;
        }
        return total;
    }

    // Opción 4 -- Buscar producto por nombre

    public static void buscarProducto(Scanner sc, ArrayList<String> nombresProductos) {
        System.out.print("Ingrese el nombre del producto que desea buscar: ");
        String nombre = sc.nextLine();

        int indice = buscarProductoPorNombre(nombre, nombresProductos);

        if (indice >= 0) {
            System.out.printf("Producto encontrado: %s | Precio: $%.2f\n", nombresProductos.get(indice),
                    preciosProductos.get(indice));
        } else {
            System.out.println("No se encotro el producto");
        }
    }


    public static int buscarProductoPorNombre(String nombre, ArrayList<String> nombresProductos) {
        for (int i = 0; i < nombresProductos.size(); i++) {
            if (nombresProductos.get(i).equals(nombre)) {
                return i; 
            }
        }
        return -1; 

    }
}