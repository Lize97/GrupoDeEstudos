package Model;

import java.sql.Date;

public class GrupoAluno {

    private Integer id;
    private Date dataEntrada;
    private Aluno aluno;
    private Grupo grupo;
    
    public GrupoAluno(){
        
    }
    public GrupoAluno(Integer id){
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
    
        public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }
}
