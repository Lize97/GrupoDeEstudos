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
public class Curso {

    private String nome;
    private Integer id;
    private Campus Campus;

    public String toString() {
        return getNome(); //To change body of generated methods, choose Tools | Templates.
    }

    public Campus getCampus() {
        return Campus;
    }

    public void setCampus(Campus Campus) {
        this.Campus = Campus;
    }

    public Curso() {

    }

    public Curso(Integer id) {
        this.id = id;
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
