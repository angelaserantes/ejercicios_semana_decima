package com.ejercicio.parking;
import java.security.PublicKey;

public class Parking {

    String[] plazas;

    public Parking(int tparking) {
        plazas = new String[tparking];

    }

    public boolean ComprobarEspaciosCamion() {
        int contadorcamion = 0;
        for (int i = 0; i <= plazas.length - 1; i++) {
            if (plazas[i] == null && i< plazas.length -1) {
                if (plazas[i + 1] == null) {
                    contadorcamion++;
                }
            }
        }
        if (contadorcamion !=0){
            return true;}
        else {
            return false;
        }
    };


    public boolean Comprobarespacios (){
        int contador =0;
        for (int i = 0; i <= plazas.length -1 ; i++) {
            if (plazas[i] != null) {
                contador++;

            }

        }
        if (contador < plazas.length){

            return true;

        }
        else {
            return false;
        }

    }

    public void guardarVehiculo(Vehiculo vehiculo) {



        if (vehiculo.getTipovehiculo() == 1) {

            for (int i = 0; i <= plazas.length - 1; i++) {
                if (plazas[i] == null) {
                    plazas[i] = vehiculo.getMatricula();
                    break;
                }
            }

        } else {

            for (int i = 0; i <= plazas.length - 1; i++)
                if (plazas[i] == null) {
                    if (plazas[i + 1] == null) {
                        plazas[i] = vehiculo.getMatricula();
                        plazas[i + 1] = plazas[i];
                        break;
                    }

                }

        }
    }






    public void MostrarMatricula() {
        for (int i = 0; i <= plazas.length -1; i++) {

            System.out.println("Plaza " + i + " Matricula " + plazas[i]);

        }
    }

    public void SalirMatricula(String Matricula){

        for (int i = 0; i <= plazas.length - 1; i++){

            if ( plazas[i] !=null && plazas[i].equals(Matricula)){
                System.out.println("La matricula " + plazas[i] + " ha sido eliminada");
                plazas[i]=null;

            }

        }

    }
    public void SalirMatriculaPosicion(int Posicion){
        for (int i = 0; i <= plazas.length - 1; i++){
            if (plazas[Posicion]==plazas[Posicion+1]   ){
                String MatriculaBorrada = plazas[Posicion];
                plazas[Posicion] = null;
                plazas[Posicion + 1] = null;
                System.out.println("Has borrado la matrícula: " + MatriculaBorrada);
                break;
            }else if(Posicion!=0 && plazas[Posicion]==plazas[Posicion-1]  ){
                String MatriculaBorrada = plazas[Posicion];
                plazas[Posicion] = null;
                plazas[Posicion - 1] = null;
                System.out.println("Has borrado la matrícula: " + MatriculaBorrada);
                break;

            } else if (i==Posicion ){
                String MatriculaBorrada = plazas[Posicion];
                plazas[Posicion]=null;
                System.out.println("Has borrado la matrícula" + MatriculaBorrada);
                break;
            } else {
                System.out.println("No es una posicion valida");
                break;
            }
        }

    }
    public void SalirMatriculaAleatoria(){
        int salir = (int) (Math.random() * plazas.length - 1);
        for (int i = 0; i <= plazas.length - 1; i++) {
            if (plazas[salir] == plazas[salir + 1])  {
                String MatriculaBorrada = plazas[salir];
                plazas[salir] = null;
                plazas[salir + 1] = null;
                System.out.println("Has borrado la matrícula " + MatriculaBorrada);
                break;
            }else if (salir!=0 && plazas[salir] == plazas[salir - 1]) {
                String MatriculaBorrada = plazas[salir];
                plazas[salir] = null;
                plazas[salir - 1] = null;
                System.out.println("Has borrado la matrícula " + MatriculaBorrada);
                break;
            } else if (i == salir) {
                String MatriculaBorrada = plazas[salir];
                plazas[salir] = null;
                System.out.println("Has borrado la matrícula " + MatriculaBorrada);
                break;
            }
        }
    }

    public  void BuscadorMatriculas (String Matricula){
        int contar=0;
        for (int i = 0; i <= plazas.length - 1; i++){

            if ( plazas[i] !=null && plazas[i].equals(Matricula)){
                System.out.println( "La matrícula está aparcada en la plaza " + i);
                contar++;

            }

        }
        if (contar==0){
            System.out.println("La matrícula indicada no existe en el parking");
        }

    }


}
