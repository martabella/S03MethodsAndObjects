import model.Genero;
import model.Libro;

import java.time.LocalDate;

public class BasicObjects {
    public static void main(String[] args) {
         int a = 20;
         Libro libro1 = new Libro("Llevará tu nombre",
                 22.70f,
                 70,
                 false,
                 Genero.Narrativa,
                 LocalDate.of(2015, 02, 03),
                 "Sonsoles Onega"
         );

        //System.out.println(libro1.getTitulo());
        //libro1.titulo = "aaa";
         Libro libro2 = new Libro("Llevará tu nombre",
                 70,
                 false,
                 Genero.Narrativa,
                 LocalDate.now(),
                 "Sonsoles Onega");

        // libro2.actualizaPrecio(20);
        System.out.println(libro1);
        System.out.println(libro2);
    }
}
