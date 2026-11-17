import java.util.Scanner;

public class Plataforma {




    public static void mostrarPanelMisiones(MisionEspacial[] misiones, int total){


        System.out.println("""
            
            ============================================================
                        NASA LAUNCH CONTROL - CABO CAÑAVERAL               
            ============================================================

                """);



        for (int i = 0; i<misiones.length; i++){


            System.out.print("[Misión" + i + "]");
            System.out.print(misiones[i]);
            System.out.println("------------------------------------------------------------");

        }


    }

    public static int contarPendientes(MisionEspacial[] misiones){

        int contador = 0;

        for (int i = 0; i<misiones.length; i++){

            if (misiones[i].estaPendiente()) {
                contador++;
            }

        }
        return contador;


    }

    public static void cabecera(){

        System.out.println("""
            ===== NASA MISSION CONTROL =====
1. Programar nuevo lanzamiento
2. Mostrar panel de lanzamientos
3. Retrasar lanzamiento por mal tiempo (+días / +horas)
4. Consultar número de lanzamientos pendientes
0. Salir        """);



    }


    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);


        do{
            cabecera();
            System.out.print("Elige una opcion: ");


            int op;
            switch (op) {
                case value:
                    
                    break;
            
                default:
                    break;
            }

        }




    }
    
}
