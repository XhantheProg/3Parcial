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

public class adicion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Crear una tienda de computadoras
        System.out.println("Ingrese el nombre de la tienda:");
        String nombreTienda = scanner.nextLine();
        System.out.println("Ingrese el nombre del propietario:");
        String nombrePropietario = scanner.nextLine();
        System.out.println("Ingrese el identificador tributario:");
        String identificadorTributario = scanner.nextLine();
        TiendaDeComputadoras tienda = new TiendaDeComputadoras(nombreTienda, nombrePropietario, identificadorTributario);

        // Agregar computadoras a la tienda
        System.out.println("Ingrese los detalles de la primera computadora:");
        Computadora comp1 = crearComputadoraDesdeInput(scanner);
        tienda.agregarComputadora(comp1);

        System.out.println("Ingrese los detalles de la segunda computadora:");
        Computadora comp2 = crearComputadoraDesdeInput(scanner);
        tienda.agregarComputadora(comp2);

        // Listar las computadoras en la tienda
        System.out.println("Inventario de la tienda:");
        tienda.listarInventario();

        // Eliminar una computadora por marca
        System.out.println("Ingrese la marca de la computadora a eliminar:");
        String marcaEliminar = scanner.nextLine();
        tienda.eliminarComputadora(marcaEliminar);

        // Buscar una computadora por marca
        System.out.println("Ingrese la marca de la computadora a buscar:");
        String marcaBuscar = scanner.nextLine();
        Computadora compEncontrada = tienda.buscarComputadora(marcaBuscar);
        if (compEncontrada != null) {
            System.out.println("Computadora encontrada:");
            System.out.println("Marca: " + compEncontrada.marca);
            System.out.println("Memoria: " + compEncontrada.memoria + " GB");
           
        } else {
            System.out.println("Computadora no encontrada.");
        }

        scanner.close();
    }

    public static Computadora crearComputadoraDesdeInput(Scanner scanner) {
        System.out.println("Ingrese la marca:");
        String marca = scanner.nextLine();
        System.out.println("Ingrese la cantidad de memoria (en GB):");
        int memoria = Integer.parseInt(scanner.nextLine());
        System.out.println("Ingrese el procesador:");
        String procesador = scanner.nextLine();
        System.out.println("Ingrese el sistema operativo:");
        String sistemaOperativo = scanner.nextLine();
        System.out.println("Ingrese el precio:");
        double precio = Double.parseDouble(scanner.nextLine());

        return new Computadora(marca, memoria, procesador, sistemaOperativo, precio);
    }
}


    

