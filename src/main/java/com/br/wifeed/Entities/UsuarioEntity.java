package com.br.wifeed.Entities;

import com.br.wifeed.Enums.userEnum;

import javax.persistence.*;

@Entity
@Table(name = "usuario")
public class UsuarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String nome;
    @Column
    private String senha;
    @Column
    private userEnum permissao;

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public userEnum getPermissao() {
        return permissao;
    }

    public void setPermissao(userEnum permissao) {
        this.permissao = permissao;
    }

    public UsuarioEntity() {
    }
}
