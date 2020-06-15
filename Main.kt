package machine

import java.util.*


class CoffeeMachine() {

    var water = 400
    var milk = 540
    var beans = 120
    var dc = 9
    var cash = 550
    var exit = 1

    fun state(water: Int, milk: Int, beans: Int, dc: Int, cash: Int){
        println("The coffee machine has:" + "\n" + "$water of water" + "\n" + "$milk of milk" + "\n" + "$beans of coffee beans" +
                "\n" + "$dc of disposable cups" + "\n" + "$cash of money")
    }

    fun pushTheButton(){
        val scanner = Scanner(System.`in`)
        while (exit > 0){
            println("Write action (buy, fill, take, remaining, exit):")
            val choose = scanner.next()
            when (choose) {
                "remaining" -> state(water, milk, beans, dc, cash)
                "exit" -> {
                    exit = 0
                }
                "buy" -> {
                    print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:")
                    val choose_1 = scanner.next()
                    when (choose_1) {
                        "1" -> {
                            // espresso
                            if (water >= 250 && beans >= 16 && dc >= 1){
                                water -= 250
                                beans -= 16
                                dc -= 1
                                cash += 4
                                println("I have enough resources, making you a coffee!")
                            }
                            else if (water <  250) println("Sorry, not enough water!")
                            else if (beans < 16) println("Sorry, not enough beans!")
                            else if (dc < 1) println("Sorry, not enough disposable cups")
                        }
                        "2" -> {
                            // latte
                            if (water >= 350 && beans >= 20 && dc >= 1 && milk >=75){
                                water -= 350
                                beans -= 20
                                milk -= 75
                                dc -= 1
                                cash += 7
                                println("I have enough resources, making you a coffee!")
                            }
                            else if (water <  350) println("Sorry, not enough water!")
                            else if (beans < 20) println("Sorry, not enough beans!")
                            else if (dc < 1) println("Sorry, not enough disposable cups")
                            else if (milk < 75) println("Sorry, not enough milk!")
                        }
                        "3" -> {
                            // cappuccino
                            if (water >= 200 && beans >= 12 && dc >= 1 && milk >=100){
                                water -= 200
                                beans -= 12
                                milk -= 100
                                dc -= 1
                                cash += 6
                                println("I have enough resources, making you a coffee!")
                            }
                            else if (water <  200) println("Sorry, not enough water!")
                            else if (beans < 12) println("Sorry, not enough beans!")
                            else if (dc < 1) println("Sorry, not enough disposable cups")
                            else if (milk < 100) println("Sorry, not enough milk!")
                        }
                        "back" -> {}
                    }
                }
                "fill" -> {
                    println("Write how many ml of water do you want to add:")
                    water += scanner.nextInt()
                    println("Write how many ml of milk do you want to add:")
                    milk += scanner.nextInt()
                    println("Write how many grams of coffee beans do you want to add:")
                    beans += scanner.nextInt()
                    println("Write how many disposable cups of coffee do you want to add:")
                    dc += scanner.nextInt()
                    //state(water, milk, beans, dc, cash)
                }
                "take" -> {
                    println("I gave you $cash")
                    cash = 0
                    //state(water, milk, beans, dc, cash)
                }
            }
        }
    }
}


fun main() {
    val cm = CoffeeMachine()
    cm.pushTheButton()
}
