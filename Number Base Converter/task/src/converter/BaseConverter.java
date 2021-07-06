package converter;

import java.math.BigInteger;
import java.util.LinkedList;

public class BaseConverter {
    public static String convert(String strNum, int sourceBase, int targetBase) {
        BigInteger decimal = DecimalConverter.toDecimalConverter(strNum, sourceBase);
        return DecimalConverter.fromDecimalConvert(decimal, targetBase);
    }
}


class DecimalConverter {
    static BigInteger toDecimalConverter(String strNum, int sourceBase) {
        BigInteger result = BigInteger.ZERO;


        int digit = 0;
        int power = 0;
        BigInteger base = BigInteger.valueOf(sourceBase);
        BigInteger tmpResult;

        for (int i = strNum.length() - 1; i >= 0; i--) {
            char ch = strNum.charAt(i);
            if (ch >= 48 && ch <= 57) {
                digit = ch - 48;
            } else if (ch >= 65 && ch <= 90) {
                digit = ch - 55;
            } else if (ch >= 97 && ch <= 122) {
                digit = ch - 87;
            }
//            tmpResult = (int) (digit * Math.pow(sourceBase, power));
            tmpResult = BigInteger.valueOf(digit).multiply(base.pow(power));
            result = result.add(tmpResult);
            power++;
        }

        return result;
    }

    static String fromDecimalConvert(BigInteger decimalNumber, int targetBase) {
        BigInteger Quotient = decimalNumber;

        int Remainder;
        LinkedList<String> list = new LinkedList<>();

        while (!Quotient.equals(BigInteger.ZERO)) {
            Remainder = Integer.parseInt(Quotient.remainder(BigInteger.valueOf(targetBase)).toString());
            Quotient = Quotient.divide(BigInteger.valueOf(targetBase));

            if (Remainder <= 9) {
                list.addFirst(String.valueOf(Remainder));
            } else {
                char ch = (char) (Remainder + 55);
                list.addFirst(String.valueOf(ch));
            }
        }

        StringBuilder out = new StringBuilder();
        for (var N : list) {
            out.append(N);
        }
        return out.toString();
    }
}