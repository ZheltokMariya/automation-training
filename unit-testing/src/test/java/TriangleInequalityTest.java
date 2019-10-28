import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TriangleInequalityTest {

    @Test
    public void allSidesZero(){
        assertThrows(IllegalArgumentException.class, () -> TriangleInequality.isTriangleExist(0, 0, 0));
    }

    @Test
    public void allSidesNegative(){
        assertThrows(IllegalArgumentException.class, () -> TriangleInequality.isTriangleExist(-9.58, -9.58, -3.47));
    }

    @Test
    public void oneSideZero(){
        assertThrows(IllegalArgumentException.class, () -> TriangleInequality.isTriangleExist(0, 5.57, 6.48));
    }

    @Test
    public void oneSideNegative(){
        assertThrows(IllegalArgumentException.class, () -> TriangleInequality.isTriangleExist(-6.34, 6.34, 4.78));
    }

    @Test
    public void equilateralTriangle(){
        assertTrue(TriangleInequality.isTriangleExist(5.5, 5.5, 5.5));
    }

    @Test
    public void isoscelesTriangle(){
        assertTrue(TriangleInequality.isTriangleExist(5.5, 5.5, 4.7));
    }

    @Test
    public void versatileTriangle(){
        assertTrue(TriangleInequality.isTriangleExist(3.56, 5.3, 7.48));
    }

    @Test
    public void oneSideMuchLargeThenSumOfOther(){
        assertFalse(TriangleInequality.isTriangleExist(3.38, 4.56, 150.98));
    }

    @Test
    public void oneSideLightlyLargeThenSumOfOther(){
        assertFalse(TriangleInequality.isTriangleExist(5.3, 4.7, 10.1));
    }

    @Test
    public void oneSideEqualToSumOfOther(){
        assertFalse(TriangleInequality.isTriangleExist(5.5, 5.5, 11.0));
    }
}
