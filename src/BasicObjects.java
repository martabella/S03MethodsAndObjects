public class BasicObjects {
    public static void main(String[] args) {
         int a = 20;
         Libro libro1 = new Libro("Llevará tu nombre",
                 new String[]{"Sonsoles Onega"},
                 22.70f,
                 70,
                 false,
                 Genero.Narrativa);

         Libro libro2 = new Libro("Llevará tu nombre",
                 new String[]{"Sonsoles Onega"},
                 70,
                 false,
                 Genero.Narrativa);

         libro2.actualizaPrecio(20);
        System.out.println(libro2.toString());
    }
}
