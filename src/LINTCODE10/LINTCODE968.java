package LINTCODE10;

public class LINTCODE968 {
    /*Description
     * 实现一个函数，该函数将确定字符串是否表示有效的货币数量。
     * 这些字符串将具有以下属性:
     * 1、数额必须包含十进制。
     * 2、数额可以选择使用'，'字符作为每个千位的分隔符，比如10,000,000。
     * 3、如果有数以千计的分隔符','，它们必须在每个数以千计的增量中出现。
     * 4、金额前必须加上货币符号。我们支持美元(D),欧元(E)和日元(Y)。
     * 5、可以在货币符号前加上负号，也可以将金额(包括货币符号)括在括号内，例如(D450)。
     * 6、美元和欧元金额可以包含分的金额，精确表示为小数点后两个数字。
     * 7、如果有小数点，必须指定到分。
     * 8、日元金额不能包含小数点。
     * 9、金额不能包含前导零，除非它是零美元、零欧元或精确到分。
     * 10、任何其他字符，包括前导或末尾的空格，都是无效的。
     * */
    public boolean validCurrencyAmount(String currency) {
        if (currency.charAt(0) == '-')
            currency = currency.substring(1);
        if (currency.charAt(0) == '(' && currency.charAt(currency.length() - 1) == ')')
            currency = currency.substring(1, currency.length() - 1);

        char type = currency.charAt(0);
        switch (type) {
            case 'D':
            case 'E':
                return validCurrencyAmountType1(currency.substring(1));
            case 'Y':
                return validCurrencyAmountType2(currency.substring(1));
            default:
                return false;
        }
        // write your code here
    }

    private boolean isInteger(char cur) {
        return cur <= '9' && cur >= '0';
    }

    public boolean validCurrencyAmountType1(String cur) {
        if (cur.charAt(cur.length() - 1) == '.')
            return false;
        System.out.println(cur);
        String[] s = cur.split("\\.");
        if (s.length > 2 || s.length == 2 && (s[1].length() != 2 || !isInteger(s[1].charAt(0)) || !isInteger(s[1].charAt(1))))
            return false;
        return validCurrencyAmountType2(s[0]);
    }

    public boolean validCurrencyAmountType2(String cur) {
        if (cur.equals("0"))
            return true;
        if (cur.charAt(0) == '0')
            return false;
        String[] s = cur.split(",");
        if (s.length == 1) {
            for (int i = 0; i < cur.length(); i++) {
                if (!isInteger(cur.charAt(i)))
                    return false;
            }
        } else {
            for (int i = 1; i < s.length; i++) {
                if (s[i].length() != 3)
                    return false;
                for (int j = 0; j < 3; j++) {
                    if (!isInteger(s[i].charAt(j)))
                        return false;
                }
            }
            for (int i = 0; i < s[0].length(); i++) {
                if (s[0].length() > 3)
                    return false;
                if (!isInteger(s[0].charAt(i)))
                    return false;
            }
        }
        return true;
    }

}
