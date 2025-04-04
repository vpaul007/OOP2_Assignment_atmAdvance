package atmAdvance1;

import java.time.LocalDateTime;

public record BalanceCheck(LocalDateTime timestamp) implements Transaction {
    public BalanceCheck(){
        this(LocalDateTime.now());
    }

    @Override
    public LocalDateTime timestamp() {
        return LocalDateTime.now();
    }
}
