package net.yefremov.sleipnirsample

import play.api.mvc.{EssentialAction, Action}
import play.api.mvc.Results.Ok
import play.mvc.Controller

trait ItemsController extends Controller {
  self: ItemsService with WireFormat =>

  def get(id: Long): EssentialAction = Action {
    Ok(getItem(id))
  }

}

object ItemsController extends ItemsController with ItemsService with RestliWireFormat
