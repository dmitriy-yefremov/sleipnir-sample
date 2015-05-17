package net.yefremov.sleipnirsample.wireformat

import com.linkedin.data.template.{DataTemplate, JacksonDataTemplateCodec, RecordTemplate}
import play.api.http.{ContentTypes, Writeable}

import scala.reflect.ClassTag

/**
 * Default restli wire formatter
 */
trait RestliWireFormat extends WireFormat {

  private val codec = new JacksonDataTemplateCodec()

  override implicit def dataTemplateWriteable: Writeable[DataTemplate[_]] = Writeable[DataTemplate[_]](
    transform = codec.dataTemplateToBytes(_: DataTemplate[_], false),
    contentType = Some(ContentTypes.JSON)
  )

  override def recordTemplateParser[T <: RecordTemplate : ClassTag]: RecordTemplateParser[T] =
    new RecordTemplateParser[T]()

}
