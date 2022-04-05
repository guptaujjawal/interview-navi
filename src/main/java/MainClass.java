import domain.LedgerBook;
import service.LedgerBookServiceImpl;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainClass {

    public static void main(String[] args) throws Exception
    {
        String loc = args[0];
        if(loc != null) {
            File file = new File(loc);
            readInput(file);
        }
        return;
    }

    private static void readInput(File file) throws FileNotFoundException {
        Scanner sc = new Scanner(file);
        List<LedgerBook> ledgerBookList = new ArrayList<>();
        LedgerBookServiceImpl ledgerBookService = new LedgerBookServiceImpl();
        while (sc.hasNextLine()) {
            String input =  sc.nextLine();
            String[] arrOfStr = input.split("\\s+", -1);
            if(Constants.LOAN.equalsIgnoreCase(arrOfStr[0])) {
                String bankName = arrOfStr[1];
                String borrowerName = arrOfStr[2];
                long principal = Long.valueOf(arrOfStr[3]);
                int term = Integer.valueOf(arrOfStr[4]);
                int rateOfInterest = Integer.valueOf(arrOfStr[5]);
                LedgerBook book = new LedgerBook(bankName, borrowerName, principal, term, rateOfInterest);
                ledgerBookList.add(book);
            } else if (Constants.PAYMENT.equalsIgnoreCase(arrOfStr[0])) {
                String bankName = arrOfStr[1];
                String borrowerName = arrOfStr[2];
                long lumpSum = Long.valueOf(arrOfStr[3]);
                int emi = Integer.valueOf(arrOfStr[4]);
                for(LedgerBook book : ledgerBookList) {
                    if(book.getBankName().equalsIgnoreCase(bankName) &&
                            book.getBorrowerName().equalsIgnoreCase(borrowerName)) {
                        book.setLumpSumEMI(emi);
                        book.setLumpSum(lumpSum);
                    }
                }
            } else if (Constants.BALANCE.equalsIgnoreCase(arrOfStr[0])) {
                String bankName = arrOfStr[1];
                String borrowerName = arrOfStr[2];
                int emi = Integer.valueOf(arrOfStr[3]);
                for(LedgerBook book : ledgerBookList) {
                    if(book.getBankName().equalsIgnoreCase(bankName) &&
                            book.getBorrowerName().equalsIgnoreCase(borrowerName)) {
                        book.setEmi(emi);
                        ledgerBookService.calculateBalance(book);
                    }
                }
            } else {
                System.out.println("Invalid input");
            }
        }
    }

}
