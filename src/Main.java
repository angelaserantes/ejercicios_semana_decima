
import com.ejercicio.parking.Parking;
import com.ejercicio.parking.Vehiculo;
import java.util.Scanner;
import java.sql.SQLOutput;
public class Main {
    public static void main(String[] args) {
        Scanner datos = new Scanner(System.in);
        Parking par = new Parking(10);
        Vehiculo veh = new Vehiculo();
        int opcion = 0;
        boolean espaciosdisp;
        boolean espaciodispcamion;

        System.out.println("Bienvenido/a al parking, ¿qué deseas hacer?");
        do {
            espaciosdisp = par.Comprobarespacios();
            espaciodispcamion = par.ComprobarEspaciosCamion();
            System.out.println("0- Pulsa 0 para generar matrícula y autoguardar");
            System.out.println("1- Pulsa 1 para introducir el vehículo manualmente");
            System.out.println("2- Pulsa 2 para ver las matrículas registradas");
            System.out.println("3- Pulsa 3 para buscar tu matrícula");
            System.out.println("4- Pulsa 4 para eliminar tu matrícula del Parking");
            System.out.println("5- Pulsa 5 para borrar la plaza de forma manual");
            System.out.println("6- Pulsa 6 para borrar la plaza de forma aleatoria");
            System.out.println("7- Pulsa 7 para salir");
            opcion = datos.nextInt();
            switch (opcion) {
                case 0:
                    int tipoveh = veh.generarTipovehiculo();
                    if (espaciosdisp && espaciodispcamion || espaciosdisp && tipoveh == 1) {
                        System.out.println("Has elegido generar matrícula");
                        veh.setMatricula(veh.generarMatricula());
                        veh.setTipovehiculo(tipoveh);
                        par.guardarVehiculo(veh);
                        break;

                    } else {
                        System.out.println("El parking está lleno");

                    }

                    break;

                case 1:
                    if (espaciosdisp) {
                        System.out.println("Introduce el tipo de tu vehiculo: Pulsa 1 para seleccionar coche o pulsa 2 para seleccionar camión");

                        int tvehiculo = datos.nextInt();
                        if (tvehiculo == 2 && espaciodispcamion) {
                            System.out.println("Introduce tu matrícula");
                            String matriculam = datos.next();
                            veh.setTipovehiculo(tvehiculo);
                            veh.setMatricula(matriculam);
                            par.guardarVehiculo(veh);
                            break;
                        } else if (tvehiculo == 1) {
                            System.out.println("Introduce tu matrícula");
                            String matriculac = datos.next();
                            veh.setTipovehiculo(tvehiculo);
                            veh.setMatricula(matriculac);
                            par.guardarVehiculo(veh);
                            break;

                        } else {
                            System.out.println("Actualmente no hay espacio para el camión");
                            break;
                        }


                    }else{
                        System.out.println("El parking está lleno ");
                        break;
                    }

                case 2:
                    System.out.println("Las matrículas registradas son: ");
                    par.MostrarMatricula();
                    break;

                case 3:
                    System.out.println("Introduce la matrícula que quieres buscar");
                    String Bmatricula = datos.next();
                    par.BuscadorMatriculas(Bmatricula);
                    break;

                case 4:
                    System.out.println("Introduce la matrícula que quieres borrar");
                    String matricula = datos.next();
                    par.SalirMatricula(matricula);
                    break;

                case 5:
                    System.out.println("Introduce la plaza que quieres borrar");
                    int posicion = datos.nextInt();
                    par.SalirMatriculaPosicion(posicion);
                    break;

                case 6:
                    par.SalirMatriculaAleatoria();
                    System.out.println("Has borrado una plaza de forma aleatoria");
                    break;

                case 7:
                    System.out.println("Hasta la próxima, gracias por venir a nuestro parking");
                    break;

                default:
                    System.out.println("La opción elegida no está disponible");
            }
        }
        while (opcion != 7);
    }


}



