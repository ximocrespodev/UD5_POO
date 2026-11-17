import java.time.*;
import java.time.format.*;
public class MisionEspacial {

    private String nombreMision;
    private String cohete;
    private LocalDate fechaDespegue;
    private LocalTime horaDespegue;
    private LocalDateTime registroControl;

    public MisionEspacial(String nombreMision, String cohete, LocalDate fechaDespegue, LocalTime horaDespegue){


        this.nombreMision = nombreMision;
        this.cohete = cohete;
        this.fechaDespegue = fechaDespegue;
        this.horaDespegue = horaDespegue;
        this.registroControl = LocalDateTime.now();
    }

    public void setNombreMision(String nombreMision){this.nombreMision = nombreMision;}
    public void setCohete(String cohete){this.cohete = cohete;}
    public void setFechaDespegue(LocalDate fecha){this.fechaDespegue = fecha;}
    public void setHoraDespegue(LocalTime hora){this.horaDespegue = horaDespegue;}

    public String getNombreMision(){return this.nombreMision;}
    public String getCohete(){return this.cohete;}
    public LocalDate getFechaDespegue(){return this.fechaDespegue;}
    public LocalTime getHoraDespegue(){return this.horaDespegue;}
    public LocalDateTime getRegistroControl(){return this.registroControl;}
    

    public void retrasarMision(int dias, int horas){

        setFechaDespegue(fechaDespegue.plusDays(dias));
        setHoraDespegue(horaDespegue.plusHours(horas));

    }

    public boolean estaPendiente(){

        if (getFechaDespegue().isAfter(LocalDate.now())) {
            return true;
        }
        return false;

    }

    @Override 
    public String toString(){

        //1. formateo de fecha
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/YY");
        //2. formateo de hora
        DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm");
        //variableinterna.format(formato)
        DateTimeFormatter formatoRegistro = DateTimeFormatter.ofPattern("dd/MM/YY HH:mm");
        

        if (estaPendiente()){
        return getNombreMision() + "(Cohete: " + getCohete() + ") \n Despegue: " + getFechaDespegue().format(formatoFecha) + " a las " + getHoraDespegue().format(formatoHora) + "\n Estado: En cuentra atrás (Pendiente)\n+ Aprobada en sistema: " + getRegistroControl().format(formatoRegistro);

        }else{
        return getNombreMision() + "(Cohete: " + getCohete() + ") \n Despegue: " + getFechaDespegue().format(formatoFecha) + " a las " + getHoraDespegue().format(formatoHora) + "\n Estado: Misión lanzada (Completada) \n+ Aprobada en sistema: " + getRegistroControl().format(formatoRegistro);

        }





    }





}
