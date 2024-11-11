/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prestamolibros;
import java.util.Random;

public class HiloEstudiante implements Runnable {
    private final String nombre;
    private final Libro[] libros;
    private final GestorPrestamo gestor;
    private final Random random = new Random();
    private int maxPrestamos; // Número máximo de veces que tomará libros


    public HiloEstudiante(String nombre, Libro[] libros, GestorPrestamo gestor, int maxPrestamos) {
        this.nombre = nombre;
        this.libros = libros;
        this.gestor = gestor;
        this.maxPrestamos = maxPrestamos;
    }

    @Override
    public void run() {
         for (int i = 0; i < maxPrestamos; i++) { // Bucle limitado por maxPrestamos
            try {
                // Obtener dos libros
                Libro[] librosPrestados = gestor.obtenerDosLibros();
                System.out.println(nombre + " ha tomado los libros: " + librosPrestados[0].getNombreLibro() + " y " + librosPrestados[1].getNombreLibro());

                // Simular el uso de los libros entre 1 y 3 horas (60-180 minutos)
                int tiempoUso = 60 + random.nextInt(121); // Entre 60 y 180 minutos
                Thread.sleep(tiempoUso * 10);  // Multiplicamos por 10 para simular 1 segundo por minuto
                System.out.println(nombre + " ha terminado de usar los libros.");

                // Devolver los libros
                gestor.devolverLibros(librosPrestados);
                System.out.println(nombre + " ha devuelto los libros.");

                // Descansar entre 1 y 2 horas (60-120 minutos)
                int tiempoDescanso = 60 + random.nextInt(61); // Entre 60 y 120 minutos
                Thread.sleep(tiempoDescanso * 10);  // Multiplicamos por 10 para simular 1 segundo por minuto
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println(nombre + " ha sido interrumpido.");
            }
        }
    }
}