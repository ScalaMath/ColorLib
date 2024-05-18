package io.github.scalamath.colorlib

import io.github.scalamath

import scala.collection.immutable.TreeMap

class Gradient private(private val points: TreeMap[Float, Color]) {

  def this() = this(new TreeMap())

  def addPoint(color: Color, offset: Float): Gradient = new Gradient(this.points.updated(offset, color))

  def addPoint(offset: Float, color: Color): Gradient = this.addPoint(color, offset)

  def +(color: Color, offset: Float): Gradient = this.addPoint(color, offset)

  def +(offset: Float, color: Color): Gradient = this + (color, offset)

  def pointCount: Int = this.points.size

  def sample(offset: Float): Color = {
    if(this.points.isEmpty) {
      Col3f(0.0f, 0.0f, 0.0f)
    } else if(this.points.contains(offset)) {
      this.points(offset)
    } else {
      val (offset1, col1) = this.points.maxBefore(offset).getOrElse((0.0f, this.points(this.points.firstKey)))
      val (offset2, col2) = this.points.minAfter(offset).getOrElse((1.0f, this.points(this.points.lastKey)))
      col1.lerp(col2, scalamath.map(offset, offset1, offset2, 0.0f, 1.0f))
    }
  }
}

object Gradient {

  def apply(): Gradient = new Gradient()

  def apply(points: (Float, Color)*): Gradient = new Gradient(TreeMap.from(points))

  def between(col1: Color, col2: Color): Gradient = this.apply(0.0f -> col1, 1.0f -> col2)
}