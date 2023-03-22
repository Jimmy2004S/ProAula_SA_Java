
package proyectodeinvestigacion.domain;

import java.util.Date;


public class ProyectoInvestigacion {


private int codigo;
private String acronimo;
private String objetivo;
private String liderProyecto;
private String idProfesor;
private String fechaRegistro;
private int id_grupo;

    public ProyectoInvestigacion() {
      
    }

    public ProyectoInvestigacion(int codigo) {
        this.codigo = codigo;
    }

    
    public ProyectoInvestigacion(int codigo, String acronimo, String objetivo, String liderProyecto, String idProfesor, String fechaRegistro, int id_grupo) {
        this.codigo = codigo;
        this.acronimo = acronimo;
        this.objetivo = objetivo;
        this.liderProyecto = liderProyecto;
        this.idProfesor = idProfesor;
        this.fechaRegistro = fechaRegistro;
        this.id_grupo = id_grupo;
    }
  
    
   
    public  int getCodigo() {
        return codigo;
    }
    public  void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getAcronimo() {
        return acronimo;
    }
    public void setAcronimo(String acronimo) {
        this.acronimo = acronimo;
    }

    public String getObjetivo() {
        return objetivo;
    }
    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public String getLiderProyecto() {
        return liderProyecto;
    }
    public void setLiderProyecto(String LiderProyecto) {
        this.liderProyecto = LiderProyecto;
    }

    public String getIdProfesor() {
        return idProfesor;
    }
    public void setIdProfesor(String idProfesor) {
        this.idProfesor = idProfesor;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }
    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public int getId_grupo() {
        return id_grupo;
    }
    public void setId_grupo(int id_grupo) {
        this.id_grupo = id_grupo;
    }
   
}

