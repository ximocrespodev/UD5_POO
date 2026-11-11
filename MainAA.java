import java.util.Scanner;

public class MainAA {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. Creamos la autoescuela con capacidad máxima de 3 alumnos
        Autoescuela autoescuela = new Autoescuela("Autoescuela Sra. Puff", 3);

        int opcion = 0;

        do {
            System.out.println("\n=== AUTOESCUELA SRA. PUFF ===");
            System.out.println("1. Matricular alumno");
            System.out.println("2. Realizar examen práctico");
            System.out.println("3. Ver el alumno más peligroso");
            System.out.println("4. Mostrar todos los alumnos");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");

            opcion = sc.nextInt();
            sc.nextLine(); // Limpiamos el buffer del Scanner tras leer un int

            switch (opcion) {
                case 1:
                    System.out.print("Introduce el nombre del alumno: ");
                    String nombreNuevo = sc.nextLine();

                    Alumno nuevo = new Alumno(nombreNuevo);
                    boolean matriculado = autoescuela.matricularAlumno(nuevo);

                    if (matriculado) {
                        System.out.println("¡Alumno " + nombreNuevo + " matriculado con éxito!");
                    } else {
                        System.out.println("ERROR: No se ha podido matricular (autoescuela llena o nombre duplicado).");
                    }
                    break;

                case 2:
                    System.out.print("Nombre del alumno a examinar: ");
                    String nombreExamen = sc.nextLine();

                    System.out.print("Número de errores cometidos: ");
                    int errores = sc.nextInt();
                    sc.nextLine(); // Limpiar buffer

                    autoescuela.realizarExamenPractico(nombreExamen, errores);
                    break;

                case 3:
                    Alumno peligroso = autoescuela.obtenerAlumnoMasPeligroso();

                    if (peligroso != null) {
                        System.out.println("⚠️ El alumno más peligroso es: " + peligroso);
                    } else {
                        System.out.println("No hay alumnos matriculados todavía.");
                    }
                    break;

                case 4:
                    // Mostramos la lista llamando al toString de la autoescuela
                    System.out.println(autoescuela);
                    break;

                case 5:
                    System.out.println("¡Gracias por visitar la Autoescuela Sra. Puff! ¡Cuidado en la carretera!");
                    break;

                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
            }

        } while (opcion != 5);

        sc.close();
    }
}