
package proaula.JJ.servicios;

import proaula.JJ.domain.Login;

public interface ILoginService {
    Login validar(String user , String clave);
}
