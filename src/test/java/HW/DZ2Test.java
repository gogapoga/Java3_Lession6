package HW;

import org.junit.Assert;
import org.junit.Test;

public class DZ2Test {
    @Test
    public void testDZ2_1() {
        int[] arr = {1, 2, 6, 4, 7, 9, 0};
        Assert.assertEquals(true, DZ.dz2(arr));
    }
    @Test
    public void testDZ2_2() {
        int[] arr = {1, 2, 6, 4, 7, 4, 0};
        Assert.assertEquals(true, DZ.dz2(arr));
    }
    @Test
    public void testDZ2_3() {
        int[] arr = {4, 2, 6, 6, 7, 9, 9};
        Assert.assertEquals(false, DZ.dz2(arr));
    }
    @Test
    public void testDZ2_4() {
        int[] arr = {1, 2, 6, 4, 7, 9, 4};
        Assert.assertEquals(true, DZ.dz2(arr));
    }
    @Test
    public void testDZ2_5() {
        int[] arr = {0, 2, 6, 6, 7, 9, 1};
        Assert.assertEquals(false, DZ.dz2(arr));
    }

}
