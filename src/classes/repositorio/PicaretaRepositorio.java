package classes.repositorio;

import classes.entidades.PicaretaEntidade;

import java.util.ArrayList;
import java.util.List;

public class PicaretaRepositorio {
    private final List<PicaretaEntidade> picaretas = new ArrayList<>();

    public void adicionar(PicaretaEntidade picareta) {
        this.picaretas.add(picareta);
    }

    public List<PicaretaEntidade> listar() {
        return this.picaretas;
    }
}
