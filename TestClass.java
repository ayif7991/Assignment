import org.junit.Assert;
import org.junit.Test;
public class TestClass {

    @Test
    public void test1(){
        Positions positionsForTest1 = new Positions(13,14,19);
        Positions positionsForTest2 = new Positions(23,89,35);

       double actualResult = DistanceCalculator.CalculationClass.getDistanceBetweentwoPoints(positionsForTest1,positionsForTest2);
       double expectedResult = 8422847.867539698 ;
       if(actualResult==expectedResult){
           Assert.assertTrue("Calculation is working fine",true);
       }
       else{
           Assert.fail("Calculation is not working");
       }


    }
}
