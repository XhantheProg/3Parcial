package Tienda;

import java.util.ArrayList;
import java.util.List;
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
    List<Computadora> inventario = new ArrayList<>();

    public TiendaDeComputadoras(String nombre, String propietario, String identificadorTributario) {
        this.nombre = nombre;
        this.propietario = propietario;
        this.identificadorTributario = identificadorTributario;
    }

    public void agregarComputadora(Computadora computadora) {
        inventario.add(computadora);
    }

    public void eliminarComputadora(String marca) {
        for (Computadora comp : inventario) {
            if (comp.marca.equalsIgnoreCase(marca)) {
                inventario.remove(comp);
                break;
            }
        }
    }

    public Computadora buscarComputadora(String marca) {
        for (Computadora comp : inventario) {
            if (comp.marca.equalsIgnoreCase(marca)) {
                return comp;
            }
        }
        return null;
    }

    public void listarInventario() {
        for (Computadora comp : inventario) {
            System.out.println("Marca: " + comp.marca);
            System.out.println("Memoria: " + comp.memoria + " GB");
            System.out.println("Procesador: " + comp.procesador);
            System.out.println("Sistema Operativo: " + comp.sistemaOperativo);
            System.out.println("Precio: $" + comp.precio);
            System.out.println("--------------------");
        }
    }
}

class Estudiante {
    String nombre;
    String apellidos;
    int codigo;
    int numeroSemestre;
    double notaFinal;

    public Estudiante(String nombre, String apellidos, int codigo, int numeroSemestre, double notaFinal) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.codigo = codigo;
        this.numeroSemestre = numeroSemestre;
        this.notaFinal = notaFinal;
    }
}

class CursoUniversitario {
    List<Estudiante> estudiantes = new ArrayList<>();

    public void agregarEstudiante(Estudiante estudiante) {
        for (Estudiante e : estudiantes) {
            if (e.codigo == estudiante.codigo) {
                System.out.println("El código del estudiante ya existe.");
                return;
            }
        }
        estudiantes.add(estudiante);
    }

    public Estudiante buscarEstudiante(int codigo) {
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.codigo == codigo) {
                return estudiante;
            }
        }
        return null;
    }

    public void eliminarEstudiante(int codigo) {
        Estudiante estudiante = buscarEstudiante(codigo);
        if (estudiante != null) {
            System.out.println("Estudiante encontrado: " + estudiante.nombre + " " + estudiante.apellidos);
            System.out.print("¿Deseas eliminar a este estudiante? (S/N): ");
            Scanner scanner = new Scanner(System.in);
            String respuesta = scanner.nextLine().trim();
            if (respuesta.equalsIgnoreCase("S")) {
                estudiantes.remove(estudiante);
                System.out.println("Estudiante eliminado.");
            } else {
                System.out.println("No se eliminó al estudiante.");
            }
        } else {
            System.out.println("No se encontró un estudiante con ese código.");
        }
    }

    public double calcularPromedio() {
        double sumaNotas = 0;
        for (Estudiante estudiante : estudiantes) {
            sumaNotas += estudiante.notaFinal;
        }
        return sumaNotas / estudiantes.size();
    }

    public void obtenerCantidadEstudiantesAprobados() {
        int aprobados = 0;
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.notaFinal >= 3.0) {
                aprobados++;
            }
        }
        double porcentajeAprobados = (double) aprobados / estudiantes.size() * 100;
        System.out.println("Cantidad de estudiantes aprobados: " + aprobados);
        System.out.println("Porcentaje de estudiantes aprobados: " + porcentajeAprobados + "%");
    }
}

public class Main {
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

        // Crear un curso universitario
        CursoUniversitario curso = new CursoUniversitario();

        // Agregar estudiantes al curso
        curso.agregarEstudiante(new Estudiante("Ana", "López", 101, 2, 4.5));
        curso.agregarEstudiante(new Estudiante("Carlos", "Martínez", 102, 3, 3.2));
        curso.agregarEstudiante(new Estudiante("Elena", "García", 103, 2, 3.9));

        // Calcular el promedio del curso
        double promedio = curso.calcularPromedio();
        System.out.println("Promedio del curso: " + promedio);

        // Obtener la cantidad de estudiantes aprobados
        curso.obtenerCantidadEstudiantesAprobados();
    }
}
