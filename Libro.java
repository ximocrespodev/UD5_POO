public class Libro {

    private String titulo;
    private String autor;
    private int AnoPublicacion;
    private boolean estado;
    private int cuentaPrestaciones;
    private static int CONTADORLIBROS;

    public Libro(String titulo, String autor, int anoPublicacion){

        this.titulo = titulo;
        this.autor = autor;
        this.AnoPublicacion = anoPublicacion;
        this.estado = true;
        this.cuentaPrestaciones = 0;
        CONTADORLIBROS++;

    }

    public void setTitulo(String titulo){this.titulo = titulo;}
    public void setAutor(String autor){this.autor = autor;}
    public void setAnoPublicacion(int anoPublicacion){this.AnoPublicacion = anoPublicacion;}
    public void setEstado(boolean estado){this.estado = estado;}
    public void setCuentaPrestaciones(int cuentaPrestaciones){this.cuentaPrestaciones = cuentaPrestaciones;}

    public String getTitulo(){return this.titulo;}
    public String getAutor(){return this.autor;}
    public int getAnoPublicacion(){return this.AnoPublicacion;}
    public boolean getEstado(){return this.estado;}
    public int getCuentaPrestaciones(){return this.cuentaPrestaciones;}



    public void prestar(){

        if(getEstado()){
            System.out.println("Prestando " + getTitulo() + "... OK ");
            setEstado(false);
            setCuentaPrestaciones(getCuentaPrestaciones()+1);
        }else {
            System.out.println("Prestando " + getTitulo() + "... ERROR: ya está prestado ");

        }

    }

    public void devolver(){

        if(!getEstado()){
            System.out.println("Devolviendo " + getTitulo() + "... OK ");
            setEstado(true);
        }else {
            System.out.println("Devolviendo " + getTitulo() + "... ERROR: ya está disponible ");

        }


    }

    public String toString(){
        return "Titulo: " + getTitulo() + " | Autor: " + getAutor() + " | Fecha: " + getAnoPublicacion() + " | Estado: " + getEstado() + " | Veces prestado: " + getCuentaPrestaciones();
    }



}
