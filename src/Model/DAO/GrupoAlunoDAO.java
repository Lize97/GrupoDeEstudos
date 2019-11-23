package Model.DAO;

import Model.GrupoAluno;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GrupoAlunoDAO extends GenericDAO<GrupoAluno> {

    @Override
    public void inserir(GrupoAluno obj) {
        String sql = "INSERT INTO grupo_aluno (data_entrada, aluno_id, grupo_id) "
                + "VALUES (?,?,?)";
        try {
            PreparedStatement pstmt = getConnection().prepareStatement(sql);//CRIANDO UMA CONEXÃO E UMA CONSULTA PREPARADA
            pstmt.setDate(1, obj.getDataEntrada());
            pstmt.setInt(2, obj.getAluno().getId());
            pstmt.setInt(3, obj.getGrupo().getId());
            pstmt.execute();
            pstmt.close();
            getConnection().close();
        } catch (SQLException e) {
            System.err.print("ERRO AO INSERIR");

        }

    }

    @Override
    public void editar(GrupoAluno obj) {
        String sql = "UPDATE grupo_aluno SET data_entrada = ?, aluno_id = ?, grupo_id = ?, WHERE id = ?";

        try {
            PreparedStatement pstmt = getConnection().prepareStatement(sql);//CRIANDO UMA CONEXÃO E UMA CONSULTA PREPARADA
            pstmt.setDate(1, obj.getDataEntrada());
            pstmt.setInt(2, obj.getId());
            pstmt.setInt(3, obj.getAluno().getId());
            pstmt.setInt(4, obj.getGrupo().getId());
            pstmt.execute();
            pstmt.close();
            getConnection().close();
        } catch (SQLException e) {
            System.err.print("ERRO AO EDITAR");

        }

    }

    @Override
    public void remover(GrupoAluno obj) {
        String sql = "DELETE FROM grupo_aluno WHERE id = ?";
        delete(sql, obj.getId());

    }

    @Override
    public GrupoAluno buscarPorId(int id) {
        String sql = "SELECT * FROM grupo_aluno WHERE id = ?";
        GrupoAluno aluno = null;
        try {//TENTA EXECUTAR O CODIGO E TRATA SE DER ERRO
            PreparedStatement pstmt = getConnection().prepareStatement(sql);//PEGA A CONEXAO E PASSA POR PARAMETRO
            pstmt.setInt(1, id); //SETA QUEM SUBSTITUI O ? POR ID
            ResultSet rs = pstmt.executeQuery();// INFORMA O TIPO DE EXECUÇÃO DA QUERY E GUARDA NA ESTRUTURA RESULTSET O RESULTADO DA BUSCA

            while (rs.next()) { // PERCORRE A LISTA PARA MOSTRAR OS RESULTADO
                aluno = new GrupoAluno(rs.getInt("id"));
                aluno.setDataEntrada(rs.getDate("data_entrada"));
                aluno.setAluno(new AlunoDAO().buscarPorId(rs.getInt("aluno_id")));
                grupo.setGrupo(new GrupoDAO().buscarPorId(rs.getInt("grupo_id")));
            }
            rs.close();
            pstmt.close();
            getConnection().close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return aluno;
    }

    @Override
    public List<GrupoAluno> listar() {
        String sql = "SELECT * FROM grupo_aluno";
        List<GrupoAluno> lista = new ArrayList<GrupoAluno>();
        try {//TENTA EXECUTAR O CODIGO E TRATA SE DER ERRO
            PreparedStatement pstmt = getConnection().prepareStatement(sql);//PEGA A CONEXAO E PASSA POR PARAMETRO
            ResultSet rs = pstmt.executeQuery();// INFORMA O TIPO DE EXECUÇÃO DA QUERY E GUARDA NA ESTRUTURA RESULTSET O RESULTADO DA BUSCA

            while (rs.next()) { // PERCORRE A LISTA PARA MOSTRAR OS RESULTADO
                GrupoAluno grupo_aluno = new GrupoAluno(rs.getInt("id"));
                grupo_aluno.setDataEntrada(rs.getDate("data_entrada"));
                grupo_aluno.setAluno(new AlunoDAO().buscarPorId(rs.getInt("aluno_id")));
                grupo_aluno.setGrupo(new GrupoDAO().buscarPorId(rs.getInt("grupo_id")));
                lista.add(grupo_aluno);
            }
            rs.close();
            pstmt.close();
            getConnection().close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return lista;
    }

}
