import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FilterReader;
import java.io.IOException;
import java.util.*;

public class Categoria {
    private static final String leerArchivo = "D:\\PMARTINEZ\\Data\\ListaProducto.txt";
    private static List<Producto> listaProductos = new ArrayList<>();
    private String nombreCategoria;


    public Categoria() {

    }

    public static void buscarPorCategoria() {
        List<Producto> listaProductosActualizar = Inventario.leerProducto();
        System.out.println("Id Producto\t\tNombre Producto\t\tCategoria\t\tPrecio\t\tCantidad Disponible");

        for (Producto producto : listaProductosActualizar) {
            System.out.println(producto.getIdProducto() + "\t\t\t\t" + producto.getNombreProducto() + "\t\t\t\t" + producto.getCategoria() + "\t\t\t" + producto.getPrecio() + "\t\t\t" + producto.getCantidadDisponible());
        }
        try {
            Scanner scanProduc = new Scanner(System.in);
            System.out.println("Nombre Categoria ");
            String categoria = scanProduc.nextLine();

            List<Producto> productos = Inventario.leerProducto();
            List<Producto> productosDeLaCategoria = new ArrayList<>();

            for (Producto producto : productos) {
                if (producto.getCategoria().equalsIgnoreCase(categoria)) {
                    productosDeLaCategoria.add(producto);
                }
            }

            if (!productosDeLaCategoria.isEmpty()) {
                System.out.println("Id Producto\tNombre Producto\tCategoria\tPrecio\tCantidad Disponible");
                for (Producto producto : productosDeLaCategoria) {
                    System.out.println(producto.getIdProducto() + "\t\t\t\t" + producto.getNombreProducto() + "\t\t\t\t" + producto.getCategoria() + "\t\t\t\t" + producto.getPrecio() + "\t\t\t" + producto.getCantidadDisponible());
                }
            } else {
                System.out.println("No existen productos asociados a esa categoria");


            }

        } catch (NumberFormatException e) {
            System.out.println("Intenta nuevamente ");
        }

    }

    public static void buscarPorNombreProducto() {
        List<Producto> listaProductosActualizar = Inventario.leerProducto();
        System.out.println("Id Producto\t\tNombre Producto\t\tCategoria\t\tPrecio\t\tCantidad Disponible");
        for (Producto producto : listaProductosActualizar) {
            System.out.println(producto.getIdProducto() + "\t\t\t\t" + producto.getNombreProducto() + "\t\t\t\t" + producto.getCategoria() + "\t\t\t" + producto.getPrecio() + "\t\t\t" + producto.getCantidadDisponible());
        }
        Scanner scanProduc = new Scanner(System.in);
        try {
            System.out.println("Ingrese el Nombre del Producto ");
            String categoriaNombreProducto = scanProduc.nextLine();

            List<Producto> productos = Inventario.leerProducto();
            List<Producto> productosDeLaCategoria = new ArrayList<>();

            for (Producto producto : productos) {
                if (producto.getNombreProducto().equalsIgnoreCase(categoriaNombreProducto)) {
                    productosDeLaCategoria.add(producto);
                }
            }

            if (!productosDeLaCategoria.isEmpty()) {
                for (Producto producto : productosDeLaCategoria) {
                    filtroCategoria(producto.getCategoria());
                    //System.out.println(producto.getIdProducto()+"\t\t"+producto.getNombreProducto()+"\t"+producto.getCategoria()+"\t"+producto.getPrecio()+"\t"+ producto.getCantidadDisponible());
                }
            } else {
                System.out.println("No existen productos asociados a esa categoria");
            }
        } catch (NumberFormatException e) {
            System.out.println("El dato ingresado no es correcto");
        }

    }

    public static void buscarPorIdProducto() {
        List<Producto> listaProductosActualizar = Inventario.leerProducto();
        System.out.println("Id Producto\t\tNombre Producto\t\tCategoria\t\tPrecio\t\tCantidad Disponible");
        for (Producto producto : listaProductosActualizar) {
            System.out.println(producto.getIdProducto() + "\t\t\t\t" + producto.getNombreProducto() + "\t\t\t\t" + producto.getCategoria() + "\t\t\t" + producto.getPrecio() + "\t\t\t" + producto.getCantidadDisponible());
        }

        Scanner scanProduc = new Scanner(System.in);
        try {
            System.out.println("Ingrese el Id Producto ");
            int categoriaIdProducto = Integer.parseInt(scanProduc.nextLine());

            List<Producto> productos = Inventario.leerProducto();
            List<Producto> productosDeLaCategoria = new ArrayList<>();

            for (Producto producto : productos) {
                if (producto.getIdProducto() == categoriaIdProducto) {
                    productosDeLaCategoria.add(producto);
                }
            }

            if (!productosDeLaCategoria.isEmpty()) {

                for (Producto producto : productosDeLaCategoria) {
                    filtroCategoria(producto.getCategoria());
                    //System.out.println(producto.getIdProducto()+"\t\t"+producto.getNombreProducto()+"\t"+producto.getCategoria()+"\t"+producto.getPrecio()+"\t"+ producto.getCantidadDisponible());
                }
            } else {
                System.out.println("No existen productos asociados a esa categoria");
            }
        } catch (NumberFormatException e) {
            System.out.println("El dato ingresado no es correcto");
        }


    }

    public static void filtroCategoria(String categoriaNombreProducto) {

        List<Producto> productos = Inventario.leerProducto();
        List<Producto> productosDeLaCategoria = new ArrayList<>();

        for (Producto producto : productos) {
            if (producto.getCategoria().equalsIgnoreCase(categoriaNombreProducto)) {
                productosDeLaCategoria.add(producto);
            }
        }

        if (!productosDeLaCategoria.isEmpty()) {
            System.out.println("Id Producto\t\tNombre Producto\t\tCategoria\t\tPrecio\t\tCantidad Disponible");
            for (Producto producto : productosDeLaCategoria) {
                System.out.println(producto.getIdProducto() + "\t\t\t\t" + producto.getNombreProducto() + "\t\t\t\t" + producto.getCategoria() + "\t\t\t" + producto.getPrecio() + "\t\t\t" + producto.getCantidadDisponible());
            }
        } else {
            System.out.println("No existen productos asociados a esa categoria");


        }

    }

    public static void CantidadProducPorCategoria() {
        // HashMap se utiliza para almacenar la info de la categoria (llave, valor)
        Map<String, Integer> categoriaTotal = new HashMap<>();
        try (BufferedReader leerCantProd = new BufferedReader(new FileReader(leerArchivo))) {
            String linea;
            while ((linea = leerCantProd.readLine()) != null) {
                String[] campos = linea.split(";");
                String categoria = campos[2];
                int cantidadDisponible = Integer.parseInt(campos[4]);
                // el metodo getOrDefault se usa para dar un valor cuando las claves son ausentes
                categoriaTotal.put(categoria, categoriaTotal.getOrDefault(categoria, 0) + cantidadDisponible);

            }
        } catch (IOException e) {
            //muestra con exactitud en donde esta el error de codigo
            e.printStackTrace();

        }
        for (Map.Entry<String, Integer> entry : categoriaTotal.entrySet()) {
            System.out.println("Categoria " + entry.getKey() + " Total productos por categoria: " + entry.getValue());
        }

    }
}
