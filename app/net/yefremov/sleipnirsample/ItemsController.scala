package net.yefremov.sleipnirsample

import net.yefremov.sleipnirsample.wireformat.{RestliWireFormat, WireFormat}
import play.api.mvc.{Request, EssentialAction, Action}
import play.api.mvc.Results._
import play.mvc.Controller

import scala.net.yefremov.sleipnirsample.Item

/**
 * Controller for items resource.
 */
trait ItemsController extends Controller {
  self: ItemsService with WireFormat =>

  // curl -X POST -d '{ "id": 1, "name": "apple" }' http://localhost:9000/items
  def create(): EssentialAction = Action(recordTemplateParser[Item]) { request: Request[Item] =>
    createItem(request.body)
    Created
  }

  // curl http://localhost:9000/items/1
  def get(id: Long): EssentialAction = Action {
    getItem(id).map(Ok(_)).getOrElse(NotFound)
  }
}

object ItemsController extends ItemsController with ItemsService with RestliWireFormat
