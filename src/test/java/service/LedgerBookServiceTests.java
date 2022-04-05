package service;

import domain.LedgerBook;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LedgerBookServiceTests {

    private LedgerBookServiceImpl ledgerBookService = new LedgerBookServiceImpl();

    @Test
    void calculateBalanceTest1() {
        //Prepare
        LedgerBook book = new LedgerBook("IDIDI", "Dale", 10000, 5, 4);
        book.setEmi(5);
        String expected = "IDIDI Dale 1000 55";
        //Execute
        String actual = ledgerBookService.calculateBalance(book);
        //Assert
        assertEquals(expected, actual);
    }

    @Test
    void calculateBalanceTest2() {
        //Prepare
        LedgerBook book = new LedgerBook("MBI", "Harry", 2000, 2, 2);
        book.setEmi(12);
        String expected = "MBI Harry 1044 12";
        //Execute
        String actual = ledgerBookService.calculateBalance(book);
        //Assert
        assertEquals(expected, actual);
    }

    @Test
    void calculateBalanceTest3() {
        //Prepare
        LedgerBook book = new LedgerBook("UON", "Shelly", 5000, 1, 6);
        book.setLumpSumEMI(5);
        book.setLumpSum(1000);
        book.setEmi(3);
        String expected = "UON Shelly 1326 9";
        //Execute
        String actual = ledgerBookService.calculateBalance(book);
        //Assert
        assertEquals(expected, actual);
    }

    @Test
    void calculateBalanceTest4() {
        //Prepare
        LedgerBook book = new LedgerBook("MBI", "Harry", 10000, 3, 7);
        book.setLumpSumEMI(10);
        book.setLumpSum(5000);
        book.setEmi(12);
        String expected = "MBI Harry 9044 10";
        //Execute
        String actual = ledgerBookService.calculateBalance(book);
        //Assert
        assertEquals(expected, actual);
    }

}
