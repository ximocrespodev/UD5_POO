import java.util.Scanner;

public class MainCafeteria {


    public static void menuPrincipal(){

        System.out.println("""
========== GESTIÓN DE LA CAFETERÍA ==========
1 - Mostrar información de la cafetería
2 - Modificar nombre
3 - Modificar dirección
4 - Modificar precio medio
5 - Abrir/cerrar cafetería
6 - Ocupar una mesa
7 - Liberar una mesa
8 - Consultar una mesa
9 - Mostrar estado de todas las mesas
10 - Mostrar estadísticas de ocupación
11 - Calcular ingresos estimados
0 - Salir                
                
                
                """);
    }

    public static String traductorESTADO(boolean estado){
        if (estado){
            return "ABIERTA";
        }
        return "CERRADA";
    }

    public static void main(String[] args){

        Scanner teclado = new Scanner(System.in);

        Cafeteria C1 = new Cafeteria("Starbucks", "Av. Madrid 55", "Valencia", 10, 10);

        int op;
        menuPrincipal();
        do {
            System.out.print("Introduce una opción: ");
            op = teclado.nextInt();

            switch (op){

                case 1:
                    //mostramos info cafeteria
                    System.out.println(C1);
                    break;

                case 2:
                    //modificamos nombre
                    break;

                case 3:
                    //modificamos direccion
                    break;

                case 4:
                    //modificamos precio medi
                    break;

                case 5:



                    System.out.println("La cafetería esta actualmente " + traductorESTADO(C1.getEstaAbierta()));

                    System.out.print("¿Quieres cerrarla? (S/N): ");



                    //abrimos o cerramos cafeteria
                    break;

                case 6:
                    //ocupamos mesa
                    break;

                case 7:
                    //liberamos mesa
                    break;

                case 8:
                    //consultamos mesa
                    break;

                case 9:
                    //mostramos estado de todas la mesas
                    break;

                case 10:
                    //mostamos estadisticas de ocupacion
                    break;

                case 11:
                    //estadistica ingresos realizados
                    break;

                default:
                    System.out.println("error: tiene que introducir una opción valida para continuar");



            }

        }while (op != 0);



    }




}
