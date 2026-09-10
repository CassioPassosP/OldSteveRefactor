import classes.entidades.PicaretaEntidade;
import classes.services.PicaretaServico;
import enums.Materiais;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        PicaretaServico picaretaService = new PicaretaServico();
        PicaretaEntidade picaretaEntidade = new PicaretaEntidade();

        System.out.println("""
                  ╔════════════════════════════════════════════════════════════════════╗
                  ║        VELHO STEVE - FÁBRICA REFATORADA DE PICARETAS MANUAL        ║
                  ╚════════════════════════════════════════════════════════════════════╝\s
                """);

        //Fabricar
        String picaretaMadeira = picaretaService.Fabricar(Materiais.MADEIRA);

        String picaretaPedra = picaretaService.Fabricar(Materiais.PEDRA);

        String picaretaFerro = picaretaService.Fabricar(Materiais.FERRO);

        String picaretaOuro = picaretaService.Fabricar(Materiais.OURO);

        System.out.println("\nPicaretas fabricadas:");
        for (PicaretaEntidade picareta : picaretaEntidade.getPicaretas()){
            System.out.println(" • " + picareta.getNome());
        }

        //Minerar
        PicaretaEntidade picaretaStream = picaretaEntidade.getPicaretas().stream()
                .filter(picareta -> picareta.getNome().equalsIgnoreCase("Picareta de ouro"))
                .findFirst()
                .orElse(null);

        int novaDurabilidade = picaretaService.Minerar(picaretaStream.getMaterial(),picaretaStream.getDurabilidade(), picaretaStream.getForca(), picaretaStream.getBlocos());

        //Reparar

        //Estado final
    }
}
