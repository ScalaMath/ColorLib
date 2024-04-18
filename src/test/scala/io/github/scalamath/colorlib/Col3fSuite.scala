package io.github.scalamath.colorlib

import io.github.scalamath
import org.scalactic.{Equality, TolerantNumerics}
import org.scalatest.funsuite.AnyFunSuite

class Col3fSuite extends AnyFunSuite {
  
  implicit val floatEquality: Equality[Float] = TolerantNumerics.tolerantFloatEquality(scalamath.Epsilon.toFloat)

  implicit val colorEquality: Equality[Color] = (a: Color, b: Any) => b match {
    case b: Color => a.getClass == b.getClass && (a.r - b.r).abs < 0.01f && (a.g - b.g).abs < 0.01f && (a.b - b.b).abs < 0.01f && (a.a - b.a).abs < 0.01f
    case _ => false
  }

  test("Create color from rgb floats and retrieve the values") {
    val color = Col3f(0.372549f, 0.619608f, 0.627451f)
    assert(color.r === 0.372549f)
    assert(color.g === 0.619608f)
    assert(color.b === 0.627451f)
    assert(color.a === 1.0f)
  }

  test("Create color from rgb integers and retrieve the values") {
    val color = Col3f(95, 158, 160)
    assert(color.r8 == 95)
    assert(color.g8 == 158)
    assert(color.b8 == 160)
    assert(color.a8 == 255)
  }

  test("Create color from HSV and retrieve the values") {
    val color = Col3f.hsv(0.5f, 0.41f, 0.63f)
    assert(color.h === 0.5f)
    assert(color.s === 0.41f)
    assert(color.v === 0.63f)
  }

  test("Create color from rgb hex and retrieve the rgba value") {
    val color = Col3f(0x5f9ea0)
    assert(color.rgba == 0x5f9ea0ff)
  }

  test("Create color from rgb hex and retrieve the argb value") {
    val color = Col3f(0x5f9ea0)
    assert(color.argb == 0xff5f9ea0)
  }

  test("Add three floats to a color") {
    val color = Col3f(0.3f, 0.4f, 0.5f)
    val res = Col3f(0.4f, 0.6f, 0.8f)
    assert(color + (0.1f, 0.2f, 0.3f) === res)
  }

  test("Add four floats to a color") {
    val color = Col3f(0.3f, 0.4f, 0.5f)
    val res = Col4f(0.4f, 0.6f, 0.8f, 1.4f)
    assert(color + (0.1f, 0.2f, 0.3f, 0.4f) === res)
  }

  test("Sum of two colors") {
    val c1 = Col3f(0.3f, 0.4f, 0.5f)
    val c2 = Col3f(0.1f, 0.2f, 0.3f)
    val res = Col3f(0.4f, 0.6f, 0.8f)
    assert(c1 + c2 === res)
  }

  test("Sum of two colors of different type") {
    val c1 = Col3f(0.3f, 0.4f, 0.5f)
    val c2 = Col4f(0.1f, 0.2f, 0.3f, 0.4f)
    val res = Col4f(0.4f, 0.6f, 0.8f, 1.4f)
    assert(c1 + c2 === res)
  }

  test("Subtract three floats from a color") {
    val color = Col3f(0.4f, 0.6f, 0.8f)
    val res = Col3f(0.3f, 0.4f, 0.5f)
    assert(color - (0.1f, 0.2f, 0.3f) === res)
  }

  test("Subtract four floats from a color") {
    val color = Col3f(0.4f, 0.6f, 0.8f)
    val res = Col4f(0.3f, 0.4f, 0.5f, 0.6f)
    assert(color - (0.1f, 0.2f, 0.3f, 0.4f) === res)
  }

  test("Subtract two colors") {
    val c1 = Col3f(0.4f, 0.6f, 0.8f)
    val c2 = Col3f(0.3f, 0.4f, 0.5f)
    val res = Col3f(0.1f, 0.2f, 0.3f)
    assert(c1 - c2 === res)
  }

  test("Subtract two colors of different types") {
    val c1 = Col3f(0.4f, 0.6f, 0.8f)
    val c2 = Col4f(0.3f, 0.4f, 0.5f, 0.6f)
    val res = Col4f(0.1f, 0.2f, 0.3f, 0.4f)
    assert(c1 - c2 === res)
  }

  test("Multiply a color with three floats") {
    val color = Col3f(0.2f, 0.3f, 0.4f)
    val res = Col3f(0.4f, 0.9f, 0.6f)
    assert(color * (2.0f, 3.0f, 1.5f) === res)
  }

  test("Multiply a color with four floats") {
    val color = Col3f(0.2f, 0.3f, 0.4f)
    val res = Col4f(0.4f, 0.9f, 0.6f, 0.8f)
    assert(color * (2.0f, 3.0f, 1.5f, 0.8f) === res)
  }

  test("Multiply two colors") {
    val c1 = Col3f(2.0f, 3.0f, 1.5f)
    val c2 = Col3f(0.2f, 0.3f, 0.4f)
    val res = Col3f(0.4f, 0.9f, 0.6f)
    assert(c1 * c2 === res)
  }

