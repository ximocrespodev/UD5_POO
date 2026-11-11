public class Autoescuela {

    private String nombreAutoescuela;
    private Alumno[] alumnos;
    private int contadorAlumnos;


    public Autoescuela(String nombre, int cantidadAlumnos){

        this.nombreAutoescuela = nombre;
        this.contadorAlumnos = 0;
        this.alumnos = new Alumno[cantidadAlumnos];


    }

    public boolean matricularAlumno(Alumno a){

        if (contadorAlumnos >= alumnos.length){
            return false;
        }
        else {

            for (int i = 0; i<this.contadorAlumnos; i++){
                if (a == alumnos[i]){
                    return false;
                }
            }

        }

        alumnos[this.contadorAlumnos] = a;
        this.contadorAlumnos++;
        return true;


    }

    public boolean realizarExamenPractico(String nombre, int erroresCometidos){

        int indiceAlumno = alumnoExiste(nombre);

        if (indiceAlumno >= 0 && !alumnos[indiceAlumno].getTieneCarnet()){

            alumnos[indiceAlumno].setIntentosExamen(1+alumnos[indiceAlumno].getIntentosExamen());

            for (int i = 1; i<erroresCometidos; i++){

                alumnos[indiceAlumno].setPuntosInfractores(alumnos[indiceAlumno].getPuntosInfractores()+15);

                if (alumnos[indiceAlumno].getPuntosInfractores() <= 60){
                    System.out.println("HAS SUPERADO EL LIMITE DE INTENTOS");
                    return false;
                }
                alumnos[indiceAlumno].setTieneCarnet(true);

            }

        }else {
            System.out.println("ERROR: Ya tienes carnet o no eres alumno de esta AUTOESCUELA");
            return false;
        }
        return false;
    }

    public int alumnoExiste(String nombreAlumno){


        for (int i=0; i<this.contadorAlumnos; i++){

            if (alumnos[i].getNombre().equalsIgnoreCase(nombreAlumno)){
                return i;
            }
        }
        return -1;
    }

    public Alumno obtenerAlumnoMasPeligroso(){

        if (this.contadorAlumnos <= 0){
            return null;
        }else {

            int topeInfractores = 0;
            Alumno topeAlumno = null;
            for (int i = 0; i<this.contadorAlumnos; i++){

                if (alumnos[i].getPuntosInfractores() >= topeInfractores){
                    topeInfractores = alumnos[i].getPuntosInfractores();
                    topeAlumno = alumnos[i];
                }


        }

            return topeAlumno;




        }


    }

    @Override
    public String toString() {

        String valorFinal = "";
        if (this.contadorAlumnos > 0) {

            for (int i = 0; i < this.contadorAlumnos; i++) {
                valorFinal += alumnos[i].toString() + "\n";

            }

        } else {

            return "ERROR: NO tienes alumnos";
        }
        return valorFinal;
    }
        }
