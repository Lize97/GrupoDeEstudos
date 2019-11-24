package Model.DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Model.Campus;

/**
 *
 * @author andre
 */
public class CampusDAO extends GenericDAO<Campus> {

    public List<Campus> listar() {        
        String sql = "SELECT * FROM campus";
        List<Campus> lista = new ArrayList<Campus>();
        try {//TENTA EXECUTAR O CODIGO E TRATA SE DER ERRO
            PreparedStatement pstmt = getConnection().prepareStatement(sql);//PEGA A CONEXAO E PASSA POR PARAMETRO
            ResultSet rs = pstmt.executeQuery();// INFORMA O TIPO DE EXECUÇÃO DA QUERY E GUARDA NA ESTRUTURA RESULTSET O RESULTADO DA BUSCA

            while (rs.next()) { // PERCORRE A LISTA PARA ADCIONAR NA LISTA OS RESULTADOS ENQUANTO TIVER ITENS NA LISTA
                Campus campus = new Campus(rs.getInt("id"));//CRIA UM NOVO ALUNO DENTRO DO WHILE
                campus.setNome(rs.getString("nome"));
                lista.add(campus); // ADCIONA O ALUNO A LISTA ANTES DE ZERAR OBJETO
            }
            rs.close();
            pstmt.close();
            getConnection().close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;

    }

    @Override
    public Campus inserir(Campus obj) {
        String sql = "INSERT INTO campus (nome, email, data_nascimento, sexo, aceita_msg, observacoes, curso_id) VALUES (?,?,?,?,?,?,?)";
        try {
            PreparedStatement pstmt = getConnection().prepareStatement(sql);//CRIANDO UMA CONEXÃO E UMA CONSULTA PREPARADA
            pstmt.setString(1, obj.getNome());
            pstmt.execute();
            pstmt.close();
            getConnection().close();
        } catch (SQLException e) {
            System.err.print("ERRO AO INSERIR");

        }
return obj;
    }

    @Override
    public void editar(Campus obj) {
        String sql = "UPDATE campus SET nome = ?, email = ?, data_nascimento = ?, sexo = ?, aceita_msg = ?, oberservacoes = ?, curso_id = ? WHERE id = ?";
        try {
            PreparedStatement pstmt = getConnection().prepareStatement(sql);//CRIANDO UMA CONEXÃO E UMA CONSULTA PREPARADA
            pstmt.setString(1, obj.getNome());
            pstmt.setInt(8, obj.getId());
            pstmt.execute();
            pstmt.close();
            getConnection().close();
        } catch (SQLException e) {
            System.err.print("ERRO AO EDITAR");

        }

    }

    @Override
    public void remover(Campus obj) {
        String sql = "DELETE FROM campus WHERE id = ?";
        delete(sql, obj.getId());

    }

    @Override
    public Campus buscarPorId(int id) {
        String sql = "SELECT * FROM campus WHERE id = ?";
        Campus campus = null;
        try {//TENTA EXECUTAR O CODIGO E TRATA SE DER ERRO
            PreparedStatement pstmt = getConnection().prepareStatement(sql);//PEGA A CONEXAO E PASSA POR PARAMETRO
            pstmt.setInt(1, id); //SETA QUEM SUBSTITUI O ? POR ID
            ResultSet rs = pstmt.executeQuery();// INFORMA O TIPO DE EXECUÇÃO DA QUERY E GUARDA NA ESTRUTURA RESULTSET O RESULTADO DA BUSCA

            while (rs.next()) { // PERCORRE A LISTA PARA MOSTRAR OS RESULTADO
                campus = new Campus(rs.getInt("id"));
                campus.setNome(rs.getString("nome"));
            }
            rs.close();
            pstmt.close();
            getConnection().close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return campus;
    }

}

