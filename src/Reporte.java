import java.io.*;
import java.util.List;
import java.util.stream.Stream;

public class Reporte {
    private static final String reporteArchivo = "D:\\PMARTINEZ\\Data\\reporte_inventario.txt";
     public static void generarReporte() {
        System.out.println("*******************************************************************");
        System.out.println("*******               5. Generar Reporte                 **********");
        System.out.println("*                                                                 *");

        String encabezado = "Id Producto\tNombre Producto\tCategoria\tPrecio\tCantidad Disponible\tValor Total Producto" ;

        List<Producto> listaGenerarReporte = Inventario.leerProducto();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(reporteArchivo))) {
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
            writer.newLine();
            writer.newLine();
            writer.write("El valor Total en todos sus productos es " +valorTotal);

            System.out.println("El reporte se encuentra en la ruta "+reporteArchivo);
            System.out.println("Archivo creado con éxito.");

            System.out.println("*                                                                 *");
            System.out.println("*******************************************************************");
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }


    }

    public static void productoMasCaro() {

        List<Producto> listProductCaro = Inventario.leerProducto();


      Producto prodMasCaro=null;
      double valorMaximo = Double.MIN_VALUE;
      for (Producto producto:listProductCaro){
          if (producto.getPrecio()>valorMaximo){
              valorMaximo=producto.getPrecio();
              prodMasCaro=producto;
          }
      }
      if(prodMasCaro!=null){
          System.out.println("El producto mas costoso  "+prodMasCaro.getNombreProducto()+ " con un valor de " +valorMaximo);
      }


    }

}
