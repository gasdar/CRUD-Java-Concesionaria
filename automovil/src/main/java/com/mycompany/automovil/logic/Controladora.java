package com.mycompany.automovil.logic;

import com.mycompany.automovil.persistence.ControladoraPersistencia;
import java.util.ArrayList;

public class Controladora {
    
    // Controladora lógica que se comunica con la controladora de persistencia
    private ControladoraPersistencia controlPersis = new ControladoraPersistencia();
    
    public Controladora() {}
    
    // ---------- CRUD DE AUTOMÓVIL -----------
    public void registrarAuto(String modelo, String marca, String motor, String color,
            String patente, String cantPuertas) {
        
        Automovil auto = new Automovil();
        
        auto.setModelo(modelo);
        auto.setMarca(marca);
        auto.setMotor(motor);
        auto.setColor(color);
        auto.setPatente(patente);
        auto.setCantPuertas(Integer.parseInt(cantPuertas));
        
        controlPersis.registrarAuto(auto);
        
    }
    public Automovil traerAuto(int idAuto) {
        return controlPersis.traerAuto(idAuto);
    }
    public ArrayList<Automovil> traerAutos() {
        return controlPersis.traerAutos();
    }
    private void modificarAuto(Automovil auto) {
        controlPersis.modificarAuto(auto);
    }
    public void modificarAuto(Automovil auto, String modelo, String marca, String motor,
            String color, String patente, String cantPuertas) {
        
        Automovil autoBD = traerAuto(auto.getId());
        autoBD.setModelo(modelo);
        autoBD.setMarca(marca);
        autoBD.setMotor(motor);
        autoBD.setColor(color);
        autoBD.setPatente(patente);
        autoBD.setCantPuertas(Integer.parseInt(cantPuertas));
        
        modificarAuto(autoBD);
        
    }
    public void eliminarAuto(int idAuto) {
        controlPersis.eliminarAuto(idAuto);
    }
    
}   // Fin de Clase