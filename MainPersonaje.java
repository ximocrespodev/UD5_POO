import java.util.Scanner;

public class MainPersonaje {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        Personaje p = new Personaje("Link", 1, 100, 50);
        int op;

        do {
            System.out.println("""
                    
                    ===== PERSONAJE =====
                    1 - Mostrar personaje
                    2 - Recibir daño
                    3 - Curarse
                    4 - Ganar monedas
                    5 - Gastar monedas
                    6 - Subir de nivel
                    7 - Cambiar nombre
                    0 - Salir
                    
                    Elige una opción:""");

            op = teclado.nextInt();

            if (op < 1 && op > 7){
                System.out.println("Introduce una opción valida...");
            }

            switch (op){

                case 1:
                    System.out.println(p.toString());
                    break;

                case 2:
                    System.out.print("Introduce el daño recibido: ");
                    int dano = teclado.nextInt();
                    p.recibirDanio(dano);
                    break;

                case 3:
                    System.out.print("Introduce la cantidad de cura: ");
                    int cura = teclado.nextInt();
                    p.curarse(cura);
                    break;

                case 4:
                    System.out.print("Introduce las monedas ganandas: ");
                    int monedas = teclado.nextInt();
                    p.ganarMonedas(monedas);
                    break;

                case 5:
                    System.out.print("Introduce las monedas gastadas: ");
                    int monedas_gastadas = teclado.nextInt();
                    p.gastarMonedas(monedas_gastadas);
                    break;

                case 6:
                    p.subirNivel();
                    break;

                case 7:

                    //limpiamos el buffer de las opciones anteriores
                    teclado.nextLine();

                    System.out.print("Introduce el nombre nuevo: ");
                    String nombre_nuevo = teclado.nextLine();
                    p.cambiarNombre(nombre_nuevo);
                    break;

            }


        }while (op != 0);


        teclado.close();


}}
