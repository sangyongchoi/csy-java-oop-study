package Bad;

import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CSVParser implements Parser {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public List<Bank> parseLinesFromCSV(final List<String> lines){
        List<Bank> banks = new ArrayList<>();
        for (final String line : lines){
            banks.add(parseFromCSV(line));
        }

        return banks;
    }

    public Bank parseFromCSV(final String line){
        final String[] columns = line.split(",");

        final LocalDate date = LocalDate.parse(doubleQuotesReplace(columns[0]), FORMATTER);
        final double amount = Double.parseDouble(columns[1]);
        final String description = columns[2];

        return new Bank(date, amount, description);
    }

    private String doubleQuotesReplace(String str){
        return str.replace("\"", "");
    }
}
