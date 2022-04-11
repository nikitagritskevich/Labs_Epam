import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomMatrix {

    public static void main(String[] args) {
      int length = 3;
      int bound = 20;
      Random random = new Random();
      if (bound < Math.pow(length, 2)) {
        throw new IllegalArgumentException();
      }
      List<Integer> matrixRandomValue = new ArrayList<>();
      int[][] matrix = new int[length][length];
      for (int i = 0; i < length; i++) {
        for (int j = 0; j < length; j++) {
          int randomValue = random.nextInt(bound);
          while (matrixRandomValue.contains(randomValue)) {
            randomValue = random.nextInt(bound);
          }
          matrixRandomValue.add(randomValue);
          matrix[i][j] = randomValue;
        }
      }
    }

}
