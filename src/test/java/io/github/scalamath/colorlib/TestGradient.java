package io.github.scalamath.colorlib;

import org.junit.Assert;
import org.junit.Test;

public class TestGradient {

    @Test
    public void testAddPoint() {
        var g1 = new Gradient()
            .addPoint(new Col3f(1.0f, 0.0f, 0.0f), 0.0f)
            .addPoint(new Col3f(1.0f, 1.0f, 0.0f), 0.5f)
            .addPoint(new Col3f(0.0f, 1.0f, 0.0f), 1.0f);
        var g2 = new Gradient()
            .addPoint(new Col3f(1.0f, 0.0f, 0.0f), 0.0f)
            .addPoint(new Col3f(1.0f, 0.0f, 1.0f), 0.25f)
            .addPoint(new Col3f(1.0f, 1.0f, 0.0f), 0.5f)
            .addPoint(new Col3f(0.0f, 0.0f, 1.0f), 0.75f)
            .addPoint(new Col3f(0.0f, 1.0f, 0.0f), 1.0f);
        var res = g1
            .addPoint(new Col3f(0.0f, 0.0f, 1.0f), 0.75f)
            .addPoint(0.25f, new Col3f(1.0f, 0.0f, 1.0f));
        Assert.assertEquals(g2, res);
    }
}
