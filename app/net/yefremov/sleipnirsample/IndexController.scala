package net.yefremov.sleipnirsample

import play.api.mvc._

/**
 * Controller for the index page.
 */
object IndexController extends Controller {

  def index = Action {
    Ok("Welcome to the Sleipnir sample app!")
  }

}
