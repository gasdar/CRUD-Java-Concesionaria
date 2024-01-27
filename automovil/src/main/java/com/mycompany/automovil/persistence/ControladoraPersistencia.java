package com.mycompany.automovil.persistence;

import com.mycompany.automovil.logic.Automovil;
import com.mycompany.automovil.persistence.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControladoraPersistencia {
    
    // Controladora de todos los JPA Controller classes
    private AutomovilJpaController autoJpa = new AutomovilJpaController();
    
    public ControladoraPersistencia() {}
    
    // ---------- CRUD DE AUTOMÓVIL -----------
    public void registrarAuto(Automovil auto) {
        autoJpa.create(auto);
    }
    public Automovil traerAuto(int idAuto) {
        return autoJpa.findAutomovil(idAuto);
    }
    public ArrayList<Automovil> traerAutos() {
        List<Automovil> allAutos = autoJpa.findAutomovilEntities();
        ArrayList<Automovil> listaAutos = new ArrayList<> (allAutos);
        return listaAutos;
    }
    public void modificarAuto(Automovil auto) {
        try {
            autoJpa.edit(auto);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void eliminarAuto(int idAuto) {
        try {
            autoJpa.destroy(idAuto);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}   // Fin de Clase