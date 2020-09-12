package Bad;

import java.io.IOException;

public class BadBankTransactionAnalyzerSimple {
    public static void main(String[] args) throws IOException {
        BankAnalyzer bankAnalyzer = new BankAnalyzer();
        bankAnalyzer.analyze("test.csv", new CSVParser());
    }
}
