/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MasterClases;

/**
 *
 * @author Adriana P
 */
public class Cliente {
    protected TipoUsuario tipoCliente;
    protected int id;
    protected String nombreDeUsuario;

    public int getIdCliente(){
        return id;
    }
    //public String getDato(){ return dato;}

    public Cliente(String nombreDeUsuario, TipoUsuario cliente){
        this.tipoCliente = cliente;
        this.nombreDeUsuario = nombreDeUsuario;
    }
    public Cliente(){
        //Todos los parámetros
    }

    public String getNombreClase(){
        String clase = this.tipoCliente.toString();
        return clase;
    }
    public TipoUsuario getTipoCliente(){
        return this.tipoCliente;
    }

    public String getNombreDeUsuario() {
        return nombreDeUsuario;
    }
    
    
    public void setTipoUsuario(TipoUsuario tipoCliente) {
        this.tipoCliente = tipoCliente;
    }
    
    @Override
    public String toString(){
        return tipoCliente.toString();
    }
}
