public class Coche {
    
    private String modelo;
    private double litrosCombustible;
    private double consumoPor100;


    public Coche(String modelo, double litrosCombustible, double consumoPor100){

        this.modelo = modelo;
        this.litrosCombustible = litrosCombustible;
        this.consumoPor100 = consumoPor100;

    }

    public void setModelo(String modelo){
        this.modelo = modelo;
    }
    public void setLitrosCombustible(double litrosCombustible){
        this.litrosCombustible = litrosCombustible;
    }
    public void setConsumoPor100(double consumopor100){
        this.consumoPor100 = consumopor100;
    }
    public String getModelo(){return this.modelo;}
    public double getLitrosCombustible(){return this.litrosCombustible;}
    public double getConsumoPor100(){return this.consumoPor100;}


    public void repostar(double litros){

        if (litros > 0){
            setLitrosCombustible(litros+getLitrosCombustible());
            System.out.println("has repostado " + litros + " litros");
        }else{
            System.out.println("Error: no puedes introducir litros negativos");

        }

    }

    public void conducir(double kilometros){

        double litrosRecorrer = kilometros*getConsumoPor100()/100;
        if (litrosRecorrer <= getLitrosCombustible()) {
        
            setLitrosCombustible(getLitrosCombustible()-litrosRecorrer);
            
            System.out.println("Has avanzado" + kilometros + "KM");
        }else{
            System.out.println("No puedes realizar esta travesia");
        }


    }

    public String toString(){
        return "MODELO: " + getModelo() + " | LITROS: " + getLitrosCombustible() + " | COMBUSTIBLE POR 100: " + consumoPor100;
    }


}
