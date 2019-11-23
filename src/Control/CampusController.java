/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.Campus;
import Model.DAO.CampusDAO;
import java.util.List;
import javax.swing.DefaultListModel;

/**
 *
 * @author andre
 */
public class CampusController extends GenericController {

    @Override
    public Object buscarPorId(int id) {
        return new CampusDAO().buscarPorId(id);
    }

    @Override
    public List<Campus> listar() {
        return new CampusDAO().listar();
    }
    
    public DefaultListModel<Campus> listarModelo(){
        DefaultListModel listaModelo = new DefaultListModel();
        for(Campus campus : listar())
               listaModelo.addElement(campus);
        return listaModelo;
    }
    public void remover(Campus campus){
        new CampusDAO().remover(campus);
    }
    public void inserir(Campus campus){
        new CampusDAO().inserir(campus);
    }
    
}
