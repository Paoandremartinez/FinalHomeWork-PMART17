import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leerOpcion = new Scanner(System.in);
        int opcion = 0; // variable utilizada en el menu principal
        int opc1=0; // Variable para menu Agregar producto
        int opc2=0; // Variable para menu Actualizar producto
        int opc3=0; // Variable para menu Eliminar producto
        int opc4=0; // Variable para menu buscar por categoria

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
                        System.out.println("Digita una opción del menú");
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
                        Menu.actualizarProducto();
                        System.out.println("Digita una opción del menú");
                        while (!leerOpcion.hasNextInt()) {
                            System.out.println("Por favor digita una opción valida");
                            leerOpcion.next();
                            System.out.println("Ingresa la opción");
                        }
                        opc2 = leerOpcion.nextInt();

                        switch (opc2) {
                            case 1:
                                System.out.println("Editando producto por Id");
                                Inventario.actualizarProductoId();

                                break;
                            case 2:
                                System.out.println("Editando producto por nombre");
                                Inventario.actualizarProductoPorNombre();
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
                    do {
                        Menu.eliminarProducto();
                        System.out.println("Digita una opción del menú");
                        while (!leerOpcion.hasNextInt()) {
                            System.out.println("Por favor digita una opción valida");
                            leerOpcion.next();
                            System.out.println("Ingresa la opción");
                        }
                        opc3 = leerOpcion.nextInt();

                        switch (opc3) {
                            case 1:
                                System.out.println("Eliminando producto por Id");
                                Inventario.eliminarProductoPorId();
                                break;
                            case 2:
                                System.out.println("Eliminando producto por nombre");
                                Inventario.eliminarProductoPorNombre();
                                break;
                            case 3:
                                System.out.println("Vuelve después..... ");
                                break;
                            default:
                                System.out.println("Número no válido, por favor verifique");
                        }

                    }while (opc3 != 3);
                    break;
                case 4:
                    do {
                        System.out.println("*******************************************************************");
                        System.out.println("*******               4. Buscar por categoria            **********");
                        System.out.println("*******************************************************************");
                        System.out.println("*  Para buscar por categoria tiene las siguientes opciones:       *");
                        System.out.println("*                                                                 *");
                        System.out.println("*  1. Buscar por categoria                                        *");
                        System.out.println("*  2. Buscar por id producto                                      *");
                        System.out.println("*  3. Buscar por nombre de producto                               *");
                        System.out.println("*  4. Me arrepenti, no quiero hacer nada :D                       *");
                        System.out.println("*                                                                 *");
                        System.out.println("*******************************************************************");
                        System.out.println("Digita una opción del menú");
                        while (!leerOpcion.hasNextInt()) {
                            System.out.println("Por favor digita una opción valida");
                            leerOpcion.next();
                            System.out.println("Ingresa la opción");
                        }
                        opc4 = leerOpcion.nextInt();

                        switch (opc4) {
                            case 1:
                                System.out.println("Buscar por Categoria");
                                Categoria.buscarPorCategoria();
                                break;
                            case 2:
                                System.out.println("Buscar por Id Producto");

                                break;
                            case 3:
                                System.out.println("Buscar por Nombre de Producto");
                                break;
                            case 4:
                                System.out.println("Vuelve después..... ");
                                break;
                            default:
                                System.out.println("Número no válido, por favor verifique");
                        }

                    }while (opc4 != 4);
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