package fr.dauphine.miageif.msa.MSA.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.Optional;
import fr.dauphine.miageif.msa.MSA.model.BankAccount;
import fr.dauphine.miageif.msa.MSA.service.BankService;

/* Exposez les endpoints REST */
@RestController
public class BankController {

    // Spring se charge de la creation d'instance
    @Autowired
    private BankService bankService;

    /**
     * Read - Get all bank accounts
     * @return - An Iterable object of BankAccount full filled
     */
    @GetMapping("/accounts")
    public Iterable<BankAccount> getAccounts() {
        return bankService.getAccounts();
    }

    /**
     * Read - Get one account
     * @param iban The iban of the account
     * @return An BankAccount object full filled
     */
    @GetMapping("/account/{iban}")
    public BankAccount getEmployee(@PathVariable("iban") final String iban) {
        Optional<BankAccount> account = bankService.getAccount(iban);
        if(account.isPresent()) {
            return account.get();
        } else {
            return null;
        }
    }

    /**
     * Create - Add a new account
     * @param account An object BankAccount
     * @return The account object saved
     */
    @PostMapping("/account")
    public BankAccount createAccount(@RequestBody BankAccount account) {
        return bankService.saveAccount(account);
    }

}
