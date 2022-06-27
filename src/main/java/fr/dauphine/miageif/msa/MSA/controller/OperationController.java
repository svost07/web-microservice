package fr.dauphine.miageif.msa.MSA.controller;

import fr.dauphine.miageif.msa.MSA.model.BankAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.List;
import fr.dauphine.miageif.msa.MSA.model.Operation;
import fr.dauphine.miageif.msa.MSA.service.OperationService;

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
     * Read - Get one operation with the id
     * @param id The id of the operation
     * @return An BankAccount object full filled
     */
    @GetMapping("/operation/{id}")
    public Operation getOperation(@PathVariable("id") final Long id) {
        Optional<Operation> operation = operationService.getOperation(id);
        if(operation.isPresent()) {
            return operation.get();
        } else {
            return null;
        }
    }

    /**
     * Read - Get one operation with the origin iban
     * @param id The iban of the operation origin
     * @return An BankAccount object full filled
     */
    @GetMapping("/operation/source/{id}")
    public List<Operation> getOperationBySourceId(@PathVariable("id") final String id) {
        return operationService.getOperationBySourceId(id);
    }

    /**
     * Read - Get one operation with the operation type
     * @param id The type of the operation
     * @return An BankAccount object full filled
     */
    @GetMapping("/operation/type/{id}")
    public List<Operation> getOperationByTypeId(@PathVariable("id") final String id) {
        return operationService.getOperationByTypeId(id);
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

    @DeleteMapping("/operation/{id}")
    public void delete_operation(@PathVariable("id") final long id) {
        Optional<Operation> operation = operationService.getOperation(id);
        if(operation.isPresent()) {
            operationService.deleteOperation(id);
        }
    }
}
