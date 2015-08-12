branch: final
# Scala Barebone application 

This is a slightly less barebone example of an application written in [Scala.js](http://www.scala-js.org/). In particular,
it links in libraries that are indispensable in being productive working with Scala.js. Intended to laying down a keel or
as a starting point for further build. Already added is the [Haoyi's Workbench](https://github.com/lihaoyi/workbench) sbt
plug-in. It spins up a local Spray web server on (by default) localhost:12345, whenever you're in the SBT console.
Navigate to [localhost:12345](http://localhost:12345) in the browser and it'll show a simple page tell you it's alive. You can
access any file within your project directory by going to localhost:12345/path/to/file in a browser. The console of the
browser will mirror the sbt's spamlog.

This demo list a sequence of San Paulo's metro station with a search function. The matched stations are displayed
while the found (sub)strings are highlighted.

## Get started
To get started, run `sbt ~fastOptJS` in this example project. This should download dependencies and prepare the relevant
javascript files. If you open
[localhost:12345/target/scala-2.11/classes/index-dev.html](localhost:12345/target/scala-2.11/classes/index-dev.html) in
your browser, it will show the demo. You can then edit the application and see the updates be sent live to the browser
without needing to refresh the page.

## The optimized version
Run `sbt fullOptJS` and open up `index-opt.html` for an optimized (~200kb) version of the final application, useful for
final publication. The auto-deployment function of the `sbt ~fastOptJS` is in that page not incorporated.

## Main method
Run `sbt run` to execute the main method with [http://phantomjs.org/](PhantomJS) installed. Or run
`example.ScalaJSExample().main()` in the browser console.

## Other branches
The other branches autowire, dodge-the-dots, final, mapper, master, ray-tracer, space-invaders, todomvc are of an earlier
date and subject for updates.
License
-------
The MIT License (MIT)

Copyright (c) 2013 Li Haoyi, Copyright (c) 2015 F.W. van den Berg

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation
files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy,
modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the
Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR
OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.