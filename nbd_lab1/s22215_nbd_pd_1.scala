package pilichm.ex_1

import scala.annotation.tailrec

object s22215_nbd_pd_1 extends App {
  val daysOfWeek = List(
    "Poniedziałek", "Wtorek", "Środa", "Czwartek", "Piątek", "Sobota", "Niedziela")

  def ex_1(): Unit = {
    println("=============================\nExercise 1 - Start.")

    def createStringWithForLoop(days: List[String]): String = {
      var resultString = ""
      for (day <- days) {
        resultString = if (resultString == "") day else resultString + ", " + day
      }
      resultString
    }

    def createStringWithForLoopStartsWithP(days: List[String]): String = {
      var resultString = ""
      for (day <- days) {
        resultString = if (day.startsWith("P"))
          if (resultString == "") day else resultString + ", " + day else resultString
      }
      resultString
    }

    def createStringWithWhileLoop(days: List[String]): String = {
      var resultString = ""
      var iter = 0
      while (iter < days.length){
        resultString = if (resultString == "") days(iter) else resultString + ", " + days(iter)
        iter += 1
      }
      resultString
    }

    println("Initial list: " + daysOfWeek)
    println(f"String created with for loop:\n${createStringWithForLoop(daysOfWeek)}")
    println(f"String created with for loop with days starting with P letter:" +
      f"\n${createStringWithForLoopStartsWithP(daysOfWeek)}")
    println(f"String created with while loop:\n${createStringWithWhileLoop(daysOfWeek)}")

    println("Exercise 1 - End.\n=============================")
  }

  def ex_2(): Unit ={
    println("=============================\nExercise 2 - Start.")

    val daysOfWeek = List(
      "Poniedziałek", "Wtorek", "Środa", "Czwartek", "Piątek", "Sobota", "Niedziela")

    def createStringRecur(days: List[String]): String = {
      if (days.length==1) days.head else days.head + ", " + createStringRecur(days.tail)
    }

    def createStringRecurReversed(days: List[String]): String = {
      if (days.isEmpty) return ""
      if (days.nonEmpty) {
        var currValue = createStringRecurReversed(days.tail)
        if (currValue != "") return currValue + ", " + days.head else currValue += days.head
      }
      return days.head
    }

    println(f"String created with recursion:\n${createStringRecur(daysOfWeek)}")
    println(f"String created with recursion from end:\n${createStringRecurReversed(daysOfWeek)}")

    println("Exercise 2 - End.\n=============================")
  }

  def ex_3(): Unit = {
    println("=============================\nExercise 3 - Start.")

    def createStringFromListTailRecur(days: List[String]): String = {
      @tailrec
      def iter(days: List[String], accumulator: String): String = {
        if (days.isEmpty)
          accumulator
        else iter(days.tail, if(accumulator=="") days.head else accumulator + ", " + days.head)
      }

      iter(days, "")
    }

    println(f"String created with tail recursion:\n${createStringFromListTailRecur(daysOfWeek)}")
    println("Exercise 3 - End.\n=============================")
  }

  def ex_4(): Unit = {
    println("=============================\nExercise 4 - Start.")

    val res_from_foldLeft = daysOfWeek.foldLeft(""){
      (a: String, b: String) => if (a!="") a + ", " + b else b
    }

    val res_from_foldRight = daysOfWeek.foldRight(""){
      (a: String, b: String) => if (a!="") a + ", " + b else b
    }

    val res_from_foldLeft_startsWithP = daysOfWeek.foldLeft(""){
      (a: String, b: String) => if (b.startsWith("P")) if (a!="") a + ", " + b else b else a
    }

    println(s"String created with foldLeft:\n ${res_from_foldLeft}")
    println(s"String created with foldRight:\n ${res_from_foldRight}")
    println(s"String created with foldLeft starting with P:\n ${res_from_foldLeft_startsWithP}")

    println("Exercise 4 - End.\n=============================")
  }

