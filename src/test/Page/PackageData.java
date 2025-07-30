package test.Page;

public class PackageData {
    // Common fields
    private String optionContent;
    private String quantityCondition;
    private ActionType actionType;

    // Gift-specific fields
    private String quantityGift;
    private String deductionOptionText;

    // Discount-specific fields
    private String discountPercent;
    private String maxAmount;
    private DiscountType discountType;
    private String deductionRule;
    private String maxSlot;

    // 🎁 Constructor cho gói TẶNG QUÀ
    public PackageData(String optionContent, String quantityCondition, String quantityGift, String deductionOptionText, ActionType actionType) {
        this.optionContent = optionContent;
        this.quantityCondition = quantityCondition;
        this.quantityGift = quantityGift;
        this.deductionOptionText = deductionOptionText;
        this.actionType = actionType;
    }

    // 💸 Constructor cho gói CHIẾT KHẤU
    public PackageData(String optionContent, String quantityCondition, String discountPercent, String maxAmount, DiscountType discountType, String deductionRule, String maxSlot) {
        this.optionContent = optionContent;
        this.quantityCondition = quantityCondition;
        this.discountPercent = discountPercent;
        this.maxAmount = maxAmount;
        this.discountType = discountType;
        this.deductionRule = deductionRule;
        this.maxSlot = maxSlot;
        this.actionType = ActionType.DISCOUNT_PERCENT;
    }

    // === Getters ===
    public String getOptionContent() {
        return optionContent;
    }

    public String getQuantityCondition() {
        return quantityCondition;
    }

    public ActionType getActionType() {
        return actionType;
    }

    public String getQuantityGift() {
        return quantityGift;
    }

    public String getDeductionOptionText() {
        return deductionOptionText;
    }

    public String getDiscountPercent() {
        return discountPercent;
    }

    public String getMaxAmount() {
        return maxAmount;
    }

    public DiscountType getDiscountType() {
        return discountType;
    }

    public String getDeductionRule() {
        return deductionRule;
    }

    public String getMaxSlot() {
        return maxSlot;
    }

    // === Setters nếu cần ===
    public void setActionType(ActionType actionType) {
        this.actionType = actionType;
    }

    public void setQuantityGift(String quantityGift) {
        this.quantityGift = quantityGift;
    }

    public void setDeductionOptionText(String deductionOptionText) {
        this.deductionOptionText = deductionOptionText;
    }

    public void setDiscountPercent(String discountPercent) {
        this.discountPercent = discountPercent;
    }

    public void setMaxAmount(String maxAmount) {
        this.maxAmount = maxAmount;
    }

    public void setDiscountType(DiscountType discountType) {
        this.discountType = discountType;
    }

    public void setDeductionRule(String deductionRule) {
        this.deductionRule = deductionRule;
    }

    public void setMaxSlot(String maxSlot) {
        this.maxSlot = maxSlot;
    }
}
