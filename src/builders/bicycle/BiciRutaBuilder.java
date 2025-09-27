package builders.bicycle;

import products.Bicicleta;

public class BiciRutaBuilder extends BicBuilder {

    public BiciRutaBuilder() {
        super(220.0f);
    }

    @Override
    public void crearBicicleta() {
        this.bicicleta = new Bicicleta();
        this.establecerPrecioBase();
    }

    @Override
    public void armarRueda(String tipo) {
        this.bicicleta.setRueda("Carretera");
    }

    @Override
    public void armarSilla(String silla) {
        this.bicicleta.setSilla("Aerodinamica");
    }

    @Override
    public void armarPintura(String color) {
        this.bicicleta.setPintura(color);
    }

    @Override
    public void agregarLuz() {
        this.bicicleta.setTieneLuces(true);
        this.bicicleta.agregarCostoFeature(25.0f);
    }

    @Override
    public void agregarCandado() {
        this.bicicleta.setTieneCandado(false);
    }

    @Override
    public void agregarTimbre() {
        this.bicicleta.setTieneTimbre(true);
        this.bicicleta.agregarCostoFeature(10.0f);
    }

    @Override
    public void agregarCanasta() {
        this.bicicleta.setTieneCanasta(false);
    }

}
