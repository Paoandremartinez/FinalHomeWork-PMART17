public class Producto {

    //Atributos privados
    private int idProducto;
    private String nombreProducto;
    private String categoria;
    private double precio;
    private int cantidadDisponible;

    public Producto (int idProducto, String nombreProducto, String categoria, double precio, int cantidadDisponible)
    {
        this.idProducto=idProducto;
        this.nombreProducto=nombreProducto;
        this.categoria= categoria;
        this.precio= precio;
        this.cantidadDisponible = cantidadDisponible;
    }
    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;


    }
    public String getNombreProducto() {
        return nombreProducto;
    }
   public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }
    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public int getCantidadDisponible() {
        return cantidadDisponible;
    }
    public void setCantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    private String mostrarProductos(){
        return "ID: " + getIdProducto() + ", Nombre: " + getNombreProducto() + ", Categoría: " + getCategoria() +
                ", Precio: " + getPrecio() + ", Cantidad disponible: " + getCantidadDisponible();
        /*System.out.println("Id Producto"  +getIdProducto());
        System.out.println("Nombre Producto"  +getNombreProducto());
        System.out.println("Categoria"  +getCategoria());
        System.out.println("Precio"  +getPrecio());
        System.out.println("CantidadDisponible"  +getCantidadDisponible());*/
    }


}
