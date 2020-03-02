package com.br.wifeed.DTO;


import com.br.wifeed.Entities.Mikrotik;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class MikrotikDTO implements Serializable {

    private static final long serialVersionUID = 5942188757507100990L;

    private Long id;
    @NotNull
    @NotEmpty
    private String localRot;
    @NotNull
    @NotEmpty
    private String identRot;

    private String faixaDHCP;

    private String leasesDHCP;

    private String versaoRot;

    private String ipStaticos;

    private String macRot;

    private String descricaoHost;

    public Mikrotik converter(Mikrotik mikrotik){
        mikrotik.setLocalRot(localRot);
        mikrotik.setFaixaDHCP(faixaDHCP);
        mikrotik.setLeasesDHCP(leasesDHCP);
        mikrotik.setVersaoRot(versaoRot);
        mikrotik.setIpStaticos(ipStaticos);
        mikrotik.setMacRot(macRot);
        mikrotik.setDescricaoHost(descricaoHost);

        return mikrotik;

    }
}
