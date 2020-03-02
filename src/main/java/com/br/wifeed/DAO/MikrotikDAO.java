package com.br.wifeed.DAO;

import com.br.wifeed.Entities.Mikrotik;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;


@Repository
public interface MikrotikDAO extends JpaRepository<Mikrotik, Long> {

    }

