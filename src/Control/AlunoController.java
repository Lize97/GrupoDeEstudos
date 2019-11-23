package Control;

import Model.Aluno;
import Model.Campus;
import Model.DAO.AlunoDAO;
import Model.DAO.CampusDAO;
import java.util.List;
import javax.swing.DefaultListModel;

/**
 *
 * @author andre
 */
public class AlunoController extends GenericController{

    @Override
    public Object buscarPorId(int id) {
        return new AlunoDAO().buscarPorId(id);
    }

    @Override
    public List <Aluno> listar() {
        return new AlunoDAO().listar();
    }
    public DefaultListModel<Campus> listarModelo(){
        DefaultListModel listaModelo = new DefaultListModel();
        for(Aluno aluno : listar())
               listaModelo.addElement(aluno);
        return listaModelo;
    }
    public void remover(Campus campus){
        new CampusDAO().remover(campus);
    }
    public void inserir(Campus campus){
        new CampusDAO().inserir(campus);
    }
    
    
}
