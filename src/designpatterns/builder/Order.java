package designpatterns.builder;

public class Order {

    private final String skuNo;
    private final int qty;
    private final String note;

    private Order(Builder builder) {
        this.skuNo = builder.skuNo;
        this.qty = builder.qty;
        this.note = builder.note;
    }

    public static class Builder {
        //required
        private final String skuNo;
        private final int qty;
        //optional
        private String note = "";

        public Builder(String skuNo, int qty) {
            this.skuNo = skuNo;
            this.qty = qty;
        }

        public Builder note(String val) {
            this.note = val;
            return this;
        }

        public Order build() {
            return new Order(this);
        }
    }

    @Override
    public String toString() {
        return "Order{" +
                "skuNo='" + skuNo + '\'' +
                ", qty=" + qty +
                ", note='" + note + '\'' +
                '}';
    }
}
