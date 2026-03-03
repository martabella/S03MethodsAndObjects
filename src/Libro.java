import java.util.Arrays;

public class Libro {
    //propiedades
    String titulo;
    String[] autores;
    float precio;
    int stock;
    boolean esTapaBlanda;
    Genero genero;

    public Libro(String titulo, String[] autores, float precio, int stock, boolean esTapaBlanda, Genero genero) {
        this.titulo = titulo;
        this.autores = autores;
        this.precio = precio;
        this.stock = stock;
        this.esTapaBlanda = esTapaBlanda;
        this.genero = genero;
    }

    public Libro(String titulo, String[] autores, int stock, boolean esTapaBlanda, Genero genero) {
        this.titulo = titulo;
        this.autores = autores;
        this.stock = stock;
        this.esTapaBlanda = esTapaBlanda;
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", autores=" + Arrays.toString(autores) +
                ", precio=" + precio +
                ", stock=" + stock +
                ", esTapaBlanda=" + esTapaBlanda +
                ", genero=" + genero +
                '}';
    }


    //funcionalidades o métodos
    public boolean actualizaPrecio(float precio){
        if (precio>0){
            this.precio = precio;
            return true;
        }
        return false;

    }
}
