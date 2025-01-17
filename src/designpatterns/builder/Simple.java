package designpatterns.builder;

public class Simple {

    private final int reqField;
    private final int optField;

    private Simple(Builder b) {
        this.reqField = b.reqField;
        this.optField = b.optField;
    }

    public static class Builder {
        private final int reqField;
        private int optField;

        public Builder(int reqField) {
            this.reqField = reqField;
        }

        public Builder optField(int optField) {
            this.optField = optField;
            return this;
        }

        public Simple build() {
            return new Simple(this);
        }

    }

    public static void main(String[] args) {
        Simple simple = new Builder(7).optField(8).build();

    }
}
