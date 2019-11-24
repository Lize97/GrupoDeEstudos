package Model.DAO;

import Model.Aluno;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author andre
 */
public class AlunoDAO extends GenericDAO<Aluno> {

    public List<Aluno> listar() {
        String sql = "SELECT * FROM aluno";
        List<Aluno> lista = new ArrayList<Aluno>();
        try {//TENTA EXECUTAR O CODIGO E TRATA SE DER ERRO
            PreparedStatement pstmt = getConnection().prepareStatement(sql);//PEGA A CONEXAO E PASSA POR PARAMETRO
            ResultSet rs = pstmt.executeQuery();// INFORMA O TIPO DE EXECUÇÃO DA QUERY E GUARDA NA ESTRUTURA RESULTSET O RESULTADO DA BUSCA
            while (rs.next()) { // PERCORRE A LISTA PARA ADCIONAR NA LISTA OS RESULTADOS ENQUANTO TIVER ITENS NA LISTA
                Aluno aluno = new Aluno(rs.getLong("id"));//CRIA UM NOVO ALUNO DENTRO DO WHILE
                aluno.setNome(rs.getString("nome"));
                aluno.setDataNascimento(rs.getDate("data_nasc"));
                aluno.setCurso(new CursoDAO().buscarPorId(rs.getInt("curso_id")));
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
    public Aluno inserir(Aluno obj) {
        String sql = "INSERT INTO aluno (nome, data_nascimento, curso_id) VALUES (?,?,?)";
        try {
            PreparedStatement pstmt = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, obj.getNome());
            pstmt.setDate(2, (Date) obj.getDataNascimento());
            pstmt.setInt(3, obj.getCurso().getId());
            pstmt.execute();

            ResultSet rs = pstmt.getGeneratedKeys();
            rs.next();
            obj.setId(rs.getLong(1));

            pstmt.close();
            getConnection().close();
        } catch (SQLException e) {
            System.err.print("ERRO AO INSERIR");

        }
        return obj;
    }

    @Override
    public void editar(Aluno obj) {
        String sql = "UPDATE aluno SET nome = ?,  data_nascimento = ?, curso_id = ? WHERE id = ?";
        try {
            PreparedStatement pstmt = getConnection().prepareStatement(sql);//CRIANDO UMA CONEXÃO E UMA CONSULTA PREPARADA
            pstmt.setString(1, obj.getNome());
            pstmt.setDate(2, (Date) obj.getDataNascimento());
            pstmt.setInt(15, obj.getCurso().getId());
            pstmt.setLong(4, obj.getId());
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
       // delete(sql, obj.getId());

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
                aluno = new Aluno(rs.getLong("id"));
                aluno.setNome(rs.getString("nome"));
                aluno.setDataNascimento(rs.getDate("data_nasc"));
                aluno.setCurso(new CursoDAO().buscarPorId(rs.getInt("curso_id")));
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
