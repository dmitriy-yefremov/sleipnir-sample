package net.yefremov.sleipnirsample

import scala.net.yefremov.sleipnirsample.Item
import scala.collection._

/**
 * Service that stores and retrieves items.
 */
trait ItemsService {

  private val store = mutable.Map(1L -> Item(1L, "banana"), 2L -> Item(2L, "apple"))

  def getItem(id: Long): Option[Item] = store.get(id)

  def createItem(item: Item): Unit = store.update(item.id, item)

  def getItems: Seq[Item] = store.values.toSeq

}
