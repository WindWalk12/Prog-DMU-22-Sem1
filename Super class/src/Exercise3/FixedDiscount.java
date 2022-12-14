package Exercise3;

public class FixedDiscount extends Discount {
    private int fixedDiscount;
    private int discountLimit;

    public FixedDiscount(int fixedDiscount, int discountLimit) {
        this.fixedDiscount = fixedDiscount;
        this.discountLimit = discountLimit;
    }


    @Override
    public double getDiscount(double price) {
        if (price > discountLimit) {
            return price - fixedDiscount;
        }
        return price;
    }
}
