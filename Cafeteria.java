public class Cafeteria {

    private String nombre;
    private String direccion;
    private String ciudad;
    private int precio_medio;
    private int num_mesas;
    private boolean estaAbierto;
    private boolean[] mesas;


    public Cafeteria(String nombre, String direccion, String ciudad, int precio_medio, int num_mesas){

        this.nombre = nombre;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.precio_medio = precio_medio;
        this.num_mesas = num_mesas;
        this.mesas = new boolean[num_mesas];

    }

    public void setNombre(String nombre){this.nombre = nombre;}
    public void setDireccion(String direccion){this.direccion = direccion;}
    public void setCiudad(String ciudad){this.ciudad = ciudad;}
    public void setPrecio_medio(int precio){this.precio_medio = precio;}
    public void setEstaAbierto(boolean estado){this.estaAbierto = estado;}

    public String getNombre(){return this.nombre;}
    public String getDireccion(){return this.direccion;}
    public String getCiudad(){return this.ciudad;}
    public int getPrecio_medio(){return precio_medio;}
    public int getNum_mesas(){return this.num_mesas;}
    public boolean getEstaAbierta(){return this.estaAbierto;}

    public boolean ocuparMesa(int mesa){

        if (mesas[mesa]){
            return false;
        }else {
            mesas[mesa] = true;
            return true;
        }


    }

    public boolean librerarMesa(int mesa){

        if (!mesas[mesa]){
            return false;
        }else {
            mesas[mesa] = false;
            return true;
        }

    }

    public boolean consultarMesa(int mesa){
        return mesas[mesa];

    }

    public void mostrarMesas(){

        System.out.println("==========ESTADO DE LAS MESAS===========");
        for (int i = 0; i<mesas.length; i++){
            System.out.print("Mesa " + (i+1) + ": " );

            if (!mesas[i]){
                System.out.print("LIBRE");
            }else {
                System.out.print("OCUPADO");

            }
            System.out.println();

        }

    }

    public void estadisticas(){

        System.out.println("========== ESTADÍSTICAS DE OCUPACIÓN ==========");
        System.out.println();
        System.out.print("Mesas totales: " + getNum_mesas());

        System.out.print("Mesas ocupadas: " + mesasTotalesOcupadas());
        System.out.print("Mesas libres: " + (getNum_mesas()-mesasTotalesOcupadas()));
        System.out.print("Porcentaje de ocupación: " + mesasTotalesOcupadas()/getNum_mesas()*100 + " %");




    }

    public void calcularIngresosEstimados(int mesasOcupadas){
        System.out.println("========== INGRESOS ESTIMADOS ==========");
        System.out.println("Mesas ocupadas: " + mesasOcupadas + " €");
        System.out.println("Precio medio: " + mesasOcupadas*getPrecio_medio() + " €");


    }

    public int mesasTotalesOcupadas(){

        int contador = 0;
        for (int i = 0; i<this.mesas.length; i++){
            if (mesas[i]){
                contador++;
            }
        }
        return contador;

    }

    @Override
    public String toString(){

        if (getEstaAbierta()) {
            return "========== INFORMACIÓN DE LA CAFETERÍA ==========\nNombre: " + getNombre() + "\nDirección: " + getDireccion() + "\nCiudad: " + getCiudad() + "\nPrecio Medio: " + getPrecio_medio() + " €\nNúmero de mesas: " + getNum_mesas() + "\nEstado: ABIERTA";
        }else{
            return "========== INFORMACIÓN DE LA CAFETERÍA ==========\nNombre: " + getNombre() + "\nDirección: " + getDireccion() + "\nCiudad: " + getCiudad() + "\nPrecio Medio: " + getPrecio_medio() + " €\nNúmero de mesas: " + getNum_mesas() + "\nEstado: CERRADA";

        }
    }



}
