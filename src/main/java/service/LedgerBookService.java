package service;

import domain.LedgerBook;

/**
 * Interface for ledger book
 */
public interface LedgerBookService {

    /**
     * The BALANCE command receives a Bank name, Borrower name and EMI number along with it.
     * It prints the total amount paid by the borrower, including all the Lump Sum amounts paid
     * including that EMI number, and the no of EMIs remaining.
     * @param book
     */
    String calculateBalance(LedgerBook book);

}
