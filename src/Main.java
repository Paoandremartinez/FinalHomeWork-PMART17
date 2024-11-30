import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leerOpcion = new Scanner(System.in);
        int opcion = 0; // variable utilizada en el menu principal
        int opc1=0; // Variable para menu Agregar producto
        int opc2=0; // Variable para menu Actualizar producto

        do {
            Menu.menuPrincipal();
            //Digitar la opción del menú principal
            System.out.println("Digita una opción del menú");
            while (!leerOpcion.hasNextInt()) {
                System.out.println("Por favor digita una opción valida");
                leerOpcion.next();
                System.out.println("Ingresa la opción");
            }

            //Casos
            opcion = leerOpcion.nextInt();
            switch (opcion) {
                case 1:
                    do {
                        Menu.agregarProducto();
                        while (!leerOpcion.hasNextInt()) {
                            System.out.println("Por favor digita una opción valida");
                            leerOpcion.next();
                            System.out.println("Ingresa la opción");
                        }
                        opc1 = leerOpcion.nextInt();

                        switch (opc1) {

                            case 1:
                                Inventario.agregarProducto();
                                break;
                            default:
                                System.out.println("Vuelve después..... ");

                        }
                    }while (opc1 != 2);
                    break;

                case 2:
                    do {
                        System.out.println("*******************************************************************");
                        System.out.println("*******               2. Actualizar Producto             **********");
                        System.out.println("*******************************************************************");
                        System.out.println("*  Para actualizar el catalogo de producto lo puedes hacer por    *");
                        System.out.println("*  las siguientes opciones:                                       *");
                        System.out.println("*                                                                 *");
                        System.out.println("*  1. Id Producto                                                 *");
                        System.out.println("*  2. Nombre Producto                                             *");
                        System.out.println("*  3. Me arrepenti, no quiero hacer nada :D                       *");
                        System.out.println("*                                                                 *");
                        System.out.println("*******************************************************************");

                        while (!leerOpcion.hasNextInt()) {
                            System.out.println("Por favor digita una opción valida");
                            leerOpcion.next();
                            System.out.println("Ingresa la opción");
                        }
                        opc2 = leerOpcion.nextInt();
                        System.out.println("prueba"+opc2);
                        switch (opc2) {
                            case 1:
                                System.out.println("Editando producto");
                                Inventario.actualizarProductoId();

                                break;
                            case 2:
                                System.out.println("Funcionalidad en Contrucción");
                                break;
                            case 3:
                                System.out.println("Vuelve después..... ");
                                break;
                            default:
                                System.out.println("Número no válido, por favor verifique");
                        }

                    }while (opc2 != 3);
                    break;


                case 3:
                    System.out.println("*******************************************************************");
                    System.out.println("*******               3. Eliminar Producto               **********");
                    System.out.println("*******************************************************************");
                    System.out.println("*                                                                 *");
                    System.out.println("*******************************************************************");
                    break;
                case 4:
                    System.out.println("*******************************************************************");
                    System.out.println("*******               4. Buscar por categoria            **********");
                    System.out.println("*******************************************************************");
                    System.out.println("*                                                                 *");
                    System.out.println("*******************************************************************");
                    break;
                case 5:
                    System.out.println("*******************************************************************");
                    System.out.println("*******               5. Generar Reporte                 **********");
                    System.out.println("*******************************************************************");
                    System.out.println("*                                                                 *");
                    System.out.println("*******************************************************************");
                    break;
                case 6:
                    System.out.println("*******************************************************************");
                    System.out.println("*******     6. Cantidad de productos por categoría       **********");
                    System.out.println("*******************************************************************");
                    System.out.println("*                                                                 *");
                    System.out.println("*******************************************************************");
                    break;
                case 7:
                    System.out.println("*******************************************************************");
                    System.out.println("*******                7. Producto más caro              **********");
                    System.out.println("*******************************************************************");
                    System.out.println("*                                                                 *");
                    System.out.println("*******************************************************************");
                    break;
                default:
                    if
                    (opcion != 8) {
                        System.out.println("Si quieres volver al menú Principal presiona enter");
                        leerOpcion.nextLine();
                        leerOpcion.nextLine();

                    }
            }




        }
            while (opcion != 8) ;
            System.out.println("Vuelve pronto...");
            leerOpcion.close();





    System.out.println( );
    }
}