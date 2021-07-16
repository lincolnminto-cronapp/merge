package blockly;

import cronapi.*;
import cronapi.rest.security.CronappSecurity;
import java.util.concurrent.Callable;



@CronapiMetaData(type = "blockly")
@CronappSecurity(post = "Public", get = "Public", execute = "Public", delete = "Public", put = "Public")
public class ObterIP {

public static final int TIMEOUT = 300;

/**
 * ObterIP
 *
 *
 * @author Usuário de Teste
 * @since 7/16/2021, 11:38:22 AM
 *
 */
public static Var getMyIPLocation() throws Exception {
 return new Callable<Var>() {

   private Var Mapa = Var.VAR_NULL;
   private Var cidade = Var.VAR_NULL;

   public Var call() throws Exception {

    Mapa =  Var.valueOf(blockly.IpParser.getLocation( Var.valueOf(582027) .getTypedObject(int.class),  Var.valueOf("ElTUcUhCjWVKTZIv") .getTypedObject(String.class),  Var.valueOf("45.172.197.93") .getTypedObject(String.class))) ;

    cidade =  cronapi.map.Operations.getMapField(Mapa ,  Var.valueOf("city") ) ;
    return Mapa
;
   }
 }.call();
}

}

