package io.github.scalamath.colorlib

import org.scalatest.funsuite.AnyFunSuite

class GradientSuite extends AnyFunSuite {

  test("Sample color from gradient") {
    val gradient = Gradient(
      0.0f -> Col3f(1.0f, 0.0f, 0.0f),
      0.5f -> Col3f(1.0f, 1.0f, 0.0f),
      1.0f -> Col3f(0.0f, 1.0f, 0.0f)
    )
    assert(gradient.sample(0.25f) == Col3f(1.0f, 0.5f, 0.0f))
    assert(gradient.sample(0.5f) == Col3f(1.0f, 1.0f, 0.0f))
    assert(gradient.sample(0.375f) == Col3f(1.0f, 0.75f, 0.0f))
    assert(gradient.sample(-0.1f) == Col3f(1.0f, 0.0f, 0.0f))
    assert(gradient.sample(0.75f) == Col3f(0.5f, 1.0f, 0.0f))
    assert(gradient.sample(0.625f) == Col3f(0.75f, 1.0f, 0.0f))
    assert(gradient.sample(1.0f) == Col3f(0.0f, 1.0f, 0.0f))
  }

  test("Add points to gradient") {
    val g1 = Gradient(
      0.0f -> Col3f(1.0f, 0.0f, 0.0f),
      0.5f -> Col3f(1.0f, 1.0f, 0.0f),
      1.0f -> Col3f(0.0f, 1.0f, 0.0f)
    )
    val g2 = Gradient(
      0.0f -> Col3f(1.0f, 0.0f, 0.0f),
      0.25f -> Col3f(1.0f, 0.0f, 1.0f),
      0.5f -> Col3f(1.0f, 1.0f, 0.0f),
      0.75f -> Col3f(0.0f, 0.0f, 1.0f),
      1.0f -> Col3f(0.0f, 1.0f, 0.0f)
    )
    val res = g1
      .addPoint(Col3f(0.0f, 0.0f, 1.0f), 0.75f)
      .addPoint(0.25f, Col3f(1.0f, 0.0f, 1.0f))
    assert(g2 == res)
  }

  test("Add points using the + operator") {
    val g1 = Gradient(
      0.0f -> Col3f(1.0f, 0.0f, 0.0f),
      0.5f -> Col3f(1.0f, 1.0f, 0.0f),
      1.0f -> Col3f(0.0f, 1.0f, 0.0f)
    )
    val g2 = Gradient(
      0.0f -> Col3f(1.0f, 0.0f, 0.0f),
      0.25f -> Col3f(1.0f, 0.0f, 1.0f),
      0.5f -> Col3f(1.0f, 1.0f, 0.0f),
      0.75f -> Col3f(0.0f, 0.0f, 1.0f),
      1.0f -> Col3f(0.0f, 1.0f, 0.0f)
    )
    val res = g1 + (Col3f(0.0f, 0.0f, 1.0f), 0.75f) + (0.25f, Col3f(1.0f, 0.0f, 1.0f))
    assert(g2 == res)
  }

  test("Get the number of points in a gradient") {
    val gradient = Gradient(
      0.0f -> Col3f(1.0f, 0.0f, 0.0f),
      1.0f / 6.0f -> Col3f(1.0f, 0.5f, 0.0f),
      2.0f / 6.0f -> Col3f(1.0f, 1.0f, 0.0f),
      3.0f / 6.0f -> Col3f(0.0f, 1.0f, 0.0f),
      4.0f / 6.0f -> Col3f(0.0f, 0.0f, 1.0f),
      5.0f / 6.0f -> Col3f(0.5f, 0.0f, 1.0f),
      1.0f -> Col3f(1.0f, 1.0f, 1.0f)
    )
    assert(gradient.pointCount == 7)
    assert(Gradient().pointCount == 0)
  }

  test("Get color without interpolating") {
    val gradient = Gradient(
      0.0f -> Col3f(1.0f, 0.0f, 0.0f),
      0.5f -> Col3f(1.0f, 1.0f, 0.0f),
      1.0f -> Col3f(0.0f, 1.0f, 0.0f)
    )
    assert(gradient.getColor(0.0f) == Col3f(1.0f, 0.0f, 0.0f))
    assert(gradient.getColor(0.25f) == Col3f(1.0f, 0.0f, 0.0f))
    assert(gradient.getColor(0.5f) == Col3f(1.0f, 1.0f, 0.0f))
    assert(gradient.getColor(0.75f) == Col3f(1.0f, 1.0f, 0.0f))
    assert(gradient.getColor(1.0f) == Col3f(0.0f, 1.0f, 0.0f))
    assert(gradient.getColor(1.2f) == Col3f(0.0f, 1.0f, 0.0f))
    assert(gradient.getColor(-0.2f) == Col3f(1.0f, 0.0f, 0.0f))
  }

  test("Remove points from gradient") {
    val g1 = Gradient(
      0.0f -> Col3f(1.0f, 0.0f, 0.0f),
      0.5f -> Col3f(1.0f, 1.0f, 0.0f),
      1.0f -> Col3f(0.0f, 1.0f, 0.0f)
    )
    val g2 = Gradient(
      0.0f -> Col3f(1.0f, 0.0f, 0.0f),
      0.25f -> Col3f(1.0f, 0.0f, 1.0f),
      0.5f -> Col3f(1.0f, 1.0f, 0.0f),
      0.75f -> Col3f(0.0f, 0.0f, 1.0f),
      1.0f -> Col3f(0.0f, 1.0f, 0.0f)
    )
    val res = g2.removePoint(0.25f).removePoint(0.75f)
    assert(g1 == res)
  }

  test("Remove points using the - operator") {
    val g1 = Gradient(
      0.0f -> Col3f(1.0f, 0.0f, 0.0f),
      0.5f -> Col3f(1.0f, 1.0f, 0.0f),
      1.0f -> Col3f(0.0f, 1.0f, 0.0f)
    )
    val g2 = Gradient(
      0.0f -> Col3f(1.0f, 0.0f, 0.0f),
      0.25f -> Col3f(1.0f, 0.0f, 1.0f),
      0.5f -> Col3f(1.0f, 1.0f, 0.0f),
      0.75f -> Col3f(0.0f, 0.0f, 1.0f),
      1.0f -> Col3f(0.0f, 1.0f, 0.0f)
    )
    val res = g2 - 0.25f - 0.75f
    assert(g1 == res)
  }

  test("Create gradient between two colors") {
    val g1 = Gradient(0.0f -> Col3f(1.0f, 0.0f, 0.0f), 1.0f -> Col3f(0.0f, 1.0f, 0.0f))
    val g2 = Gradient.between(Col3f(1.0f, 0.0f, 0.0f), Col3f(0.0f, 1.0f, 0.0f))
    assert(g1 == g2)
  }
}
