package io.github.scalamath.colorlib

import scala.collection.immutable.TreeMap

/**
 * Represents a color transition.
 *
 * Created from a set of points made of a color and an offset.
 * A color can be sampled from the gradient and the result will be an interpolation between the colors of the gradient.
 *
 * The offsets are usually numbers between `0.0` and `1.0`, but other values are also allowed.
 *
 * @example {{{
 *            // Scala
 *            val gradient = Gradient(
 *              0.0f -> Col4f(1.0f, 0.0f, 0.0f), // Red
 *              0.5f -> Col4f(1.0f, 1.0f, 0.0f), // Yellow
 *              1.0f -> Col4f(0.0f, 1.0f, 0.0f) // Green
 *            )
 *            // Java
 *            Gradient gradient = new Gradient()
 *              .addPoint(0.0f, new Col4f(1.0f, 0.0f, 0.0f))
 *              .addPoint(0.5f, new Col4f(1.0f, 1.0f, 0.0f))
 *              .addPoint(1.0f, new Col4f(0.0f, 1.0f, 0.0f));
 * }}}
 *
 * @param points Points in the gradient.
 * @see [[sample]]
 */
class Gradient private(private val points: TreeMap[Float, Color]) {

  /**
   * Creates an empty gradient.
   */
  def this() = this(new TreeMap())

  /**
   * Creates a new gradient obtained by updating this one with the given color and offset.
   *
   * @param color The color to add to the gradient.
   * @param offset The offset of the color.
   * @return The new gradient.
   */
  def addPoint(color: Color, offset: Float): Gradient = new Gradient(this.points.updated(offset, color))

  /**
   * Creates a new gradient obtained by updating this one with the given color and offset.
   *
   * @param offset The offset of the color.
   * @param color The color to add to the gradient.
   * @return The new gradient.
   */
  def addPoint(offset: Float, color: Color): Gradient = this.addPoint(color, offset)

  /**
   * Creates a new gradient obtained by updating this one with the given color and offset.
   *
   * This method is an alias for `addPoint`.
   *
   * @param color The color to add to the gradient.
   * @param offset The offset of the color.
   * @return The new gradient.
   */
  def +(color: Color, offset: Float): Gradient = this.addPoint(color, offset)

  /**
   * Creates a new gradient obtained by updating this one with the given color and offset.
   *
   * This method is an alias for `addPoint`.
   *
   * @param offset The offset of the color.
   * @param color The color to add to the gradient.
   * @return The new gradient.
   */
  def +(offset: Float, color: Color): Gradient = this + (color, offset)

  /**
   * Returns the number of points in the gradient.
   * Each pair of color and offset is a point.
   *
   * @return The number of colors in the gradient.
   */
  def pointCount: Int = this.points.size

  /**
   * Returns the interpolated color specified by the given offset.
   * Colors are interpolated linearly.
   *
   * Returns black if this gradient does not have any points.
   *
   * Returns the first color in the gradient if the given offset is lower than the offset of the first point.
   * Returns the last color in the gradient if the given offset is higher than the offset of the last point.
   *
   * @param offset The offset of the color.
   * @return The result of linearly interpolating the color of this gradient at the given offset.
   */
  def sample(offset: Float): Color = {
    if(this.points.isEmpty) {
      Col3f(0.0f, 0.0f, 0.0f)
    } else if(this.points.contains(offset)) {
      this.points(offset)
    } else if(offset < this.points.firstKey) {
      this.points(this.points.firstKey)
    } else if(offset > this.points.lastKey) {
      this.points(this.points.lastKey)
    } else {
      val (offset1, col1) = this.points.maxBefore(offset).get
      val (offset2, col2) = this.points.minAfter(offset).get
      col1.lerp(col2, (offset - offset1) / (offset2 - offset1))
    }
  }

  /**
   * Returns the color of the gradient at the given offset.
   * Can also be used to interpolate colors using a constant interpolation.
   *
   * @param offset The offset of the color.
   * @return The color at the given offset.
   */
  def getColor(offset: Float): Color = {
    if(this.points.contains(offset)) {
      this.points(offset)
    } else {
      this.points.maxBefore(offset).map(entry => entry._2).getOrElse(this.points(this.points.firstKey))
    }
  }

  /**
   * Creates a new gradient obtained by removing the color at the given offset from this gradient.
   *
   * @param offset The offset of the color.
   * @return The new gradient.
   */
  def removePoint(offset: Float): Gradient = new Gradient(this.points.removed(offset))

  /**
   * Creates a new gradient obtained by removing the color at the given offset from this gradient.
   *
   * This method is an alias for `removePoint`.
   *
   * @param offset The offset of the color.
   * @return The new gradient.
   */
  def -(offset: Float): Gradient = this.removePoint(offset)

  override def equals(obj: Any): Boolean = obj match {
    case gradient: Gradient => this.points.equals(gradient.points)
    case _ => super.equals(obj)
  }

  override def hashCode(): Int = 31 + this.points.hashCode()
}

/**
 * Factory methods for gradients.
 */
object Gradient {

  /**
   * Creates an empty gradient.
   *
   * Allows to construct a gradient without using the `new` keyword in Scala.
   *
   * @return The newly instantiated gradient.
   */
  def apply(): Gradient = new Gradient()

  /**
   * Creates a gradient from the given points.
   * Every point is a pair made of an offset and a color.
   *
   * @example {{{
   *            val gradient = Gradient(
   *              0.0f -> Col4f(1.0f, 0.0f, 0.0f),
   *              0.5f -> Col4f(1.0f, 1.0f, 0.0f),
   *              1.0f -> Col4f(0.0f, 1.0f, 0.0f)
   *            )
   * }}}
   *
   * @param points The points that make up the gradient.
   * @return The newly instantiated gradient.
   */
  def apply(points: (Float, Color)*): Gradient = new Gradient(TreeMap.from(points))

  /**
   * Creates a gradient with only two points, with the two given colors.
   * The two given colors will have offsets of `0.0` and `1.0`.
   *
   * @param col1 The color with offset `0.0`.
   * @param col2 The color with offset `1.0`.
   * @return The newly instantiated gradient.
   */
  def between(col1: Color, col2: Color): Gradient = this.apply(0.0f -> col1, 1.0f -> col2)
}