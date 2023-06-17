import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class SimpleMathLibraryTest {
    double a;
    double b;
    SimpleMathLibrary sML;

    @BeforeEach
    public void initAB() {
        a = 5;
        b = 3;
    }

    @Test
    @DisplayName("Addition two numbers")
    void add() {
        assertEquals(8, sML.add(a, b));
    }

    @DisplayName("Subtraction two numbers")
    @Test
    void minus() {
        assertNotEquals(8, sML.minus(a, b));
    }

// Не зумів з масивом
//    @ParameterizedTest
//    @ValueSource(ints = {7, 8, 9})
    @Test
      void arrayAfterLastNumberFourFewFour() {
        assertArrayEquals(new int[]{7, 8, 9}, sML.arrayAfterLastNumberFour(new int[]{0, 1, 2, 3, 4, 5, 4, 7, 8, 9}));
    }
    @Test
      void arrayAfterLastNumberFourOnceFour() {
        assertArrayEquals(new int[]{5, 6, 7, 8, 9}, sML.arrayAfterLastNumberFour(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}));
    }
    @Test
      void arrayAfterLastNumberFourOnceFourNotEquals() {
        assertNotEquals(new int[]{6, 7, 8, 9}, sML.arrayAfterLastNumberFour(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}));
    }
    @Test
    @DisplayName("Will work RuntimeException")
      void arrayAfterLastNumberFourThrowRuntimeException() {
        assertThrowsExactly(RuntimeException.class, () -> sML.arrayAfterLastNumberFour(new int[]{0, 1, 2, 3, 152, 5, 6, 7, 8, 9}),
//це робив для звичайної перевірки, як працює )
                "В масиві відсутня цифра 4 і вона не остання");
    }

    @Test
    @DisplayName("Necessarily Throw EmptyArrayException")
    void arrayAfterLastNumberFourThrowEmptyArrayException() {
        assertThrowsExactly (EmptyArrayException.class, () -> sML.arrayAfterLastNumberFour(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 4}),
//це робив для звичайної перевірки, як працює )
                "В масиві присутня цифра 4, результатом буде пустий масив");
    }

    @Test
    @DisplayName("Exist only 1111")
    void presentOneFourFalse1() {
        assertFalse(sML.presentOneFour(new int[]{1, 1, 1, 1}));
    }
    @Test
    @DisplayName("Exist only 1 and 4")
    void presentOneFourTrue() {
        assertTrue(sML.presentOneFour(new int[]{1, 4, 1, 4}));
    }
    @Test
    @DisplayName("Exist only 4444")
    void presentOneFourFalse2() {
        assertFalse(sML.presentOneFour(new int[]{4, 4, 4, 4}));
    }
    @Test
    @DisplayName("Other numbers are present")
    void presentOneFourFalse3() {
        assertFalse(sML.presentOneFour(new int[]{1, 2, 3, 4}));
    }


}
