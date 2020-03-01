package befaster.solutions.CHK.pricing;

import befaster.solutions.CHK.SKUItem;

import java.util.HashMap;
import java.util.Map;

public class PricingStrategyFactory {

    private  static final Map<SKUItem,PricingStrategy> map = new HashMap<>();

    static {
        map.put(SKUItem.A, new MultiPricingStrategy(
                            new MultiPricingStrategy(new RegularPricingStrategy(), 3, 130),
                            5,
                            200));
        map.put(SKUItem.B, new MultiPricingStrategy(new RegularPricingStrategy(),2,45));
        map.put(SKUItem.C, new RegularPricingStrategy());
        map.put(SKUItem.D, new RegularPricingStrategy());
        map.put(SKUItem.F, new RegularPricingStrategy());

    }

    public static PricingStrategy getStrategy(SKUItem skuItem) {
        return map.get(skuItem);
    }
}

