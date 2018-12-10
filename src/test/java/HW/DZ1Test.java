package HW;

import org.junit.Assert;
import org.junit.Test;

public class DZ1Test {
    @Test
    public void testDZ1_1() {
        int[] arr = {1, 2, 6, 4, 7, 9, 0};
        int[] res = {7, 9, 0};
        Assert.assertArrayEquals(res, DZ.dz1(arr));
    }
    @Test
    public void testDZ1_2() {
        int[] arr = {1, 2, 6, 4, 7, 4, 0};
        int[] res = {0};
        Assert.assertArrayEquals(res, DZ.dz1(arr));
    }
    @Test
    public void testDZ1_3() {
        int[] arr = {4, 2, 6, 6, 7, 9, 9};
        int[] res = {2, 6, 6, 7, 9, 9};
        Assert.assertArrayEquals(res, DZ.dz1(arr));
    }
    @Test
    public void testDZ1_4() {
        int[] arr = {1, 2, 6, 4, 7, 9, 4};
        int[] res = null;
        Assert.assertArrayEquals(res, DZ.dz1(arr));
    }
    @Test (expected = RuntimeException.class)
    public void testDZ1_5() {
        int[] arr = {1, 2, 6, 6, 7, 9, 0};
        int[] res = null;
        Assert.assertArrayEquals(res, DZ.dz1(arr));
    }
}
