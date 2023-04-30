/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proaula.JJ.servicios;

import java.util.List;
import proaula.JJ.domain.Grupo;

/**
 *
 * @author jimen
 */
public interface IGrupoService {
    
    public boolean agregarGrupo(String nombre);
    public List listarGrupos();
    Grupo buscarGrupo(String nombre);
    public boolean modificarGrupo(Object recurso);
    public boolean eliminarGrupo(int codigoGrupo);
    
    public boolean agregarPersonaGrupo(int codigoPersona , int codigoGrupo);
    public boolean borrarPersonaGrupo(int codigoPersona);
    public List listarPersonaGrupo(int codigoGrupo);
}
