package tutorial

trait CarService {
  def findAll: Seq[Car]

  def search(keyword: String): Seq[Car]
}
