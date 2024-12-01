import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Reporte {
    private static final String leerArchivo = "D:\\PMARTINEZ\\Data\\reporte_inventario.txt";
    public static void generarReporte() {
        String encabezado = "Id Producto\tNombre Producto\tCategoria\tPrecio\tCantidad Disponible\tValor Total Producto" ;

        List<Producto> listaGenerarReporte = Inventario.leerProducto();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(leerArchivo))) {
            double valorTotal=0;

            // Escribir una línea por cada producto en el ArrayList
            writer.write(encabezado);
            writer.newLine();

            for (Producto producto : listaGenerarReporte) {
                double valorProducto = producto.getPrecio()*producto.getCantidadDisponible();
                valorTotal+=valorProducto;

                 writer.write(String.join("\t\t", String.valueOf(producto.getIdProducto()),
                        producto.getNombreProducto(), producto.getCategoria(),
                        String.valueOf(producto.getPrecio()), String.valueOf(producto.getCantidadDisponible()),String.valueOf(valorProducto)));
                writer.newLine();

            }
            System.out.println("El reporte se encuentra en la ruta "+leerArchivo);
            System.out.println("Archivo creado con éxito.");
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
        /*for (Producto producto : listaGenerarReporte) {
            System.out.println(producto.getIdProducto()+"\t\t\t\t"+producto.getNombreProducto()+"\t\t\t\t\t\t"+producto.getCategoria()+"\t\t\t"+producto.getPrecio()+"\t\t\t"+ producto.getCantidadDisponible());
        }*/

    }
}
