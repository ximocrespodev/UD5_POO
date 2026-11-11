public class Alumno {

    private String nombre;
    private int intentosExamen;
    private int puntosInfractores;
    private boolean tieneCarnet;


    public Alumno(String nombre){

        this.nombre = nombre;
        this.intentosExamen = 0;
        this.puntosInfractores = 0;
        this.tieneCarnet = false;
    }

    public void setNombre(String nombre){this.nombre = nombre;}
    public void setIntentosExamen(int intentos){this.intentosExamen = intentos;}
    public void setPuntosInfractores(int puntos){this.puntosInfractores = puntos;}
    public void setTieneCarnet(boolean tiene){this.tieneCarnet = tiene;}

    public String getNombre(){return this.nombre;}
    public int getIntentosExamen(){return this.intentosExamen;}
    public int getPuntosInfractores(){return this.puntosInfractores;}
    public boolean getTieneCarnet(){return this.tieneCarnet;}


    @Override
    public String toString(){

        if (getTieneCarnet()){
            return "Nombre: " + getNombre() + " | Intentos Examen: " + getIntentosExamen() + " | Puntos infractores: " + getPuntosInfractores() + " | Tiene carnet: SI";
        }else {
            return "Nombre: " + getNombre() + " | Intentos Examen: " + getIntentosExamen() + " | Puntos infractores: " + getPuntosInfractores() + " | Tiene carnet: NO";

        }

    }


}
