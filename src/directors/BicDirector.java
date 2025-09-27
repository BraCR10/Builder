package directors;

import builders.bicycle.BicBuilder;
import products.Bicicleta;

public class BicDirector {
    BicBuilder builder;

    public void setBuilder(BicBuilder builder) {
        this.builder = builder;
    }

    public void construirBicicletaEstandar(String color) {
        builder.crearBicicleta();
        builder.armarPintura(color);
        builder.armarRueda("Urbana");
        builder.armarSilla("Comoda");
        builder.agregarLuz();
        builder.agregarCandado();
        builder.agregarTimbre();
    }

    public void construirBicicletaMontania(String color) {
        builder.crearBicicleta();
        builder.armarPintura(color);
        builder.armarRueda("MTB");
        builder.armarSilla("Deportiva");
        builder.agregarLuz();
        builder.agregarCandado();
    }

    public void construirBicicletaRuta(String color) {
        builder.crearBicicleta();
        builder.armarPintura(color);
        builder.armarRueda("Carretera");
        builder.armarSilla("Aerodinamica");
        builder.agregarLuz();
        builder.agregarTimbre();
    }

    public void construirBicicletaPersonalizada(String color, String rueda, String silla, boolean luz, boolean candado, boolean timbre, boolean canasta) {
        builder.crearBicicleta();
        builder.armarPintura(color);
        builder.armarRueda(rueda);
        builder.armarSilla(silla);
        if (luz) builder.agregarLuz();
        if (candado) builder.agregarCandado();
        if (timbre) builder.agregarTimbre();
        if (canasta) builder.agregarCanasta();
    }

    public Bicicleta getBicicleta() {
        return builder.getBicicleta();
    }
}
