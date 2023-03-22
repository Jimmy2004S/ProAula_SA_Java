
package proyectodeinvestigacion.domain;


public class Grupo {
    
    private  int codigo;
    private String nick;
    private String[] persona;

    public Grupo(){
    }

    public Grupo(int codigo, String nick, String[] persona) {
        this.codigo = codigo;
        this.nick = nick;
        this.persona = persona;
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

    public String[] getPersona() {
        return persona;
    }

    public void setPersona(String[] persona) {
        this.persona = persona;
    }

   
    
    
}
