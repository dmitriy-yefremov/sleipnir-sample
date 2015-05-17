package net.yefremov.sleipnirsample

import scala.net.yefremov.sleipnirsample.Item
import scala.collection._

/**
 * Service that stores and retrieves items synchronously.
 */
trait ItemsService {

  private val store = mutable.Map.empty[Long, Item]

  def getItem(id: Long): Option[Item] = store.get(id)

  def createItem(item: Item): Unit = store.update(item.id, item)

}
