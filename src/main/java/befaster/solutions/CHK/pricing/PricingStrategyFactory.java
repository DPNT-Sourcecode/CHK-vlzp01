package befaster.solutions.CHK.pricing;

import befaster.solutions.CHK.SKUItem;

public class PricingStrategyFactory {

    public static PricingStrategy getStrategy(SKUItem skuItem) {
        PricingStrategy strategy;
        switch (skuItem) {
            case A:
                strategy = new MultiPricingStrategy(
                                new MultiPricingStrategy(
                                        new RegularPricingStrategy(),
                                        3,
                                        130),
                                5,
                                200);
                break;
            case B:
                strategy = new MultiPricingStrategy(new RegularPricingStrategy(),2,45);
                break;
            case C:
            case D:
            default:
                strategy = new RegularPricingStrategy();
                break;
        }
        return strategy;
    }
}
