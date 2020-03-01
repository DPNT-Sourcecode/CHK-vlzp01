package befaster.solutions.CHK;

import java.util.Arrays;

public enum SKUItem {
    A("A",50), B("B",30), C("C",20), D("D",15),
    E("E",40), F("F",10), G("G",20),H("H",10),
    I("I",35),J("J",60),K("K",70),L("L",90),
    M("M",15),N("N",40),O("O",10),P("P",50),
    Q("Q",30),R("R",50),S("S",20),T("T",20),
    U("U",40),V("V",50),W("W",20),X("X",17),
    Y("Y",20),Z("Z",21);
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

