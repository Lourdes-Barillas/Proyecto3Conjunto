/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MasterClases;

import java.sql.Date;

/**
 *
 * @author Adriana P
 */
public class Orden {
    public static String envioBodega = "Envio a bodega";
    public static String envioDomicilio = "Envio a domicilio";
    
    private int id;
    private Orden orden;
    private Date fecha;
    private Double precioEnvio;
    private String tipoEnvio;
    private int estado;
    private int diasEnvio;
    
    public Orden(int _idOrden, Double _precioEnvio, String _tipoEnvio, int _estado, int _dias){
        orden = new Orden();
        orden.setId(_idOrden);
        //fecha = new java.sql.Date(id, id, id)
    }
    public Orden(){
        
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
    
    public int getIdOrden() {
        return this.orden.getId();
    }

    public int getFecha() {
        return 0;
    }

    public double getPrecioDeEnvio() {
        return this.precioEnvio;
    }

    public String getTipoEnvio() {
        return this.tipoEnvio;
    }

    public int getEstado() {
        return this.estado;
    }

    public int getdiasEnvio() {
        return this.diasEnvio;
    }
    
}
