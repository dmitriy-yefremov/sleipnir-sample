package net.yefremov.sleipnirsample

import scala.net.yefremov.sleipnirsample.Item

trait ItemsService {

  def getItem(id: Long) = Item(id = 1, name = "banana")

}
