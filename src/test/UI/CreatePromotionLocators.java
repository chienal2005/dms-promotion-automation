package test.UI;

import org.openqa.selenium.By;

public class CreatePromotionLocators {
    public static By getConditionLocator(int index) {
        return By.id("//input[@id='packages_" + index + "_condition_option']/ancestor::div[contains(@class,'ant-select-selector')]//span[contains(@class,'ant-select-selection-placeholder')]");
    }

    public static By getActionLocator(int index) {
        return By.id("packages_" + index + "_action_value_quantity");
    }

    public static By getSlotLocator(int index) {
        return By.id("packages_" + index + "_action_value_slot");
    }


    public static final By PROMOTION_MENU = By.xpath("//span[contains(text(),'Chương trình khuyến mãi')]");
    public static final By MANAGE_PROMOTION_MENU = By.xpath("//a[@href='/promotion/event']");
    public static final By HEADER_LABEL_MANAGE_PROMOTION = By.xpath("//span[@class='ant-page-header-heading-title css-1843uat' and text()='Quản lý khuyến mãi']");

        public static final By BUTTON_CREATE_NEW = By.xpath("//span[text()='Tạo mới']/ancestor::button");

        public static final By INPUT_PROMOTION_CODE = By.id("code");
        public static final By INPUT_PROMOTION_NAME = By.xpath("//input[@placeholder='Nhập vào tên chương trình khuyến mãi']");
    public static final By INPUT_RULE_DESCRIPTION = By.xpath("//div[@role='textbox']");

        public static final By INPUT_DATE_START = By.xpath("//input[@placeholder='Chọn ngày bắt đầu']");
        public static final By INPUT_DATE_END = By.xpath("//input[@placeholder='Chọn ngày kết thúc']");

        public static final By RADIO_NORMAL = By.xpath("//input[@name='kind' and @value='NORMAL']/following-sibling::span");
        public static final By RADIO_ONTOP = By.xpath("//input[@name='kind' and @value='ONTOP']/following-sibling::span");
//kho
        public static final By DROPDOWN_STORAGE = By.xpath("//input[@id='warehouse_type_id']/ancestor::div[contains(@class,'ant-select')]");

    public static final By OPTION_STORAGE_SALES = By.xpath("//div[@class='ant-select-item-option-content' and normalize-space()='Kho bán']");
    public static final By OPTION_STORAGE_PROMOTION = By.xpath("//div[@class='ant-select-item-option-content' and normalize-space()='Kho khuyến mãi']");
    public static final By OPTION_STORAGE_POSM = By.xpath("//div[@class='ant-select-item-option-content' and normalize-space()='Kho POSM']");
    public static final By OPTION_STORAGE_DISPLAY = By.xpath("//div[@class='ant-select-item-option-content' and normalize-space()='Kho trưng bày']");


    public static final By DROPDOWN_METHOD = By.xpath("//input[@id='method_apply']/ancestor::div[contains(@class,'ant-select')]/div[@class='ant-select-selector']");
    public static final By OPTION_NORMAL = By.xpath("//div[contains(text(),'Không bậc thang')]");
    public static final By OPTION_STEP = By.xpath("//div[contains(text(),'Bậc thang')]");

        public static final By DROPDOWN_CONDITION = By.xpath("//input[@id='setup_list_buy_0_option']/ancestor::div[contains(@class,'ant-select')]");
        public static final By OPTION_PRODUCT_LIST = By.xpath("//div[text()='Danh sách sản phẩm']");
    public static final By OPTION_GROUP_PRODUCT_LIST = By.xpath("//div[text()='Danh sách sản phẩm']");

    public static final By BUTTON_SELECT_FILE = By.xpath("//span[contains(@class,'ant-upload-btn')]");
    public static final By BUTTON_IMPORT_EXCEL = By.xpath("//span[text()='Import Excel']/ancestor::button");
        public static final By INPUT_IMPORT_EXCEL = By.xpath("//div[@class='ant-upload-drag-container']");
        public static final By BUTTON_PROCESS = By.xpath("//span[text()='Tiến hành xử lý']/ancestor::button");
        public static final By BUTTON_CONFIRM = By.xpath("//span[text()='Xác nhận']/ancestor::button");

        public static final By BUTTON_ADD_PACKAGE = By.xpath("//div[contains(@class, 'ant-pro-card-title')]//button//span[text()='Thêm mới']");

    public static final By OPTION_CONTENT_1 = By.xpath("//div[@class='ant-select-item-option-content' and normalize-space()='Số lượng mỗi loại sản phẩm']");
    public static final By OPTION_CONTENT_2 = By.xpath("//div[@class='ant-select-item-option-content' and normalize-space()='Tổng số lượng nhóm sản phẩm']");
    public static final By OPTION_CONTENT_3 = By.xpath("//div[@class='ant-select-item-option-content' and normalize-space()='Tổng giá trị nhóm sản phẩm']");
    public static final By OPTION_CONTENT_4 = By.xpath("//div[@class='ant-select-item-option-content' and normalize-space()='Tổng giá trị đơn hàng']");

