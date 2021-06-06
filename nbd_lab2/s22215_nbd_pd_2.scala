package pilichm.ex_2

class KontoBankowe(){
  private var stanKonta: Float = 0

  def this(initialAmount: Float) = {
    this()
    stanKonta = initialAmount
  }

  def getStanKonta: Float = stanKonta

  def wplata(amount: Float): Unit = stanKonta += amount

  def wyplata(amount: Float): Unit = stanKonta -= amount
}

object s22215_nbd_pd_2 extends  App {
  val daysOfWeek = List(
    "Poniedziałek", "Wtorek", "Środa", "Czwartek", "Piątek", "Sobota", "Niedziela")

  def ex_1(): Unit = {
    println("=============================\nExercise 1 - Start.")

    def matchPracaWeek(dayName: String): String = {
      val workingDayReg = "Poniedziałek|Wtorek|Środa|Czwartek|Piątek".r
      val weekendReg = "Sobota|Niedziela".r
      dayName match {
        case workingDayReg() => "Praca"
        case weekendReg() => "Weekend"
        case _ => "Nie ma takiego dnia"
      }
    }

    print("Results foe days of week:\n")
    for (day <- daysOfWeek){
      print(f"Day $day is a ${matchPracaWeek(day)}\n")
    }
    print(f"Result for random word 'Losowy' = ${matchPracaWeek("Losowy")}\n")
    println("Exercise 1 - End.\n=============================")
  }

  // Tylko pokazanie wykorzystania dwóch konstruktorów. Definicja na początku pliku.
  def ex_2(): Unit = {
    println("=============================\nExercise 2 - Start.")

    val KontoBezKwotyStartowej = new KontoBankowe()
    val KontoZKwotaStartowa = new KontoBankowe(1200)

    print(f"Stan konta dla konta bez podania kwoty startowej: ${KontoBezKwotyStartowej.getStanKonta}\n")
    print(f"Stan konta dla konta z kwota poczatkowa 1200: ${KontoZKwotaStartowa.getStanKonta}\n")
    println("Exercise 2 - End.\n=============================")
  }

  def ex_3(): Unit = {
    println("=============================\nExercise 3 - Start.")

    class Osoba(val imie: String, val nazwisko: String)

    val osoba1 = new Osoba("John", "Smith")
    val osoba2 = new Osoba("David", "Tennant")
    val osoba3= new Osoba("Matt", "Smith")
    val osoba4 = new Osoba("Obi-Wan", "Kenobi")
    val osoba5 = new Osoba("Obi-Two", "Kenobi")
    val osoba6 = new Osoba("Desmond", "Miles")

    def greet(osoba: Osoba): String = {
      (osoba.imie, osoba.nazwisko) match {
        case ("John" | "David", "Tennant" | "Smith") => "Hello, sweetie!"
        case ("Matt", "Smith") => "I am eleven."
        case ("Obi-Wan" | "Obi-Two", "Kenobi") => "Hello, there!"
        case _ => "Hi."
      }
    }

    print(f"Greeting for ${osoba1.imie} ${osoba1.nazwisko} is ${greet(osoba1)}\n")
    print(f"Greeting for ${osoba2.imie} ${osoba2.nazwisko} is ${greet(osoba2)}\n")
    print(f"Greeting for ${osoba3.imie} ${osoba3.nazwisko} is ${greet(osoba3)}\n")
    print(f"Greeting for ${osoba4.imie} ${osoba4.nazwisko} is ${greet(osoba4)}\n")
    print(f"Greeting for ${osoba5.imie} ${osoba5.nazwisko} is ${greet(osoba5)}\n")
    print(f"Greeting for ${osoba6.imie} ${osoba6.nazwisko} is ${greet(osoba6)}\n")
    println("Exercise 3 - End.\n=============================")
  }

  def ex_4(): Unit = {
    println("=============================\nExercise 4 - Start.")

    def kwadrat(num: Int) = num*num

    def func_4(number: Int, callback: Int => Int): Int = {
      var tempNumber = callback(number)
      tempNumber = callback(tempNumber)
      callback(tempNumber)
    }

    print(f"Function called for number 2 and function kwadrat(): ${func_4(2, kwadrat)}\n")
    println("Exercise 4 - End.\n=============================")
  }


  def ex_5():Unit = {
    println("=============================\nExercise 5 - Start.")

    class Osoba(val imie: String = "Michal", val nazwisko: String = "Pilichowski", val podatek: Float = 0.18f)

    trait Pracownik extends Osoba{
      var pensja: Int = 1000
      override val podatek: Float = 0.2f * getPensja

      def getPensja = pensja
      def setPensja(nwPensja: Int){
        pensja = nwPensja
      }
    }

    trait Student extends Osoba{
      override val podatek = 0f
    }

    trait Nauczyciel extends Pracownik{
      override val podatek:Float = 0.1f * getPensja
    }

    object pracownik extends Pracownik
    object student extends Student
    object nauczyciel extends Nauczyciel


    print("Sprawdzenie podatków dla traitów.\n")
    print(f"Dla studenta podatek = ${student.podatek}\n")
    print(f"Dla pracownika podatek = ${pracownik.podatek}\n")
    print(f"Dla nauczyciela podatek = ${nauczyciel.podatek}\n")

    object studentPtacownik extends Student with Pracownik
    object pracownikStudent extends Pracownik with Student

    print("Sprawdzenie wpływu kolejnosci dziediczenia na podatek.\n")
    print(f"Podatek dla object -> student -> pracownik = ${studentPtacownik.podatek}\n")
    print(f"Podatek dla object -> pracownik -> student = ${pracownikStudent.podatek}\n")
    println("Exercise 5 - End.\n=============================")
  }

  ex_1()
  ex_2()
  ex_3()
  ex_4()
  ex_5()
}
