package net.yefremov.sleipnirsample

import com.linkedin.data.template.{DataTemplate, JacksonDataTemplateCodec}
import play.api.http.{ContentTypes, Writeable}

trait RestliWireFormat extends WireFormat {

  private val codec = new JacksonDataTemplateCodec()

  implicit def dataTemplateWriteable: Writeable[DataTemplate[_]] = Writeable[DataTemplate[_]](
    transform = codec.dataTemplateToBytes(_: DataTemplate[_], false),
    contentType = Some(ContentTypes.JSON)
  )

}
