package com.br.wifeed.Entities;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "mikrotik")
public class Mikrotik {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String localRot;
    @Column
    private String identRot;
    @Column
    private String faixaDHCP;
    @Column
    private String leasesDHCP;
    @Column
    private String versaoRot;
    @Column
    private String ipStaticos;
    @Column
    private String macRot;
    @Column
    private String descricaoHost;

    public Mikrotik() {
    }

    public Long getId() {
        return id;
    }
    public Long setId(Long id){
        this.id = id;
        return id;
    }

    public String getLocalRot() {
        return localRot;
    }

    public void setLocalRot(String localRot) {
        this.localRot = localRot;
    }

    public String getIdentRot() {
        return identRot;
    }

    public void setIdentRot(String identRot) {
        this.identRot = identRot;
    }

    public String getFaixaDHCP() {
        return faixaDHCP;
    }

    public void setFaixaDHCP(String faixaDHCP) {
        this.faixaDHCP = faixaDHCP;
    }

    public String getLeasesDHCP() {
        return leasesDHCP;
    }

    public void setLeasesDHCP(String leasesDHCP) {
        this.leasesDHCP = leasesDHCP;
    }

    public String getVersaoRot() {
        return versaoRot;
    }

    public void setVersaoRot(String versaoRot) {
        this.versaoRot = versaoRot;
    }

    public String getIpStaticos() {
        return ipStaticos;
    }

    public void setIpStaticos(String ipStaticos) {
        this.ipStaticos = ipStaticos;
    }

    public String getMacRot() {
        return macRot;
    }

    public void setMacRot(String macRot) {
        this.macRot = macRot;
    }

    public String getDescricaoHost() {
        return descricaoHost;
    }

    public void setDescricaoHost(String descricaoHost) {
        this.descricaoHost = descricaoHost;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

}
