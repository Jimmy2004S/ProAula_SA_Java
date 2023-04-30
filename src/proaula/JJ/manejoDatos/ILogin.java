
package proaula.JJ.manejoDatos;

import java.sql.SQLException;
import proaula.JJ.domain.Login;

public interface ILogin {
    
    Login validar(String user , String clave) throws SQLException;
    
}
