package tutorial

import scala.beans.BeanProperty

class Car(
  @BeanProperty var id: Int,
  @BeanProperty var model: String,
  @BeanProperty var make: String,
  @BeanProperty var preview: String,
  @BeanProperty var description: String,
  @BeanProperty var price: Int
  ) {
  override def equals(other: Any): Boolean = {
    other match {
      case o: Car =>
        id == o.id
      case _ => false
    }
  }

  override def hashCode(): Int = {
    val prime = 31
    val result = 1
    prime * result + Option(id).fold(0)(_.hashCode)
  }
}
