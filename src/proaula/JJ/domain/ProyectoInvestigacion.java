
package proaula.JJ.domain;

import java.util.Date;


public class ProyectoInvestigacion {


private int codigo;
private String acronimo;
private String descripcion;
private String fechaRegistro;
private int like;
private int codigo_grupo;
private int codigo_lider;

    public ProyectoInvestigacion() {
      
    }

    public ProyectoInvestigacion(int codigo) {
        this.codigo = codigo;
    }

    public ProyectoInvestigacion(int codigo, String acronimo, String descripcion, String fechaRegistro, int like, int id_grupo , int id_lider) {
        this.codigo = codigo;
        this.acronimo = acronimo;
        this.descripcion = descripcion;
        this.fechaRegistro = fechaRegistro;
        this.like = like;
        this.codigo_grupo = id_grupo;
        this.codigo_lider = id_lider;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
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

    public int getCodigo_grupo() {
        return codigo_grupo;
    }

    public void setCodigo_grupo(int codigo_grupo) {
        this.codigo_grupo = codigo_grupo;
    }

    public int getCodigo_lider() {
        return codigo_lider;
    }

    public void setCodigo_lider(int codigo_lider) {
        this.codigo_lider = codigo_lider;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }
    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    @Override
    public String toString() {
        return "ProyectoInvestigacion{" + "codigo=" + codigo + ", acronimo=" + acronimo + ", descripcion=" + descripcion + ", fechaRegistro=" + fechaRegistro + ", like=" + like + ", codigo_grupo=" + codigo_grupo + ", codigo_lider=" + codigo_lider + '}';
    }
   
    
}

