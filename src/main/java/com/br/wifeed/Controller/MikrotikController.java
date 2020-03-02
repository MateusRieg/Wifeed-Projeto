package com.br.wifeed.Controller;

import com.br.wifeed.API.MikrotikAPI;
import com.br.wifeed.DAO.MikrotikDAO;
import com.br.wifeed.Entities.Mikrotik;
import javassist.NotFoundException;
import me.legrange.mikrotik.MikrotikApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class MikrotikController {

    @Autowired
    private MikrotikDAO mikrotikDAO;

    private MikrotikAPI mikrotikAPI;

    @RequestMapping(value = "/mikrotik")
    public List<Mikrotik> getAllMikrotik() throws MikrotikApiException {
        return mikrotikDAO.findAll();

    }
    @RequestMapping(value = "mikrotik/leases")
    public List<Map<String,String>> returnLeases() throws MikrotikApiException{
        return mikrotikAPI.printLeasesDHCP();
    }

    @RequestMapping("/mikrotik/{id}")
    public ResponseEntity<Mikrotik> getMikrotikById(@PathVariable(value = "id") Long mikrotikId) throws NotFoundException, MikrotikApiException {
        Mikrotik mikrotik = mikrotikDAO.findById(mikrotikId).orElseThrow(() -> new NotFoundException("Unable to get person " + mikrotikId));
        return ResponseEntity.ok().body(mikrotik);
    }
    @PostMapping("/mikrotik")
    public Mikrotik createMikrotik(@Valid @RequestBody Mikrotik mikrotik){
        return mikrotikDAO.save(mikrotik);
    }
    @PutMapping("/mikrotik/{id}")
    public ResponseEntity<Mikrotik> updateMikrotik(@PathVariable(value = "id") Long mikrotikId, @Valid @RequestBody Mikrotik mikrotikInfo) throws NotFoundException {
        Mikrotik mikrotik = mikrotikDAO.findById(mikrotikId).orElseThrow(() -> new NotFoundException("Unable to get person " + mikrotikId));

        mikrotik.setIdentRot(mikrotik.getIdentRot());
        mikrotik.setDescricaoHost(mikrotik.getDescricaoHost());
        mikrotik.setLeasesDHCP(mikrotik.getLeasesDHCP());
        mikrotik.setMacRot(mikrotik.getMacRot());
        mikrotik.setIpStaticos(mikrotik.getIpStaticos());
        mikrotik.setVersaoRot(mikrotik.getVersaoRot());
        mikrotik.setFaixaDHCP(mikrotik.getFaixaDHCP());
        mikrotik.setLocalRot(mikrotik.getLocalRot());

        final Mikrotik updateMikrotik = mikrotikDAO.save(mikrotik);
        return ResponseEntity.ok(updateMikrotik);
    }
    @DeleteMapping("/mikrotik/{id}")
    public Map<String, Boolean> deleteMikrotik(@PathVariable(value = "id") Long mikrotikId) throws NotFoundException {
        Mikrotik mikrotik = mikrotikDAO.findById(mikrotikId).orElseThrow(() -> new NotFoundException("Unable to get person " + mikrotikId));

        mikrotikDAO.delete(mikrotik);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
