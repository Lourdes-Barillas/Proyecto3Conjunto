
import CRUD.Create;
import MasterClases.Cliente;
import MasterClases.Producto;
import MasterClases.TipoUsuario;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Adriana P
 */
public class Prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Prueba main = new Prueba();
        main.insertCliente("MaryStar", TipoUsuario.Cliente_Individual);
        
    }
    
    
    /**
     * Este procedimiento sirve de prueba para insertar los productos con 
     * su nombre y su precio
     * @param productoNombre
     * @param precio 
     */
    public void insertProd(String productoNombre, Double precio){
        Producto producto = new Producto(productoNombre, precio);
        Create create = new Create();
        create.insertProducto(producto, 80);
    }
    
    /**
     * Este procedimiento sirve de prueba para insertar los productos con 
     * su nombre y su precio
     * @param productoNombre
     * @param precio 
     */
    public void insertCliente(String nombreUsuario, TipoUsuario tipocliente){
        Cliente cliente = new Cliente(nombreUsuario, tipocliente);
        Create create = new Create();
        create.insertCliente(cliente);
    }
    
}
