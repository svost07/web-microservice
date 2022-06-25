package fr.dauphine.miageif.msa.MSA.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import lombok.Data;

/*Classe persistente representant  un compte bancaire
 @Entity est une annotation qui indique que la classe
 correspond à une table de la base de données.*/
@Data
@Entity
public class BankAccount {

    @Id
    private String iban;

    @Column(name="account_type")
    private String account;

    @Column(name="interest")
    private BigDecimal interest;

    @Column(name="fees")
    private BigDecimal fees;

    public BankAccount(){}

    public BankAccount(String iban, String account, BigDecimal interest, BigDecimal fees) {
        super();
        this.iban = iban;
        this.account = account;
        this.interest = interest;
        this.fees = fees;
    }

    // On surcharge pour retourner du JSON
    /* grâce à l'annotation @RestController.
    Spring sait alors que les réponses aux requêtes
    qu'il vous passe devront être très probablement en format JSON.*/
    @Override
    public String toString() {
        return "BankAccount{" +
                "IBAN=" + iban +
                ", acount type='" + account + '\'' +
                ", interest=" + interest + '\'' +
                ", fees=" + fees +
                '}';
    }
}
