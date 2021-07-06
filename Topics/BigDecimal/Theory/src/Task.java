// You can experiment here, it won’t be checked

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Task {
  public static void main(String[] args) {
    // put your code here
    BigDecimal number = new BigDecimal("2.001");
    number = number.add(BigDecimal.ONE);
    number = number.negate();
    number.setScale(1, RoundingMode.HALF_DOWN);
    System.out.println(number);
  }
}
