/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author andre
 */
public class Grupo {

    private String nome;
    private Integer id;
    private Integer ano;
    private Integer semestre;
    private String objetivo;
    private String atividade;
    private String local;
    private Integer diaSemana;
    private Time horaInicio;
    private Time horaFim;
    private Date dataInicio;
    private Integer qtdMinPar;
    private Integer qtdMaxPar;
    private Integer qtdEncontro;
    private Boolean ativo;
    private GrupoTipo GrupoTipo;
    private Aluno Aluno;
    private Campus Campus;

    public Campus getCampus() {
        return Campus;
    }

    public void setCampus(Campus Campus) {
        this.Campus = Campus;
    }

    public Aluno getAluno() {
        return Aluno;
    }

    public void setAluno(Aluno Aluno) {
        this.Aluno = Aluno;
    }

    public GrupoTipo getGrupoTipo() {
        return GrupoTipo;
    }

    public void setGrupoTipo(GrupoTipo GrupoTipo) {
        this.GrupoTipo = GrupoTipo;
    }

    public Grupo() {

    }

    public String getNome() {
        return nome;
    }

    public Grupo(Integer id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Integer getSemestre() {
        return semestre;
    }

    public void setSemestre(Integer semestre) {
        this.semestre = semestre;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public String getAtividade() {
        return atividade;
    }

    public void setAtividade(String atividade) {
        this.atividade = atividade;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public Integer getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(Integer diaSemana) {
        this.diaSemana = diaSemana;
    }

    public Time getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Time horaIninicio) {
        this.horaInicio = horaIninicio;
    }

    public Time getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(Time horaFim) {
        this.horaFim = horaFim;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Integer getQtdMinPar() {
        return qtdMinPar;
    }

    public void setQtdMinPar(Integer qtdMinPar) {
        this.qtdMinPar = qtdMinPar;
    }

    public Integer getQtdMaxPar() {
        return qtdMaxPar;
    }

    public void setQtdMaxPar(Integer qtdMaxPar) {
        this.qtdMaxPar = qtdMaxPar;
    }

    public Integer getQtdEncontro() {
        return qtdEncontro;
    }

    public void setQtdEncontro(Integer qtdEncontro) {
        this.qtdEncontro = qtdEncontro;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

}
