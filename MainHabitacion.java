import java.util.Scanner;

public class MainHabitacion {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        Habitacion h1 = new Habitacion(205, "Doble", 75.50, false);
        int op;
        do {
            System.out.println("""
                    ===== GESTIÓN DE HOTEL =====
                    1 - Mostrar habitación
                    2 - Modificar precio por noche
                    3 - Ocupar habitación
                    4 - Liberar habitación
                    5 - Calcular precio de una estancia
                    0 - Salir
                    Elige una opción:
                    """);


            op = teclado.nextInt();

            switch (op) {

                case 1:
                    System.out.println(h1.toString());
                    break;
                case 2:
                    System.out.print("Introduce el precio nuevo: ");
                    int precio_nuevo = teclado.nextInt();
                    h1.setPrecioNoche(precio_nuevo);
                    break;

                case 3:
                    h1.ocupar();
                    System.out.println("La habitación ha sido ocupada.");
                    break;

                case 4:
                    h1.liberar();
                    System.out.println("Has liberado la habitación.");
                    break;

                case 5:

                    System.out.print("Introduce las noches que te vas a quedar: ");
                    int noches_estancia = teclado.nextInt();
                    System.out.println("Precio total: " + h1.calcularPrecio(noches_estancia));
            }

        } while (op != 0);


        teclado.close();


    }}
