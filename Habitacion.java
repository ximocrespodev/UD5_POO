import java.util.Scanner;

public class Habitacion {
    private int numero;
    private String tipo;
    private double precioNoche;
    private boolean ocupada;

    public Habitacion(int numero, String tipo, double precioNoche, boolean ocupada){

        this.numero = numero;
        this.tipo = tipo;
        this.precioNoche = precioNoche;
        this.ocupada = ocupada;

    }


    public int getNumero() {
        return numero;
    }

    public String getTipo(){
        return this.tipo;
    }
    public double getPrecioNoche(){
        return this.precioNoche;
    }

    public boolean getOcupada(){
        return this.ocupada;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setTipo(String tipo){
        this.tipo = tipo;
    }
    public void setPrecioNoche(int precio_nuevo){
        this.precioNoche = precio_nuevo;
    }
    public void setOcupada(boolean opcion){
        this.ocupada = opcion;
    }

    public void ocupar(){
        setOcupada(true);
    }

    public void liberar(){
        setOcupada(false);
    }

    public double calcularPrecio(int noches){
        return getPrecioNoche()*noches;
    }

    public String estadoHabitacion(){

        if (getOcupada()){
            return "Ocupada";
        }else {
            return "Libre";
        }

    }

    @Override
    public String toString(){
        return "Habitación " + getNumero() + " - " + getTipo() + " - " + getPrecioNoche() + " €/noche" + " - " + estadoHabitacion();
    }



}
