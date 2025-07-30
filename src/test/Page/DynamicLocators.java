package test.Page;

import org.openqa.selenium.By;

public class DynamicLocators {
    //🔹 Dropdown “Điều kiện” trong mỗi gói:
    public static By getDropdownPackageCondition(int packageIndex) {
        return By.xpath("//input[@id='packages_" + packageIndex + "_condition_option']/ancestor::div[contains(@class,'ant-select')]//div[contains(@class,'ant-select-selector')]");
    }
    //🔹 Option trong dropdown Điều kiện:
    public static By getConditionOption(String optionText, int packageIndex) {
        // XPath dùng index để chỉ đúng gói cần chọn
        return By.xpath("(//div[@class='ant-select-item-option-content' and normalize-space()='" + optionText + "'])[" + (packageIndex + 1) + "]");
    }

    //🔹 Input: Số lượng Điều kiện (condition_value_quantity)
    public static By getInputConditionQuantity(int packageIndex) {
        return By.xpath("//input[@id='packages_" + packageIndex + "_condition_value_quantity']");
    }
    //🔹 Input: Tổng giá trị nhóm sản phẩm (condition_value_total_amount)
    public static By getInputConditionTotalAmount(int packageIndex) {
        return By.xpath("//input[@id='packages_" + packageIndex + "_condition_value_total_amount']");
    }
    public static By getInputConditionTotalOrderAmount(int packageIndex) {
        return By.xpath("//input[@id='packages_" + packageIndex + "_condition_value_total_amount']");
    }
    //Các loại hình thức
    public static By getActionOptionByText(String actionText) {
        return By.xpath("//div[@class='ant-select-item-option-content' and normalize-space()='" + actionText.trim() + "']");
    }


    //🔹 Dropdown Hình thức (Action Option)
    public static By getDropdownPackageActionOption(int packageIndex) {
        return By.xpath("//input[@id='packages_" + packageIndex + "_action_option']/ancestor::div[contains(@class,'ant-select-selector')]");
    }
    //🔹 Các loại hành động (Hình thức)
    public static By getActionOption(String visibleText) {
        return By.xpath("//div[@class='ant-select-item-option-content' and normalize-space()='" + visibleText + "']");
    }
    //🔹 Input: Số lượng gói trong hành động (Action Quantity)
    public static By getInputActionQuantity(int packageIndex) {
        return By.xpath("//input[@id='packages_" + packageIndex + "_action_value_quantity']");
    }
    //Input: Số suất tối đa/Đơn
    public static By getInputActionSlotLimit(int packageIndex) {
        return By.xpath("//input[@id='packages_" + packageIndex + "_action_value_slot_desired']");
    }
    //Dropdown: Quy tắc giảm trừ
    public static By getDropdownDeductionRule(int packageIndex) {
        return By.xpath("//input[@id='packages_" + packageIndex + "_action_value_kind_of_deduction']/ancestor::div[contains(@class,'ant-select-selector')]");
    }
    //🔹 Option: Quy tắc giảm trừ cụ thể
    public static By getDeductionRuleOption(String optionText, int packageIndex) {
        return By.xpath("(//div[@class='ant-select-item-option-content' and normalize-space()='" + optionText + "'])[" + (packageIndex + 1) + "]");
    }
    public static By getInputDiscountPercent(int packageIndex) {
        return By.xpath("//input[@id='packages_" + packageIndex + "_action_value_discount_percent']");
    }

    public static By getInputDiscountMaxAmount(int packageIndex) {
        return By.xpath("//input[@id='packages_" + packageIndex + "_action_value_discount_maximum_amount']");
    }

    public static By getDiscountTypeLabelByText(String labelText) {
        return By.xpath("//span[text()='" + labelText + "']");
    }

    public static By getInputSlotPerOrder(int packageIndex) {
        return By.id("packages_" + packageIndex + "_action_value_slotPerOrder");
    }
    //🔹 Option: Quy tắc giảm trừ cụ thể
    public static By getInputSlotDesired(String optionText, int packageIndex) {
        return By.xpath("(//div[@class='ant-select-item-option-content' and normalize-space()='" + optionText + "'])[" + (packageIndex + 1) + "]");
    }
}
