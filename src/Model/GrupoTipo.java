/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author andre
 */
public class GrupoTipo {

    private String nome;
    private Integer id;

    public String toString() {
        return getNome(); //To change body of generated methods, choose Tools | Templates.
    }

    public GrupoTipo(Integer id) {
        this.id = id;
    }

    public GrupoTipo(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
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
}
