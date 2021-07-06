package converter;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.LinkedList;

public class BaseConverter {
    public static String convert(String strNum, int sourceBase, int targetBase) {
        String[] parts = strNum.split("\\.");
        String integerPart = parts[0];
        String fractionalPart = "";
        if (parts.length == 2) {
            fractionalPart = parts[1];
            BigDecimal decimal = DecimalConverter.toDecimalConverter(integerPart, fractionalPart, sourceBase, true);
            return DecimalConverter.fromDecimalConvert(decimal, targetBase, true);
        }
        else {
            BigDecimal decimal = DecimalConverter.toDecimalConverter(integerPart, fractionalPart, sourceBase, false);
            return DecimalConverter.fromDecimalConvert(decimal, targetBase, false);
        }
    }
}


class DecimalConverter {
    static BigDecimal toDecimalConverter(String integerPart, String fractionalPart, int sourceBase, boolean isFractional) {
        BigDecimal base = BigDecimal.valueOf(sourceBase);

        BigDecimal result = BigDecimal.ZERO;
        //converting integer part
        BigDecimal tmpResult;
        int digit = 0;
        int power = 0;
        for (int i = integerPart.length() - 1; i >= 0; i--) {
            char ch = integerPart.charAt(i);
            if (ch >= 48 && ch <= 57) {
                digit = ch - 48;
            } else if (ch >= 65 && ch <= 90) {
                digit = ch - 55;
            } else if (ch >= 97 && ch <= 122) {
                digit = ch - 87;
            }
            tmpResult = BigDecimal.valueOf(digit).multiply(base.pow(power));
            result = result.add(new BigDecimal(tmpResult.toString()));
            power++;
        }

        //converting fractional part
        if (isFractional){
            power = 1;
            for (int i = 0; i < fractionalPart.length(); i++) {
                char ch = fractionalPart.charAt(i);
                if (ch >= 48 && ch <= 57) {
                    digit = ch - 48;
                } else if (ch >= 65 && ch <= 90) {
                    digit = ch - 55;
                } else if (ch >= 97 && ch <= 122) {
                    digit = ch - 87;
                }
                BigDecimal baseOfPower = base.pow(power);
                tmpResult = BigDecimal.valueOf(digit).divide(baseOfPower, 10, RoundingMode.CEILING);
                result = result.add(new BigDecimal(tmpResult.toString()));
                power++;
            }
        }

        return result;
    }

    static String fromDecimalConvert(BigDecimal decimalNumber, int targetBase, boolean isFractional) {
        BigDecimal bigDecimalBase = BigDecimal.valueOf(targetBase);
        BigInteger bigIntBase = BigInteger.valueOf(targetBase);

        //converting integer part
        BigInteger integer = decimalNumber.toBigInteger();
        BigInteger Quotient = integer;
        int Remainder;
        LinkedList<String> list = new LinkedList<>();
        while (Quotient.compareTo(BigInteger.ZERO) != 0) {
            Remainder = Integer.parseInt(Quotient.remainder(bigIntBase).toString());
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

        //converting fractional part
        if (isFractional){
            BigDecimal integerPart = new BigDecimal(integer.toString());
            BigDecimal fractionalPart = decimalNumber.subtract(integerPart);
            StringBuilder StrConvertedFraction = new StringBuilder(".");
            while (true) {
                BigDecimal remainder = fractionalPart.multiply(bigDecimalBase);
                BigInteger remainderInt = remainder.toBigInteger();
                BigDecimal decimalRemainderInt = new BigDecimal(remainderInt.toString());
                BigDecimal remainderFraction = remainder.subtract(decimalRemainderInt);

                Remainder = Integer.parseInt(remainderInt.toString());
                if (Remainder <= 9) {
                    StrConvertedFraction.append(Remainder);
                } else {
                    char ch = (char) (Remainder + 55);
                    StrConvertedFraction.append(ch);
                }


                if (remainderFraction.equals(BigDecimal.ZERO) || StrConvertedFraction.length() == 6) {
                    break;
                } else {
                    fractionalPart = remainderFraction;
                }
            }

            if (StrConvertedFraction.length() < 6) {
                int length = StrConvertedFraction.length();
                int empty = 7 - length;
                StrConvertedFraction.append("0".repeat(Math.max(0, empty)));
            }
            out.append(StrConvertedFraction);
        }


        return out.toString();
    }
}