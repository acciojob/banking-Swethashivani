package com.driver;

public class CurrentAccount extends BankAccount {
    String tradeLicenseId; //consists of Uppercase English characters only

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception
        super(name, balance, 5000);
        this.tradeLicenseId = tradeLicenseId;
    }

    public String getTradeLicenseId() {
        return tradeLicenseId;
    }

    public void setTradeLicenseId(String tradeLicenseId) {
        this.tradeLicenseId = tradeLicenseId;
    }

    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception
        boolean isValid = true;
        for (int i = 0; i < tradeLicenseId.length() - 1; i++) {
            if (tradeLicenseId.charAt(i) == tradeLicenseId.charAt(i + 1)) {
                isValid = false;
                break;
            }
        }
        if (!isValid) {
            String reorganisedString = reorganizeString(tradeLicenseId);
            if (reorganisedString.equals(""))
                throw new Exception("Valid License can not be generated");
            else {
                this.tradeLicenseId = reorganisedString;
            }
        }
    }

    public String reorganizeString(String str) {
        int n = str.length();
        if (n <= 1) return str;
        int[] string = new int[26];
        int hf = 0;
        for (char a : str.toCharArray()) {
            if (hf < ++string[a - 'a']) hf = string[a - 'a'];
        }
        if (hf * 2 - 1 > n) return "";
        char[] res = new char[n];
        int odd = 0, even = 1;
        for (int i = 0; i < 26; i++) {
            while (string[i] > 0 && string[i] < n / 2 + 1 && even < n) {
                res[even] = (char) (i + 'a');
                even += 2;
                string[i]--;
            }
            while (string[i] > 0) {
                res[odd] = (char) (i + 'a');
                odd += 2;
                string[i]--;
            }
        }
        return new String(res);
    }

}


