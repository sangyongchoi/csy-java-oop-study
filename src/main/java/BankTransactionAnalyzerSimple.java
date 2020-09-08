import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class BankTransactionAnalyzerSimple {
    private static final String RESOURCES = "src/main/resources/";
    private static final BankStatementCSVParser bankStatementCSVParser = new BankStatementCSVParser();

    public static void main(String[] args) throws IOException {
        final Path path = Paths.get(RESOURCES + "test.csv");
        final List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);

        final List<BankTransaction> bankTransactions = bankStatementCSVParser.parseLinesFromCSV(lines);
        final BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);

        collectSummary(bankStatementProcessor);
    }

    private static void collectSummary(final BankStatementProcessor bankStatementProcessor){
        System.out.println("1 : " + bankStatementProcessor.calculateTotalAmount());
        System.out.println("2 : " + bankStatementProcessor.calculateTotalForCategory("Salary"));
        System.out.println("3 : " + bankStatementProcessor.calculateTotalInMonth(Month.JANUARY));
    }
}
