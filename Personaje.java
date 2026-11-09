import java.util.Scanner;

public class Personaje {

    private String nombre;
    private int nivel;
    private int vida;
    private int monedas;

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getNombre(){
        return this.nombre;
    }

    public void setNivel(int new_level){
        nivel = new_level;
    }

    public int getNivel(){
        return  this.nivel;
    }

    public void setVida(int vida_nueva){
        this.vida = vida_nueva;
    }

    public int getVida(){
        return this.vida;
    }

    public void setMonedas(int cantidad){
        monedas = cantidad;
    }

    public int getMonedas(){
        return this.monedas;
    }



    public Personaje(String nombre, int nivel, int vida, int monedas){
        this.nombre = nombre;
        this.nivel = nivel;
        this.vida = vida;
        this.monedas =  monedas;
    }



    public void recibirDanio(int cantidad){

        if (this.vida - cantidad > 0){
            setVida(this.vida-cantidad);
        }else {
            System.out.println("ERROR: La resta de la vida introducida puede bajar de 0.");
        }
    }

    public void curarse(int cantidad){
        if (this.vida + cantidad <= 100){
            setVida(this.vida+cantidad);
        }else {
            System.out.println("ERROR: La suma de la vida puede superar 100.");
        }

    }

    public void ganarMonedas(int cantidad){
        setMonedas(this.monedas+cantidad);
    }

    public void gastarMonedas(int cantidad){

        if (this.monedas-cantidad >= 0){
            setMonedas(this.monedas-cantidad);
        }else {
            System.out.println("ERROR: No tienes suficientes monedas");
        }


    }

    public void subirNivel(){

        if (this.nivel+1 < 100){
            setNivel(this.nivel+1);
            setVida(100);
        }else {
            System.out.println("ERROR: No puedes subir más el nivel");
        }

    }

    public void cambiarNombre(String nombre){
        setNombre(nombre);
    }

    @Override
    public String toString(){
        return "Nombre: " + getNombre() + "\n" + "Nivel: " + getNivel() + "\n" + "Vida: " + getVida() + "/100\n" + "Monedas: " + getMonedas() ;
    }




        }

