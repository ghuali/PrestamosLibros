/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package prestamolibros;

/**
 *
 * @author Usuario
 */
public class PrestamoLibros {

    public static int NUMERO_LIBROS = 9;
    public static int NUMERO_ESTUDIANTES = 4; 
    public static int MAX_PRESTAMOS = 4; // Número de veces que cada estudiante puede tomar libros


    public static void main(String[] args) {
        // Crear los libros
        Libro libros[] = new Libro[NUMERO_LIBROS];
        libros[0] = new Libro(1, "libro 1");
        libros[1] = new Libro(2, "libro 2");
        libros[2] = new Libro(3, "libro 3");
        libros[3] = new Libro(4, "libro 4");
        libros[4] = new Libro(5, "libro 5");
        libros[5] = new Libro(6, "libro 6");
        libros[6] = new Libro(7, "libro 7");
        libros[7] = new Libro(8, "libro 8");
        libros[8] = new Libro(9, "libro 9");

        GestorPrestamo gestor = new GestorPrestamo(libros);

        // Crear los estudiantes
        Thread estudiantes[] = new Thread[NUMERO_ESTUDIANTES];
        
        estudiantes[0] = new Thread(new HiloEstudiante("Andrei", libros, gestor, MAX_PRESTAMOS));
        estudiantes[1] = new Thread(new HiloEstudiante("Samuel", libros, gestor, MAX_PRESTAMOS));
        estudiantes[2] = new Thread(new HiloEstudiante("Yoel", libros, gestor, MAX_PRESTAMOS));
        estudiantes[3] = new Thread(new HiloEstudiante("Alvaro", libros, gestor, MAX_PRESTAMOS));

        
        
        estudiantes[0].start();
        estudiantes[1].start();
        estudiantes[2].start();
        estudiantes[3].start();
        

        // Esperar a que terminen los hilos (en este caso, nunca terminarán)
        for (Thread estudiante : estudiantes) {
            try {
                estudiante.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
