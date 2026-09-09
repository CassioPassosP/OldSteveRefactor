import classes.entidades.PicaretaEntidade;
import classes.services.PicaretaServico;
import enums.Materiais;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> picaretas = new ArrayList<>();
        PicaretaServico picaretaService = new PicaretaServico();

        System.out.println("""
                  ╔════════════════════════════════════════════════════════════════════╗
                  ║        VELHO STEVE - FÁBRICA REFATORADA DE PICARETAS MANUAL        ║
                  ╚════════════════════════════════════════════════════════════════════╝\s
                """);

        String picareta1 = picaretaService.Fabricar(
                Materiais.MADEIRA,
                50,
                5
                );

        picaretas.add(picareta1);

        String picareta2 = picaretaService.Fabricar(
                Materiais.PEDRA,
                70,
                8
        );

        picaretas.add(picareta2);

        String picareta3 = picaretaService.Fabricar(
                Materiais.FERRO,
                100,
                12
        );

        picaretas.add(picareta3);

        System.out.println("\nPicaretas no inventario:");
        for (String picareta : picaretas){
            System.out.println(" • " + picareta);
        }

        //minerar

        //reparar

        //estado final
    }
}
