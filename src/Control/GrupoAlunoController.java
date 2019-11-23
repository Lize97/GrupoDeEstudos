package Control;

import Model.GrupoAluno;
import Model.DAO.GrupoAlunoDAO;
import java.util.List;
import javax.swing.DefaultListModel;

/**
 *
 * @author jhow
 */
public class GrupoAlunoController extends GenericController<GrupoAluno> {

    @Override
    public GrupoAluno buscarPorId(int id) {
        return new GrupoAlunoDAO().buscarPorId(id);
    }

    @Override
    public List<GrupoAluno> listar() {
        return new GrupoAlunoDAO().listar();
    }

    public void remover(GrupoAluno grupo_aluno) {
        new GrupoAlunoDAO().remover(grupo_aluno);
    }

    public void inserir(GrupoAluno grupo_aluno) {
        new GrupoAlunoDAO().inserir(grupo_aluno);
    }

    public DefaultListModel<GrupoAluno> listarModelo() {
        DefaultListModel listaModelo = new DefaultListModel();
        for (GrupoAluno grupo_aluno : listar()) {
            listaModelo.addElement(grupo_aluno);
        }
        return listaModelo;

    }
}
