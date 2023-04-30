/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proaula.JJ.wq;


import java.util.List;
import proaula.JJ.domain.ProyectoInvestigacion;
import proaula.JJ.servicios.IService;
import proaula.JJ.servicios.PersonaService;
import proaula.JJ.servicios.ProyectosService;

/**
 *
 * @author jimen
 */
public class d {
    
    public static void main(String[] args) {
  
        ProyectosService P = new ProyectosService();
        List<ProyectoInvestigacion> list = P.listar();
        for (ProyectoInvestigacion estudiante : list) {
            System.out.println(estudiante);
        }
        
    }
}
