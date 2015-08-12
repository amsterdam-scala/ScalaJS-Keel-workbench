package example

import org.scalajs.dom
import org.scalajs.dom.html
import org.scalajs.dom.raw.Element

import scala.scalajs.js.JSApp
import scala.scalajs.js.annotation.JSExport
import scalatags.JsDom.all._
import scalatags.stylesheet.{Sheet, StyleSheet}

@JSExport
object ScalaJSExample extends JSApp { // JSApp is optional to satisfy sbt run

  val exampleStyle = Sheet[exampleStyle]
  trait exampleStyle extends StyleSheet {
    def highlighted = cls(color := "green", fontWeight := "bold")

    def fade = cls.hover(opacity := 0.3)

    def glitter = cls.hover(backgroundColor := "pink")
  }

  val myStyle = dom.document.createElement("style")
  myStyle.textContent = exampleStyle.styleSheetText
  dom.document.head.appendChild(myStyle)

  @JSExport
  def showDetail(document: html.BlockElement) {
    import exampleStyle._

    val myInput = input().render
    val myOutput = div().render

    def stations = List(
      "Vila Madalena",
      "Paraíso",
      "Ana Rosa",
      "Consolação",
      "Trianon",
      "Brás",
      "Luz",
      "Brigadeiro",
      "Tatuapé",
      "Belém"
    )

    val stationsUl = dom.document.createElement("stations")
    stationsUl.innerHTML = highLighter("", stations).innerHTML

    def highLighter (searchText: String, list : List[String]): Element = {
      val buffer = dom.document.createElement("buffer")

      list.filter(_.toLowerCase.contains(searchText)).foreach { station =>
        val indexOf = station.toLowerCase indexOf searchText

        val (startOfText, foundText, endOfText) = (station.take(indexOf)
          , station.slice(indexOf, indexOf + searchText.length)
          , station.drop(indexOf + searchText.length))

        buffer.appendChild(li(fade, startOfText, span(highlighted, foundText), endOfText).render)
      }
      buffer
    }

    myInput.onkeyup = (e: dom.Event) => {
      myOutput.innerHTML = myInput.value
      stationsUl.innerHTML = highLighter( myInput.value.toLowerCase, stations).innerHTML
    }

    document.innerHTML = h1(exampleStyle.glitter, s"Olá, TDC! ${"\\o/" * 3}").render.outerHTML
    document.appendChild(myInput)
    document.appendChild(myOutput)
    document.appendChild(stationsUl)
  }

  def main() { // Optional to satisfy sbt run
    val className = this.getClass.getName.init
    val l = className.length()
    println(("-" * 50).patch((50 - l) / 2, className, l))
  }
}