    public static final By ACTION_DISCOUNT = By.xpath("//div[@class='ant-select-item-option-content' and normalize-space()='Chiết khấu']");
    public static final By ACTION_REDUCE = By.xpath("//div[@class='ant-select-item-option-content' and normalize-space()='Giảm tiền']");
    public static final By ACTION_GIFT_SAME = By.xpath("//div[@class='ant-select-item-option-content' and normalize-space()='Tặng kèm sản phẩm cùng loại']");
    public static final By ACTION_GIFT_LIST = By.xpath("//div[@class='ant-select-item-option-content' and normalize-space()='Tặng kèm sản phẩm theo danh sách']");

        //gói 1
        public static final By DROPDOWN_PACKAGE_CONDITION = By.xpath("//input[@id='packages_0_condition_option']/ancestor::div[contains(@class,'ant-select-selector')]");
    public static final By OPTION_CONTENT_2_PACKAGE_1 = By.xpath("//div[@class='ant-select-item-option-content' and text()='Tổng số lượng nhóm sản phẩm']");
    public static final By CONDITION_VALUE_QUALITY_1 = By.xpath("(//input[@placeholder='Nhập vào số lượng'])[1]");
    public static final By DROPDOWN_PACKAGE_ACTION_OPTION_0 = By.xpath("//input[@id='packages_0_action_option']/ancestor::div[contains(@class,'ant-select-selector')]");

    public static final By OPTION_PACKAGE_QUANTITY = By.xpath("//div[@class='ant-select-item-option-content' and text()='Tặng kèm sản phẩm cùng loại']");
    public static final By INPUT_PACKAGE_QUANTITY = By.xpath("(//input[@placeholder='Nhập vào số lượng'])[2]");
    public static final By Action_value_kind_of_deduction = By.xpath("//input[@id='packages_0_action_value_kind_of_deduction']/ancestor::div[contains(@class,'ant-select-selector')]");
    public static final By Value_kind_of_deduction_1_P1 = By.xpath("//div[@class='ant-select-item-option-content' and normalize-space()='Giảm trừ theo suất thực nhận']");
    public static final By Value_kind_of_deduction_2_P1 = By.xpath("//div[@class='ant-select-item-option-content' and normalize-space()='Giảm trừ toàn bộ sản phẩm']");
//gói 2
    public static final By DROPDOWN_PACKAGE_CONDITION_2 = By.xpath("//input[@id='packages_1_condition_option']/ancestor::div[contains(@class,'ant-select-selector')]");
    public static final By OPTION_CONTENT_2_PACKAGE_2 = By.xpath("(//div[@class='ant-select-item-option-content' and text()='Tổng số lượng nhóm sản phẩm'])[2]");
    public static final By CONDITION_VALUE_QUALITY_2 = By.xpath("(//input[@placeholder='Nhập vào số lượng'])[3]");
    public static final By DROPDOWN_PACKAGE_ACTION_OPTION_1 = By.xpath("//input[@id='packages_1_action_option']/ancestor::div[contains(@class,'ant-select-selector')]");
    public static final By INPUT_PACKAGE_QUANTITY_2 = By.xpath("(//input[@placeholder='Nhập vào số lượng'])[4]");
    public static final By Action_value_kind_of_deduction_2 = By.xpath("//input[@id='packages_1_action_value_kind_of_deduction']/ancestor::div[contains(@class,'ant-select-selector')]");
    public static final By Value_kind_of_deduction_1_P2 = By.xpath("(//div[@class='ant-select-item-option-content' and normalize-space()='Giảm trừ theo suất thực nhận'])[2]");
    public static final By Value_kind_of_deduction_2_P2 = By.xpath("(//div[@class='ant-select-item-option-content' and normalize-space()='Giảm trừ toàn bộ sản phẩm'][2]");
    //gói 3
    public static final By DROPDOWN_PACKAGE_CONDITION_3 = By.xpath("//input[@id='packages_2_condition_option']/ancestor::div[contains(@class,'ant-select-selector')]");
    public static final By OPTION_CONTENT_2_PACKAGE_3 = By.xpath("(//div[@class='ant-select-item-option-content' and text()='Tổng số lượng nhóm sản phẩm'])[3]");
    public static final By CONDITION_VALUE_QUALITY_3 = By.xpath("(//input[@placeholder='Nhập vào số lượng'])[5]");
    public static final By DROPDOWN_PACKAGE_ACTION_OPTION_2 = By.xpath("//input[@id='packages_2_action_option']/ancestor::div[contains(@class,'ant-select-selector')]");
    public static final By INPUT_PACKAGE_QUANTITY_3 = By.xpath("(//input[@placeholder='Nhập vào số lượng'])[6]");
    public static final By Action_value_kind_of_deduction_3 = By.xpath("//input[@id='packages_2_action_value_kind_of_deduction']/ancestor::div[contains(@class,'ant-select-selector')]");
    public static final By Value_kind_of_deduction_1_P3 = By.xpath("(//div[@class='ant-select-item-option-content' and normalize-space()='Giảm trừ theo suất thực nhận'])[3]");
    public static final By Value_kind_of_deduction_2_P3 = By.xpath("(//div[@class='ant-select-item-option-content' and normalize-space()='Giảm trừ toàn bộ sản phẩm'])[3]");


