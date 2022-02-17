import scala.math.BigDecimal.double2bigDecimal
object bucket {
  def main(args: Array[String]): Unit = {
    val arr = (0.000d to 101.000d by 0.050d).toArray
    var i=1
      while(i<=10) {
            var x = scala.io.StdIn.readLine("Enter a number \n").toDouble
            if(x<0&&x>100.049)
              println("enter number between 0 to 100.049 \n")
            else
            search(arr, x)
        i=i+1
      }
    def search(arr: Array[BigDecimal], n: Double): Unit = {
      var low = 0
      var high = arr.length - 1
      while (low <= high) {
        var middle = low + (high - low) / 2
        if (n >= arr(middle) && n < arr(middle + 1)) {
          println(s"bucket is ${arr(middle) + 0.000} - ${arr(middle + 1) - 0.001}")
          return
        }
        else if (arr(middle) > n)
          high = middle - 1
        else
          low = middle + 1
      }
    }
  }
}
