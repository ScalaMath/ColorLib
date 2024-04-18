package io.github.scalamath.colorlib;

import org.junit.Assert;
import org.junit.Test;

public class TestCol3f {

    @Test
    public void testAddThreeFloats() {
        var color = new Col3f(0.3f, 0.4f, 0.5f);
        var res = new Col3f(0.4f, 0.6f, 0.8f);
        Assert.assertTrue(res.equalsApprox(color.add(0.1f, 0.2f, 0.3f)));
    }

    @Test
    public void testAddFourFloats() {
        var color = new Col3f(0.3f, 0.4f, 0.5f);
        var res = new Col4f(0.4f, 0.6f, 0.8f, 1.4f);
        Assert.assertTrue(res.equalsApprox(color.add(0.1f, 0.2f, 0.3f, 0.4f)));
    }

    @Test
    public void testAddTwoColors() {
        var c1 = new Col3f(0.3f, 0.4f, 0.5f);
        var c2 = new Col3f(0.1f, 0.2f, 0.3f);
        var res = new Col3f(0.4f, 0.6f, 0.8f);
        Assert.assertTrue(res.equalsApprox(c1.add(c2)));
    }

    @Test
    public void testAddTwoColorsOfDifferentTypes() {
        var c1 = new Col3f(0.3f, 0.4f, 0.5f);
        var c2 = new Col4f(0.1f, 0.2f, 0.3f, 0.4f);
        var res = new Col4f(0.4f, 0.6f, 0.8f, 1.4f);
        Assert.assertTrue(res.equalsApprox(c1.add(c2)));
    }

    @Test
    public void testSubtractThreeFloats() {
        var color = new Col3f(0.4f, 0.6f, 0.8f);
        var res = new Col3f(0.3f, 0.4f, 0.5f);
        Assert.assertTrue(res.equalsApprox(color.subtract(0.1f, 0.2f, 0.3f)));
    }

    @Test
    public void testSubtractFourFloats() {
        var color = new Col3f(0.4f, 0.6f, 0.8f);
        var res = new Col4f(0.3f, 0.4f, 0.5f, 0.6f);
        Assert.assertTrue(res.equalsApprox(color.subtract(0.1f, 0.2f, 0.3f, 0.4f)));
    }

    @Test
    public void testSubtractTwoColors() {
        var c1 = new Col3f(0.4f, 0.6f, 0.8f);
        var c2 = new Col3f(0.3f, 0.4f, 0.5f);
        var res = new Col3f(0.1f, 0.2f, 0.3f);
        Assert.assertTrue(res.equalsApprox(c1.subtract(c2)));
    }

    @Test
    public void testSubtractTwoColorsOfDifferentTypes() {
        var c1 = new Col3f(0.4f, 0.6f, 0.8f);
        var c2 = new Col4f(0.3f, 0.4f, 0.5f, 0.6f);
        var res = new Col4f(0.1f, 0.2f, 0.3f, 0.4f);
        Assert.assertTrue(res.equalsApprox(c1.subtract(c2)));
    }

    @Test
    public void testMultiplyWithThreeFloats() {
        var color = new Col3f(0.2f, 0.3f, 0.4f);
        var res = new Col3f(0.4f, 0.9f, 0.6f);
        Assert.assertTrue(res.equalsApprox(color.multiply(2.0f, 3.0f, 1.5f)));
    }

    @Test
    public void testMultiplyWithFourFloats() {
        var color = new Col3f(0.2f, 0.3f, 0.4f);
        var res = new Col4f(0.4f, 0.9f, 0.6f, 2.0f);
        Assert.assertTrue(res.equalsApprox(color.multiply(2.0f, 3.0f, 1.5f, 2.0f)));
    }
    
    @Test
    public void testMultiplyTwoColors() {
        var c1 = new Col3f(2.0f, 3.0f, 1.5f);
        var c2 = new Col3f(0.2f, 0.3f, 0.4f);
        var res = new Col3f(0.4f, 0.9f, 0.6f);
        Assert.assertTrue(res.equalsApprox(c1.multiply(c2)));
    }
    
    @Test
    public void testMultiplyTwoColorsOfDifferentTypes() {
        var c1 = new Col3f(2.0f, 3.0f, 1.5f);
        var c2 = new Col4f(0.2f, 0.3f, 0.4f, 1.0f);
        var res = new Col4f(0.4f, 0.9f, 0.6f, 1.0f);
        Assert.assertTrue(res.equalsApprox(c1.multiply(c2)));
    }
    
    @Test
    public void testMultiplyWithAFloat() {
        var color = new Col3f(0.2f, 0.4f, 0.6f);
        var res = new Col3f(0.3f, 0.6f, 0.9f);
        Assert.assertTrue(res.equalsApprox(color.multiply(1.5f)));
    }
    
    @Test
    public void testDivideByThreeFloats() {
        var color = new Col3f(1.0f, 0.8f, 0.6f);
        var res = new Col3f(0.5f, 0.2f, 0.2f);
        Assert.assertTrue(res.equalsApprox(color.divide(2.0f, 4.0f, 3.0f)));
    }

    @Test
    public void testDivideByFourFloats() {
        var color = new Col3f(1.0f, 0.8f, 0.6f);
        var res = new Col4f(0.5f, 0.2f, 0.2f, 0.2f);
        Assert.assertTrue(res.equalsApprox(color.divide(2.0f, 4.0f, 3.0f, 5.0f)));
    }

    @Test
    public void testDivideTwoColors() {
        var c1 = new Col3f(1.0f, 0.8f, 0.6f);
        var c2 = new Col3f(2.0f, 4.0f, 3.0f);
        var res = new Col3f(0.5f, 0.2f, 0.2f);
        Assert.assertTrue(res.equalsApprox(c1.divide(c2)));
    }

    @Test
    public void testDivideTwoColorsOfDifferentTypes() {
        var c1 = new Col3f(1.0f, 0.8f, 0.6f);
        var c2 = new Col4f(0.5f, 0.2f, 0.25f, 1.0f);
        var res = new Col4f(2.0f, 4.0f, 2.4f, 1.0f);
        Assert.assertTrue(res.equalsApprox(c1.divide(c2)));
    }

    @Test
    public void testDivideColorByAFloat() {
        var color = new Col3f(0.2f, 0.4f, 0.6f);
        var res = new Col3f(0.1f, 0.2f, 0.3f);
        Assert.assertTrue(res.equalsApprox(color.divide(2.0f)));
    }

    @Test
    public void testEqualsApproxThreeFloats() {
        var color = new Col3f(0.9999999f, 0.4999999f, 0.7500001f);
        Assert.assertTrue(color.equalsApprox(1.0f, 0.5f, 0.75f));
    }

    @Test
    public void testEqualsApproxFourFloats() {
        var color = new Col3f(0.9999999f, 0.4999999f, 0.7500001f);
        Assert.assertTrue(color.equalsApprox(1.0f, 0.5f, 0.75f, 1.0000001f));
    }

    @Test
    public void testColorEqualsApprox() {
        var c1 = new Col3f(0.9999999f, 0.4999999f, 0.7500001f);
        var c2 = new Col3f(1.0f, 0.5f, 0.75f);
        Assert.assertTrue(c1.equalsApprox(c2));
    }

    @Test
    public void testEqualsApproxRGBA() {
        var color = new Col3f(0.372549f, 0.619608f, 0.627451f);
        Assert.assertTrue(color.equalsApprox(0x5f9ea0ff));
    }
}
