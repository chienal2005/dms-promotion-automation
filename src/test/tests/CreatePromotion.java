package test.tests;

import org.testng.annotations.Test;
import test.Page.LoginPage;
import test.PageObject.CreatePromotionPage;
import test.utilities.BaseTest;
import test.utilities.ConfigReader;

public class CreatePromotion extends BaseTest {

    @Test
    public void testCreatePromotionStepByStep() {
        login();
        CreatePromotionPage promotionPage = new CreatePromotionPage(driver);

        openCreatePromotionScreen(promotionPage);
        fillBasicInformation(promotionPage);
        setConditionAndImportProduct(promotionPage);
        setupPromotionPackages(promotionPage);
        setupBudget(promotionPage);
        savePromotion(promotionPage);
    }

    private void login() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(ConfigReader.get("username"), ConfigReader.get("password"));
    }

    private void openCreatePromotionScreen(CreatePromotionPage promotionPage) {
        promotionPage.clickCreateNewButton();
    }

    private void fillBasicInformation(CreatePromotionPage promotionPage) {
        promotionPage.enterPromotionCode();
        promotionPage.enterPromotionName();
        promotionPage.selectStartAndEndDate();
        promotionPage.selectPromotionType(2); //1 on top, 2 normal
        promotionPage.selectStorage(1); //1 kho bán, 2 kho km, 3 posm, 4 kho trưng bày
        promotionPage.selectMethodStep(1);
    }

    private void setConditionAndImportProduct(CreatePromotionPage promotionPage) {
        promotionPage.selectConditionProduct("Danh sách sản phẩm");
        promotionPage.importExcelProduct();
    }

    private void setupPromotionPackages(CreatePromotionPage promotionPage) {

        promotionPage.actionPackage(1, "6", "3");
        promotionPage.actionPackage(2,"4", "2");
        promotionPage.actionPackage(3, "2", "1");
    }


    private void setupBudget(CreatePromotionPage promotionPage) {
        promotionPage.TotalBudget(100);
        promotionPage.AreaBudget(50,40);
        promotionPage.DistributorBudget(9900073, 30);
        promotionPage.permerchantBudget(30);
        promotionPage.fillBudgetProductByStep();

    }

    private void savePromotion(CreatePromotionPage promotionPage) {
        promotionPage.savePromotion();
    }
}
