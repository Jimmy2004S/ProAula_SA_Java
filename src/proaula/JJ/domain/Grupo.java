
package proaula.JJ.domain;

import java.util.List;


public class Grupo {
    
    private  int codigo;
    private String nick;
    private List<Integer> codigo_persona;

    public Grupo(){
    }

    public Grupo(int codigo, String nick) {
        this.codigo = codigo;
        this.nick = nick;
    }

    
   
    public Grupo(int codigo, String nick, List<Integer> persona) {
        this.codigo = codigo;
        this.nick = nick;
        this.codigo_persona = persona;
    }
    

    public List<Integer> getPersona() {
        return codigo_persona;
    }

    public void setPersona(List<Integer> persona) {
        this.codigo_persona = persona;
    }

    

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }
  
}
