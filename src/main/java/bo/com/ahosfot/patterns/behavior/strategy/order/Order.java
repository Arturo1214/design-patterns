package bo.com.ahosfot.patterns.behavior.strategy.order;

import bo.com.ahosfot.patterns.behavior.strategy.strategies.PayStrategy;
import lombok.Getter;
import lombok.Setter;

public class Order {
    @Getter @Setter
    private int totalCost = 0;
    @Getter
    private boolean isClosed = false;

    public void processOrder(PayStrategy payStrategy) {
        payStrategy.collectPaymentDetails();
    }

    public void setClosed() {
        isClosed = true;
    }

}
