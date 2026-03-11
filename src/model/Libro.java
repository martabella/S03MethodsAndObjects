package model;

import java.time.LocalDate;
import java.util.Arrays;

public class Libro {
    //propiedades
    private String titulo;
    private String[] autores;
    private float precio;
    private int stock;
    private boolean esTapaBlanda;
    private Genero genero;
    private LocalDate fechaPublicacion;

    public Libro(String titulo, float precio, int stock, boolean esTapaBlanda, Genero genero, LocalDate fechaPublicacion, String... autores) {
        this.titulo = titulo;
        this.autores = autores;
        this.precio = precio;
        this.stock = stock;
        this.esTapaBlanda = esTapaBlanda;
        this.genero = genero;
        this.fechaPublicacion = fechaPublicacion;
    }

    public Libro(String titulo, int stock, boolean esTapaBlanda, Genero genero, LocalDate fechaPublicacion, String... autores) {
        this.titulo = titulo;
        this.autores = autores;
        this.stock = stock;
        this.esTapaBlanda = esTapaBlanda;
        this.genero = genero;
        this.fechaPublicacion = fechaPublicacion;
    }

    public String[] getAutores() {
        return autores;
    }

    public float getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }

    public boolean setPrecio(float precio) {
        if (precio>0){
            this.precio = precio;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "model.Libro{" +
                "titulo='" + titulo + '\'' +
                ", autores=" + Arrays.toString(autores) +
                ", precio=" + precio +
                ", stock=" + stock +
                ", esTapaBlanda=" + esTapaBlanda +
                ", genero=" + genero +
                ", fechaPublicacion=" + fechaPublicacion +
                '}';
    }

    //funcionalidades o métodos
    public boolean vender(){
        if (this.stock>0 && this.precio>0) {
            this.stock--;
            return true;
        }else{
            return false;
        }
    }

}
