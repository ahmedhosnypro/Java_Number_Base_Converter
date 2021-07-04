package converter;

import java.util.LinkedList;
import java.util.Map;

abstract public class BaseConverter {
    abstract String convert(int input, int targetBase);

    abstract String toBinary(int input);

    abstract String toOctal(int input);

    abstract String toDecimal(int input);

    abstract String toHex(int input);
}

class ConvertFactory {
    public BaseConverter createConverter(String inputBase) {
        inputBase = inputBase.toLowerCase();
        switch (inputBase) {
            case "decimal":
                return new DecimalConverter();
            default:
                return null;
        }
    }

    public BaseConverter createConverter(int inputtBase) {
        switch (inputtBase) {
            case 10:
                return new DecimalConverter();
            default:
                return null;
        }
    }

}

class DecimalConverter extends BaseConverter {
    @Override
    String convert(int input, int targetBase) {
        switch (targetBase) {
            case 2:
                return toBinary(input);
            case 8:
                return toOctal(input);
            case 16:
                return toHex(input);
            default:
                return String.valueOf(input);
        }
    }

    private String normalConvert(int input, int targetBase) {
        StringBuilder out = new StringBuilder();
        LinkedList<Integer> list = new LinkedList<>();
        int Quotient = input;
        int Remainder;
        while (Quotient > 0) {
            Remainder = Quotient % targetBase;
            Quotient /= targetBase;
            list.addFirst(Remainder);
        }
        for (var N : list) {
            out.append(N);
        }
        return out.toString();
    }

    @Override
    String toBinary(int input) {
        return normalConvert(input, 2);
    }

    @Override
    String toOctal(int input) {
        return normalConvert(input, 8);
    }

    @Override
    String toDecimal(int input) {
        return String.valueOf(input);
    }

    @Override
    String toHex(int input) {
        StringBuilder out = new StringBuilder();
        LinkedList<String> list = new LinkedList<>();
        int Quotient = input;
        int Remainder;
        Map<Integer, String> map = Map.of(10, "A", 11, "B", 12, "C",
                13, "D", 14, "E", 15, "F");
        while (Quotient > 0) {
            Remainder = Quotient % 16;
            Quotient /= 16;
            String v = map.getOrDefault(Remainder, String.valueOf(Remainder));
            list.addFirst(v);
        }
        for (var N : list) {
            out.append(N);
        }
        return out.toString();
    }
}
