package hu.unideb.inf.esemenykezelo.data.repository;

import hu.unideb.inf.esemenykezelo.data.entity.FelhasznaloEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FelhasznaloRepository extends JpaRepository<FelhasznaloEntity, Long> {
}