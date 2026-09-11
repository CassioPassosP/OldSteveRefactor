package classes.services;

import classes.entidades.PicaretaEntidade;
import classes.repositorio.PicaretaRepositorio;
import enums.Materiais;
import interfaces.FerramentaColeta;

public class PicaretaServico implements FerramentaColeta {
    private final PicaretaRepositorio repositorio;

    public PicaretaServico(PicaretaRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public int Minerar(String nome,Materiais material, int durabilidade, int forca, int blocos) {
        System.out.println("\n=== MINERANDO COM PICARETA DE " + material + " ===");
        System.out.println("Durabilidade atual: " + durabilidade);
        System.out.println("Força: " + forca);
        System.out.println("Blocos a minerar: " + blocos);

        PicaretaEntidade picaretaSelecionada = repositorio.listar().stream()
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
            case "madeira" -> durabilidade = Materiais.MADEIRA.getDurabilidade();
            case "pedra" -> durabilidade = Materiais.PEDRA.getDurabilidade();
            case "ferro" -> durabilidade = Materiais.FERRO.getDurabilidade();
            case "ouro" -> durabilidade = Materiais.OURO.getDurabilidade();
            default -> durabilidade = 60;
        };

        System.out.println("Durabilidade: " + durabilidade);

        int forca = switch (material.name().toLowerCase()) {
                    case "madeira" -> forca = Materiais.MADEIRA.getForca();
                    case "pedra" -> forca = Materiais.PEDRA.getForca();
                    case "ferro" -> forca = Materiais.FERRO.getForca();
                    case "ouro" -> forca = Materiais.OURO.getForca();
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
        repositorio.adicionar(picaretaCriada);

        return "Picareta de " + material + " (D: " + durabilidade + ", F: " + forca + ")";
    }

    @Override
    public int Reparar(String nome, Materiais material, int durabilidadeAtual, int quantidade) {
        System.out.println("\n=== REPARANDO PICARETA DE " + material + " ===");
        System.out.println("Durabilidade atual: " + durabilidadeAtual);
        System.out.println("Quantidade a reparar: " + quantidade);

        PicaretaEntidade picaretaSelecionada = repositorio.listar().stream()
                .filter(picareta -> picareta.getNome().equalsIgnoreCase(nome))
                .findFirst()
                .orElse(null);

        int durabilidadeNova = durabilidadeAtual + quantidade;

        int limiteMaximo = switch (material.name().toLowerCase()) {
            case "madeira" -> limiteMaximo = Materiais.MADEIRA.getDurabilidade();
            case "pedra" -> limiteMaximo = Materiais.PEDRA.getDurabilidade();
            case "ferro" -> limiteMaximo = Materiais.FERRO.getDurabilidade();
            case "ouro" -> limiteMaximo = Materiais.OURO.getDurabilidade();
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