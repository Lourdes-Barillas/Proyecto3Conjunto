/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUD;

import Globalpackage.GlobalVariables;
import MasterClases.*;
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
     * @param producto
     * 
     * RECORDAR QUE INSERTA SÓLO "Prod_Nombre y Prod_Costo", YA QUE Prod_Id ES AUTOINCREMENT
     */
    public void insertCliente(Cliente cliente) {
        //Insertamos el cliente
        String consulta = insert 
                + "public.\"Clientes\" (\"Cliente_Usuario\", \"Cliente_TipoCliente\")" 
                + values;
        //la consulta será INSERT INTO PRODUCTOS VALUES('PROD_NOMBRE', 'PROD_PRECIO');
        try {
            //1. Crear la conexión
            Connection miConexion = globalvariables.connection();
            
            PreparedStatement miStatement = miConexion.prepareStatement(consulta);
            miStatement.setString(1, cliente.getNombreDeUsuario());
            miStatement.setString(2, cliente.getTipoCliente().toString());
            //Si fue insertado, busquemos el uno
            insertado = miStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al insertar " + e);
        }
    }
    
}
