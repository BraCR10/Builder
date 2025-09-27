package builders.bicycle;

import products.Bicicleta;

public class BiciEstandarBuilder extends BicBuilder{

    public BiciEstandarBuilder() {
        super(150.0f); 
    }

    @Override
    public void crearBicicleta() {
        this.bicicleta = new Bicicleta();
        this.establecerPrecioBase();
    }

    @Override
    public void armarRueda(String tipo) {
        this.bicicleta.setRueda(tipo);
    }

    @Override
    public void armarSilla(String silla) {
        this.bicicleta.setSilla(silla);
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
        this.bicicleta.setTieneTimbre(true);
        this.bicicleta.agregarCostoFeature(10.0f);
    }

    @Override
    public void agregarCanasta() {
        this.bicicleta.setTieneCanasta(false);
    }


}
