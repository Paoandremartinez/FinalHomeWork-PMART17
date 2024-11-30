import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Inventario {
    private static final String leerArchivo ="D:\\PMARTINEZ\\Data\\ListaProducto.txt";
    private static List<Producto> listaProductos = new ArrayList<>();

    public Inventario() {
        listaProductos = new ArrayList<>();
    }
    public static void agregarProducto() {
        //File archivo = new File("D:\\PMARTINEZ\\Data\\ListaProducto.txt");

        System.out.println("Archivo Existe " );
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
                    // Escribir los campos separados por comas (puedes cambiar el delimitador si es necesario)
                    // Se crea el String.valueOf para que se pueda leer cada tipo de dato de las variables
                    writer.write(String.join(";", String.valueOf(producto1.getIdProducto()), producto1.getNombreProducto(), producto1.getCategoria(), String.valueOf(producto1.getPrecio()), String.valueOf(producto1.getCantidadDisponible())));
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
           while ((linea = br.readLine())!=null){
               String[] datos = linea.split(";");
               int idProducto = Integer.parseInt(datos[0]);
               String nombreProducto = datos[1];
               String categoria = datos[2];
               double precio = Double.parseDouble(datos[3]);
               int cantidadDisponible = Integer.parseInt(datos[4]);
               Producto producto = new Producto(idProducto, nombreProducto, categoria, precio, cantidadDisponible);
               listaProductos.add(producto);
               //int idProducto = Integer.parseInt(linea);
               System.out.println(listaProductos);

           }

       }catch (IOException e) {
           System.out.println("Error al leer el archivo: " + e.getMessage());
       }
return listaProductos;
    }


    public static void  actualizarProductoId() {
        List<Producto> listaProductosActualizar= Inventario.leerProducto();
        for (Producto producto:listaProductosActualizar){
            System.out.println("Id Producto" +producto.getIdProducto());
            System.out.println("Nombre Producto" +producto.getNombreProducto());
            System.out.println("Categoria" +producto.getCategoria());
            System.out.println("Precio" +producto.getPrecio());
            System.out.println("Cantidad Disponible" +producto.getCantidadDisponible());

            Scanner scanId = new Scanner(System.in);
            System.out.println("Ingresa el ID Producto actualizar");
            int idProducto = Integer.parseInt(scanId.nextLine());
            Scanner scanId2 = new Scanner(System.in);
            System.out.println("Ingrese el nuevo ID Producto ");
            int newIdProduct = Integer.parseInt(scanId2.nextLine());

            if (producto.getIdProducto()==newIdProduct){
                producto.setIdProducto(newIdProduct);

            } else if(producto.getIdProducto()!=newIdProduct)
            {
                System.out.println("El IdProducto no se encuentra ");
            }

        }
    }
   public boolean eliminarProducto(int idProducto) {
        return listaProductos.removeIf(producto -> producto.getIdProducto()==idProducto);
    }
}






