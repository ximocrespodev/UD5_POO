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
                    System.out.println();
                    System.out.println();
                    break;

                case 2:
                    teclado.nextLine();
                    System.out.println("Introduce un nombre nuevo para la cafeteria: ");
                    String nombreNuevo = teclado.nextLine();

                    C1.setNombre(nombreNuevo);
                    System.out.println("Nombre actualizado satisfactoriamente.");
                    break;

                case 3:
                    System.out.println("Introduce una dirección nueva para la cafeteria: ");
                    String direccionNueva = teclado.nextLine();
                    C1.setDireccion(direccionNueva);
                    System.out.println("Dirección actualizada satisfactoriamente.");
                    break;

                case 4:
                    System.out.println("Introduce un precio medio de venta: ");
                    int precioMedio = teclado.nextInt();
                    C1.setPrecio_medio(precioMedio);
                    System.out.println("Precio actualizado satisfactoriamente.");                    break;

                case 5:

                    char opcion;
                    String quieres;
                    int accion;

                    System.out.println("La cafetería esta actualmente " + traductorESTADO(C1.getEstaAbierta()));

                    if (C1.getEstaAbierta()){
                        quieres = "cerrarla"; //si o no
                        accion = 1;
                    }else {
                        quieres = "abrirla"; //si o no
                        accion = 2;
                    }



                        System.out.print("¿Quieres " + quieres + " ? (S/N): ");
                        opcion = teclado.next().charAt(0);
                        System.out.println(opcion);

                    if (accion == 1 && opcion == 'S'){
                        C1.setEstaAbierto(false);
                        System.out.println("La cafetería se ha CERRADO correctamente.");
                    }
                    else if (accion == 2 && opcion == 'S'){
                        C1.setEstaAbierto(true);
                        System.out.println("La cafetería se ha ABIERTO correctamente.");
                    }else {
                        System.out.println("Introduce una opción valida para realizar cambios...");
                    }


                    //abrimos o cerramos cafeteria
                    break;

                case 6:
                    //ocupamos mesa
                    int mesa;
                    System.out.println("Número de mesa: ");
                    mesa = teclado.nextInt();

                    if(C1.ocuparMesa(mesa-1)){
                        System.out.println("La mesa " + mesa + " ha sido ocupada correctamente.");
                    }else {
                        System.out.println("ERROR: La mesa " + mesa + " ya está ocupada");
                    }

                    break;

                case 7:

                    int mesaL;
                    System.out.println("Número de mesa: ");
                    mesaL = teclado.nextInt();

                    if(C1.librerarMesa(mesaL-1)){
                        System.out.println("La mesa " + mesaL + " ha sido liberada correctamente.");
                    }else {
                        System.out.println("ERROR: La mesa " + mesaL + " ya está libre");
                    }
                    //liberamos mesa
                    break;

                case 8:
                    int mesaC;
                    System.out.println("Número de mesa: ");
                    mesaC = teclado.nextInt();

                    C1.consultarMesa(mesaC);

                    //consultamos mesa
                    break;

                case 9:

                    C1.mostrarMesas();
                    //mostramos estado de todas la mesas
                    break;

                case 10:


                    //mostamos estadisticas de ocupacion
                    C1.estadisticas();
                    break;

                case 11:

                    int numMesasCalcular;

                    do{
                        System.out.println("Introduce un numero de mesas: ");
                        numMesasCalcular = teclado.nextInt();

                        if (numMesasCalcular < 1 && numMesasCalcular > C1.getNum_mesas()){
                            System.out.println("error: introduce un numero de mesas valido");
                        }

                    }while (numMesasCalcular < 1 && numMesasCalcular > C1.getNum_mesas());


                    C1.calcularIngresosEstimados(numMesasCalcular);
                    //estadistica ingresos realizados
                    break;

                default:
                    System.out.println("error: tiene que introducir una opción valida para continuar");
                    break;

                case 12:
                    menuPrincipal();


            }

        }while (op != 0);



    }




}
