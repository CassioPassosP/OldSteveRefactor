import classes.services.PicaretaServico;
import enums.Materiais;

public class Main {
    public static void main(String[] args) {

        PicaretaServico picaretaService = new PicaretaServico();

        picaretaService.Fabricar(
                Materiais.MADEIRA,
                50,
                5
                );

        picaretaService.Fabricar(
                Materiais.PEDRA,
                70,
                8
        );

        picaretaService.Fabricar(
                Materiais.FERRO,
                100,
                12
        );
    }
}
