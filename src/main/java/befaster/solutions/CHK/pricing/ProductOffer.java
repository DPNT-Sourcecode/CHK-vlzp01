package befaster.solutions.CHK.pricing;

import befaster.solutions.CHK.Product;

import java.util.Set;

public interface ProductOffer {
    void apply(Set<Product> products);
}

