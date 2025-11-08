package service;

import excepcion.ExcepcionPreparacion;

public class Principal {
    public static void main(String[] args) {
        try {
            System.out.println("========== PREPARANDO CAFÉ ==========");
            PlantillaBebida cafe = new Cafe("Colombiano");
            cafe.prepararReceta();

            System.out.println("\n========== PREPARANDO TÉ ==========");
            PlantillaBebida te = new Te("Negro");
            te.prepararReceta();

            System.out.println("\n========== PREPARANDO CHOCOLATE ==========");
            PlantillaBebida chocolate = new ChocolateCaliente("Dulce", true);
            chocolate.prepararReceta();

            System.out.println("\n========== PREPARANDO LIMONADA ==========");
            PlantillaBebida limonada = new Limonada("Baja", 8);
            limonada.prepararReceta();

        } catch (ExcepcionPreparacion e) {
            System.err.println("Error en preparación: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
