import javax.naming.SizeLimitExceededException;

public class JavaTwoHWTwo {
    private static final int ARR_SIZE_MULT = 5;
    private static final int RAND_MULT = 401;
    private static final String TESTO = "testo";
    public static void main(String[] args) {
        int result = 0;

        try {
            result = sumArray(createStringArray());
            System.out.println("Сумма элементов массива: " + result);
        } catch (MySizeArrayException mySizeArrayException) {
            System.out.println("Размер массива не 4х4");
        } catch (MyArrayDataException myArrayDataException) {
            System.out.println("Элемент массива не является целым числом.");
        }

    }

    private static String[][] createStringArray() throws MySizeArrayException {
        int arrSize = (int) ((Math.random() * ARR_SIZE_MULT) + 1);


        String array[][] = new String[arrSize][arrSize];

        try {
            if (array.length != 4) {
                throw new SizeLimitExceededException("Not 4x4.");
            }
        } catch (SizeLimitExceededException exception) {
            throw new MySizeArrayException("Размер массива не 4х4");
        }

        for (int indRows = 0; indRows < array.length; indRows++) {
            for (int indCols = 0; indCols < array.length; indCols++) {
                int rand = (int) (Math.random() * RAND_MULT);
                if (rand >= RAND_MULT - 15) {
                    array[indRows][indCols] = TESTO;
                } else {
                    array[indRows][indCols] = String.valueOf(rand);
                }
            }
        }
        return array;
    }

    private static int sumArray(String array[][]) throws MySizeArrayException, MyArrayDataException {
        int sumElements = 0;

        try {
            if (array.length != 4) {
                throw new SizeLimitExceededException("Not 4x4.");
            }
        } catch (SizeLimitExceededException exception) {
            throw new MySizeArrayException("Размер массива не 4х4");
        }


        for (int indRows = 0; indRows < array.length; indRows++) {
            for (int indCols = 0; indCols < array.length; indCols++) {
                try {
                    sumElements += Integer.parseInt(array[indRows][indCols]);
                } catch (NumberFormatException numberFormatException) {
                    throw new MyArrayDataException("Элемент [" + indRows + "][" + indCols + "] не является целым числом");
                }
            }
        }

        
        return sumElements;
    }
}
