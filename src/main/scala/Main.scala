import scala.math.BigDecimal

object Main extends App
{
  def tax( num :Double ) : Int =
  {
    var taxed = 0.0
    if ( num > 100000)
    {
      taxed = (num-100000)*0.4
      taxed = taxed + tax(100000)
    }
    else if ( num <= 100000 && num > 30000)
    {
      taxed = (num-30000) * 0.25
      taxed = taxed + tax(30000)
    }
    else if ( num <= 30000 && num > 10000)
    {
      taxed = (num-10000) * 0.1
      taxed = taxed + tax( 10000)
    }
    else if ( num <= 10000 )
    {
      taxed.toInt
    }
    taxed.toInt
  }

  def totalTaxRate(taxRate: Double): Int =
  {
    //tax(num)/num
    var taxNum = 0.0
    //val taxRate2 = BigDecimal(taxRate).setScale(3, BigDecimal.RoundingMode.HALF_UP).toDouble
    //taxNum = tax(20000)
    //return taxNum/20000
    for( i <- 10000 to 5000000 by 1)
    {
      taxNum = tax(i)
      taxNum = taxNum/i
      if( ~=(taxNum, taxRate, 0.000001) )
      {
        return i
      }
    }
    0
  }

  def ~=(x: Double, y: Double, precision: Double) =
  {
    if ((x - y).abs < precision) true else false
  }

  //println(totalTaxRate(256250))
  println( totalTaxRate(0.3959) )
}


