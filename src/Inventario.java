import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Inventario {
    private static final String leerArchivo = "D:\\PMARTINEZ\\Data\\ListaProducto.txt";

    private static List<Producto> listaProductos = new ArrayList<>();

    public Inventario() {
        listaProductos = new ArrayList<>();
    }

    public static void agregarProducto() {
        // File archivo = new File("D:\\PMARTINEZ\\Data\\ListaProducto.txt");

        System.out.println("Archivo Existe ");
        System.out.println("*******************************************************************");

        System.out.println("                         Agregar Producto                           ");

        List<Producto> listaProducto = new ArrayList<>();
        Scanner scanProduc = new Scanner(System.in);
        boolean isProductEntryComplete = false;
        while (!isProductEntryComplete) {
            System.out.println("Ingresa los siguientes datos:");
            System.out.println("Id Producto ");
            int idProducto = Integer.parseInt(scanProduc.nextLine());
            System.out.println("Nombre Producto ");
            String nombreProducto = scanProduc.nextLine();
            System.out.println("Categoria ");
            String categoria = scanProduc.nextLine();
            System.out.println("Precio ");
            double precio = Double.parseDouble(scanProduc.nextLine());
            System.out.println("Cantidad Disponible ");
            int cantidadDisponible = Integer.parseInt(scanProduc.nextLine());

            Producto producto = new Producto(idProducto, nombreProducto, categoria, precio, cantidadDisponible);
            listaProducto.add(producto);

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(leerArchivo, true))) {
                // Escribir una línea por cada producto en el ArrayList
                for (Producto producto1 : listaProducto) {
                    // Escribir los campos separados por comas (puedes cambiar el delimitador si es
                    // necesario)
                    // Se crea el String.valueOf para que se pueda leer cada tipo de dato de las
                    // variables
                    writer.write(String.join(";", String.valueOf(producto1.getIdProducto()),
                            producto1.getNombreProducto(), producto1.getCategoria(),
                            String.valueOf(producto1.getPrecio()), String.valueOf(producto1.getCantidadDisponible())));
                    writer.newLine();

                }
                System.out.println("Archivo creado con éxito.");
            } catch (IOException e) {
                System.err.println("Error al escribir en el archivo: " + e.getMessage());
            }

            isProductEntryComplete = true;
        }

    }

    public static List<Producto> leerProducto() {

        List<Producto> listaProductos = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(leerArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                int idProducto = Integer.parseInt(datos[0]);
                String nombreProducto = datos[1];
                String categoria = datos[2];
                double precio = Double.parseDouble(datos[3]);
                int cantidadDisponible = Integer.parseInt(datos[4]);
                Producto producto = new Producto(idProducto, nombreProducto, categoria, precio, cantidadDisponible);
                listaProductos.add(producto);
                // int idProducto = Integer.parseInt(linea);
//				System.out.println(listaProductos);

            }

        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        return listaProductos;
    }

    public static void actualizarProductoId() {
        List<Producto> listaProductosActualizar = Inventario.leerProducto();
        System.out.println("Id Producto\t\tNombre Producto\t\tCategoria\t\tPrecio\t\tCantidad Disponible");

        for (Producto producto : listaProductosActualizar) {
            System.out.println(producto.getIdProducto() + "\t\t\t\t" + producto.getNombreProducto() + "\t\t\t\t\t\t" + producto.getCategoria() + "\t\t\t" + producto.getPrecio() + "\t\t\t" + producto.getCantidadDisponible());
        }

        Scanner scanId = new Scanner(System.in);
        try {
            System.out.println("Ingresa el ID Producto actualizar");
            int idProducto = Integer.parseInt(scanId.nextLine());

            boolean loEncontro = false;
            for (Producto producto : listaProductosActualizar) {
                if (producto.getIdProducto() == idProducto) {
                    Scanner scanProduc = new Scanner(System.in);
                    System.out.println("Nombre Producto ");
                    String nombreProducto = scanProduc.nextLine();
                    System.out.println("Categoria ");
                    String categoria = scanProduc.nextLine();
                    System.out.println("Precio ");
                    double precio = Double.parseDouble(scanProduc.nextLine());
                    System.out.println("Cantidad Disponible ");
                    int cantidadDisponible = Integer.parseInt(scanProduc.nextLine());

                    producto.setNombreProducto(nombreProducto);
                    producto.setCategoria(categoria);
                    producto.setPrecio(precio);
                    producto.setCantidadDisponible(cantidadDisponible);
                    loEncontro = true;
                    break;
                }
            }


            if (loEncontro) {
                //Actualizar archivo
                escribirInventario(listaProductosActualizar);
            } else {
                System.out.println("No existe ese id Producto en el inventario");
            }
        } catch (NumberFormatException e) {
            System.out.println("El ID ingresado no es un número valido");
        }
    }

    public static void actualizarProductoPorNombre() {
        List<Producto> listaProductosActualizar = Inventario.leerProducto();
        System.out.println("Id Producto\t\tNombre Producto\t\t\tCategoria\t\t\tPrecio\t\t\tCantidad Disponible");

        for (Producto producto : listaProductosActualizar) {
            System.out.println(producto.getIdProducto() + "\t\t\t\t" + producto.getNombreProducto() + "\t\t\t\t\t\t" + producto.getCategoria() + "\t\t\t" + producto.getPrecio() + "\t\t\t" + producto.getCantidadDisponible());
        }

        Scanner scanId = new Scanner(System.in);
        try {
            System.out.println("Ingresa el Nombre del producto a actualizar");
            String nombreProductoActualizar = scanId.nextLine();

            boolean loEncontro = false;
            for (Producto producto : listaProductosActualizar) {
                if (producto.getNombreProducto().equalsIgnoreCase(nombreProductoActualizar)) {
                    Scanner scanProduc = new Scanner(System.in);
                    System.out.println("Nombre Producto \t\t");
                    String nombreProducto = scanProduc.nextLine();
                    System.out.println("Categoria \t\t");
                    String categoria = scanProduc.nextLine();
                    System.out.println("Precio \t\t");
                    double precio = Double.parseDouble(scanProduc.nextLine());
                    System.out.println("Cantidad Disponible \t\t");
                    int cantidadDisponible = Integer.parseInt(scanProduc.nextLine());

                    producto.setNombreProducto(nombreProducto);
                    producto.setCategoria(categoria);
                    producto.setPrecio(precio);
                    producto.setCantidadDisponible(cantidadDisponible);
                    loEncontro = true;
                    break;
                }
            }

            if (loEncontro) {
                //Actualizar archivo
                escribirInventario(listaProductosActualizar);
            } else {
                System.out.println("No existe ese nombre de Producto en el inventario");
            }
        } catch (NumberFormatException e) {
            System.out.println("El dato ingresado no es correcto");
        }
    }

    public static void eliminarProductoPorId() {
        List<Producto> listaProductos = Inventario.leerProducto();
        System.out.println("Id Producto\t\tNombre Producto\t\tCategoria\t\tPrecio\t\tCantidad Disponible");

        for (Producto producto : listaProductos) {
            System.out.println(producto.getIdProducto() + "\t\t\t\t" + producto.getNombreProducto() + "\t\t\t\t\t" + producto.getCategoria() + "\t\t\t" + producto.getPrecio() + "\t\t\t" + producto.getCantidadDisponible());
        }
        try {
            Scanner scanId = new Scanner(System.in);
            System.out.println("Ingresa el Id del producto a eliminar");
            int idProductoEliminar = Integer.parseInt(scanId.nextLine());


            boolean loEncontro = false;
            for (Producto producto : listaProductos) {

                if (idProductoEliminar == producto.getIdProducto()) {
                    listaProductos.remove(producto);
                    loEncontro = true;
                    break;
                }
            }

            if (loEncontro) {
                //Actualizar archivo
                escribirInventario(listaProductos);
            } else {
                System.out.println("No existe ese Id de Producto en el inventario");
            }
        } catch (NumberFormatException e) {
            System.out.println("El dato ingresado no es válido ");
        }

    }

    public static void eliminarProductoPorNombre() {
        List<Producto> listaProductos = Inventario.leerProducto();
        System.out.println("Id Producto\t\tNombre Producto\t\t\tCategoria\t\tPrecio\t\tCantidad Disponible");

        for (Producto producto : listaProductos) {
            System.out.println(producto.getIdProducto() + "\t\t\t\t" + producto.getNombreProducto() + "\t\t\t\t\t" + producto.getCategoria() + "\t\t\t" + producto.getPrecio() + "\t\t\t" + producto.getCantidadDisponible());
        }
        try {
            Scanner scanId = new Scanner(System.in);
            System.out.println("Ingresa el Nombre del producto a eliminar");
            String nombreProductoEliminar = scanId.nextLine();

            boolean loEncontro = false;
            for (Producto producto : listaProductos) {
                if (producto.getNombreProducto().equalsIgnoreCase(nombreProductoEliminar)) {
                    listaProductos.remove(producto);
                    loEncontro = true;
                    break;
                }
            }

            if (loEncontro) {
                //Actualizar archivo
                escribirInventario(listaProductos);
            } else {
                System.out.println("No existe ese nombre de Producto en el inventario");
            }
        }catch (NumberFormatException e) {
            System.out.println("Intenta nuevamente ");
        }
    }


    public static void escribirInventario(List<Producto> listaProducto) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(leerArchivo))) {
            // Escribir una línea por cada producto en el ArrayList
            for (Producto producto1 : listaProducto) {
                // Escribir los campos separados por comas (puedes cambiar el delimitador si es
                // necesario)
                // Se crea el String.valueOf para que se pueda leer cada tipo de dato de las
                // variables
                writer.write(String.join(";", String.valueOf(producto1.getIdProducto()),
                        producto1.getNombreProducto(), producto1.getCategoria(),
                        String.valueOf(producto1.getPrecio()), String.valueOf(producto1.getCantidadDisponible())));
                writer.newLine();

            }
            System.out.println("Archivo actualizado con éxito.");
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
}
