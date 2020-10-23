
import CRUD.Create;
import MasterClases.Children.Empresarial;
import MasterClases.Children.Individual;
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
        //main.insertCliente(2, TipoUsuario.Cliente_Individual);
        //main.insertUsuario("@Esau");
        //main.insertClienteInd("33587825654124", 1);
        main.insertClienteEmpresarial("vorgas@yahoo.com", 3);
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
    public void insertCliente(int idUsuario, TipoUsuario tipocliente){
        Cliente cliente = new Cliente(idUsuario, tipocliente);
        Create create = new Create();
        create.insertCliente(cliente);
    }
    
    public void insertUsuario(String nombre){
        Create create = new Create();
        create.insertUsuario(nombre);
    }
    
    public void insertClienteInd(String dpi, int idCliente){
        Individual cliente = new Individual(dpi, idCliente);
        Create create = new Create();
        create.insertClienteIndividual(cliente);
    }
    
    public void insertClienteEmpresarial(String contacto, int idCliente){
        Empresarial cliente = new Empresarial(contacto, idCliente);
        Create create = new Create();
        create.insertClienteEmpresarial(cliente);
    }
}
