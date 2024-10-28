package hu.unideb.inf.esemenykezelo.data.repository;

import hu.unideb.inf.esemenykezelo.data.entity.CsoportEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CsoportRepository extends JpaRepository<CsoportEntity, Long> {
}
