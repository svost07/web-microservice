package fr.dauphine.miageif.msa.MSA.model;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.Date;
import lombok.Data;


/*Classe persistente representant une operation bancaire
 @Entity est une annotation qui indique que la classe
 correspond à une table de la base de données.
 @Data permet d'eviter de specifier les geter et seter @Table(name = "bank_operation") */
@Data
@Entity
public class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double amount;

    @Column(name="operation_type")
    private String op_type;

    @Column(name="iban_source")
    private String source;

    @Column(name="iban_target")
    private String target;

    //@Temporal(value=TemporalType.DATE)
    //private Date operation_date;

    public Operation(){}

    public Operation(Long id, Double amount, String op_type, String source, String target) {
        super();
        this.id = id;
        this.op_type = op_type;
        this.source = source;
        this.target = target;
        this.amount = amount;
    }

    // On surcharge pour retourner du JSON
    /* grâce à l'annotation @RestController.
    Spring sait alors que les réponses aux requêtes
    qu'il vous passe devront être très probablement en format JSON.*/
    @Override
    public String toString() {
        return "Operation{" +
                "id=" + id +
                ", operation_type='" + op_type + '\'' +
                ", iban_source=" + source + '\'' +
                ", iban_target=" + target + '\'' +
                ", amount=" + amount + '\'' +
                '}';
    }

}
