package test.Page;

public enum DiscountType {
        TOTAL_ORDER("totalAmountOfOrder", "Chiết khấu % toàn bộ đơn hàng"),
        PRODUCT_GROUP("totalAmountOfSkus", "Chiết khấu % giá trị nhóm sản phẩm"),
        PRODUCT_GROUP_BY_CONDITION("totalAmountOfSkusByMultiple", "Chiết khấu % giá trị nhóm sản phẩm theo điều kiện");

        private final String value;
        private final String labelText;

        DiscountType(String value, String labelText) {
                this.value = value;
                this.labelText = labelText;
        }

        public String getValue() {
                return value;
        }

        public String getLabelText() {
                return labelText;
        }
}


