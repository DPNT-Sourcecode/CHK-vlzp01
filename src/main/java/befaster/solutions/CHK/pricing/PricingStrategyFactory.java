package befaster.solutions.CHK.pricing;

import befaster.solutions.CHK.SKUItem;

import java.util.HashMap;
import java.util.Map;

public class PricingStrategyFactory {

    private  static final Map<SKUItem,PricingStrategy> map = new HashMap<>();
    private static final PricingStrategy defaultStrategy = new RegularPricingStrategy();

    static {
        map.put(SKUItem.A, new MultiPricingStrategy(
                            new MultiPricingStrategy(new RegularPricingStrategy(), 3, 130),
                            5,
                            200));
        map.put(SKUItem.B, new MultiPricingStrategy(new RegularPricingStrategy(),2,45));

        map.put(SKUItem.H, new MultiPricingStrategy(
                            new MultiPricingStrategy(new RegularPricingStrategy(), 5, 45),
                            10,
                            80));
        map.put(SKUItem.K, new MultiPricingStrategy(new RegularPricingStrategy(),2,120));
        map.put(SKUItem.P, new MultiPricingStrategy(new RegularPricingStrategy(),5,200));
        map.put(SKUItem.Q, new MultiPricingStrategy(new RegularPricingStrategy(),3,80));
        map.put(SKUItem.V, new MultiPricingStrategy(
                new MultiPricingStrategy(new RegularPricingStrategy(), 2, 90),
                3,
                130));
    }

    public static PricingStrategy getStrategy(SKUItem skuItem) {
        PricingStrategy strategy = map.get(skuItem);
        return (strategy == null) ? defaultStrategy : strategy;
    }
}
