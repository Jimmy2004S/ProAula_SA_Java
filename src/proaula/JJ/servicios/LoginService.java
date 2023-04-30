package proaula.JJ.servicios;

import config.Conexion;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import proaula.JJ.domain.Login;
import proaula.JJ.manejoDatos.LoginDAO;


public class LoginService implements ILoginService{

    @Override
    public Login validar(String user, String clave) {
       Login login = new Login();
       Connection conexion = null;
        try {
            conexion = Conexion.getConnection();
            LoginDAO loginDAO = new LoginDAO(conexion);
            login = loginDAO.validar(user, clave);
        } catch (SQLException ex) {
            Logger.getLogger(LoginService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return login;
    }


    }
