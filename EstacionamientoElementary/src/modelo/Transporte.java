/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Isidro
 */
public class Transporte {
    private String placa;
    private String color;
    private String marca;
    private int modelo;
    private int numCajon;
    private int numTicket;
    private int  precio;

    /**
     * @return the placa
     */
    public String getPlaca() {
        return placa;
    }

    /**
     * @param placa the placa to set
     */
    public void setPlaca(String placa) {
        this.placa = placa;
    }

    /**
     * @return the color
     */
    public String getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * @return the marca
     */
    public String getMarca() {
        return marca;
    }

    /**
     * @param marca the marca to set
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * @return the modelo
     */
    public int getModelo() {
        return modelo;
    }

    /**
     * @param modelo the modelo to set
     */
    public void setModelo(int modelo) {
        this.modelo = modelo;
    }

    /**
     * @return the numCajon
     */
    public int getNumCajon() {
        return numCajon;
    }

    /**
     * @param numCajon the numCajon to set
     */
    public void setNumCajon(int numCajon) {
        this.numCajon = numCajon;
    }

    /**
     * @return the numTicket
     */
    public int getNumTicket() {
        return numTicket;
    }

    /**
     * @param numTicket the numTicket to set
     */
    public void setNumTicket(int numTicket) {
        this.numTicket = numTicket;
    }

    public Transporte(String placa, String color, String marca, int modelo, int numCajon, int numTicket) {
        this.placa = placa;
        this.color = color;
        this.marca = marca;
        this.modelo = modelo;
        this.numCajon = numCajon;
        this.numTicket = numTicket;
    }

    /**
     * @return the precio
     */
    public int getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(int precio) {
        this.precio = precio;
    }
    
    
}
