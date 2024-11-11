/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prestamolibros;
import java.util.Random;


public class GestorPrestamo {
    private final Libro[] libros;
    private final Random random = new Random();

    public GestorPrestamo(Libro[] libros) {
        this.libros = libros;
    }

    // Método para intentar obtener dos libros disponibles
    public synchronized Libro[] obtenerDosLibros() {
        Libro[] librosPrestados = new Libro[2];
        int librosObtenidos = 0;

        while (librosObtenidos < 2) {
            int indice = random.nextInt(libros.length);
            Libro libro = libros[indice];

            // Verificar si el libro no está prestado
            if (!libro.isPrestado()) {
                libro.setPrestado(true);
                librosPrestados[librosObtenidos] = libro;
                librosObtenidos++;
            }
        }
        return librosPrestados;
    }

    // Método para devolver los libros después de usarlos
    public synchronized void devolverLibros(Libro[] librosPrestados) {
        for (Libro libro : librosPrestados) {
            if (libro != null) {
                libro.setPrestado(false);
            }
        }
    }
}