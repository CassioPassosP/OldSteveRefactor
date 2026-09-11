import classes.entidades.PicaretaEntidade;
import classes.repositorio.PicaretaRepositorio;
import classes.services.PicaretaServico;
import enums.Materiais;

public class Main {
    public static void main(String[] args) {
        PicaretaRepositorio picaretaRepositorio = new PicaretaRepositorio();
        PicaretaServico picaretaService = new PicaretaServico(picaretaRepositorio);

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
        for (PicaretaEntidade picareta : picaretaRepositorio.listar()){
            System.out.println(" • " + picareta.getNome());
        }

        //Minerar
        PicaretaEntidade picaretaStream = picaretaRepositorio.listar().stream()
                .filter(picareta -> picareta.getNome().equalsIgnoreCase("Picareta de ouro"))
                .findFirst()
                .orElse(null);

        int novaDurabilidade = picaretaService.Minerar(picaretaStream.getNome(), picaretaStream.getMaterial(),picaretaStream.getDurabilidade(), picaretaStream.getForca(), picaretaStream.getBlocos());

        //Reparar
        int reparar = picaretaService.Reparar(picaretaStream.getNome(), picaretaStream.getMaterial(),picaretaStream.getDurabilidade(), 29);

        //Estado final
        System.out.println("\nEstado final das picaretas:");
        for (PicaretaEntidade picareta : picaretaRepositorio.listar()){
            System.out.println(" • " + picareta.toString());
        }

    }
}
