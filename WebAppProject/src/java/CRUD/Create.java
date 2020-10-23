/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUD;

import Globalpackage.GlobalVariables;
import MasterClases.*;
import MasterClases.Children.Empresarial;
import MasterClases.Children.Individual;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *Esta clase tiene la propiedad de insertar registros. Se llama create en honor del 
 * acrónimo CRUD, Create, Read, Update, Delete
 * @author Adriana P
 */
public class Create {
    private int insertado;
    private String insert = "INSERT INTO ";
    private String values = " VALUES(?,?);";
    GlobalVariables globalvariables = new GlobalVariables();
    
    /**
     * Procedimiento de insertar en Productos. El orden de insersión es
     * Prod_Id, Prod_Nombre, Prod_Costo, es decir: smallint, character varying, double presicion
     * @param producto
     * 
     * RECORDAR QUE INSERTA SÓLO "Prod_Nombre y Prod_Costo", YA QUE Prod_Id ES AUTOINCREMENT
     */
    public void insertProducto(Producto producto,int cantidad) {
        values = " VALUES(?,?,?);";
        String consulta = insert + "public.\"Productos\" (\"Prod_Nombre\", \"Prod_Costo\", \"Prod_Existencia\") " + values;
        //la consulta será INSERT INTO PRODUCTOS VALUES('PROD_NOMBRE', 'PROD_PRECIO');
        try {
            //1. Crear la conexión
            Connection miConexion = globalvariables.connection();
            
            PreparedStatement miStatement = miConexion.prepareStatement(consulta);
            miStatement.setString(1, producto.getProducto());
            miStatement.setDouble(2, producto.getPrecio());
            miStatement.setInt(3, cantidad);
            //Si fue insertado, busquemos el uno
            insertado = miStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al insertar " + e);
        }
    }
    
    /**
     * Procedimiento de insertar en Productos. El orden de insersión es
     * Prod_Id, Prod_Nombre, Prod_Costo, es decir: smallint, character varying, double presicion
     * @param cliente
     * RECORDAR QUE INSERTA SÓLO "Prod_Nombre y Prod_Costo", YA QUE Prod_Id ES AUTOINCREMENT
     */
    public void insertCliente(Cliente cliente) {
        //Insertamos el cliente
        String consulta = insert 
                + "public.\"Clientes\" (\"Cliente_UsuarioId\", \"Cliente_TipoCliente\")" 
                + values;
        //la consulta será INSERT INTO PRODUCTOS VALUES('PROD_NOMBRE', 'PROD_PRECIO');
        try {
            //1. Crear la conexión
            Connection miConexion = globalvariables.connection();
            
            PreparedStatement miStatement = miConexion.prepareStatement(consulta);
            miStatement.setInt(1, cliente.getIdDeUsuario());
            miStatement.setString(2, cliente.getTipoCliente().toString());
            //Si fue insertado, busquemos el uno
            insertado = miStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al insertar " + e);
        }
    }
    
    
    /**
     * Inserta un cliente individual detrás de un cliente general
     * @param cliente 
     */
    public void insertClienteIndividual(Individual cliente) {
        //Insertamos el cliente individual
        String consulta = insert 
                + "public.\"ClientesIndividuales\" (\"CI_DPI\", \"CI_ClienteId\")" 
                + values;
        //la consulta será INSERT INTO PRODUCTOS VALUES('PROD_NOMBRE', 'PROD_PRECIO');
        try {
            //1. Crear la conexión
            Connection miConexion = globalvariables.connection();
            
            PreparedStatement miStatement = miConexion.prepareStatement(consulta);
            miStatement.setString(1, cliente.getDpi());
            miStatement.setInt(2, cliente.getIdCliente());
            //Si fue insertado, busquemos el uno
            insertado = miStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al insertar " + e);
        }
    }
    
    
    /**
     * Inserta un cliente Empresarial detrás de un cliente general
     * @param cliente 
     */
    public void insertClienteEmpresarial(Empresarial cliente) {
        //Insertamos el cliente
        String consulta = insert 
                + "public.\"ClientesEmpresariales\" (\"CE_Contacto\", \"CE_ClienteId\")" 
                + values;
        //la consulta será INSERT INTO PRODUCTOS VALUES('PROD_NOMBRE', 'PROD_PRECIO');
        try {
            //1. Crear la conexión
            Connection miConexion = globalvariables.connection();
            
            PreparedStatement miStatement = miConexion.prepareStatement(consulta);
            miStatement.setString(1, cliente.getContacto());
            miStatement.setInt(2, cliente.getIdCliente());
            //Si fue insertado, busquemos el uno
            insertado = miStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al insertar " + e);
        }
    }
    
    
    /**
     * Inserta un cliente Empresarial detrás de un cliente general
     * @param id es el id del usuario
     * @param nombre es el nombre de usuario
     */
    public void insertUsuario(String nombre) {
        values = " VALUES(?);";
        //Insertamos el cliente
        String consulta = insert 
                + "public.\"Usuarios\" (\"Usuario_Nombre\")" 
                + values;
        //la consulta será INSERT INTO PRODUCTOS VALUES('PROD_NOMBRE', 'PROD_PRECIO');
        try {
            //1. Crear la conexión
            Connection miConexion = globalvariables.connection();
            
            PreparedStatement miStatement = miConexion.prepareStatement(consulta);
            miStatement.setString(1, nombre);
            //Si fue insertado, busquemos el uno
            insertado = miStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al insertar " + e);
        }
    }
}
