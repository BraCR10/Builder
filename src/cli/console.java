package cli;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import products.Bicicleta;
import directors.BicDirector;
import builders.bicycle.*;

public class console {
    private List<Bicicleta> bicicletas;
    private BicDirector director;
    private Scanner scanner;

    public console() {
        this.bicicletas = new ArrayList<>();
        this.director = new BicDirector();
        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n=== GESTION DE BICICLETAS ===");
            System.out.println("1. Crear bicicleta");
            System.out.println("2. Ver todas las bicicletas");
            System.out.println("3. Buscar bicicleta por ID");
            System.out.println("4. Eliminar bicicleta");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opcion: ");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    crearBicicleta();
                    break;
                case 2:
                    verTodasLasBicicletas();
                    break;
                case 3:
                    buscarPorId();
                    break;
                case 4:
                    eliminarBicicleta();
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion invalida");
            }
        } while (opcion != 5);
    }

    private void crearBicicleta() {
        System.out.println("\n=== CREAR BICICLETA ===");
        System.out.println("1. Bicicleta Estandar");
        System.out.println("2. Bicicleta de Montania");
        System.out.println("3. Bicicleta de Ruta");
        System.out.println("4. Bicicleta Personalizada");
        System.out.print("Seleccione tipo: ");

        int tipo = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingrese color: ");
        String color = scanner.nextLine();

        Bicicleta bicicleta = null;

        switch (tipo) {
            case 1:
                director.setBuilder(new BiciEstandarBuilder());
                director.construirBicicletaEstandar(color);
                bicicleta = director.getBicicleta();
                break;
            case 2:
                director.setBuilder(new BiciMontaniaBuilder());
                director.construirBicicletaMontania(color);
                bicicleta = director.getBicicleta();
                break;
            case 3:
                director.setBuilder(new BiciRutaBuilder());
                director.construirBicicletaRuta(color);
                bicicleta = director.getBicicleta();
                break;
            case 4:
                crearBicicletaPersonalizada(color);
                return;
            default:
                System.out.println("Tipo invalido");
                return;
        }

        bicicletas.add(bicicleta);
        System.out.println("Bicicleta creada exitosamente!");
    }

    private void crearBicicletaPersonalizada(String color) {
        System.out.print("Tipo de rueda: ");
        String rueda = scanner.nextLine();
        System.out.print("Tipo de silla: ");
        String silla = scanner.nextLine();

        System.out.print("¿Agregar luces? (s/n): ");
        boolean luz = scanner.nextLine().toLowerCase().equals("s");

        System.out.print("¿Agregar candado? (s/n): ");
        boolean candado = scanner.nextLine().toLowerCase().equals("s");

        System.out.print("¿Agregar timbre? (s/n): ");
        boolean timbre = scanner.nextLine().toLowerCase().equals("s");

        System.out.print("¿Agregar canasta? (s/n): ");
        boolean canasta = scanner.nextLine().toLowerCase().equals("s");

        director.setBuilder(new BiciPersonalizadaBuilder());
        director.construirBicicletaPersonalizada(color, rueda, silla, luz, candado, timbre, canasta);

        bicicletas.add(director.getBicicleta());
        System.out.println("Bicicleta personalizada creada exitosamente!");
    }

    private void verTodasLasBicicletas() {
        System.out.println("\n=== TODAS LAS BICICLETAS ===");
        if (bicicletas.isEmpty()) {
            System.out.println("No hay bicicletas registradas.");
            return;
        }

        float costoTotal = 0;
        for (int i = 0; i < bicicletas.size(); i++) {
            System.out.println("\n--- Bicicleta " + (i + 1) + " ---");
            mostrarDetallesBicicleta(bicicletas.get(i));
            costoTotal += bicicletas.get(i).getPrecio();
        }
        System.out.println("\n=== RESUMEN ===");
        System.out.println("Total de bicicletas: " + bicicletas.size());
        System.out.println("Valor total del inventario: $" + String.format("%.2f", costoTotal));
    }

    private void buscarPorId() {
        System.out.print("Ingrese ID de la bicicleta: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (Bicicleta bici : bicicletas) {
            if (bici.getId() == id) {
                System.out.println("\n=== BICICLETA ENCONTRADA ===");
                mostrarDetallesBicicleta(bici);
                return;
            }
        }

        System.out.println("No se encontró una bicicleta con ID: " + id);
    }


    private void eliminarBicicleta() {
        if (bicicletas.isEmpty()) {
            System.out.println("No hay bicicletas para eliminar.");
            return;
        }

        System.out.print("Ingrese ID de la bicicleta a eliminar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < bicicletas.size(); i++) {
            if (bicicletas.get(i).getId() == id) {
                bicicletas.remove(i);
                System.out.println("Bicicleta con ID " + id + " eliminada exitosamente!");
                return;
            }
        }

        System.out.println("No se encontró una bicicleta con ID: " + id);
    }

    private void mostrarDetallesBicicleta(Bicicleta bici) {
        System.out.println("ID: " + bici.getId());
        System.out.println("Color: " + (bici.getPintura() != null ? bici.getPintura() : "Sin color"));
        System.out.println("Rueda: " + (bici.getRueda() != null ? bici.getRueda() : "Sin rueda"));
        System.out.println("Silla: " + (bici.getSilla() != null ? bici.getSilla() : "Sin silla"));
        System.out.println("Luces: " + (bici.getTieneLuces() != null && bici.getTieneLuces() ? "Si (+$25)" : "No"));
        System.out.println("Candado: " + (bici.getTieneCandado() != null && bici.getTieneCandado() ? "Si (+$15)" : "No"));
        System.out.println("Timbre: " + (bici.getTieneTimbre() != null && bici.getTieneTimbre() ? "Si (+$10)" : "No"));
        System.out.println("Canasta: " + (bici.getTieneCanasta() != null && bici.getTieneCanasta() ? "Si (+$20)" : "No"));
        System.out.println("PRECIO TOTAL: $" + String.format("%.2f", bici.getPrecio()));
    }

}
