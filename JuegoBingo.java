import java.util.ArrayList;
import java.util.Random;

public class JuegoBingo {

    public static final int LINEAS = 3;
    public static final int COLUMNAS = 5;

    public static void cabecera(){
        System.out.println("""
                ¡ Bienvenido/a al bingo Chester!
                Aquí tienes tu cartón. ¡Buena suerte!
                """);
    }


    public static void mostrarCarton(String[][] carton){

        for (int i = 0; i<carton.length; i++){

            for (int j = 0; j<carton[i].length; j++){

                System.out.print(carton[i][j] + " ");
            }
            System.out.println();

        }


    }

    public static boolean numeroExiste(String[][] carton, int numero){

        String numeroString = String.valueOf(numero);

        for (int i = 0; i<carton.length; i++){

            for (int j = 0; j<carton[i].length; j++){

                if (carton[i][j] != null && carton[i][j].equals(numeroString)){
                    return true;
                }

            }
            System.out.println();

        }
        return false;

    }



    public static void inicializarCarton(String[][] Carton){
        //Inicializamos los numeros aleatorios
        Random rand = new Random();

        for (int i = 0; i<Carton.length; i++){

            for (int j = 0; j<Carton[i].length; j++){


                int NumeroAleatorio = rand.nextInt(90) + 1;

                if (!numeroExiste(Carton, NumeroAleatorio)){

                    if (NumeroAleatorio < 10){
                        Carton[i][j] = " " + String.valueOf(NumeroAleatorio);

                    }else {
                        Carton[i][j] = String.valueOf(NumeroAleatorio);

                    }}else {
                    j--;
                }

            }
            System.out.println();

        }
    }

    public static boolean esLinea(String[][] Carton){

        int contadorLinea = 0;
        for (int i = 0; i<Carton.length; i++){

            for (int j = 0; j<Carton[i].length; j++){

                if (Carton[i][j].equals(" X")){
                    contadorLinea++;
                }


            }
            if (contadorLinea == 5){
                return true;
            }else {
                contadorLinea = 0;
            }


        }

        return false;



    }

    public static boolean esBingo(String[][] Carton){

        int contadorLinea = 0;
        for (int i = 0; i<Carton.length; i++){

            for (int j = 0; j<Carton[i].length; j++){

                if (Carton[i][j].equals(" X")){
                    contadorLinea++;
                }


            }



        }
        if (contadorLinea == LINEAS*COLUMNAS){
            return true;
        }else {
            contadorLinea = 0;
        }

        return false;



    }

    public static boolean bolaEnCarton(String[][] Carton, int numeroDescubierto){
        for (int i = 0; i<Carton.length; i++){

            for (int j = 0; j<Carton[i].length; j++){

                if (numeroDescubierto >= 10){
                    if (Carton[i][j].equals(String.valueOf(numeroDescubierto))){

                        Carton[i][j] = " X";
                        return true;

                    }
                }else {
                    if (Carton[i][j].equals(" " + String.valueOf(numeroDescubierto))){

                        Carton[i][j] = " X";
                        return true;

                    }
                }

            }
        }
        return false;
    }


    public static void main(String[] args){


        String[][] Carton = new String[LINEAS][COLUMNAS];
        mostrarCarton(Carton);
        inicializarCarton(Carton);



        cabecera();
        mostrarCarton(Carton);
        boolean CheckLinea = false;
        int bolas = 0;
        ArrayList<Integer> numerosSacados = new ArrayList<>();
        Random rand = new Random();


        for (int intentos = 1; intentos <= 50; intentos++){

            int numeroDescubierto = rand.nextInt(90) + 1;


            if (numerosSacados.contains(numeroDescubierto)){
                intentos--;
                continue;
            }else {
                numerosSacados.add(numeroDescubierto);
            }
            bolas++;

            System.out.println("Bola " + intentos + ": " + numeroDescubierto);

            if (!CheckLinea && esLinea(Carton)){
                System.out.println("Has realizado linea!");
                CheckLinea = true;
            }
            if (esBingo(Carton)){
                System.out.println("B I N G O");
                break;

            }

            if (bolaEnCarton(Carton, numeroDescubierto)){
                mostrarCarton(Carton);

            }

        }

        if (bolas == 50){
            System.out.println("HAS PERDIDO");
            System.out.println("LINEA: " + esLinea(Carton));

        }else {
            System.out.println("Has ganado amigo");
            System.out.println("Total bolas: " + bolas);
            System.out.println("LINEA: " + esLinea(Carton));

        }

    }
}
