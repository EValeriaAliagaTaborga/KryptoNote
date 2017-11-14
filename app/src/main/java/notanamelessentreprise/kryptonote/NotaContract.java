package notanamelessentreprise.kryptonote;

import android.provider.BaseColumns;

/**
 * Created by DTIC-123 on 23/03/2017.
 */

public class NotaContract {


    //invoice = factura u.u

    public static abstract class NotaEntry implements BaseColumns {
        public static final String TABLE_NAME ="notas";
        public static final String _ID = "id";
        public static final String TITLE = "titulo";
        public static final String NOTE = "nota";
        public static final String ENCRYPTITLE = "tituloEncriptado";
        public static final String ENCRYPNOTE = "notaEncriptada";
        public static final String PASSWORD = "contrasenia";
    }
}
