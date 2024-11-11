package hu.unideb.inf.esemenykezelo.data.repository;

import hu.unideb.inf.esemenykezelo.data.entity.JogosultsagEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JogosultsagRepository extends JpaRepository<JogosultsagEntity, Long> {
    JogosultsagEntity findByNev(String nev);
}
