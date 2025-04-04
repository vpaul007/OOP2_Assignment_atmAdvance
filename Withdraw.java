package atmAdvance;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record Withdraw(BigDecimal amount, LocalDateTime timestamp) implements Transaction {
    public Withdraw(BigDecimal amount){
        this(amount, LocalDateTime.now());}

    @Override
    public LocalDateTime timestamp() {
        return LocalDateTime.now();
    }
}
