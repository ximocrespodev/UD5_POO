public class CajaFuerte {
    
    private String codigoSecreto;
    private int intentosRestantes;
    private boolean estaBloqueada;
    private double dineroRobado;


    public CajaFuerte(String codigoSecreto){
        
        this.codigoSecreto = codigoSecreto;
        this.intentosRestantes = 3;
        this.estaBloqueada = false;
        this.dineroRobado = 0;

    }

    public void setCodigoSecreto(String codigo){this.codigoSecreto = codigo;}
    public void setIntentos(int intentos){this.intentosRestantes = intentos;}
    public void setEstaBloqueada(boolean esta){this.estaBloqueada = esta;}
    public void setDineroRobado(double dinero){this.dineroRobado = dinero;}

    public String getCodigoSecreto(){return this.codigoSecreto;}
    public int getIntentos(){return this.intentosRestantes;}
    public boolean getEstaBloqueada(){return this.estaBloqueada;}
    public double getDineroRobado(){return this.dineroRobado;}



    public void intentarAbrir(String codigoIntento, double cantidad){


        if (getEstaBloqueada()){
            System.out.println("ALERTA ALERTA ALERTA: Viene don cangrejo");
        
        }else if(codigoIntento.equals(getCodigoSecreto())){
            System.out.println("ACCESO CON EXITO");
            setDineroRobado(cantidad + getDineroRobado());
            setIntentos(3);
        }else{
            setIntentos(intentosRestantes-1);
            System.out.println("CODIGO INTRODUCIDO INCORRECTO");
            if (getIntentos() <= 0){
                setEstaBloqueada(true);
            }
        }



    }

    @Override 
    public String toString(){

        if (estaBloqueada) {
            return "SE ENCUENTRA BLOQUEADA";

        }else{
            return "SE ENCUENTRA ABIERTA";

        }

    }



}
