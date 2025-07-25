package test.PageObject;

import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import test.Page.BasePage;
import test.Page.DynamicPackageLocators;
import test.UI.CreatePromotionLocators;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class CreatePromotionPage extends BasePage {

    public CreatePromotionPage(WebDriver driver) {
        super(driver);
    }

    public void clickCreateNewButton() {
        clickToElement(CreatePromotionLocators.PROMOTION_MENU);
        clickToElement(CreatePromotionLocators.MANAGE_PROMOTION_MENU);
        clickToElement(CreatePromotionLocators.BUTTON_CREATE_NEW);
    }

    public void enterPromotionCode() {
        String code = "AutoUI" + new Random().nextInt(100000);
        sendKey(CreatePromotionLocators.INPUT_PROMOTION_CODE, code);
    }

    public void enterPromotionName() {
        String name = "autodms000000" + new Random().nextInt(100000) + "bacthang_Tangkemcungloai";
        sendKey(CreatePromotionLocators.INPUT_PROMOTION_NAME, name);
    }

    public void selectStartAndEndDate() {
        LocalDate today = LocalDate.now();
        String currentTime = LocalTime.now().plusMinutes(2).withSecond(0).format(DateTimeFormatter.ofPattern("HH:mm"));
        String startDate = today.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + " " + currentTime;
        String endDate = today.plusDays(90).format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) + " " + currentTime;
        new Actions(driver).moveToElement(driver.findElement(CreatePromotionLocators.INPUT_RULE_DESCRIPTION)).click().sendKeys("Áp dụng chương trình Auto - Bậc thang").perform();
        inputDate(CreatePromotionLocators.INPUT_DATE_START, startDate);
        inputDate(CreatePromotionLocators.INPUT_DATE_END, endDate);
        clickOutsideToClosePopup();
    }

    public void selectPromotionType(int type) {
        if (type == 1) clickToElement(CreatePromotionLocators.RADIO_ONTOP);
        else if (type == 2) clickToElement(CreatePromotionLocators.RADIO_NORMAL);
        else throw new IllegalArgumentException("Invalid promotion type: " + type);
    }

    private static final Map<Integer, By> STORAGE_OPTION_MAP = Map.of(
            1, CreatePromotionLocators.OPTION_STORAGE_SALES,
            2, CreatePromotionLocators.OPTION_STORAGE_PROMOTION,
            3, CreatePromotionLocators.OPTION_STORAGE_POSM,
            4, CreatePromotionLocators.OPTION_STORAGE_DISPLAY
    );

    public void selectStorage(int type) {
        clickToElement(CreatePromotionLocators.DROPDOWN_STORAGE);
        By optionLocator = STORAGE_OPTION_MAP.get(type);
        if (optionLocator == null) {
            throw new IllegalArgumentException("Invalid storage type: " + type);
        }
        clickToElement(optionLocator);
    }

    public void selectMethodStep(int methodCode) {
        clickToElement(CreatePromotionLocators.DROPDOWN_METHOD);
        switch (methodCode) {
            case 0:
                clickToElement(CreatePromotionLocators.OPTION_NORMAL);
                break;
            case 1:
                clickToElement(CreatePromotionLocators.OPTION_STEP);
                break;
            default:
                throw new IllegalArgumentException("Method code must be 0 or 1");
        }
    }

    public void selectConditionProduct(String label) {
        clickToElement(CreatePromotionLocators.DROPDOWN_CONDITION);
        switch (label.trim()) {
            case "Danh sách sản phẩm":
                clickToElement(CreatePromotionLocators.OPTION_PRODUCT_LIST);
                break;
            case "Nhóm sản phẩm":
                clickToElement(CreatePromotionLocators.OPTION_GROUP_PRODUCT_LIST);
                break;
            default:
                throw new IllegalArgumentException("Invalid product condition label: " + label);
        }
    }

    public void importExcelProduct() {
        clickToElement(CreatePromotionLocators.BUTTON_IMPORT_EXCEL);
        WebElement inputFile = driver.findElement(By.xpath("//input[@name='file' and @type='file']"));
        makeVisible(inputFile);
        inputFile.sendKeys("D:\\import-products.xlsx");
        clickToElement(CreatePromotionLocators.BUTTON_PROCESS);
        try {
            clickToElement(CreatePromotionLocators.BUTTON_CONFIRM);
        } catch (Exception ignored) {}
    }


    public void actionPackage(int packageNumber, String quantityCondition, String quantityGift) {
        clickToElement(CreatePromotionLocators.BUTTON_ADD_PACKAGE);
        switch (packageNumber) {
            case 1:
                fillPackage(CreatePromotionLocators.DROPDOWN_PACKAGE_CONDITION, CreatePromotionLocators.OPTION_CONTENT_2_PACKAGE_1, CreatePromotionLocators.CONDITION_VALUE_QUALITY_1, quantityCondition, CreatePromotionLocators.DROPDOWN_PACKAGE_ACTION_OPTION_0, CreatePromotionLocators.INPUT_PACKAGE_QUANTITY, quantityGift, CreatePromotionLocators.Action_value_kind_of_deduction, CreatePromotionLocators.Value_kind_of_deduction_1_P1);
                break;
            case 2:
                fillPackage(CreatePromotionLocators.DROPDOWN_PACKAGE_CONDITION_2, CreatePromotionLocators.OPTION_CONTENT_2_PACKAGE_2, CreatePromotionLocators.CONDITION_VALUE_QUALITY_2, quantityCondition, null, CreatePromotionLocators.INPUT_PACKAGE_QUANTITY_2, quantityGift, CreatePromotionLocators.Action_value_kind_of_deduction_2, CreatePromotionLocators.Value_kind_of_deduction_1_P2);
                break;
            case 3:
                fillPackage(CreatePromotionLocators.DROPDOWN_PACKAGE_CONDITION_3, CreatePromotionLocators.OPTION_CONTENT_2_PACKAGE_3, CreatePromotionLocators.CONDITION_VALUE_QUALITY_3, quantityCondition, null, CreatePromotionLocators.INPUT_PACKAGE_QUANTITY_3, quantityGift, CreatePromotionLocators.Action_value_kind_of_deduction_3, CreatePromotionLocators.Value_kind_of_deduction_2_P3);
                break;
        }
    }

    private void fillPackage(By conditionDropdown, By conditionOption, By inputCondition, String conditionValue, By actionDropdown, By inputQuantity, String giftValue, By deductionDropdown, By deductionOption) {
        clickDropdownOption(conditionDropdown, conditionOption);
        sendKey(inputCondition, conditionValue);
        if (actionDropdown != null) clickDropdownOption(actionDropdown, CreatePromotionLocators.OPTION_PACKAGE_QUANTITY);
        sendKey(inputQuantity, giftValue);
        clickDropdownOption(deductionDropdown, deductionOption);
    }

    public void fillBudgetProductByStep() {
        driver.findElements(CreatePromotionLocators.ICON_SYNC_PRODUCT_BUDGET).stream().filter(WebElement::isDisplayed).findFirst().ifPresent(btn -> {
            scrollIntoView(btn);
            btn.click();
        });
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ant-spin-spinning")));
        List<WebElement> rows = driver.findElements(By.xpath("//tbody//tr[not(contains(@style,'display: none'))]"));
        for (WebElement row : rows) {
            try {
                WebElement packageCell = row.findElement(By.xpath("./td[3]"));
                int budget = getBudgetValue(packageCell.getText().trim());
                if (budget == 0) continue;
                Optional<WebElement> inputOptional = row.findElements(By.xpath(".//input[@placeholder='nhập dữ liệu' and not(@disabled)]")).stream().filter(WebElement::isDisplayed).findFirst();
                inputOptional.ifPresent(input -> {
                    scrollIntoView(input);
                    input.clear();
                    input.sendKeys(String.valueOf(budget));
                });
            } catch (NoSuchElementException ignored) {}
        }
    }

    private int getBudgetValue(String packageName) {
        if (packageName.contains("Gói khuyến mãi 1")) return 30;
        if (packageName.contains("Gói khuyến mãi 2")) return 20;
        if (packageName.contains("Gói khuyến mãi 3")) return 10;
        return 0;
    }

    public void TotalBudget(Object value) {
        clickToElement(CreatePromotionLocators.TAB_BUDGET);
        clickToElement(CreatePromotionLocators.RADIO_BUDGET_SLOT);
        clickToElement(CreatePromotionLocators.CHECKBOX_TOTAL_BUDGET);
        sendKey(CreatePromotionLocators.INPUT_TOTAL_BUDGET, value);
        clickToElement(CreatePromotionLocators.CHECKBOX_LIMIT_PRODUCT);
    }
    public void AreaBudget(Object value1, Object value2) {
        clickToElement(CreatePromotionLocators.CHECKBOX_AREA_BUDGET);
        displayAndClick(CreatePromotionLocators.BUTTON_ADD_REGION_BUDGET);
        //sendKeys(CreatePromotionLocators.INPUT_SEARCH_REGION, Region1);
        //click(CreatePromotionLocators.BUTTON_SEARCH_REGION);
        clickCheckboxRow(CreatePromotionLocators.CHECKBOX_FIRST_RESULT1);
        clickCheckboxRow(CreatePromotionLocators.CHECKBOX_FIRST_RESULT2);
        clickToElement(CreatePromotionLocators.BUTTON_CONFIRM_REGION);
        sendKey(CreatePromotionLocators.INPUT_REGION_BUDGET1, value1);
        sendKey(CreatePromotionLocators.INPUT_REGION_BUDGET2, value2);
    }
    public void DistributorBudget(Object id, Object value1 ) {
        // 1. Bật cấu hình ngân sách Nhà phân phối
        clickToElement(CreatePromotionLocators.CHECKBOX_DISTRIBUTOR_BUDGET);

        // 2. Click nút "Thêm mới" khu vực NPP
        displayAndClick(CreatePromotionLocators.BUTTON_ADD_DISTRIBUTOR_BUDGET);
        sendKey(CreatePromotionLocators.INPUT_SEARCH_DISTRIBOR, id);
        clickCheckboxRow(CreatePromotionLocators.BUTTON_SEARCH_DISTRIBUTOR);

        // 3. Chọn 2 NPP đầu tiên
        wait.until(ExpectedConditions.visibilityOfElementLocated(CreatePromotionLocators.CHECKBOX_FIRST_DISTRIBUTOR1));
        clickToElement(CreatePromotionLocators.CHECKBOX_FIRST_DISTRIBUTOR1);
        //click(CreatePromotionLocators.CHECKBOX_FIRST_DISTRIBUTOR2);

        // 4. Xác nhận chọn
        clickToElement(CreatePromotionLocators.BUTTON_CONFIRM_DISTRIBUTOR);

        // 5. Nhập ngân sách từng NPP
        sendKey(CreatePromotionLocators.INPUT_DISTRIBUTOR_BUDGET1, value1);
        //sendKeys(CreatePromotionLocators.INPUT_DISTRIBUTOR_BUDGET2, value2);

    }

    public void permerchantBudget(Object value){
        clickToElement(CreatePromotionLocators.CHECKBOX_PERMERCHANRT_BUDGET);
        sendKey(CreatePromotionLocators.INPUT_PERMERCHANRT_BUDGET, value);
    }


    public void savePromotion() {
        clickToElement(CreatePromotionLocators.BUTTON_SAVE);
        clickToElement(CreatePromotionLocators.BUTTON_ACCEPT);
    }
}