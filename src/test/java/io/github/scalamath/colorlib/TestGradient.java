package io.github.scalamath.colorlib;

import org.junit.Test;

public class TestGradient {

    @Test
    public void testGradient() {
        var gradient = new Gradient()
            .addPoint(new Col3f(1.0f, 0.0f, 0.0f), 0.0f)
            .addPoint(new Col3f(0.0f, 1.0f, 0.0f), 1.0f);
        System.out.println(gradient.sample(0.5f));
    }
}
