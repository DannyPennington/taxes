import org.scalatest.FlatSpec
import Main.tax


class Tests extends FlatSpec
{
  "values under 10,000" should "not be taxed" in
  {
    assert( tax(5000) == 0 )
    assert( tax(10000) == 0 )
  }
  "values under 30,000" should "taxed at 10%" in
  {
    assert( tax(30000) == 2000 )
    assert( tax(20000) == 1000 )
  }
  "values under 100,000" should "taxed at 25%" in
  {
    assert( tax(100000) == 19500 )
    assert( tax(90000) == 17000 )
  }
  "values above 100,000" should "taxed at 40%" in
  {
    assert( tax(200000) == 59500 )
    assert( tax(150000) == 39500 )
    assert( tax(999999) == 379500 )
  }
}
