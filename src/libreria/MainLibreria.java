package libreria;

import model.Genero;
import model.Libro;

import java.time.LocalDate;
import java.util.ArrayList;

public class MainLibreria {

    private ArrayList<Libro> libreria = new ArrayList<>();

    public static void main(String[] args) {
        MainLibreria programa = new MainLibreria();
        programa.start();
    }

    public void start(){
        cargarDatosPrueba();
        boolean exit = false;
        int optionMenu;
        String menu = """
        ==========================================
              📚 LIBRERÍA LA SALLE FP 📚      
        ==========================================
          1. 👤 Consultar libros por autor
          2. 💰 Consultar libros por precio
          3. 🛒 Vender libro
          4. 📖 Mostrar catálogo completo
          5. ➕ Añadir nuevo libro
        ------------------------------------------
          6. Salir
        ==========================================
        """;

        do{
            System.out.println(menu);
            optionMenu = Utils.leerEnteroConsola("Selecciona una opción", 1, 6);
            switch (optionMenu){
                case 1:
                    consultarLibrosAutor();
                    break;
                case 2:
                    consultarLibrosPrecio();
                    break;
                case 3:
                    venderLibro();
                    break;
                case 4:
                    mostrarCatalogo(false);
                    break;
                case 5:
                    altaLibro();
                    break;
                case 6:
                    System.out.println("Saliendo");
                    exit = true;
                    break;
            }
        }while(!exit);
    }


    public void altaLibro(){
        String titulo = Utils.leerStringConsole("Introduce titulo del libro: ");
        String[] autores = new String[2];
        float precio = Utils.leerFloatConsole("Introduce precio ",0, Float.MAX_VALUE);
        int stock = Utils.leerEnteroConsola("Introduce stock", 0, Integer.MAX_VALUE);
        boolean esTapaBlanda = Utils.leerBooleanConsole("Es tapa blanda? ");
        Genero genero = Utils.leerEnumGenero("Introduce género");
        LocalDate fechaPublicacion = Utils.leerFechaConsole("Introduce fecha publicación");

        Libro libro = new Libro(titulo, precio, stock, esTapaBlanda, genero, fechaPublicacion, autores);
        libreria.add(libro);
        System.out.println("Libro añadido");
        mostrarCatalogo(false);
    }
    public void venderLibro(){
        if (libreria.isEmpty()){ return;}
        mostrarCatalogo(true);
        //leer consola el libro que quiero vender
        //reto para foro: leerEntero con array de valores posibles.
        int indiceLibroSeleccionado = Utils.leerEnteroConsola("¿Qué libro quieres?", 0,libreria.size()-1);
        if (libreria.get(indiceLibroSeleccionado).vender()){
            System.out.println("Enhorabuena por tu adquisición");
        }else{
            System.out.println("Lo sentimos, el libro no está disponible");
        }
        System.out.println(libreria.get(indiceLibroSeleccionado));
    }
    public void consultarLibrosPrecio(){
        if (libreria.isEmpty()){ return;}
        //Leer el precio de busqueda
        //Buscar en libreria qué libros cumplen con este criterio
        //Recordar que si no hay ningún libro que cumpla con el criterio, informar al usuario
    }

    public void consultarLibrosAutor(){
        if (libreria.isEmpty()){ return;}
        String autorBusqueda = Utils.leerStringConsole("¿Qué autor te interesa?");
        boolean encontrado = false;
        for (Libro libro : libreria){
            String[] autores = libro.getAutores();
            for (String autor : autores){
                if (autor.toLowerCase().contains(autorBusqueda.toLowerCase())){
                    System.out.println(libro);
                    encontrado = true;
                }
            }
        }
        if (!encontrado){
            System.out.println("Lo sentimos, no disponemos de libros del autor: "+autorBusqueda);
        }
    }
    public void mostrarCatalogo(boolean activarFiltro){
        for (int i=0; i<libreria.size(); i++){
            if (activarFiltro){
                Libro libro =  libreria.get(i);
                if (libro.getPrecio()>0 && libro.getStock()>0){
                    System.out.println("[" + (i) + "] " + libreria.get(i));
                }
            }else {
                System.out.println("[" + (i) + "] " + libreria.get(i));
            }
        }
        /*for (Libro libro : libreria){
            System.out.println(libro);
        }*/
    }



    private void cargarDatosPrueba(){
        libreria.add(new model.Libro("Cien años de soledad", 22.50f, 10, false,
                model.Genero.Narrativa, LocalDate.of(1967, 5, 30), "Gabriel García Márquez"));
        libreria.add(new model.Libro("El Principito", 12.00f, 3, true,
                model.Genero.Infantil, LocalDate.of(1943, 4, 6), "Antoine de Saint-Exupéry"));
        libreria.add(new model.Libro("Neufert: El Arte de Proyectar", 95.00f, 5, false,
                model.Genero.Arquitectura, LocalDate.of(2019, 10, 15), "Ernst Neufert", "Peter Neufert"));
        libreria.add(new model.Libro("Aventuras Bisiestas", 15.99f, 0, true,
                model.Genero.Infantil, LocalDate.of(2024, 2, 29), "Autor Anónimo"));
        libreria.add(new model.Libro("Bocetos Urbanos", 15, false,
                model.Genero.Arquitectura, LocalDate.of(2022, 1, 1), "Jane Jacobs"));
    }
}
