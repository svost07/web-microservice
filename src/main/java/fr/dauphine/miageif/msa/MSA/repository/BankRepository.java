package fr.dauphine.miageif.msa.MSA.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import fr.dauphine.miageif.msa.MSA.model.BankAccount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/* Implementation de la communication entre l’application et la base de donnees*/
@Repository
public interface BankRepository extends JpaRepository<BankAccount, String> {
    //BankAccount findBySourceAndDest(String source, String dest);
}
