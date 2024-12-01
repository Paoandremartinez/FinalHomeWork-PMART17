import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Categoria {

    private String nombreCategoria;

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public Categoria() {

    }

    public static HashMap<String, List<Producto>> obtenerCategorias(){
        HashMap<String, List<Producto>> productosPorCategoria=new HashMap<>();

        List<Producto> productos=Inventario.leerProducto();

        for(Producto producto:productos) {
            List<Producto> productosCategoria=new ArrayList<>();
            if(productosPorCategoria.containsKey(producto.getCategoria())) {
                productosCategoria= productosPorCategoria.get(producto.getCategoria());
                productosCategoria.add(producto);
                productosPorCategoria.put(producto.getCategoria(), productosCategoria);
            } else {
                productosCategoria.add(producto);
                productosPorCategoria.put(producto.getCategoria(), productosCategoria);
            }
        }

        return productosPorCategoria;
    }

    public static void buscarPorCategoria(){

        Scanner scanProduc = new Scanner(System.in);
        System.out.println("Nombre Categoria ");
        String categoria = scanProduc.nextLine();

        List<Producto> productos=Inventario.leerProducto();
        List<Producto> productosDeLaCategoria=new ArrayList<>();

        for(Producto producto:productos) {
            if(producto.getCategoria().equalsIgnoreCase(categoria)) {
                productosDeLaCategoria.add(producto);
            }
        }

        if(!productosDeLaCategoria.isEmpty()) {
            System.out.println("Id Producto\tNombre Producto\tCategoria\tPrecio\tCantidad Disponible" );
            for(Producto producto:productosDeLaCategoria) {
                System.out.println(producto.getIdProducto()+"\t\t"+producto.getNombreProducto()+"\t"+producto.getCategoria()+"\t"+producto.getPrecio()+"\t"+ producto.getCantidadDisponible());
            }
        }else {
            System.out.println("No existen productos asociados a esa categoria");
        }


    }

    public static List<Producto> buscarPorCategoria(String categoria){

        List<Producto> productos=Inventario.leerProducto();
        List<Producto> productosDeLaCategoria=new ArrayList<>();

        for(Producto producto:productos) {
            if(producto.getCategoria().equalsIgnoreCase(categoria)) {
                productosDeLaCategoria.add(producto);
            }
        }

        return productosDeLaCategoria;
    }
}
