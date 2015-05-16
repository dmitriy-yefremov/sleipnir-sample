package net.yefremov.sleipnirsample

import play.api.mvc._

object Application extends Controller {

  def index = Action {
    Ok("Welcome to the Sleipnir sample app!")
  }

}
