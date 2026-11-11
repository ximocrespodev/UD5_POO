import java.util.Scanner;

public class MainApartamento {


    public static void cabecera(){

        System.out.println("""
                
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

        Apartamento ap1 = new Apartamento("DisneyLand AP1", "Av. Lincon Street 45", "Paris", 500);


        int op;

        do {

            cabecera();
            op = teclado.nextInt();


            switch (op){

                case 1:
                    System.out.println(ap1);
                    break;

                case 2:
                    System.out.println("Introduce una noche a reservar: ");
                    int dia = teclado.nextInt();

                    System.out.println("Introduce un mes a reservar: ");
                    int mes = teclado.nextInt();

                    ap1.reservar(mes-1, dia-1);
                    break;


                case 3:

                    System.out.println("Introduce una noche a liberar: ");
                    int dia_liberar = teclado.nextInt();

                    System.out.println("Introduce un mes a liberar: ");
                    int mes_liberar = teclado.nextInt();

                    ap1.liberar(mes_liberar-1, dia_liberar-1);
                    break;


                case 4:

                    System.out.println("Introduce una noche para comprobar: ");
                    int dia_comprobar = teclado.nextInt();

                    System.out.println("Introduce un mes a comprobar: ");
                    int mes_comprobar = teclado.nextInt();

                    if (ap1.estaOcupado(dia_comprobar-1, mes_comprobar-1)){
                        System.out.println("El apartameno se encuentra ocupado el dia " + dia_comprobar + " del mes " + ap1.nombreMes(mes_comprobar-1));
                     }
                    break;



                case 5:

                    System.out.println("Introduce que mes quieres mostrar: ");

                    System.out.println("Introduce un mes a comprobar: ");
                    int mes_mostrar = teclado.nextInt();
                    ap1.mostrarCalendarioMensual(mes_mostrar-1);
                    break;

                case 6:
                    ap1.mostrarCalendarioAnual();
                    break;


                case 7:

                    System.out.println("Introduce un mes a comprobar: ");
                    int ben_mes = teclado.nextInt();

                    ap1.beneficiosMes(ben_mes-1);
                    break;

                case 8:

                    ap1.beneficiosAno();
                    break;

                case 0:
                    System.out.println("SALIENDO");
                    break;



            }

            if (op !=0 && op<1 && op>8){
                System.out.println("ERROR: Tienes que introducir una opción valida para continaur");
            }



        }while (op !=0 && op>=1 && op<=8);



        teclado.close();
    }


}
