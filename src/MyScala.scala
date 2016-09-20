import scala.io.StdIn._
import scala.collection.mutable.ListBuffer
import sun.security.util.Length

object MyScala {
  def main(args: Array[String]): Unit = {
    var i = 0
    var list1 = new ListBuffer[Car]()
    var list3 = new ListBuffer[Int]()
    var numcars: Int = 0
    while (i < args.length - 1) {
      if ("EXIT" == args(i)) {
        numcars = numcars + 1
        val c = new Car(args(i - 1).toInt, args(i + 1).toInt, numcars)
        list1 += c
      }
      i = i + 1
    }

    for (obj2 <- list1) {
      for (obj1 <- list1) {

        if ((obj2.entrySec >= obj1.entrySec) && (obj2.entrySec <= obj1.exitSec) ||

          (obj2.exitSec >= obj1.entrySec) && (obj2.exitSec <= obj1.exitSec)) {

          obj2.addList(obj1.numCars)
        }

      }
      // list3 +== carnum

    }
    for (i <- 0 to list1.length - 1) {
      println(list1(i).numCars + " Entry : " + list1(i).entrySec + " Exit : " + list1(i).exitSec + " List " + list1(i).getSet)
    }

    //println(list3.max)
    var n: Int = 0
    for (i <- 0 to list1.length - 1) {
      n = 0
      for (j <- 0 to list1.length - 1) {
        if (list1(i).getSet.subsetOf(list1(j).getSet)) {
          n = n + 1

        }

      }
      list3 += n
    }
    println("max : " + list3.max)
  }

}

class Car(ent: Int, exi: Int, n: Int) {
  var list: ListBuffer[Int] = new ListBuffer[Int]

  def entrySec: Int = ent
  def exitSec: Int = exi
  def numCars: Int = {
    val numCars = n
    numCars

  }
  def addList(n: Int) = {

    list += n

  }
  def getSet: Set[Int] = {

    list.toSet

  }

}

  

  
  






