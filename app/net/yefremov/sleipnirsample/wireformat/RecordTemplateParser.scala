package net.yefremov.sleipnirsample.wireformat

import com.linkedin.data.DataMap
import com.linkedin.data.template.{DataTemplateUtil, JacksonDataTemplateCodec, RecordTemplate}
import play.api.libs.concurrent.Execution.Implicits._
import play.api.libs.iteratee.{Done, Iteratee, Traversable}
import play.api.mvc.Results._
import play.api.mvc.{BodyParser, BodyParsers, RequestHeader, Result}

import scala.reflect.ClassTag

/**
 * A body parser for instances of [[RecordTemplate]].
 */
class RecordTemplateParser[A <: RecordTemplate : ClassTag](maxBodySize: Int = BodyParsers.parse.DEFAULT_MAX_TEXT_LENGTH) extends BodyParser[A] {

  private def toRecord(dataMap: DataMap): A = {
    val clazz = implicitly[ClassTag[A]].runtimeClass.asInstanceOf[Class[A]]
    DataTemplateUtil.wrap(dataMap, clazz)
  }

  def apply(requestHeader: RequestHeader): Iteratee[Array[Byte], Either[Result, A]] = {
    Traversable.takeUpTo[Array[Byte]](maxBodySize)
      .transform(Iteratee.consume[Array[Byte]]().map(RecordTemplateParser.codec.bytesToMap _ andThen toRecord))
      .flatMap(Iteratee.eofOrElse(EntityTooLarge))
      .flatMap {
        case data@Left(_) => Done(data)
        case data@Right(_) => Done(data)
      }
  }

}

object RecordTemplateParser {

  private val codec = new JacksonDataTemplateCodec()

}
