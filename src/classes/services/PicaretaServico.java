package classes.services;

import classes.entidades.PicaretaEntidade;
import enums.Materiais;
import interfaces.Ferramenta;

public class PicaretaServico implements Ferramenta {
    PicaretaEntidade picaretaEntidade = new PicaretaEntidade();

    @Override
    public int Minerar(String nome,Materiais material, int durabilidade, int forca, int blocos) {
        System.out.println("\n=== MINERANDO COM PICARETA DE " + material + " ===");
        System.out.println("Durabilidade atual: " + durabilidade);
        System.out.println("Força: " + forca);
        System.out.println("Blocos a minerar: " + blocos);

        PicaretaEntidade picaretaSelecionada = picaretaEntidade.getPicaretas().stream()
                .filter(picareta -> picareta.getNome().equalsIgnoreCase(nome))
                .findFirst()
                .orElse(null);

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
            System.out.println(" A picareta de " + material.name().toLowerCase() + " quebrou completamente!");
        }

        picaretaSelecionada.setDurabilidade(durabilidadeRestante);
        return durabilidadeRestante;
    }

    @Override
    public String Fabricar(Materiais material) {
        System.out.println("\n=== FABRICANDO PICARETA ===");
        System.out.println("Material: " + material);

        int durabilidade = switch (material.name().toLowerCase()) {
            case "madeira" -> durabilidade = 50;
            case "pedra" -> durabilidade = 70;
            case "ferro" -> durabilidade = 100;
            case "ouro" -> durabilidade = 31;
            default -> durabilidade = 60;
        };

        System.out.println("Durabilidade: " + durabilidade);

        int forca = switch (material.name().toLowerCase()) {
                    case "madeira" -> forca = 5;
                    case "pedra" -> forca = 8;
                    case "ferro" -> forca = 12;
                    case "ouro" -> forca = 9;
                    default -> forca = 6;
                };

        System.out.println("Força: " + forca);

        if (durabilidade <= 0 || forca <= 0) {
            System.out.println(" Picareta inválida!");
            return null;
        }

        int blocos = switch (material.name().toLowerCase()) {
            case "madeira" -> blocos = 17;
            case "pedra" -> blocos = 20;
            case "ferro" -> blocos = 40;
            case "ouro" -> blocos = 30;
            default -> blocos = 19;
        };

        System.out.println("Picareta de " + material.name().toLowerCase() + " fabricada com sucesso!");
        String nome = "Picareta de " + material.name().toLowerCase() ;

        PicaretaEntidade picaretaCriada = new PicaretaEntidade(nome,durabilidade, material, blocos, forca);
        picaretaEntidade.setPicaretas(picaretaCriada);

        return "Picareta de " + material + " (D: " + durabilidade + ", F: " + forca + ")";
    }

    @Override
    public int Reparar(String nome, Materiais material, int durabilidadeAtual, int quantidade) {
        System.out.println("\n=== REPARANDO PICARETA DE " + material + " ===");
        System.out.println("Durabilidade atual: " + durabilidadeAtual);
        System.out.println("Quantidade a reparar: " + quantidade);

        PicaretaEntidade picaretaSelecionada = picaretaEntidade.getPicaretas().stream()
                .filter(picareta -> picareta.getNome().equalsIgnoreCase(nome))
                .findFirst()
                .orElse(null);

        int durabilidadeNova = durabilidadeAtual + quantidade;

        int limiteMaximo = switch (material.name().toLowerCase()) {
            case "madeira" -> limiteMaximo = 50;
            case "pedra" -> limiteMaximo = 70;
            case "ferro" -> limiteMaximo = 100;
            case "ouro" -> limiteMaximo = 30;
            default -> limiteMaximo = 60;
        };

        if (durabilidadeNova > limiteMaximo) {
            System.out.println(" Reparo limitado a " + limiteMaximo);
            durabilidadeNova = limiteMaximo;
        }

        System.out.println(" Durabilidade nova: " + durabilidadeNova);

        picaretaSelecionada.setDurabilidade(durabilidadeNova);
        return durabilidadeNova;
    }
}