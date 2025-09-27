package builders.bicycle;

import products.Bicicleta;

public abstract class  BicBuilder {

    Bicicleta bicicleta;
    Float costo;

    public BicBuilder(float costoBase) {
        this.costo = costoBase;
    }

    public abstract void crearBicicleta();
    public abstract void armarPintura(String color);
    public abstract void armarRueda(String tipo);
    public abstract void armarSilla(String silla);
    public abstract void agregarLuz();
    public abstract void agregarCandado();
    public abstract void agregarTimbre();
    public abstract void agregarCanasta();
    public Bicicleta getBicicleta() {
        return this.bicicleta;
    }

    protected void establecerPrecioBase() {
        this.bicicleta.setPrecio(this.costo);
    }
}
