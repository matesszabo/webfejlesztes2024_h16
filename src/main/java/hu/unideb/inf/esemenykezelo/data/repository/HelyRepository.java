package hu.unideb.inf.esemenykezelo.data.repository;

import hu.unideb.inf.esemenykezelo.data.entity.HelyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HelyRepository extends JpaRepository<HelyEntity, Long> {
}