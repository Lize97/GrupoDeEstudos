package Model.DAO;
import Model.Aluno;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author andre
 */
public class AlunoDAO extends GenericDAO<Aluno>{

        public List<Aluno> listar() {        
        String sql = "SELECT * FROM aluno";
        List<Aluno> lista = new ArrayList<Aluno>();
        try {//TENTA EXECUTAR O CODIGO E TRATA SE DER ERRO
            PreparedStatement pstmt = getConnection().prepareStatement(sql);//PEGA A CONEXAO E PASSA POR PARAMETRO
            ResultSet rs = pstmt.executeQuery();// INFORMA O TIPO DE EXECUÇÃO DA QUERY E GUARDA NA ESTRUTURA RESULTSET O RESULTADO DA BUSCA

            while (rs.next()) { // PERCORRE A LISTA PARA ADCIONAR NA LISTA OS RESULTADOS ENQUANTO TIVER ITENS NA LISTA
                Aluno aluno = new Aluno(rs.getInt("id"));//CRIA UM NOVO ALUNO DENTRO DO WHILE
                aluno.setNome(rs.getString("nome"));
                lista.add(aluno); // ADCIONA O ALUNO A LISTA ANTES DE ZERAR OBJETO
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
    public void inserir(Aluno obj) {
        String sql = "INSERT INTO aluno (nome, email, data_nascimento, sexo, aceita_msg, observacoes, curso_id) VALUES (?,?,?,?,?,?,?)";
        try {
            PreparedStatement pstmt = getConnection().prepareStatement(sql);//CRIANDO UMA CONEXÃO E UMA CONSULTA PREPARADA
            pstmt.setString(1, obj.getNome());
            pstmt.execute();
            pstmt.close();
            getConnection().close();
        } catch (SQLException e) {
            System.err.print("ERRO AO INSERIR");

        }

    }

    @Override
    public void editar(Aluno obj) {
        String sql = "UPDATE aluno SET nome = ?, email = ?, data_nascimento = ?, sexo = ?, aceita_msg = ?, oberservacoes = ?, curso_id = ? WHERE id = ?";
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
    public void remover(Aluno obj) {
        String sql = "DELETE FROM aluno WHERE id = ?";
        delete(sql, obj.getId());

    }

    @Override
    public Aluno buscarPorId(int id) {
        String sql = "SELECT * FROM aluno WHERE id = ?";
        Aluno aluno = null;
        try {//TENTA EXECUTAR O CODIGO E TRATA SE DER ERRO
            PreparedStatement pstmt = getConnection().prepareStatement(sql);//PEGA A CONEXAO E PASSA POR PARAMETRO
            pstmt.setInt(1, id); //SETA QUEM SUBSTITUI O ? POR ID
            ResultSet rs = pstmt.executeQuery();// INFORMA O TIPO DE EXECUÇÃO DA QUERY E GUARDA NA ESTRUTURA RESULTSET O RESULTADO DA BUSCA

            while (rs.next()) { // PERCORRE A LISTA PARA MOSTRAR OS RESULTADO
                aluno = new Aluno(rs.getInt("id"));
                aluno.setNome(rs.getString("nome"));
            }
            rs.close();
            pstmt.close();
            getConnection().close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return aluno;
    }

    
    
}
