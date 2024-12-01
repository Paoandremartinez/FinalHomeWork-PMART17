package utilidades;

import java.util.Scanner;

public class ValidacionOpcion{
    public static void validarOpcion (Scanner leerOpcion){
        while (!leerOpcion.hasNextInt()) {
            System.out.println("Por favor digita una opción valida");
            leerOpcion.next();
            System.out.println("Ingresa la opción");
        }
}



}
