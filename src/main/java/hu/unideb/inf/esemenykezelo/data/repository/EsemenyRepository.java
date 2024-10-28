package hu.unideb.inf.esemenykezelo.data.repository;

import hu.unideb.inf.esemenykezelo.data.entity.EsemenyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EsemenyRepository extends JpaRepository<EsemenyEntity, Long> {

    //select * from esemeny where nev like '%nev%';
    List<EsemenyEntity> findAllByNevContains(String nev);
}