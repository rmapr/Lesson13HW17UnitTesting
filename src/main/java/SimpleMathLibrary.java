import java.util.Arrays;

public class SimpleMathLibrary {


    public static void main(String[] args) {
        System.out.println(add(5, 3));
        System.out.println(minus(5, 3));
        int[] arrayAfterFour = arrayAfterLastNumberFour(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9});
        System.out.println(Arrays.toString(arrayAfterFour));
        System.out.println(presentOneFour(new int[]{1, 1, 1, 1}));
        System.out.println(presentOneFour(new int[]{1, 1, 1, 4}));
        System.out.println(presentOneFour(new int[]{4, 4, 4, 4}));
        System.out.println(presentOneFour(new int[]{1, 2, 4, 4}));
    }

    public static double add(double a, double b) {
        return a + b;
    }

    public static double minus(double a, double b) {
        return a - b;
    }

    //    14. Написати метод, якому як аргумент передається не порожній одновимірний цілісний масив. Метод повинен повернути новий масив,
//отриманий шляхом витягування з вихідного масиву елементів, що йдуть після останньої четвірки. Вхідний масив повинен містити
//хоча б одну четвірку, інакше в методі необхідно викинути RuntimeException.
//Написати набір тестів цього методу (по 3-4 варіанти вхідних даних).
//    Наприклад: [1 2 4 4 2 3 4 1 7] -> вих: [1 7].
    public static int[] arrayAfterLastNumberFour(int[] arrayInt) {
        int[] arrayNew;
        int indexLastFourInArray = -1;
        for (int i = 0; i < arrayInt.length; i++) {
            if (arrayInt[i] == 4) {
                indexLastFourInArray = i;
            }
        }
        if (indexLastFourInArray == -1) {
            throw new RuntimeException("В масиві відсутня цифра 4");
        } else if (indexLastFourInArray == arrayInt.length - 1) {
            throw new EmptyArrayException("В масиві цифра 4 остання, результатом буде пустий масив");
        }
        arrayNew = new int[arrayInt.length - indexLastFourInArray - 1];
        for (int i = 0; i < arrayNew.length; i++) {

            arrayNew[i] = arrayInt[indexLastFourInArray + i + 1];
        }
        return arrayNew;
    }

    //15. Написати метод, який перевіряє склад масиву з чисел 1 і 4. Якщо у ньому немає хоч однієї четвірки чи одиниці, то
//метод поверне false; Написати набір тестів цього методу (по 3-4 варіанти вхідних даних).
//Наприклад:
//[ 1 1 1 4 4 1 4 4] -> true
//[ 1 1 1 1 1 1] -> false
//[ 4 4 4 4] -> false
//[ 1 4 4 1 1 4 3] -> false
    public static boolean presentOneFour(int[] arrayInt) {
        boolean presentOne = false;
        boolean presentFour = false;

        for (int i : arrayInt) {
            switch (i) {
                case 1 -> presentOne = true;
                case 4 -> presentFour = true;
                default -> {
                    return false;
                }
            }
        }
        return presentOne && presentFour;
    }

}
