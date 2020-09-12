package Bad;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class BankAnalyzer {
    private final String RESOURCES = "src/main/resources/";
    public BankAnalyzer() {
    }

    public void analyze(String fileName, Parser parser) throws IOException {
        Path path = Paths.get(RESOURCES + fileName);
        List<String> lines = Files.readAllLines(path);
        List<Bank> banks = parser.parseLinesFromCSV(lines);
        BankProcessor bankProcessor = new BankProcessor(banks);

        double total = bankProcessor.calculateTotalAmount();
    }
}
