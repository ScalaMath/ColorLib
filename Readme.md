
# ColorLib

A Scala library for color math.

## Project goals

ColorLib is an extension of [VecMatLib](https://github.com/HexagonNico/VecMatLib) for color math, since colors can be seen as 3D or 4D vectors whose components are the *r*, *g*, *b*, and *alpha* components of the color.

Color classes are written in Scala to make the best use possible of Scala's operator overloading.
All methods with symbolic names have an alias for better interoperability with java.

All operations in ColorLib are designed to **not** modify the object on which the operation is invoked to respect the principles of purity and immutability of functional programming.

## Representation of colors

ColorLib offers 3 different representation of colors:

* The `Col3f` class represents a color using three single-precision floating point numbers, representing the color's *r*, *g*, and *b* components in a range between `0.0` and `1.0`.
* The `Col4f` class represents a color using four single-precision floating point numbers, representing the color's *r*, *g*, *b*, and *alpha* components in a range between `0.0` and `1.0`.
* The `Col1i` class represents a color using a single 4-bits integer.

The `Col3f` and `Col4f` also allow values outside the `[0.0, 1.0]` range.
This representation matches the one used in the [OpenGL Shading Language](https://www.khronos.org/opengl/wiki/Data_Type_(GLSL)).

The `Col1i` class only allows values in the `[0, 255]` range.
Values outside of this range are clamped.
This representation uses significantly less memory than the other two.

```scala
val white = Col3f(1.0f, 1.0f, 1.0f)
val cadetBlue = Col3f(0.372549f, 0.619608f, 0.627451f)
val orangeRed = Col3f(1.0f, 0.270588f, 0.0f)
val springGreen = Col3f(0.0f, 1.0f, 0.498039f)
val transparent = Col4f(1.0f, 1.0f, 1.0f, 0.0f)
```

When writing a function that accepts a color, it is best to use the `Color` trait.
This allows to use any representation of the color.

```scala
def function(color: Color): Unit = {
  println(color.r)
  println(color.g)
  println(color.b)
}

val color = Col4f(0.5f, 1.0f, 0.7f)
function(color) // Prints 0.5, 1.0, 0.7
```

Colors can also be created from their hex value.

```scala
val white = Col1i(0xffffffff) // Uses the RGBA format
val red = Col3f(0xff0000) // Uses the RGB format
val purple = Col3f(0xff00ff) // Equivalent to (1.0f, 0.0f, 1.0f)
val transparentGreen = Col4f(0x00ff0080) // Equivalent to (0.0f, 1.0f, 0.0f, 0.5f)
```

## Using with LWJGL

ColorLib can be used together with [LWJGL](https://lwjgl.org) to load colors into shaders.

This example loads a color made of three floats into the active shader program.

```Java
public void loadUniform(String name, Color color) {
    int location = GL20.glGetUniformLocation(program, name);
    GL20.glUniform3f(location, color.r(), color.g(), color.b());
}
```

Notice how the `Color` trait is used.

## Multithreading

Due to ColorLib not using any internal or temporal objects during any computations, neither modifying objects on which operations are called, it can be used safely in a multithreaded application.

## Add ColorLib to your project

### sbt

```
libraryDependencies += "io.github.scalamath" % "colorlib" % "1.0"
```

### Maven

```
<dependency>
    <groupId>io.github.scalamath</groupId>
    <artifactId>colorlib</artifactId>
    <version>1.0</version>
</dependency>
```

### Gradle

```
implementation 'io.github.scalamath:colorlib:1.0'
```

## Questions and answers

**Q**: Why does ColorLib not use scala 3?

**A**: One of the design goals of ColorLib is to be usable both in Scala and Java. Support for Scala 3 in IDEs is still actively being developed, therefore a Scala 3 library may not be suitable to work with.

**Q**: Why is color math not included in [VecMatLib](https://github.com/HexagonNico/VecMatLib)?

**A**: Color math used to be a part of VecMatLib, although there may be applications where colors not necessary, therefore in that case one can depend on VecMatLib without having to include an unnecessary dependency for colors.

## Contributing

ColorLib was developed by a single person as an extension of [VecMatLib](https://github.com/HexagonNico/VecMatLib).

Your contributions are always welcome! Please submit a pull request or open an issue if you want to contribute with bug
fixes, code improvements, documentation, and better unit test coverage.

## Support

Support the project with a donation:

* [PayPal](https://paypal.me/hexagonnico)
* [Ko-fi](https://ko-fi.com/HexagonNico)