package com.br.wifeed.Entities;



import javax.persistence.*;

@Entity
@Table
public class LocalEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String nome;
    @Column
    private String local;
    @Column
    private Long parentid;
    @Column
    private Long childId;
}
