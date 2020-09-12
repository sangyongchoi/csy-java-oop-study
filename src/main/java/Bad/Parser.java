package Bad;

import java.util.List;

public interface Parser {
    List<Bank> parseLinesFromCSV(final List<String> lines);
    Bank parseFromCSV(final String line);
}
