package classes.services;

import enums.Materiais;
import interfaces.Ferramenta;

public class PicaretaServico implements Ferramenta {

    public static int Mine(String material, int durabilidade, int forca, int blocos) {
        System.out.println("\n=== MINERANDO COM PICARETA DE " + material.toUpperCase() + " ===");
        System.out.println("Durabilidade atual: " + durabilidade);
        System.out.println("Força: " + forca);
        System.out.println("Blocos a minerar: " + blocos);

        if (durabilidade <= 0) {
            System.out.println("Picareta quebrada!");
            return 0;
        }

        int blocosMinerados = 0;
        int durabilidadeRestante = durabilidade;

        for (int i = 0; i < blocos; i++) {
            if (durabilidadeRestante <= 0) {
                System.out.println(" Picareta quebrou no bloco " + (i + 1));
                break;
            }
            durabilidadeRestante--;
            blocosMinerados++;
        }

        System.out.println("\nMinerados " + blocosMinerados + " blocos");
        System.out.println("Durabilidade restante: " + durabilidadeRestante);

        if (durabilidadeRestante <= 0) {
            System.out.println(" A picareta de " + material + " quebrou completamente!");
        }

        return durabilidadeRestante;
    }

    @Override
    public String Fabricar(Materiais material, int durabilidade, int forca) {
        System.out.println("\n=== FABRICANDO PICARETA ===");
        System.out.println("Material: " + material);
        System.out.println("Durabilidade: " + durabilidade);
        System.out.println("Força: " + forca);

        if (durabilidade <= 0 || forca <= 0) {
            System.out.println(" Picareta inválida!");
            return null;
        }

        System.out.println("Picareta de " + material + " fabricada com sucesso!");
        return "Picareta de " + material + " (D: " + durabilidade + ", F: " + forca + ")";
    }

    @Override
    public int Reparar(Materiais material, int durabilidadeAtual, int quantidade) {
        System.out.println("\n=== REPARANDO PICARETA DE " + material + " ===");
        System.out.println("Durabilidade atual: " + durabilidadeAtual);
        System.out.println("Quantidade a reparar: " + quantidade);

        int durabilidadeNova = durabilidadeAtual + quantidade;
        int limiteMaximo = 0;

        switch (material.name().toLowerCase()) {
            case "madeira": limiteMaximo = 50; break;
            case "pedra": limiteMaximo = 70; break;
            case "ferro": limiteMaximo = 100; break;
            case "ouro": limiteMaximo = 30; break;
            default: limiteMaximo = 60;
        }

        if (durabilidadeNova > limiteMaximo) {
            System.out.println(" Reparo limitado a " + limiteMaximo);
            durabilidadeNova = limiteMaximo;
        }

        System.out.println(" Durabilidade nova: " + durabilidadeNova);
        return durabilidadeNova;
    }
}