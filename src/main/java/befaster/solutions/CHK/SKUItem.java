package befaster.solutions.CHK;

public enum SKUItem {
    A("A",50),
    B("B",30),
    C("C",20),
    D("D",15);

    private String name;
    private Integer price;

    private SKUItem(String name, Integer price) {
        this.name = name;
        this.price = price;
    }

    public static SKUItem valueOf(Character skuChar) {
        return null;
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }
}

