package $name$

import java.io.File

case class Config(files: List[File] = Nil, ignoreCase: Boolean = false)

object $name$ extends App {
  val parser = new scopt.OptionParser[Config]("$name$") {
    head(BuildInfo.name, BuildInfo.version)

    arg[File]("file...")
      .unbounded()
      .optional()
      .action((x, c) => c.copy(files = x :: c.files))
      .text("input files, reads STDIN if non are given")
      .validate(x =>
        if (x.exists) {
          success
        } else {
          failure(s"input file \$x does not exist")
      })

    note("""|
            |note text
            |
            |options:
            |""".stripMargin)

    opt[Unit]('i', "ignore-case")
      .action((x, c) => c.copy(ignoreCase = true))
      .text("ignore case")

    note("\nother options:\n")

    help("help").text("prints this usage text")

    version("version")

    note("")
  }

  parser.parse(args, Config()) match {
    case Some(config) =>
      println(config)

    case None =>
  }

}
