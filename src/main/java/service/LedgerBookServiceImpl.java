package service;

import domain.LedgerBook;

import java.text.DecimalFormat;

/**
 * Implementation for LedgerBookService
 */
public class LedgerBookServiceImpl implements LedgerBookService {

    @Override
    public String calculateBalance(LedgerBook book) {
        long interest = (book.getPrincipal() * book.getTerm() * book.getRateOfInterest())/100;
        double totalAmount = interest + book.getPrincipal();
        double emiAmount = Math.ceil(totalAmount/(book.getTerm() * 12));
        double amountPaidInEMIAndLumpSum;
        int totalEMI = book.getTerm() * 12;
        int emiLeft;
        if(book.getLumpSumEMI() > 0 && book.getLumpSum() > 0 && book.getEmi() > book.getLumpSumEMI()) {
            amountPaidInEMIAndLumpSum = (emiAmount * book.getEmi()) + book.getLumpSum();
            double amountLeft = totalAmount - amountPaidInEMIAndLumpSum;
            emiLeft = (int) Math.ceil(amountLeft/emiAmount);
        } else {
            emiLeft = totalEMI - book.getEmi();
            amountPaidInEMIAndLumpSum = emiAmount * book.getEmi();
        }
        DecimalFormat format = new DecimalFormat("0.#");
        String output = book.getBankName() +" "+ book.getBorrowerName()+" "+ format.format(amountPaidInEMIAndLumpSum) +
                " "+ format.format(emiLeft);
        System.out.println(output);
        return output;
    }
}
