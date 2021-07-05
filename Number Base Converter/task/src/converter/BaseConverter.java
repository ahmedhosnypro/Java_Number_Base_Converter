package converter;

import java.util.LinkedList;
import java.util.Map;

abstract public class BaseConverter {
    Map<Integer, String> hexMap;
    Map<String, Integer> reversedHexMap;

    {
        hexMap = Map.of(10, "A", 11, "B", 12, "C",
                13, "D", 14, "E", 15, "F");
        reversedHexMap = Map.of("A", 10, "B", 11, "C", 12, "D",
                13, "E", 14, "F", 15);
    }

    abstract String fromBaseConvert(String decimalNumber, String targetBase);

    abstract String toBaseConverter(String sourceNumber, String sourceBase);
}

class ConvertFactory {
    public BaseConverter createConverter() {
//        String inputBase
//        inputBase = inputBase.toLowerCase();
//        switch (inputBase) {
//            case "binary":
//                return new BinaryConverter();
//            case "octal":
//                return new OctalConverter();
//            case "decimal":
//                return new DecimalConverter();
//            case "hex":
//                return new HexConverter();
//            default:
//                return null;
//        }
        return new DecimalConverter();
    }

    public BaseConverter createConverter(int inputBase) {
//        switch (inputBase) {
//            case 2:
//                return new BinaryConverter();
//            case 8:
//                return new OctalConverter();
//            case 10:
//                return new DecimalConverter();
//            case 16:
//                return new HexConverter();
//            default:
//                return null;
//        }
        return new DecimalConverter();
    }

}

class DecimalConverter extends BaseConverter{

    @Override
    String fromBaseConvert(String decimalNumber, String targetBase) {
        int Quotient = Integer.parseInt(decimalNumber);
        int base = Integer.parseInt(targetBase);
        int Remainder;
        LinkedList<String> list = new LinkedList<>();

        while (Quotient > 0) {
            Remainder = Quotient % base;
            Quotient /= base;

            if (base == 2 || base == 8 || base == 10) {
                list.addFirst(String.valueOf(Remainder));
            } else if (base == 16) {
                list.addFirst(hexMap.getOrDefault(Remainder, String.valueOf(Remainder)));
            }
        }

        StringBuilder out = new StringBuilder();
        for (var N : list) {
            out.append(N);
        }
        return out.toString();
    }

    @Override
    String toBaseConverter(String sourceNumber, String sourceBase) {
        int base = Integer.parseInt(sourceBase);

        int result =0;
        if (base == 2 || base == 8) {

            int digit = Integer.parseInt(sourceNumber);
            int power = 0;
            int tmpResult;
            while (digit > 0) {
                int n = digit % 10;
                tmpResult = (int) (n * Math.pow(base, power));
                result += tmpResult;
                digit /= 10;
                power++;
            }
        } else if (base == 16) {
            int digit;
            int power = 0;
            int tmpResult;

            for (int i = sourceNumber.length()-1; i >= 0; i--) {
                char ch = sourceNumber.charAt(i);
                digit = reversedHexMap.getOrDefault(String.valueOf(ch), (ch - 48));
                tmpResult = (int) (digit * Math.pow(base, power));
                result += tmpResult;
                power++;
            }
        }

        return String.valueOf(result);
    }
}