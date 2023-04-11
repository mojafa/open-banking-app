package mojafa.betterbanking.controllers;

import mojafa.betterbanking.dto.TransactionDTO;
import mojafa.betterbanking.models.Transaction;
import mojafa.betterbanking.services.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.springframework.http.ResponseEntity.notFound;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/api/v1/transactions")
public class TransactionController {

    public TransactionController(final TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/{accountNumber}")
    public ResponseEntity<List<TransactionDTO>> findAllByAccountNumber(@PathVariable("accountNumber") final Integer accountNumber) throws Exception {
        var list = transactionService.findAllByAccountNumber(accountNumber)
                .stream().map(this::map)
                .collect(toList());

        if (list.isEmpty()){
            return  notFound().build();
        }
        return ok(list);
    }

    private TransactionDTO map(final Transaction tr) {
        return TransactionDTO.apply(tr);
    }

    private final TransactionService transactionService;
}