    public static final By TAB_BUDGET = By.xpath("//div[@role='tab' and .//span[text()='Ngân sách']]");

        public static final By RADIO_BUDGET_SLOT = By.xpath("//input[@name='budget_config_budget_type' and @value='SLOT']/parent::span");
        public static final By CHECKBOX_TOTAL_BUDGET = By.xpath("//input[@id='budget_config_use_budget_1']/parent::span");
        public static final By INPUT_TOTAL_BUDGET = By.xpath("//input[@id='budget_config_total_budget_current_value_total_budget']");
// ngn sach kv
    public static final By CHECKBOX_AREA_BUDGET = By.xpath("//input[@id='budget_config_use_budget_2']/parent::span");
    public static final By BUTTON_ADD_REGION_BUDGET = By.xpath("//div[contains(@class,'ant-pro-table-list-toolbar') and .//strong[normalize-space()='Danh sách khu vực']]//button[span[normalize-space()='Thêm mới']]");
    public static final By INPUT_SEARCH_REGION = By.xpath("//input[@id='keyword' and @type='table']");
    public static final By BUTTON_SEARCH_REGION = By.xpath("//button[span[normalize-space()='Tìm kiếm']]");
    public static final By CHECKBOX_FIRST_RESULT1 = By.xpath("//tr[.//td[contains(text(),'8')]]//label[contains(@class,'ant-checkbox-wrapper')]");
    public static final By CHECKBOX_FIRST_RESULT2 = By.xpath("//tr[.//td[contains(text(),'4')]]//label[contains(@class,'ant-checkbox-wrapper')]");

    //ns npp
    public static final By CHECKBOX_DISTRIBUTOR_BUDGET = By.xpath("//input[@id='budget_config_use_budget_3']/parent::span");
    public static final By BUTTON_ADD_DISTRIBUTOR_BUDGET = By.xpath("//div[contains(@class,'ant-pro-table-list-toolbar') and .//strong[normalize-space()='Danh sách nhà phân phối']]//button[span[normalize-space()='Thêm mới']]");
    public static final By INPUT_SEARCH_DISTRIBOR = By.xpath("//input[@id='keyword' and @type='table']");
    public static final By BUTTON_SEARCH_DISTRIBUTOR = By.xpath("//div[contains(@class,'ant-modal-content') and .//div[contains(text(),'Chọn nhà phân phối')]]//button[span[normalize-space()='Tìm kiếm']]");
    public static final By CHECKBOX_FIRST_DISTRIBUTOR1 = By.xpath("//div[.//div[text()='Danh sách nhà phân phối']]//tbody//tr[td[text()='1']]//label[contains(@class,'ant-checkbox-wrapper')]");
    public static final By BUTTON_CONFIRM_DISTRIBUTOR = By.xpath("//div[contains(@class,'ant-modal-footer')]//button[span[normalize-space()='Đồng ý']]");
    public static final By INPUT_DISTRIBUTOR_BUDGET1 = By.xpath("(//th[text()='Mã NPP']//ancestor::div[@class='ant-table-header']/following-sibling::div//input[@placeholder='nhập dữ liệu'])[1]");
    public static final By INPUT_DISTRIBUTOR_BUDGET2 = By.xpath("(//th[text()='Mã NPP']//ancestor::div[@class='ant-table-header']/following-sibling::div//input[@placeholder='nhập dữ liệu'])[2]");


    public static final By CHECKBOX_PERMERCHANRT_BUDGET = By.xpath("//input[@id='budget_config_use_budget_4']/parent::span");
    public static final By INPUT_PERMERCHANRT_BUDGET = By.xpath("//input[@id='budget_config_per_merchant_budget_current_value_total_budget']");

    public static final By BUTTON_CONFIRM_REGION = By.xpath("//button[span[normalize-space()='Đồng ý']]");
    public static final By INPUT_REGION_BUDGET1 = By.xpath("//div[normalize-space()='Ngân sách Khu vực']//following::input[@placeholder='nhập dữ liệu'][1]");
    public static final By INPUT_REGION_BUDGET2 = By.xpath("//div[normalize-space()='Ngân sách Khu vực']//following::input[@placeholder='nhập dữ liệu'][2]");

    public static final By CHECKBOX_LIMIT_PRODUCT = By.xpath("//input[@id='budget_config_use_budget_5']/following-sibling::span");
        public static final By ICON_SYNC_PRODUCT_BUDGET = By.xpath("(//button[.//span[contains(@class,'anticon-file-sync')]])[3]");
        public static final By INPUT_PRODUCT_BUDGET = By.xpath("//td[contains(@class,'ant-table-cell')]//input[@placeholder='nhập dữ liệu' and not(@disabled)]");

        public static final By BUTTON_SAVE = By.xpath("//span[text()='Lưu']/ancestor::button");
        public static final By BUTTON_ACCEPT = By.xpath("//span[text()='Đồng ý']/ancestor::button");
}
