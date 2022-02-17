class Info(var PlayerName: String, var Country: String, var Matches: Int, var Runs: Int, var Wickets: Int,var Year: Int)
{}
object Info {

  def main(args: Array[String]): Unit = {
    var flag = true
    var Player = List.empty[Info]
    while (flag) {
      val result = scala.io.StdIn.readLine(" Do you want to continue? (yes/no) \n ")
      if (result == "no")
        flag = false
      else {
        var PlayerName = scala.io.StdIn.readLine("Enter Player Name \n")
        var Country = scala.io.StdIn.readLine("Enter Country Name \n")
        var Matches = scala.io.StdIn.readLine("Enter Number of matches played \n").toInt
        var Runs = scala.io.StdIn.readLine("Enter Run Scored \n").toInt
        var Wickets = scala.io.StdIn.readLine("Enter Wicket Taken \n").toInt
        var Year = scala.io.StdIn.readLine("Enter its year \n").toInt
        Player = Player :+ (new Info(PlayerName, Country, Matches, Runs, Wickets, Year))
      }
    }
    println("Question - 1. Player with the best highest run scored! ");
    var MostRun = Player.sortBy(x => x.Runs).reverse
    println(MostRun(0).PlayerName)
    println('\n')
    println("Question - 2. Top 5 players by run scored!")
    for (player <- MostRun.take(5)) {
      println(player.PlayerName)
    }
    println("\n")
    println("Question - 3. Top 5 players by wicket taken!")
    var MostWickets = Player.sortBy(x => x.Wickets).reverse
    for (player <- MostWickets.take(5)) {
      println(player.PlayerName)
    }
    println("\n")
    println("Question - 4. Rank players with overall performance give weight 5x to wicket taken and (5/100)x to run scored!")
    var PlayerRank = Player.sortBy(x => x.Wickets * 5).sortBy(x => x.Runs * 0.05).reverse
    var Rank = 1
    for (player <- PlayerRank) {
      println(s"Rank $Rank --> " + player.PlayerName)
      Rank += 1;
    }
  }
}
