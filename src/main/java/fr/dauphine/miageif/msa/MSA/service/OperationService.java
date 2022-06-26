package fr.dauphine.miageif.msa.MSA.service;

import java.util.Optional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import fr.dauphine.miageif.msa.MSA.model.Operation;
import fr.dauphine.miageif.msa.MSA.repository.OperationRepository;
import lombok.Data;

@Data
@Service
public class OperationService {
    @Autowired
    private OperationRepository operationRepository;

    public Optional<Operation> getOperation(final Long id) {
        return operationRepository.findById(id);
    }

    public Iterable<Operation> getOperations() {
        return operationRepository.findAll();
    }

    public void deleteOperation(final Long id) {
        operationRepository.deleteById(id);
    }

    public Operation saveOperation(Operation id) {
        Operation saveId = operationRepository.save(id);
        return saveId;
    }

    public List<Operation> getOperationBySourceId(String id) {
        return operationRepository.findBySource(id);
    }

    public List<Operation> getOperationByTypeId(String id) {
        return operationRepository.findByType(id);
    }
}
