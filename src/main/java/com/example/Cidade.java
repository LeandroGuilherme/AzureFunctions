/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

/**
 *
 * @author Leandro
 */
public class Cidade {

    private Long id;
    private String nome;

    private Estado estado;
    
    public Cidade (){}

    public Cidade(Long id, String nome, Estado estado) {
        this.setId(id);
        this.setNome(nome);
        this.setEstado(estado);
    }
    
     /**
     * @return the id
     */
    public Long getId() {
        return id;
    }
    
     /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

}
