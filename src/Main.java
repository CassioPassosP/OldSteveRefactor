import classes.entidades.PicaretaEntidade;
import classes.services.PicaretaServico;
import enums.Materiais;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        PicaretaServico picaretaService = new PicaretaServico();

        System.out.println("""
                  ╔════════════════════════════════════════════════════════════════════╗
                  ║        VELHO STEVE - FÁBRICA REFATORADA DE PICARETAS MANUAL        ║
                  ╚════════════════════════════════════════════════════════════════════╝\s
                """);

        //Fabricar
        String picareta1 = picaretaService.Fabricar(Materiais.MADEIRA);

        String picareta2 = picaretaService.Fabricar(Materiais.PEDRA);

        String picareta3 = picaretaService.Fabricar(Materiais.FERRO);

//        System.out.println("\nPicaretas no inventario:");
//        for (String picareta : picaretaService){
//            System.out.println(" • " + picareta);
//        }

        //Minera

        //Reparar

        //Estado final
    }
}
