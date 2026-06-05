package Main;

import Ventana.LitConnectSplash;
import Ventana.VentanaPrincipal;

public class Main {

    public static void main(String[] args) throws Exception {
        VentanaPrincipal ventana = new VentanaPrincipal();
        new LitConnectSplash();
        ventana.setVisible(true);
    }
}
