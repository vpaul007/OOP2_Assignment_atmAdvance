package atmAdvance1;


import java.math.BigDecimal;
import java.time.LocalDateTime;

public record Deposit(BigDecimal amount, LocalDateTime timestamp) implements Transaction  {

    public Deposit(BigDecimal amount){
        this(amount, LocalDateTime.now());
    }
    @Override
    public LocalDateTime timestamp() {
        return LocalDateTime.now();
    }
}
