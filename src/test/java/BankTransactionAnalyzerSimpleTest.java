import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

class BankTransactionAnalyzerSimpleTest {
    private final BankStatementParser bankStatementParser = new BankStatementCSVParser();

    @Test
    @DisplayName("Junit 테스트")
    public void shouldParseOneCorrectLine() throws Exception{
        // given
        final String line = "30-01-2017,-50,Tesco";
        final BankTransaction expected = new BankTransaction(
                LocalDate.of(2017, Month.JANUARY, 30), -50, "Tesco");
        final BankTransaction result;
        final double tolerance = 0.0d;

        // when
        result = bankStatementParser.parseFrom(line);

        //then
        Assertions.assertEquals(expected.getDate(), result.getDate());
        Assertions.assertEquals(expected.getAmount(), result.getAmount());
        Assertions.assertEquals(expected.getDescription(), result.getDescription());
    }

}