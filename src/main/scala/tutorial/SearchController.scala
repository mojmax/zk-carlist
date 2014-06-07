package tutorial

import org.zkoss.zk.ui.Component
import org.zkoss.zk.ui.select.SelectorComposer
import org.zkoss.zk.ui.select.annotation.{Wire, Listen}
import org.zkoss.zul._
import org.zkoss.zul.ext.Selectable
import collection.JavaConverters._

// omit import for brevity
class SearchController extends SelectorComposer[Component] {
  @Wire
  private val keywordBox: Textbox = null
  @Wire
  private val carListbox: Listbox = null
  @Wire
  private val modelLabel: Label = null
  @Wire
  private val makeLabel: Label = null
  @Wire
  private val priceLabel: Label = null
  @Wire
  private val descriptionLabel: Label = null
  @Wire
  private val previewImage: Image = null

  private val carService = new CarServiceImpl

  @Listen("onSelect = #carListbox")
  def showDetail(): Unit = {
    val selection = carListbox.getModel.asInstanceOf[Selectable[Car]].getSelection
    if (selection != null && !selection.isEmpty) {
      val selected: Car = selection.iterator().next()
      previewImage.setSrc(selected.preview)
      modelLabel.setValue(selected.model)
      makeLabel.setValue(selected.make)
      priceLabel.setValue(selected.price.toString)
      descriptionLabel.setValue(selected.description)
    }
  }

  @Listen("onClick = #searchButton")
  def search() = {
    val keyword = keywordBox.getValue
    val result: Seq[Car] = carService.search(keyword)
    carListbox.setModel(new ListModelList[Car](result.asJava))
  }
}
