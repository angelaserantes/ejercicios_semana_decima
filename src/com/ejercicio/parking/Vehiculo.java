package com.ejercicio.parking;

public class Vehiculo {

    private String matricula;

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    private int tipovehiculo;

    public int getTipovehiculo() {
        return tipovehiculo;
    }

    public void setTipovehiculo(int tipovehiculo) {
        this.tipovehiculo = tipovehiculo;
    }

    public static String generarMatricula() {
        char[] letras = {'B', 'C', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'V',
                'W', 'X', 'Y', 'Z'};
        String matricula = "";

        for (int i = 0; i < 7; i++) {

            int numerosm = (int) (Math.random() * 10);
            int posicionletra = (int) (Math.random() * 20);
            if (i > 3) {
                matricula += letras[posicionletra];
            } else
                matricula += numerosm;


        }
        return matricula;

    }
    public static int generarTipovehiculo(){
        int p = (int) (Math.random() * 2 + 1 );
        return p;

    }
}
