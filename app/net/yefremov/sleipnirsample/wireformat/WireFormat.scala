package net.yefremov.sleipnirsample.wireformat

import com.linkedin.data.template.{AbstractArrayTemplate, DataTemplate, RecordTemplate}
import play.api.http.Writeable
import play.api.mvc.BodyParser

import scala.reflect.ClassTag

/**
 * Wire format abstraction. Provides both BodyParsers to parse the request body to a DataTemplate,
 * and response formatters to serialize a DataTemplate to JSON.
 */
trait WireFormat {

  implicit def dataTemplateWriteable: Writeable[DataTemplate[_]]

  def recordTemplateParser[T <: RecordTemplate : ClassTag]: BodyParser[T]

}
