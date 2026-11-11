import java.util.Scanner;

public class MainApartamento {


    public static void cabecera(){

        System.out.print("""
                
                ===================================================
                GESTIÓN DE APARTAMENTO TURÍSTICO (AIRBNB)
                ===================================================
                1. Ver datos del apartamento
                2. Reservar una noche
                3. Liberar una noche
                4. ¿Está ocupada una fecha?
                5. Mostrar calendario de un mes
                6. Mostrar calendario anual
                7. Beneficios de un mes
                8. Beneficios del año
                0. Salir
                ===================================================
                Elige una opción: """);



    }


    public static void main(String[] args){

        Scanner teclado = new Scanner(System.in);

        System.out.print("Introduce el nombre del Apartamento: ");
        String nombreAPT = teclado.nextLine();

        System.out.print("Introduce la direccion del Apartamento: ");
        String direccionAPT = teclado.nextLine();

        System.out.print("Introduce la ciudad del apartamento: ");
        String ciudadAPT = teclado.nextLine();

        System.out.print("Introduce el precio inicial por noche: ");
        int precioInicialAPT = teclado.nextInt();

        System.out.print("Numero de huespedes inicial: ");
        int numeroHuespedesAPT = teclado.nextInt();


        Apartamento ap1 = new Apartamento(nombreAPT, direccionAPT, ciudadAPT, precioInicialAPT, numeroHuespedesAPT);


        int op;

        do {

            cabecera();
            op = teclado.nextInt();


            switch (op){

                case 1:
                    System.out.println(ap1);
                    break;

                case 2:

                    System.out.print("Mes (1-12): ");
                    int mes = teclado.nextInt();

                    System.out.print("Día: ");
                    int dia = teclado.nextInt();

                    System.out.print("Introduce el numero de huespedes: ");
                    int numeroHuespedesReserva = teclado.nextInt();



                    ap1.reservar(mes-1, dia-1, numeroHuespedesReserva);
                    break;


                case 3:

                    System.out.print("Mes (1-12): ");
                    int mes_liberar = teclado.nextInt();

                    System.out.print("Día: ");
                    int dia_liberar = teclado.nextInt();



                    ap1.liberar(mes_liberar-1, dia_liberar-1);
                    break;


                case 4:

                    System.out.print("Mes (1-12): ");
                    int mes_comprobar = teclado.nextInt();

                    System.out.print("Día: ");
                    int dia_comprobar = teclado.nextInt();


                    if (ap1.estaOcupado(dia_comprobar-1, mes_comprobar-1)){
                        System.out.println("El apartameno se encuentra ocupado el dia " + dia_comprobar + " del mes " + ap1.nombreMes(mes_comprobar-1));
                     }else {
                        System.out.println("El apartamento se encuentra libre para esas fechas.");
                    }
                    break;



                case 5:


                    System.out.print("Mes (1-12): ");
                    int mes_mostrar = teclado.nextInt();
                    ap1.mostrarCalendarioMensual(mes_mostrar-1);
                    break;

                case 6:
                    ap1.mostrarCalendarioAnual();
                    break;


                case 7:

                    System.out.print("Mes (1-12): ");
                    int ben_mes = teclado.nextInt();

                    ap1.beneficiosMes(ben_mes-1);
                    break;

                case 8:

                    ap1.beneficiosAno();
                    break;

                case 0:
                    System.out.println("SALIENDO");
                    break;


                default:
                    System.out.println("Debes introducir una opción para continuar...");
                    break;



            }

            if (op !=0 && op<1 && op>8){
                System.out.println("ERROR: Tienes que introducir una opción valida para continaur");
            }



        }while (op !=0);



        teclado.close();
    }


}
