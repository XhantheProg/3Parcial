package AdiciondeTienda;

import java.util.Scanner;

class Computadora {
    String marca;
    int memoria;
    String procesador;
    String sistemaOperativo;
    double precio;

    public Computadora(String marca, int memoria, String procesador, String sistemaOperativo, double precio) {
        this.marca = marca;
        this.memoria = memoria;
        this.procesador = procesador;
        this.sistemaOperativo = sistemaOperativo;
        this.precio = precio;
    }
}

class TiendaDeComputadoras {
    String nombre;
    String propietario;
    String identificadorTributario;
    Computadora[] inventario = new Computadora[10]; // Tamaño fijo

    int cantidadComputadoras = 0;

    public TiendaDeComputadoras(String nombre, String propietario, String identificadorTributario) {
        this.nombre = nombre;
        this.propietario = propietario;
        this.identificadorTributario = identificadorTributario;
    }

    public void agregarComputadora(Computadora computadora) {
        if (cantidadComputadoras < inventario.length) {
            inventario[cantidadComputadoras] = computadora;
            cantidadComputadoras++;
            System.out.println("Computadora agregada.");
        } else {
            System.out.println("Inventario lleno. No se pudo agregar la computadora.");
        }
    }

    public void eliminarComputadora(String marca) {
        for (int i = 0; i < cantidadComputadoras; i++) {
            if (inventario[i].marca.equalsIgnoreCase(marca)) {
                for (int j = i; j < cantidadComputadoras - 1; j++) {
                    inventario[j] = inventario[j + 1];
                }
                inventario[cantidadComputadoras - 1] = null;
                cantidadComputadoras--;
                System.out.println("Computadora eliminada.");
                return;
            }
        }
        System.out.println("No se encontró una computadora con esa marca.");
    }

    public Computadora buscarComputadora(String marca) {
        for (int i = 0; i < cantidadComputadoras; i++) {
            if (inventario[i].marca.equalsIgnoreCase(marca)) {
                return inventario[i];
            }
        }
        return null;
    }

    public void listarInventario() {
        for (int i = 0; i < cantidadComputadoras; i++) {
            Computadora comp = inventario[i];
            System.out.println("Marca: " + comp.marca);
            System.out.println("Memoria: " + comp.memoria + " GB");
            System.out.println("Procesador: " + comp.procesador);
            System.out.println("Sistema Operativo: " + comp.sistemaOperativo);
            System.out.println("Precio: $" + comp.precio);
            System.out.println("--------------------");
        }
    }
}

public class adicionsinsc {
    public static void main(String[] args) {
        // Crear una tienda de computadoras
        TiendaDeComputadoras tienda = new TiendaDeComputadoras("Mi Tienda", "Juan Pérez", "123456789");

        // Agregar computadoras a la tienda
        tienda.agregarComputadora(new Computadora("HP", 8, "Intel i5", "Windows 10", 699.99));
        tienda.agregarComputadora(new Computadora("Dell", 16, "Intel i7", "Windows 11", 999.99));

        // Listar las computadoras en la tienda
        System.out.println("Inventario de la tienda:");
        tienda.listarInventario();

        // Eliminar una computadora por marca
        tienda.eliminarComputadora("HP");

        // Buscar una computadora por marca
        Computadora comp = tienda.buscarComputadora("Dell");
        if (comp != null) {
            System.out.println("Computadora encontrada:");
            System.out.println("Marca: " + comp.marca);
            System.out.println("Memoria: " + comp.memoria + " GB");
        } else {
            System.out.println("Computadora no encontrada.");
        }
    }
}