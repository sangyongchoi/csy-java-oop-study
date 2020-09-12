package Bad;

import java.util.List;

public class BankProcessor {
    private final List<Bank> banks;

    public BankProcessor(List<Bank> bakns) {
        this.banks = bakns;
    }

    public double calculateTotalAmount(){
        double total = 0d;
        for(final Bank bankTransaction : banks){
            total += bankTransaction.getAmount();
        }
        return total;
    }

}
