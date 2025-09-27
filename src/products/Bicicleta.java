package products;

public class Bicicleta {
    //Attributes
    private static int contadorId = 1;
    private int id;
    String pintura;
    String rueda;
    String silla;
    Boolean tieneLuces;
    Boolean tieneTimbre;
    Boolean tieneCandado;
    Boolean tieneCanasta;
    private float precio;

    //Constructor
    public Bicicleta() {
        this.id = contadorId++;
        this.precio = 0.0f; 
    }

    //Methods
    public String getRueda() {
        return rueda;
    }

    public void setRueda(String rueda) {
        this.rueda = rueda;
    }

    public String getSilla() {
        return silla;
    }

    public void setSilla(String silla) {
        this.silla = silla;
    }

    public Boolean getTieneLuces() {
        return tieneLuces;
    }

    public void setTieneLuces(Boolean tieneLuces) {
        this.tieneLuces = tieneLuces;
    }

    public Boolean getTieneTimbre() {
        return tieneTimbre;
    }

    public void setTieneTimbre(Boolean tieneTimbre) {
        this.tieneTimbre = tieneTimbre;
    }

    public Boolean getTieneCandado() {
        return tieneCandado;
    }

    public void setTieneCandado(Boolean tieneCandado) {
        this.tieneCandado = tieneCandado;
    }

    public Boolean getTieneCanasta() {
        return tieneCanasta;
    }

    public void setTieneCanasta(Boolean tieneCanasta) {
        this.tieneCanasta = tieneCanasta;
    }

    public String getPintura() {
        return pintura;
    }

    public void setPintura(String pintura) {
        this.pintura = pintura;
    }

    public int getId() {
        return id;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public void agregarCostoFeature(float costo) {
        this.precio += costo;
    }
}
