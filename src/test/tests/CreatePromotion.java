package test.tests;

import org.testng.annotations.Test;
import test.Page.ActionType;
import test.Page.DiscountType;
import test.Page.LoginPage;
import test.Page.PackageData;
import test.PageObject.CreatePromotionPage;
import test.utilities.BaseTest;
import test.utilities.ConfigReader;

import java.util.Arrays;
import java.util.List;

public class CreatePromotion extends BaseTest {

    /**
     * Testcase: Chiết khấu phần trăm
     * Hình thức: Tăng kèm SP cùng loại
     * Mô tả: Tạo CTKM Tăng kèm SP cùng loại
     */
    @Test
    public void testCreatePromotion_Gift() {
        login();
        CreatePromotionPage promotionPage = new CreatePromotionPage(driver);

        openCreatePromotionScreen(promotionPage);
        fillBasicInformation(promotionPage,"TangKemSPCungLoai");
        setConditionAndImportProduct(promotionPage);

        // 🎁 CTKM tặng quà (GIFT_SAME)
        List<PackageData> giftPackages = Arrays.asList(
                new PackageData("Tổng giá trị nhóm sản phẩm", "500000", "3", "Giảm trừ theo suất thực nhận", ActionType.GIFT_SAME),
                new PackageData("Số lượng mỗi loại sản phẩm", "6", "2", "Giảm trừ theo suất thực nhận", ActionType.GIFT_SAME),
                new PackageData("Tổng giá trị nhóm sản phẩm", "4", "1", "Giảm trừ toàn bộ sản phẩm", ActionType.GIFT_SAME)
        );
        promotionPage.createTieredPackages(giftPackages);

        setupBudgetSlot(promotionPage);
        savePromotion(promotionPage);
    }
    /**
     * Testcase: Chiết khấu phần trăm
     * Hình thức: Chiết khấu
     * Mô tả: Tạo CTKM chiết khấu % giá trị trên tổng ĐH
     */
    @Test
    public void testDiscountPromotionTotal() {
        login();
        CreatePromotionPage promotionPage = new CreatePromotionPage(driver);

        openCreatePromotionScreen(promotionPage);
        fillBasicInformation(promotionPage, "ChietkhauTrenTongDH");
        setConditionAndImportProduct(promotionPage);

        // 🟩 Tạo 1 gói chiết khấu đơn giản
        List<PackageData> packageDataList = Arrays.asList(
                // 🎁 Gói tặng quà
                new PackageData("Tổng giá trị nhóm sản phẩm", "500000", "10", "100000", DiscountType.TOTAL_ORDER, "", ""),
                // 💸 Gói chiết khấu theo tổng đơn hàng
                new PackageData("Tổng giá trị nhóm sản phẩm", "200000", "5", "100000", DiscountType.TOTAL_ORDER, "", ""),
                // 💸 Gói chiết khấu theo điều kiện
                new PackageData("Số lượng mỗi loại sản phẩm", "6", "10", "100000", DiscountType.TOTAL_ORDER, "", "")
        );
        promotionPage.createAllPackages(packageDataList);

        setupBudgetAmount(promotionPage);
        savePromotion(promotionPage);
    }
    /**
     * Testcase: Chiết khấu phần trăm
     * Hình thức: Chiết khấu
     * Mô tả: Tạo CTKM chiết khấu % giá trị nhóm sản phẩm
     */
    @Test
    public void testDiscountPromotionGroup() {
        login();
        CreatePromotionPage promotionPage = new CreatePromotionPage(driver);

        openCreatePromotionScreen(promotionPage);
        fillBasicInformation(promotionPage,"ChietKhauTrenNhomDK");
        setConditionAndImportProduct(promotionPage);

        // 🟩 Tạo 1 gói chiết khấu đơn giản
        List<PackageData> packageDataList = Arrays.asList(
                // 🎁 Gói tặng quà
                new PackageData("Tổng giá trị nhóm sản phẩm", "500000", "10", "100000", DiscountType.PRODUCT_GROUP, "", ""),
                // 💸 Gói chiết khấu theo tổng đơn hàng
                new PackageData("Tổng giá trị nhóm sản phẩm", "200000", "5", "100000", DiscountType.PRODUCT_GROUP, "", ""),
                // 💸 Gói chiết khấu theo điều kiện
                new PackageData("Số lượng mỗi loại sản phẩm", "6", "10", "100000", DiscountType.PRODUCT_GROUP, "", "")
        );
        promotionPage.createAllPackages(packageDataList);

        setupBudgetAmount(promotionPage);
        savePromotion(promotionPage);
    }


    // ----- Shared setup methods -----
    private void login() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(ConfigReader.get("username"), ConfigReader.get("password"));
    }

    private void openCreatePromotionScreen(CreatePromotionPage promotionPage) {
        promotionPage.clickCreateNewButton();
    }

    private void fillBasicInformation(CreatePromotionPage promotionPage, String value) {
        promotionPage.enterPromotionCode();
        promotionPage.enterPromotionName(value);
        promotionPage.selectStartAndEndDate();
        promotionPage.selectPromotionType(2); // Normal
        promotionPage.selectStorage(1);       // Kho bán
        promotionPage.selectMethodStep(1);    // Bậc thang
    }

    private void setConditionAndImportProduct(CreatePromotionPage promotionPage) {
        promotionPage.selectConditionProduct("Danh sách sản phẩm");
        promotionPage.importExcelProduct();
    }

    private void setupBudgetSlot(CreatePromotionPage promotionPage) {
        promotionPage.TotalBudget("SLOT", 100);
        promotionPage.AreaBudget(50,40);
        promotionPage.DistributorBudget(9900073, 30);
        promotionPage.permerchantBudget(30);
        promotionPage.fillBudgetProductByStep();

    }
    private void setupBudgetAmount(CreatePromotionPage promotionPage) {
        promotionPage.TotalBudget("AMOUNT", 100);
        promotionPage.AreaBudget(50,40);
        promotionPage.DistributorBudget(9900073, 30);
        promotionPage.permerchantBudget(30);
    }

    private void savePromotion(CreatePromotionPage promotionPage) {
        promotionPage.savePromotion();
    }
}
