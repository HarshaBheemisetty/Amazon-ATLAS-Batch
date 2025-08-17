import java.util.List;

// General Interface (segregated based on usage)
interface Payment {
    Object status();
    List<Object> getListOfPayment();
}

// Bank-specific interface
interface Bank {
    void initiatePayment();
    void stopPayment();
}

// Loan-specific interface
interface Loan {
    void initiateRepayment();
    void initiateFinalSettlement();
}

// Class that uses Bank operations + Payment details
class BankPayment implements Payment, Bank {
    public Object status() {
        System.out.println("Bank Payment Status: SUCCESS");
        return "BankPaymentStatus";
    }

    public List<Object> getListOfPayment() {
        System.out.println("Fetching bank payments...");
        return List.of("BankTxn1", "BankTxn2");
    }

    public void initiatePayment() {
        System.out.println("Initiating bank payment...");
    }

    public void stopPayment() {
        System.out.println("Stopping bank payment...");
    }
}

// Class that uses Loan operations + Payment details
class LoanPayment implements Payment, Loan {
    public Object status() {
        System.out.println("Loan Payment Status: PENDING");
        return "LoanPaymentStatus";
    }

    public List<Object> getListOfPayment() {
        System.out.println("Fetching loan payments...");
        return List.of("LoanTxnA", "LoanTxnB");
    }

    public void initiateRepayment() {
        System.out.println("Initiating repayment...");
    }

    public void initiateFinalSettlement() {
        System.out.println("Final settlement initiated...");
    }

    // Specific loan-related method (not in interface)
    public List<Object> initiateLoanSettlement() {
        System.out.println("Initiating loan settlement...");
        return List.of("SettlementTxnX");
    }
}
public class Day21_InterfaceSeg1 {
    public static void main(String[] args) {
        // Test BankPayment
        System.out.println("---- Bank Payment ----");
        BankPayment bankPayment = new BankPayment();
        bankPayment.initiatePayment();
        bankPayment.stopPayment();
        System.out.println("Status: " + bankPayment.status());
        System.out.println("Payments: " + bankPayment.getListOfPayment());

        // Test LoanPayment
        System.out.println("\n---- Loan Payment ----");
        LoanPayment loanPayment = new LoanPayment();
        loanPayment.initiateRepayment();
        loanPayment.initiateFinalSettlement();
        System.out.println("Status: " + loanPayment.status());
        System.out.println("Payments: " + loanPayment.getListOfPayment());
        System.out.println("Loan Settlements: " + loanPayment.initiateLoanSettlement());
    }
}
