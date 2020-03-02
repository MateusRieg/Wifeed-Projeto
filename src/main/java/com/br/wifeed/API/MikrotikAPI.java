package com.br.wifeed.API;
import com.br.wifeed.DAO.MikrotikDAO;
import com.br.wifeed.Entities.Mikrotik;
import me.legrange.mikrotik.ApiConnection;
import me.legrange.mikrotik.MikrotikApiException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;


public class MikrotikAPI {
    Mikrotik mikrotik = new Mikrotik();

    @Autowired
    private MikrotikDAO mikrotikDAO;

    public void loginRouter() throws MikrotikApiException {
        ApiConnection con = ApiConnection.connect("192.168.100.1"); // connect to router
        con.login("api","api@123"); // log in to router
        con.close(); // disconnect from router

    }
    public List<Map<String, String>> printStaticIPAddress() throws MikrotikApiException {
            ApiConnection con = ApiConnection.connect("192.168.100.1"); // connect to router
            con.login("api", "api@123");
            con.setTimeout(5000);
        List<Map<String, String>> rs = con.execute("/ip/address/print where dynamic=false return address");
        for (Map<String, String> r : rs) {
            System.out.println(r);
        }
        con.close();
        return rs;
    }
    public List<Map<String, String>> printIPAddress() throws MikrotikApiException {
        ApiConnection con = ApiConnection.connect("192.168.100.1"); // connect to router
        con.login("api", "api@123");
        List<Map<String, String>> rs = con.execute("/ip/address/print return address");
            for (Map<String, String> r : rs) {
            System.out.println(r);
        }

        con.close();
        return rs;
    }
    public List<Map<String, String>> printLeasesDHCP() throws MikrotikApiException {
        ApiConnection con = ApiConnection.connect("192.168.100.1"); // connect to router
        con.login("api", "api@123");
        List<Map<String, String>> rs = con.execute("/ip/dhcp-server/lease/print ");
        for (Map<String, String> map : rs) {
            System.out.println(map.get("address"));
//            mikrotikDAO.setLeasesDHCP(map.get("address"));
        }

        con.close();
        return rs ;
    }
}