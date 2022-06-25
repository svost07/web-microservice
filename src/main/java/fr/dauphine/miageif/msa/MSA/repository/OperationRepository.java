package fr.dauphine.miageif.msa.MSA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import fr.dauphine.miageif.msa.MSA.model.Operation;
import org.springframework.stereotype.Repository;

/* Implementation de la communication entre l’application et la base de donnees*/
@Repository
public interface OperationRepository extends JpaRepository<Operation, Long>{

}
