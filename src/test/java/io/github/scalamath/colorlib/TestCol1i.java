package io.github.scalamath.colorlib;

import org.junit.Assert;
import org.junit.Test;

public class TestCol1i {

    @Test
    public void testAddFourFloats() {
        var color = new Col1i(0.3f, 0.4f, 0.5f, 0.6f);
        var res = new Col1i(0.4f, 0.6f, 0.8f, 1.0f);
        this.assertEqualsApprox(res, color.add(0.1f, 0.2f, 0.3f, 0.4f));
    }

    @Test
    public void testAddThreeFloats() {
        var color = new Col1i(0.3f, 0.4f, 0.5f, 0.8f);
        var res = new Col1i(0.4f, 0.6f, 0.8f, 0.8f);
        this.assertEqualsApprox(res, color.add(0.1f, 0.2f, 0.3f));
    }

    @Test
    public void testAddTwoColors() {
        var c1 = new Col1i(0.3f, 0.4f, 0.5f, 0.6f);
        var c2 = new Col1i(0.1f, 0.2f, 0.3f, 0.4f);
        var res = new Col1i(0.4f, 0.6f, 0.8f, 1.0f);
        this.assertEqualsApprox(res, c1.add(c2));
    }

    @Test
    public void testAddTwoColorsOfDifferentTypes() {
        var c1 = new Col1i(0.3f, 0.4f, 0.5f, 0.6f);
        var c2 = new Col4f(0.1f, 0.2f, 0.3f, 0.4f);
        var res = new Col4f(0.4f, 0.6f, 0.8f, 1.0f);
        this.assertEqualsApprox(res, c1.add(c2));
    }

    @Test
    public void testSubtractFourFloats() {
        var color = new Col1i(0.4f, 0.6f, 0.8f, 1.0f);
        var res = new Col1i(0.3f, 0.4f, 0.5f, 0.6f);
        this.assertEqualsApprox(res, color.subtract(0.1f, 0.2f, 0.3f, 0.4f));
    }

    @Test
    public void testSubtractThreeFloats() {
        var color = new Col1i(0.4f, 0.6f, 0.8f, 1.0f);
        var res = new Col1i(0.3f, 0.4f, 0.5f, 1.0f);
        this.assertEqualsApprox(res, color.subtract(0.1f, 0.2f, 0.3f));
    }

    @Test
    public void testSubtractTwoColors() {
        var c1 = new Col1i(0.4f, 0.6f, 0.8f, 1.0f);
        var c2 = new Col1i(0.3f, 0.4f, 0.5f, 0.6f);
        var res = new Col1i(0.1f, 0.2f, 0.3f, 0.4f);
        this.assertEqualsApprox(res, c1.subtract(c2));
    }

    @Test
    public void testSubtractTwoColorsOfDifferentTypes() {
        var c1 = new Col1i(0.4f, 0.6f, 0.8f, 1.0f);
        var c2 = new Col4f(0.3f, 0.4f, 0.5f, 0.6f);
        var res = new Col4f(0.1f, 0.2f, 0.3f, 0.4f);
        this.assertEqualsApprox(res, c1.subtract(c2));
    }

    @Test
    public void testMultiplyWithFourFloats() {
        var color = new Col1i(0.2f, 0.3f, 0.4f, 0.5f);
        var res = new Col1i(0.4f, 0.9f, 0.6f, 1.0f);
        this.assertEqualsApprox(res, color.multiply(2.0f, 3.0f, 1.5f, 2.0f));
    }

    @Test
    public void testMultiplyWithThreeFloats() {
        var color = new Col1i(0.2f, 0.3f, 0.4f, 1.0f);
        var res = new Col1i(0.4f, 0.9f, 0.6f);
        this.assertEqualsApprox(res, color.multiply(2.0f, 3.0f, 1.5f));
    }

    @Test
    public void testMultiplyTwoColors() {
        var c1 = new Col1i(0.5f, 0.4f, 0.6f, 1.0f);
        var c2 = new Col1i(0.2f, 0.4f, 0.6f, 1.0f);
        var res = new Col1i(0.1f, 0.16f, 0.36f, 1.0f);
        this.assertEqualsApprox(res, c1.multiply(c2));
    }

    @Test
    public void testMultiplyTwoColorsOfDifferentTypes() {
        var c1 = new Col1i(0.5f, 0.4f, 0.6f, 1.0f);
        var c2 = new Col4f(0.2f, 0.4f, 0.6f, 1.0f);
        var res = new Col4f(0.1f, 0.16f, 0.36f, 1.0f);
        this.assertEqualsApprox(res, c1.multiply(c2));
    }

    @Test
    public void testMultiplyWithAFloat() {
        var color = new Col1i(0.2f, 0.4f, 0.6f, 1.0f);
        var res = new Col1i(0.3f, 0.6f, 0.9f, 1.0f);
        this.assertEqualsApprox(res, color.multiply(1.5f));
    }

    @Test
    public void testDivideByFourFloats() {
        var color = new Col1i(1.0f, 0.8f, 0.6f, 1.0f);
        var res = new Col1i(0.5f, 0.2f, 0.2f, 0.2f);
        this.assertEqualsApprox(res, color.divide(2.0f, 4.0f, 3.0f, 5.0f));
    }

    @Test
    public void testDivideByThreeFloats() {
        var color = new Col1i(1.0f, 0.8f, 0.6f, 1.0f);
        var res = new Col1i(0.5f, 0.2f, 0.2f, 1.0f);
        this.assertEqualsApprox(res, color.divide(2.0f, 4.0f, 3.0f));
    }

    @Test
    public void testDivideTwoColors() {
        var c1 = new Col1i(0.1f, 0.2f, 0.1f, 0.4f);
        var c2 = new Col1i(0.2f, 0.2f, 0.25f, 0.5f);
        var res = new Col1i(0.5f, 1.0f, 0.4f, 0.8f);
        this.assertEqualsApprox(res, c1.divide(c2));
    }

    @Test
    public void testDivideTwoColorsOfDifferentTypes() {
        var c1 = new Col1i(0.1f, 0.2f, 0.1f, 0.4f);
        var c2 = new Col4f(0.2f, 0.2f, 0.25f, 0.5f);
        var res = new Col4f(0.5f, 1.0f, 0.4f, 0.8f);
        this.assertEqualsApprox(res, c1.divide(c2));
    }

    @Test
    public void testDivideColorByAFloat() {
        var color = new Col1i(1.0f, 0.8f, 0.6f, 0.4f);
        var res = new Col1i(0.5f, 0.4f, 0.3f, 0.2f);
        this.assertEqualsApprox(res, color.divide(2.0f));
    }

    private void assertEqualsApprox(Color expected, Color res) {
        Assert.assertTrue(Math.abs(expected.r() - res.r()) < 0.01f);
        Assert.assertTrue(Math.abs(expected.g() - res.g()) < 0.01f);
        Assert.assertTrue(Math.abs(expected.b() - res.b()) < 0.01f);
        Assert.assertTrue(Math.abs(expected.a() - res.a()) < 0.01f);
    }
}
