/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prestamolibros;

/**
 *
 * @author Usuario
 */
public class Libro {
    int isbn;
    String nombreLibro;
    boolean prestado;
    
    
    public Libro(int isbn, String nombreLibro) {
        this.isbn = isbn;
        this.nombreLibro = nombreLibro;
        this.prestado = false;
    }
    
    public int getIsbn() {
        return isbn;
    }
    
    public String getNombreLibro() {
        return nombreLibro;
    }

    synchronized public boolean isPrestado() {
        return prestado;
    }
    
    public synchronized void setPrestado(boolean prestado) {
        this.prestado = prestado;
        if (prestado) {
            System.out.println("Libro " + nombreLibro + " (ISBN: " + isbn + ") ha sido prestado.");
        } else {
            System.out.println("Libro " + nombreLibro + " (ISBN: " + isbn + ") ha sido devuelto.");
        }
    }
}
