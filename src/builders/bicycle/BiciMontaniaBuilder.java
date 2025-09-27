package builders.bicycle;

import products.Bicicleta;

public class BiciMontaniaBuilder extends BicBuilder {

    public BiciMontaniaBuilder() {
        super(180.0f);
    }

    @Override
    public void crearBicicleta() {
        this.bicicleta = new Bicicleta();
        this.establecerPrecioBase();
    }

    @Override
    public void armarRueda(String tipo) {
        this.bicicleta.setRueda("MTB");
    }

    @Override
    public void armarSilla(String silla) {
        this.bicicleta.setSilla("Deportiva");
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
        this.bicicleta.setTieneCandado(true);
        this.bicicleta.agregarCostoFeature(15.0f);
    }

    @Override
    public void agregarTimbre() {
        this.bicicleta.setTieneTimbre(false);
    }

    @Override
    public void agregarCanasta() {
        this.bicicleta.setTieneCanasta(false);
    }

}
