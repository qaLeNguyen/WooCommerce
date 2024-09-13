package utils;

import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class DataProviderService {

    @DataProvider(name = "validEmails")
    public Object[][] ValidEmail() throws IOException {
        List<Map<String, String>> fullInfo = DataLoader.loadTestData(
                "src/test/resources/data/CreateAnAccountData.json",
                "validEmails");

        Object[][] data = new Object[fullInfo.size()][1];

        for (int i = 0; i < fullInfo.size(); i++) {
            Map<String, String> value = fullInfo.get(i);
            data[i][0] = value.get("email");
        }
        return data;
    }

    @DataProvider(name = "invalidEmails")
    public Object[][] InvalidEmail() throws IOException {
        List<Map<String, String>> fullInfo = DataLoader.loadTestData(
                "src/test/resources/data/CreateAnAccountData.json",
                "invalidEmails");

        Object[][] data = new Object[fullInfo.size()][1];

        for (int i = 0; i < fullInfo.size(); i++) {
            Map<String, String> value = fullInfo.get(i);
            data[i][0] = value.get("email");
        }
        return data;
    }

    @DataProvider(name = "Valid Email And ReLogin")
    public Object[][] validEmailsAndReLogin() throws IOException {
        List<Map<String, String>> fullInfo = DataLoader.loadTestData(
                "src/test/resources/data/CreateAnAccountData.json",
                "validEmailsAndReLogin");

        Object[][] data = new Object[fullInfo.size()][1];

        for (int i = 0; i < fullInfo.size(); i++) {
            Map<String, String> value = fullInfo.get(i);
            data[i][0] = value.get("email");
        }
        return data;
    }

    @DataProvider(name = "Spanish")
    public Object[][] Spanish() throws IOException {
        List<Map<String, String>> fullInfo = DataLoader.loadTestData(
                "src/test/resources/data/HomePageData.json",
                "Spanish");

        Object[][] data = new Object[fullInfo.size()][8];

        for (int i = 0; i < fullInfo.size(); i++) {
            Map<String, String> value = fullInfo.get(i);
            data[i][0] = value.get("language");
            data[i][1] = value.get("buttonCreateAnAccount");
            data[i][2] = value.get("buttonLogin");
            data[i][3] = value.get("howWooHelpYou");
            data[i][4] = value.get("loveByMillionsOfBrands");
            data[i][5] = value.get("powerUpWooStore");
            data[i][6] = value.get("trustEcommercePlatform");
            data[i][7] = value.get("footer");
        }
        return data;
    }

    @DataProvider(name = "French")
    public Object[][] French() throws IOException {
        List<Map<String, String>> fullInfo = DataLoader.loadTestData(
                "src/test/resources/data/HomePageData.json",
                "French");

        Object[][] data = new Object[fullInfo.size()][8];

        for (int i = 0; i < fullInfo.size(); i++) {
            Map<String, String> value = fullInfo.get(i);
            data[i][0] = value.get("language");
            data[i][1] = value.get("buttonCreateAnAccount");
            data[i][2] = value.get("buttonLogin");
            data[i][3] = value.get("loveByMillionsOfBrands");
            data[i][4] = value.get("getExpertHelp");
            data[i][5] = value.get("powerUpWooStore");
            data[i][6] = value.get("solutions");
            data[i][7] = value.get("footer");
        }
        return data;
    }

    @DataProvider(name = "Portuguese")
    public Object[][] Portuguese() throws IOException {
        List<Map<String, String>> fullInfo = DataLoader.loadTestData(
                "src/test/resources/data/HomePageData.json",
                "Portuguese");

        Object[][] data = new Object[fullInfo.size()][8];

        for (int i = 0; i < fullInfo.size(); i++) {
            Map<String, String> value = fullInfo.get(i);
            data[i][0] = value.get("language");
            data[i][1] = value.get("buttonCreateAnAccount");
            data[i][2] = value.get("buttonLogin");
            data[i][3] = value.get("loveByMillionsOfBrands");
            data[i][4] = value.get("getExpertHelp");
            data[i][5] = value.get("powerUpWooStore");
            data[i][6] = value.get("solutions");
            data[i][7] = value.get("footer");
        }
        return data;
    }

    @DataProvider(name = "buyProduct")
    public Object[][] buyProduct() throws IOException {
        List<Map<String, String>> fullInfo = DataLoader.loadTestData(
                "src/test/resources/data/ActionBuyingData.json",
                "buyProduct");

        Object[][] data = new Object[fullInfo.size()][11];

        for (int i = 0; i < fullInfo.size(); i++) {
            Map<String, String> value = fullInfo.get(i);
            data[i][0] = value.get("productName");
            data[i][1] = value.get("email");
            data[i][2] = value.get("confirmEmail");
            data[i][3] = value.get("firstName");
            data[i][4] = value.get("lastName");
            data[i][5] = value.get("countryRegion");
            data[i][6] = value.get("address1");
            data[i][7] = value.get("city");
            data[i][8] = value.get("state");
            data[i][9] = value.get("postCode");
            data[i][10] = value.get("method");
        }
        return data;
    }

    @DataProvider(name = "buySeveralProducts")
    public Object[][] buySeveralProducts() throws IOException {
        List<Map<String, String>> fullInfo = DataLoader.loadTestData(
                "src/test/resources/data/ActionBuyingData.json",
                "buySeveralProducts");

        Object[][] data = new Object[fullInfo.size()][15];

        for (int i = 0; i < fullInfo.size(); i++) {
            Map<String, String> value = fullInfo.get(i);
            data[i][0] = value.get("productName1");
            data[i][1] = value.get("productName2");
            data[i][2] = value.get("productName3");
            data[i][3] = value.get("productName4");
            data[i][4] = value.get("productName5");
            data[i][5] = value.get("email");
            data[i][6] = value.get("confirmEmail");
            data[i][7] = value.get("firstName");
            data[i][8] = value.get("lastName");
            data[i][9] = value.get("countryRegion");
            data[i][10] = value.get("address1");
            data[i][11] = value.get("city");
            data[i][12] = value.get("state");
            data[i][13] = value.get("postCode");
            data[i][14] = value.get("method");
        }
        return data;
    }

    @DataProvider(name = "searchProducts")
    public Object[][] searchProducts() throws IOException {
        List<Map<String, String>> fullInfo = DataLoader.loadTestData(
                "src/test/resources/data/ActionBuyingData.json",
                "searchProducts");

        Object[][] data = new Object[fullInfo.size()][20];

        for (int i = 0; i < fullInfo.size(); i++) {
            Map<String, String> value = fullInfo.get(i);
            data[i][0] = value.get("productName1");
            data[i][1] = value.get("productName2");
            data[i][2] = value.get("productName3");
            data[i][3] = value.get("productName4");
            data[i][4] = value.get("productName5");
            data[i][5] = value.get("productName6");
            data[i][6] = value.get("productName7");
            data[i][7] = value.get("productName8");
            data[i][8] = value.get("productName9");
            data[i][9] = value.get("productName10");
            data[i][10] = value.get("productName11");
            data[i][11] = value.get("productName12");
            data[i][12] = value.get("productName13");
            data[i][13] = value.get("productName14");
            data[i][14] = value.get("productName15");
            data[i][15] = value.get("productName16");
            data[i][16] = value.get("productName17");
            data[i][17] = value.get("productName18");
            data[i][18] = value.get("productName19");
            data[i][19] = value.get("productName20");
        }
        return data;
    }

    @DataProvider(name = "filterProductsByCategory")
    public Object[][] filterProductsByCategory() throws IOException {
        List<Map<String, String>> fullInfo = DataLoader.loadTestData(
                "src/test/resources/data/ActionBuyingData.json",
                "filterProductsByCategory");

        Object[][] data = new Object[fullInfo.size()][2];

        for (int i = 0; i < fullInfo.size(); i++) {
            Map<String, String> value = fullInfo.get(i);
            data[i][0] = value.get("category");
            data[i][1] = value.get("expectVendorName");
        }
        return data;
    }

    @DataProvider(name = "filterProductsByPrice")
    public Object[][] filterProductsByPrice() throws IOException {
        List<Map<String, String>> fullInfo = DataLoader.loadTestData(
                "src/test/resources/data/ActionBuyingData.json",
                "filterProductsByPrice");

        Object[][] data = new Object[fullInfo.size()][3];

        for (int i = 0; i < fullInfo.size(); i++) {
            Map<String, String> value = fullInfo.get(i);
            data[i][0] = value.get("rangePrice");
            data[i][1] = value.get("beginPrice");
            data[i][2] = value.get("endPrice");
        }
        return data;
    }

    @DataProvider(name = "findProducts")
    public Object[][] findProducts() throws IOException {
        List<Map<String, String>> fullInfo = DataLoader.loadTestData(
                "src/test/resources/data/ActionBuyingData.json",
                "findProducts");

        Object[][] data = new Object[fullInfo.size()][1];

        for (int i = 0; i < fullInfo.size(); i++) {
            Map<String, String> value = fullInfo.get(i);
            data[i][0] = value.get("productNameDisplayed");
        }
        return data;
    }

}