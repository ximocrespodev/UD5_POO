public class Apartamento {

    private String nombre;
    private String direccion;
    private String ciudad;
    private int precio_noche;
    private boolean[][] reservas;
    private int numeroHuespedes;


            private static final int[] DIAS_MES = {31, 28, 31, 30, 31, 30,
                    31, 31, 30, 31, 30, 31};

            private static final String[] MESES_ESCRITO = {"Enero", "Febrero" ,"Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};

            //CONSTRUCTOR
            public Apartamento(String nombre, String direccion, String ciudad, int precioNoche, int numeroHuespedes) {

                this.nombre = nombre;
                this.direccion = direccion;
                this.ciudad = ciudad;
                this.precio_noche = precioNoche;
                this.reservas = new boolean[12][];
                this.numeroHuespedes = numeroHuespedes;

                //Creamos las subarrays dentro del mes
                for (int mes = 0; mes < 12; mes++) {
                    this.reservas[mes] = new boolean[DIAS_MES[mes]];
                }
            }

            public void setNombre(String nombre){
                this.nombre = nombre;
            }
            public void setDireccion(String direccion){
                this.direccion = direccion;
            }
            public void setCiudad(String ciudad){
                this.ciudad = ciudad;
            }
            public void setPrecioNoche(int precio){
                this.precio_noche = precio;
            }
            public void setNumeroHuespedes(int numero){this.numeroHuespedes = numero;}

            public String getNombre(){return this.nombre;}
            public String getDireccion(){return this.direccion;}
            public String getCiudad(){return this.ciudad;}
            public int getPrecioNoche(){return this.precio_noche;}
            public int getNumeroHuespedes(){return this.numeroHuespedes;}

            @Override
            public String toString(){
                return "Nombre: " + getNombre() + " Direccion: " + getDireccion() + " Precio PN: " + getPrecioNoche() +"€ Numero de huespedes:" + getNumeroHuespedes();
            }

            public void reservar(int mes, int dia, int numeroHuespedes){

                if (!esFechaValida(mes, dia)){
                    System.out.println("ERROR: La fecha introducida no es valida.");
                }else if (estaOcupado(mes, dia)){
                    System.out.println("ERROR: El alojamiento ya se encuentra reservado en esas fechas.");
                } else if (numeroHuespedes>getNumeroHuespedes()) {
                    System.out.println("ERROR: El numero de huespedes es mayor al permitido");
                } else {
                    this.reservas[mes][dia] = true;
                    System.out.println("Noche del día " + (dia+1) + " de " + nombreMes(mes) + " reservada.");
                }
            }

            public boolean estaOcupado(int mes, int dia){

                if (this.reservas[mes][dia]){
                    return true;
                }else {
                    return false;
                }
            }

            public void liberar(int mes, int dia){
                if (this.reservas[mes][dia]){
                    this.reservas[mes][dia] = false;
                }else {
                    System.out.println("ERROR: YA SE ENCUENTRA LIBERADA");
                }
            }


            public boolean esFechaValida(int mes, int dia){

                if (mes <= this.reservas.length-1 && mes >= 0 && dia <= this.reservas[mes].length-1  && dia >= 0){
                    return true;
                }else {
                    return false;
                }

            }

            public void mostrarCalendarioMensual(int mes){

                System.out.println("==="+nombreMes(mes)+"===");
                String valor = "";
                int contador = 0;

                for (int i = 0; i<this.reservas[mes].length-1; i++){

                    if (estaOcupado(mes, i)){
                        valor = "X";
                    }else {
                        valor = " ";
                    }

                    if (i<10){

                        if (i==8){
                            System.out.print(" "+(i+1) + ":[" + valor + "]");

                        }else {
                        System.out.print(" "+(i+1) + ":[" + valor + "] ");
                        }

                    }else {
                        System.out.print((i+1) + ":[" + valor + "] ");

                    }

                    contador++;

                    if (contador >= 7){
                        contador=0;
                        System.out.println();
                    }

                }

            }

            public void mostrarCalendarioAnual(){

                for (int i = 0; i<=this.reservas.length-1; i++){

                    mostrarCalendarioMensual(i);
                    System.out.println();
                }

            }

            public String nombreMes(int num){

                return MESES_ESCRITO[num];

            }

            public int totalDiasLibres(int mes){
                int libre = 0;

                for (int i = 0; i<=this.reservas[mes].length-1; i++){

                    if (!estaOcupado(mes, i)){
                        libre++;
                    }
                }
                return libre;
            }

            public int totalDiasOcupados(int mes){

                int ocupado = 0;

                for (int i = 0; i<=this.reservas[mes].length-1; i++){

                    if (estaOcupado(mes, i)){
                        ocupado++;
                    }
                }
                return ocupado;

            }

            public int totalDiasOcupadosAnyo(){

                int ocupado = 0;

                for (int i = 0; i<=this.reservas.length-1; i++){

                    ocupado += totalDiasOcupados(i);
                }
                return ocupado;

            }

            public void beneficiosMes(int mes){

                double bruto = totalDiasOcupados(mes) * (double) getPrecioNoche();
                double suministros = bruto * 0.05; // electricidad, agua, Internet
                double limpieza = bruto * 0.05;
                double impuestos = bruto * 0.30;
                double neto = bruto - suministros - limpieza - impuestos;


                System.out.println("--- BENEFICIOS DE " + nombreMes(mes) + "---");

                System.out.println("Noches ocupadas:   " + totalDiasOcupados(mes));
                System.out.println("Precio por noche:   " + getPrecioNoche() + "€");
                System.out.println("Beneficio bruto:   " + bruto + "€");
                System.out.println("Suministros (5%):   " + suministros);
                System.out.println("Limpieza (5%):   " + limpieza);
                System.out.println("Impuestos (30%):   " + impuestos);
                System.out.println("Beneficio neto:   " + neto);

            }
            public void beneficiosAno(){

                double bruto = totalDiasOcupadosAnyo() * (double) getPrecioNoche();
                double suministros = bruto * 0.05; // electricidad, agua, Internet
                double limpieza = bruto * 0.05;
                double impuestos = bruto * 0.30;
                double neto = bruto - suministros - limpieza - impuestos;


                System.out.println("--- BENEFICIOS DEL AÑO---");

                System.out.println("Noches ocupadas:   " + totalDiasOcupadosAnyo());
                System.out.println("Precio por noche:   " + getPrecioNoche() + "€");
                System.out.println("Beneficio bruto:   " + bruto + "€");
                System.out.println("Suministros (5%):   " + suministros);
                System.out.println("Limpieza (5%):   " + limpieza);
                System.out.println("Impuestos (30%):   " + impuestos);
                System.out.println("Beneficio neto:   " + neto);


            }


            public int nochesLibres(int mes){

                int nochesLibres = 0;

                for (int i = 0; i<=this.reservas[mes].length-1; i++){

                    if (estaOcupado(mes, i)){
                        nochesLibres++;
                    }

                }
                return nochesLibres;


            }


        }