  def ex_5(): Unit = {
    println("=============================\nExercise 5 - Start.")
    val ProductPrices = Map("Milk" -> 2.4, "Bread" -> 2.8, "Potatoes" -> 1.3)
    println(s"Initial map:\n ${ProductPrices}")
    val ProductsWithDiscounts = ProductPrices map {case (key, value) => (key, 0.9*value)}
    println(s"Map after 10% discount:\n ${ProductsWithDiscounts}")
    println("Exercise 5 - End.\n=============================")
  }

  def ex_6(): Unit = {
    println("=============================\nExercise 6 - Start.")

    def printTupleWithThreeElements(triple: (Int, String, Boolean)): Unit = {
      println(s"First element of type: ${triple._1.getClass} and value: ${triple._1}")
      println(s"Second element of type: ${triple._2.getClass} and value: ${triple._2}")
      println(s"Third element of type: ${triple._3.getClass} and value: ${triple._3}")
    }

    printTupleWithThreeElements((42, "Scala", true))

    println("Exercise 6 - End.\n=============================")
  }

  def ex_7(): Unit = {
    println("=============================\nExercise 7 - Start.")

    val ProductPrices = Map("Milk" -> 2.4, "Bread" -> 2.8, "Potatoes" -> 1.3)

    def getValue(prices: Map[String, Double], key: String): Option[Double] = {
      try {
        prices.get(key)
      } catch {
        case e: Exception => None
      }
    }

    println(s"Getting value for existing key:\n ${getValue(ProductPrices, "Milk")}")
    println(s"Getting value for non existing key:\n ${getValue(ProductPrices, "Tomatoes")}")

    println("Exercise 7 - End.\n=============================")
  }

  def ex_8(): Unit = {
    println("=============================\nExercise 8 - Start.")

    val listOfNumbers = List(0, 1, -2, 0, 0, 1, 4, -5, 0, 1)

    def removeZeros(numbers: List[Int]): List[Int] = {
      def iter(nums: List[Int], processedList: List[Int]): List[Int] ={
        if (nums.isEmpty){
          return processedList
        } else {
          if (nums.head==0) iter(nums.tail, processedList) else iter(nums.tail, processedList ++ List(nums.head))
        }
      }
      iter(numbers, List())
    }

    println(s"Initial list:\n ${listOfNumbers}")
    println(s"List with removed zeros:\n ${removeZeros(listOfNumbers)}")
    println("Exercise 8 - End.\n=============================")
  }

  def ex_9(): Unit = {
    println("=============================\nExercise 9 - Start.")

    val listOfNumbers = List(0, 1, -2, 0, 0, 1, 4, -5, 0, 1)

    def incrementElementsOfList(numbers: List[Int]): List[Int] = {
      numbers.map(x => x+1)
    }

    println(s"Initial list:\n ${listOfNumbers}")
    println(s"List with removed zeros:\n ${incrementElementsOfList(listOfNumbers)}")
    println("Exercise 9 - End.\n=============================")
  }

  def ex_10(): Unit = {
    println("=============================\nExercise 10 - Start.")

    def listOfNumbers = List(-4.68,-6.43,5.74,-1.58,-11.35,2.98,6,-21.66,0.49,3.65)

    def getAbsValuesFromRange(numbers: List[Double]): List[Double] = {
      numbers.filter(_<12).filter(_ > -5).map(x => x.abs)
    }

    println(s"Initial list:\n ${listOfNumbers}")
    println(s"LIst with absolute values from range <-5, 12>:" +
      s"\n ${getAbsValuesFromRange(listOfNumbers)}")
    println("Exercise 10 - End.\n=============================")
  }

  ex_1()
  ex_2()
  ex_3()
  ex_4()
  ex_5()
  ex_6()
  ex_7()
  ex_8()
  ex_9()
  ex_10()
}
