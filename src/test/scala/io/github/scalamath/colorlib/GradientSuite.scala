package io.github.scalamath.colorlib

import org.scalatest.funsuite.AnyFunSuite

class GradientSuite extends AnyFunSuite {

  test("Thing") {
    val gradient = Gradient(
      0.0f -> Col3f(1.0f, 0.0f, 0.0f),
      0.5f -> Col3f(0.0f, 1.0f, 0.0f)
    )
    println(gradient.sample(0.5f))
    println(gradient.sample(0.25f))
    println(gradient.sample(0.1f))
    println(gradient.sample(0.75f))
    println(gradient.sample(1.0f))
  }
}
