package fr.dauphine.miageif.msa.MSA.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import fr.dauphine.miageif.msa.MSA.model.BankAccount;
import fr.dauphine.miageif.msa.MSA.repository.BankRepository;
import lombok.Data;

@Data
@Service
public class BankService {

    @Autowired
    private BankRepository bankRepository;

    public Optional<BankAccount> getAccount(final String iban) {
        return bankRepository.findById(iban);
    }

    public Iterable<BankAccount> getAccounts() {
        return bankRepository.findAll();
    }

    public void deleteAccount(final String iban) {
        bankRepository.deleteById(iban);
    }

    public BankAccount saveAccount(BankAccount iban) {
        BankAccount saveIban = bankRepository.save(iban);
        return saveIban;
    }

}