  test("Multiply two colors of different types") {
    val c1 = Col3f(2.0f, 3.0f, 1.5f)
    val c2 = Col4f(0.2f, 0.3f, 0.4f, 0.8f)
    val res = Col4f(0.4f, 0.9f, 0.6f, 0.8f)
    assert(c1 * c2 === res)
  }

  test("Multiply a color with a float") {
    val color = Col3f(0.2f, 0.4f, 0.6f)
    val res = Col3f(0.3f, 0.6f, 0.9f)
    assert(color * 1.5f === res)
  }

  test("Divide a color by three floats") {
    val color = Col3f(1.0f, 0.8f, 0.6f)
    val res = Col3f(0.5f, 0.2f, 0.2f)
    assert(color / (2.0f, 4.0f, 3.0f) === res)
  }

  test("Divide a color by four floats") {
    val color = Col3f(1.0f, 0.8f, 0.6f)
    val res = Col4f(0.5f, 0.2f, 0.2f, 0.2f)
    assert(color / (2.0f, 4.0f, 3.0f, 5.0f) === res)
  }

  test("Divide two colors") {
    val c1 = Col3f(1.0f, 0.8f, 0.6f)
    val c2 = Col3f(2.0f, 4.0f, 3.0f)
    val res = Col3f(0.5f, 0.2f, 0.2f)
    assert(c1 / c2 === res)
  }

  test("Divide two colors of different types") {
    val c1 = Col3f(1.0f, 0.8f, 0.6f)
    val c2 = Col4f(0.5f, 0.2f, 0.25f, 1.0f)
    val res = Col4f(2.0f, 4.0f, 2.4f, 1.0f)
    assert(c1 / c2 === res)
  }

  test("Divide a color by a float") {
    val color = Col3f(0.2f, 0.4f, 0.6f)
    val res = Col3f(0.1f, 0.2f, 0.3f)
    assert(color / 2.0f === res)
  }

  test("Blend two colors") {
    val c1 = Col3f(1.0f, 0.0f, 0.0f)
    val c2 = Col3f(1.0f, 1.0f, 0.0f)
    assert(c1.blend(c2) === c2)
  }

  test("Blend two colors of different type") {
    val c1 = Col3f(1.0f, 0.0f, 0.0f)
    val c2 = Col4f(1.0f, 1.0f, 0.0f, 0.5f)
    val res = Col4f(1.0f, 0.5f, 0.0f, 1.0f)
    assert(c1.blend(c2) === res)
  }

  test("Invert a color") {
    val color = Col3f(0.2f, 0.5f, 0.7f)
    val res = Col3f(0.8f, 0.5f, 0.3f)
    assert(color.inverted === res)
  }

  test("Color luminance") {
    val color = Col3f(0.372549f, 0.619608f, 0.627451f)
    val res = 0.2126f * 0.372549f + 0.7152f * 0.619608f + 0.0722f * 0.627451f
    assert(color.luminance === res)
  }

  test("Make a color darker") {
    val color = Col3f(0.372549f, 0.619608f, 0.627451f)
    assert(color.darker(0.1f).luminance < color.luminance)
  }

  test("Make a color lighter") {
    val color = Col3f(0.372549f, 0.619608f, 0.627451f)
    assert(color.lighter(0.1f).luminance > color.luminance)
  }

  test("Linear interpolation between two colors") {
    val c1 = Col3f(0.2f, 0.4f, 0.2f)
    val c2 = Col3f(0.4f, 0.8f, 0.6f)
    val res1 = Col3f(0.3f, 0.6f, 0.4f)
    val res2 = Col3f(0.25f, 0.5f, 0.3f)
    val res3 = Col3f(0.35f, 0.7f, 0.5f)
    assert(c1.lerp(c2, 0.5f) === res1)
    assert(c1.lerp(c2, 0.25f) === res2)
    assert(c1.lerp(c2, 0.75f) === res3)
  }

  test("Linear interpolation between two colors of different types") {
    val c1 = Col3f(0.2f, 0.4f, 0.2f)
    val c2 = Col4f(0.4f, 0.8f, 0.6f, 0.5f)
    val res1 = Col4f(0.3f, 0.6f, 0.4f, 0.75f)
    val res2 = Col4f(0.25f, 0.5f, 0.3f, 0.875f)
    val res3 = Col4f(0.35f, 0.7f, 0.5f, 0.625f)
    assert(c1.lerp(c2, 0.5f) === res1)
    assert(c1.lerp(c2, 0.25f) === res2)
    assert(c1.lerp(c2, 0.75f) === res3)
  }

  test("Color equals approx three floats") {
    val color = Col3f(0.9999999f, 0.4999999f, 0.7500001f)
    assert(color ~= (1.0f, 0.5f, 0.75f))
  }

  test("Color equals approx four floats") {
    val color = Col3f(0.9999999f, 0.4999999f, 0.7500001f)
    assert(color ~= (1.0f, 0.5f, 0.75f, 1.0000001f))
  }

  test("Color equals approx another color") {
    val c1 = Col3f(0.9999999f, 0.4999999f, 0.7500001f)
    val c2 = Col3f(1.0f, 0.5f, 0.75f)
    assert(c1 ~= c2)
  }

  test("Color equals approx rgba value") {
    val color = Col3f(0.372549f, 0.619608f, 0.627451f)
    assert(color ~= 0x5f9ea0ff)
  }
}
