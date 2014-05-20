package com.loyal3.admin.ui

import org.zkoss.bind.annotation.{NotifyChange, Command, Init}
import scala.beans.BeanProperty

/**
 * @author Kenji Nakamura
 */
class ScalaViewModel {

  @BeanProperty
  var count:Int = 0

  @Init
  def init() {
    count = 999
  }

  @Command
  @NotifyChange(Array("count"))
  def cmd() {
    count = count + 1
  }
}
