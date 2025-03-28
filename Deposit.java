package atmAdvance1;

import java.math.BigDecimal;

public record Deposit(BigDecimal amount) implements Transaction  {

}
