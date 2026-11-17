import java.util.Random;
import java.util.Scanner;

public class CazaTesoro {


    static final int FILAS = 3;
    static final int COLUMNAS = 4;
    static final int MONEDAS = 0;
    static final int VIDAS = 10;


    public static void inicializarTerreno(Casilla[][] terreno){

        for (int i = 0; i<terreno.length; i++){
            for (int j = 0; j<terreno[i].length; j++){
                terreno[i][j] = new Casilla();
            }
        }


    }

    public static void colocarElementos(Casilla[][] terreno, int numTesoros, int numTrampas){

        //generar fila y columna aleatorio dentro del rango
        Random rand = new Random();

        int filaGenerada;
        int columnaGenerada;

        for (int i = 0; i<numTesoros; i++){

        filaGenerada = rand.nextInt(FILAS) + 1;
        columnaGenerada = rand.nextInt(COLUMNAS) + 1;

        if (!terreno[filaGenerada-1][columnaGenerada-1].getTieneTesoro() && !terreno[filaGenerada-1][columnaGenerada-1].getTieneTrampa()) {
            terreno[filaGenerada-1][columnaGenerada-1].setTieneTesoro(true);
        }else{
            i--;
            
        }

        }

        for (int i = 0; i<numTrampas; i++){

        filaGenerada = rand.nextInt(FILAS) + 1;
        columnaGenerada = rand.nextInt(COLUMNAS) + 1;


        if (!terreno[filaGenerada-1][columnaGenerada-1].getTieneTesoro() && !terreno[filaGenerada-1][columnaGenerada-1].getTieneTrampa()) {
            terreno[filaGenerada-1][columnaGenerada-1].setTieneTrampa(true);
        }else{
            i--;
            
        }

        }

        
       

    }

    public static void mostrarTerreno(Casilla[][] terreno, int vidas, int monedas){

        System.out.print("        ");
        for (int z = 0; z<COLUMNAS; z++){
            System.out.print("Col " + z + "            ");
        }

        System.out.println();

        for (int i = 0; i<terreno.length; i++){

            System.out.print("Fila " + i + " |");

            for (int j = 0; j<terreno[i].length; j++){ 

                System.out.print(terreno[i][j] + "             |");


            }
        System.out.println();

        
        }

        System.out.println("Vidas: " + vidas + " | Monedas: " + monedas);
        



    }

    public static boolean quedanTesoros(Casilla[][] terreno){
        for (int i = 0; i<terreno.length; i++){
            for (int j = 0; j<terreno[i].length; j++){

                if (terreno[i][j].getTieneTesoro()) {
                    return true;
                }



            }}
            return false;
    }

    public static void menu(){
        System.out.println("""

            ===== CAZA DEL TESORO =====
1. Mostrar mapa de la isla
2. Excavar en una coordenada
3. Consultar estado del aventurero (Vidas y Monedas)
0. Salir                """);




    }


    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        Casilla[][] terreno = new Casilla[FILAS][COLUMNAS];
        inicializarTerreno(terreno);
        colocarElementos(terreno, 3, 3);
       
        

        int op = 0;
        int columna;
        int fila;
        int vidasRestantes = VIDAS;
        int monedasRestantes = MONEDAS;


        do{
            menu();
            System.out.print("Elige una opción: ");
            op = sc.nextInt();

            switch (op) {
                case 1:
                    mostrarTerreno(terreno, vidasRestantes, monedasRestantes);
                    break;

                case 2:
                    System.out.print("Introduce una fila entre (0-" + (FILAS-1) + "): ");
                    fila = sc.nextInt();
                    
                    System.out.print("Introduce una columna entre (0-" + (COLUMNAS-1) + "): ");
                    columna = sc.nextInt();


                    if (!terreno[fila][columna].getDescubierta()) {
                        
                    if(terreno[fila][columna].explorar() == 1){
                        System.out.println("Tiene tesoro!");
                        monedasRestantes += 10;
                    }else if (terreno[fila][columna].explorar() == -1) {
                        System.out.println("Tiene trampa!");
                        vidasRestantes--;
                    }else{
                        System.out.println("No hay nada aquí");
                    }


                }else{

                    System.out.println("Terreno ya descubierto");
                }
                    break;


                case 3:
                    System.out.print("Vida: " );


                    for (int i = 0; i<vidasRestantes; i++){
                        System.out.print("\u2665 ");
                    }


                    System.out.print(" | Monedas restantes \uD83D\uDCB0 :" + monedasRestantes);


                    break;

        
                default:
                    System.out.println("Introduce una opción valida para continuar");;
                    break;
            }
            


            
        }while(op != 0 && vidasRestantes > 0);



        sc.close();


    }


    
}
