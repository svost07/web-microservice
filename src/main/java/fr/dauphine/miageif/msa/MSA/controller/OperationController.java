package fr.dauphine.miageif.msa.MSA.controller;
import java.util.Optional;

import fr.dauphine.miageif.msa.MSA.model.Operation;
import fr.dauphine.miageif.msa.MSA.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/* Exposez les endpoints REST */
@RestController
public class OperationController {
    // Spring se charge de la creation d'instance
    @Autowired
    private OperationService operationService;

    /**
     * Read - Get all bank operations
     * @return - An Iterable object of Operation full filled
     */
    @GetMapping("/operations")
    public Iterable<Operation> getOperations() {
        return operationService.getOperations();
    }

    /**
     * Read - Get one employee
     * @param id The id of the operation
     * @return An BankAccount object full filled
     */
    @GetMapping("/operation/{id}")
    public Operation getEmployee(@PathVariable("id") final Long id) {
        Optional<Operation> operation = operationService.getOperation(id);
        if(operation.isPresent()) {
            return operation.get();
        } else {
            return null;
        }
    }

    /**
     * Create - Add a new operation
     * @param operation An object Operation
     * @return The operation object saved
     */
    @PostMapping("/operation")
    public Operation createOperation(@RequestBody Operation operation) {
        return operationService.saveOperation(operation);
    }

}
