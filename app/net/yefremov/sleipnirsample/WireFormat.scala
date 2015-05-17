package net.yefremov.sleipnirsample

import com.linkedin.data.template.DataTemplate
import play.api.http.Writeable

trait WireFormat {

  implicit def dataTemplateWriteable: Writeable[DataTemplate[_]]

}
