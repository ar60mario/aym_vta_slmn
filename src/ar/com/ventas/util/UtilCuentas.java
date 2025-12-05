package ar.com.ventas.util;

import java.text.DecimalFormat;

/**
 *
 * @author MARIO
 */
public class UtilCuentas {

    private static DecimalFormat df = new DecimalFormat("#0.00");

    public static Double redondearDoble(Double importe) {
        String str_importe = df.format(importe);
        Double resultado = Double.valueOf(str_importe.replace(",", "."));
        return resultado;
    }

    public static Float redondearFloat(Float importe) {
        String str_importe = df.format(importe);
        Float resultado = Float.valueOf(str_importe.replace(",", "."));
        return resultado;
    }
}
