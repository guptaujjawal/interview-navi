package domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LedgerBook {
    private String bankName;
    private String borrowerName;
    private long principal;
    private int term;
    private int rateOfInterest;
    private int emi;
    private int lumpSumEMI;
    private long lumpSum;

    public LedgerBook(String bankName, String borrowerName, long principal, int term, int rateOfInterest) {
        this.bankName = bankName;
        this.borrowerName = borrowerName;
        this.principal = principal;
        this.term = term;
        this.rateOfInterest = rateOfInterest;
    }
}
