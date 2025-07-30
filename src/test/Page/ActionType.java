package test.Page;

public enum ActionType {
    GIFT_SAME("Tặng kèm sản phẩm cùng loại"),
    GIFT_CUSTOM("Tặng kèm sản phẩm theo danh sách"),
    DISCOUNT_PERCENT("Chiết khấu"),
    DISCOUNT_AMOUNT("Giảm tiền");

    private final String label;

    ActionType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

}

