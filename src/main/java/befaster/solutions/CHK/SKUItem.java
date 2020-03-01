package befaster.solutions.CHK;

import java.util.Arrays;

public enum SKUItem {
    A("A",50),
    B("B",30),
    C("C",20),
    D("D",15),
    E("E",40),
    F("F",10);

    private String name;
    private Integer price;

    private SKUItem(String name, Integer price) {
        this.name = name;
        this.price = price;
    }

    public static SKUItem valueOf(Character skuChar) {
        for(SKUItem item : SKUItem.values()){
            if(item.name.equals(skuChar.toString())) {
                return item;
            }
        }
        throw new IllegalArgumentException("InValid SKU item");
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }
}
