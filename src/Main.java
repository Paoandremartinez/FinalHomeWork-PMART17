import utilidades.ValidacionOpcion;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leerOpcion = new Scanner(System.in);
        int opcion = 0; // variable utilizada en el menu principal
        int opc1 = 0; // Variable para menu Agregar producto
        int opc2 = 0; // Variable para menu Actualizar producto
        int opc3 = 0; // Variable para menu Eliminar producto
        int opc4 = 0; // Variable para menu buscar por categoria

        do {
            Menu.menuPrincipal();
            //Digitar la opción del menú principal

            System.out.println("Digita una opción del menú");
            ValidacionOpcion.validarOpcion(leerOpcion);


            //Casos
            opcion = leerOpcion.nextInt();
            switch (opcion) {
                case 1:
                    do {
                        Menu.agregarProducto();
                        System.out.println("Digita una opción del menú");
                        ValidacionOpcion.validarOpcion(leerOpcion);
                        opc1 = leerOpcion.nextInt();

                        switch (opc1) {

                            case 1:
                                Inventario.agregarProducto();
                                break;
                            default:
                                System.out.println("Vuelve después..... ");

                        }
                    } while (opc1 != 2);
                    break;

                case 2:
                    do {
                        Menu.actualizarProducto();
                        System.out.println("Digita una opción del menú");
                        ValidacionOpcion.validarOpcion(leerOpcion);
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

                    } while (opc2 != 3);
                    break;


                case 3:
                    do {
                        Menu.eliminarProducto();
                        System.out.println("Digita una opción del menú");
                        ValidacionOpcion.validarOpcion(leerOpcion);
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

                    } while (opc3 != 3);
                    break;
                case 4:
                    do {
                        Menu.buscarPorCategoria();

                        ValidacionOpcion.validarOpcion(leerOpcion);
                        opc4 = leerOpcion.nextInt();

                        switch (opc4) {
                            case 1:
                                System.out.println("Buscar por Categoria");
                                Categoria.buscarPorCategoria();
                                break;
                            case 2:
                                System.out.println("Buscar por Id Producto");
                                Categoria.buscarPorIdProducto();

                                break;
                            case 3:
                                System.out.println("Buscar por Nombre de Producto");
                                Categoria.buscarPorNombreProducto();
                                break;
                            case 4:
                                System.out.println("Vuelve después..... ");
                                break;
                            default:
                                System.out.println("Número no válido, por favor verifique");
                        }

                    } while (opc4 != 4);
                    break;
                case 5:
                    Reporte.generarReporte();
                    break;
                case 6:
                    Categoria.CantidadProducPorCategoria();
                    break;
                case 7:
                    Reporte.productoMasCaro();
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
        while (opcion != 8);
        System.out.println("Vuelve pronto...");
        leerOpcion.close();


    }
}