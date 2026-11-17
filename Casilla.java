public class Casilla {

    private boolean descubierta;
    private boolean tieneTesoro;
    private boolean tieneTrampa;

    public Casilla(){

        this.descubierta = false;
        this.tieneTesoro = false;
        this.tieneTrampa = false;

    }

    public void setDescubierta(boolean es){this.descubierta = es;}
    public void setTieneTesoro(boolean es){this.tieneTesoro = es;}
    public void setTieneTrampa(boolean es){this.tieneTrampa = es;}

    public boolean getDescubierta(){return this.descubierta;}
    public boolean getTieneTesoro(){return this.tieneTesoro;}
    public boolean getTieneTrampa(){return this.tieneTrampa;}
    

    public int explorar(){
    
    setDescubierta(true);


     if (getTieneTesoro()) {
            return 1;
            
        }else if(getTieneTrampa()) {
            return -1;
            
            
        } else {
            return 0;
        }


    

   

    }

    @Override 
    public String toString(){
        
            if (getDescubierta() && getTieneTesoro()) {
                return "[$]";

            }else if(getDescubierta() && getTieneTrampa()){
                return "[X]";
            
            }  
            else if (!getDescubierta()){
                  return "[?]";   
                }else{
                    return "[ ]";
                }

    }


        
    }

    

    

