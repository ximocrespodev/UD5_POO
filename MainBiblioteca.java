import java.util.ArrayList;

public class MainBiblioteca {

    public static void librosDisponibles(ArrayList<Libro> librosCreados){


        System.out.println("LIBROS DISPONIBLES");
        for (int i = 0; i<librosCreados.toArray().length; i++){

            if (librosCreados.get(i).getEstado()){
                System.out.println("\t" + "-" + librosCreados.get(i).getTitulo() + " ( " + librosCreados.get(i).getAutor() + ", " + librosCreados.get(i).getAnoPublicacion() + ")");
            }


        }


    }

    public static Libro librosMasPrestado(ArrayList<Libro> librosCreados){


        int mayor = 0;
        Libro ganador = null;

        for (int i = 0; i<librosCreados.toArray().length; i++){

          if (librosCreados.get(i).getCuentaPrestaciones() > mayor){
              mayor = librosCreados.get(i).getCuentaPrestaciones();
              ganador = librosCreados.get(i);
          }


        }
        return ganador;


    }




    public static void main(String[] args) {

        Libro l1 = new Libro("Blancanieves", "Gorge Escrig", 1956);
        Libro l2 = new Libro("La Cenicienta", "Ximo Crespo", 1878);
        Libro l3 = new Libro("El Quijote", "Hugo Bisquert Rosello", 1568);
        Libro l4 = new Libro("Jumangi The Book", "Hugo Bisquert Rosello", 1999);

        ArrayList<Libro> libros = new ArrayList<>();
        libros.add(l1);
        libros.add(l2);
        libros.add(l3);
        libros.add(l4);
        System.out.println("Total libros creados: " + libros.toArray().length);




        l1.prestar();
        l2.prestar();
        l3.prestar();

        System.out.println(l1);
        System.out.println(l2);
        System.out.println(l3);

        l1.devolver();
        l1.devolver();
        l1.prestar();


        System.out.println("--- RESUMEN ---");
        System.out.println("Disponibles: ");
        librosDisponibles(libros);

        System.out.println("Más prestado: " + librosMasPrestado(libros).getTitulo() + " ( " + librosMasPrestado(libros).getCuentaPrestaciones() + " préstamos )");
        System.out.println();

        System.out.println("Total libros creados: " + libros.toArray().length);
        System.out.println();





    }




}
