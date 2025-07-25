package test.Page;

public class DynamicPackageLocators {
    public static final String DROPDOWN_PACKAGE_CONDITION_OPTION_XPATH =
            "//input[@id='packages_%d_condition_option']";

    public static final String INPUT_PACKAGE_CONDITION_VALUE_XPATH =
            "//input[@name='packages[%d].condition.value']";

    public static final String DROPDOWN_PACKAGE_ACTION_OPTION_XPATH =
            "//input[@id='packages_%d_action_option']";

    public static final String INPUT_PACKAGE_ACTION_VALUE_XPATH =
            "//input[@name='packages[%d].action.value']";
}
