package Control;

import Model.Aluno;
import Model.DAO.AlunoDAO;
import java.util.List;
import javax.swing.DefaultListModel;

public class AlunoController extends GenericController<Aluno> {

    @Override
    public Aluno buscarPorId(int id) {
        return new AlunoDAO().buscarPorId(id);
    }

    @Override
    public List<Aluno> listar() {
        return new AlunoDAO().listar();
    }

    public DefaultListModel<Aluno> listarModelo() {
        DefaultListModel listaModelo = new DefaultListModel();
        for (Aluno aluno : listar()) {
            listaModelo.addElement(aluno);
        }
        return listaModelo;
    }

    public void remover(Aluno aluno) {
        new AlunoDAO().remover(aluno);
    }

    public void editar(Aluno aluno) {
        new AlunoDAO().editar(aluno);
    }

    public Aluno inserir(Aluno aluno) {
        return new AlunoDAO().inserir(aluno);
    }

}
