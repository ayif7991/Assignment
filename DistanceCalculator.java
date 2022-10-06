import java.util.Arrays;
import java.util.Comparator;

public class DistanceCalculator {
        public static void main(String[] args) {
                //Taking the values from User
                System.out.println("Enter the latitude,longitude and height of the coordinate 1:");
                Positions position1 = new Positions();
                System.out.println("Enter the latitude,longitude and height of the coordinate 2:");
                Positions position2 = new Positions();
                System.out.println("Enter the latitude,longitude and height of the coordinate 3:");
                Positions position3 = new Positions();
                System.out.println("Enter the latitude,longitude and height of the coordinate 4:");
                Positions position4 = new Positions();

               //Storing and printing coordinates in Array
                Positions[] positionArray = {position1,position2,position3,position4};
                System.out.println("Coordinates: "+ positionArray[0].printValues()+" "+positionArray[1].printValues()+" "+positionArray[2].printValues()+" "+positionArray[3].printValues());

                //Sorting latitudes in Ascending order
                Arrays.sort(positionArray, new Comparator<Positions>() {
                        @Override
                        public int compare(Positions o1, Positions o2) {
                                return Double.compare(o1.getLatitude(),o2.getLatitude());
                        }
                });
                System.out.println("Coordinates in latitude ascending order: "+ positionArray[0].printValues()+" "+positionArray[1].printValues()+" "+positionArray[2].printValues()+" "+positionArray[3].printValues());

                //Sorting latitudes in Descending order
                Arrays.sort(positionArray, new Comparator<Positions>() {
                        @Override
                        public int compare(Positions o1, Positions o2) {
                                return Double.compare(o2.getLongitude(),o1.getLongitude());
                        }
                });
                System.out.println("Coordinates in Longitude descending order: "+positionArray[0].printValues()+" "+positionArray[1].printValues()+" "+positionArray[2].printValues()+" "+positionArray[3].printValues());

                //Distance between two points is calculated by calling getDistanceBetweentwoPoints
                double result;
                result = CalculationClass.getDistanceBetweentwoPoints(position1,position2);
                System.out.println("Distance between position1 and position2 is: "+result);
                result = CalculationClass.getDistanceBetweentwoPoints(position1,position3);
                System.out.println("Distance between position1 and position3 is: "+result);
                result = CalculationClass.getDistanceBetweentwoPoints(position1,position4);
                System.out.println("Distance between position1 and position4 is: "+result);
                result = CalculationClass.getDistanceBetweentwoPoints(position2,position3);
                System.out.println("Distance between position2 and position3 is: "+result);
                result = CalculationClass.getDistanceBetweentwoPoints(position2,position4);
                System.out.println("Distance between position2 and position4 is: "+result);
                result = CalculationClass.getDistanceBetweentwoPoints(position3,position4);
                System.out.println("Distance between position3 and position4 is: "+result);


        }
        //Class to do all mathematical calculations
        public static class CalculationClass{
                static double radianFactor = Math.PI/180;
                static double earthRadius = 6378137.0;
                public static double getDistanceBetweentwoPoints(Positions a,Positions b){
                        double x1 = a.getLatitude();
                        double x2 = b.getLatitude();
                        double y1 = a.getLongitude();
                        double y2 = b.getLongitude();
                        double z1 = a.getHeight();
                        double z2 = b.getHeight();
                        double Deltalatitudeindegrees = x1-x2;
                        double Deltalongitudeindegrees = y1-y2;
                        double Deltalatitudeinradians = Deltalatitudeindegrees * radianFactor;
                        double Deltalongitudeinradians = Deltalongitudeindegrees * radianFactor;
                        double Deltalatitudeinmetres = Deltalatitudeinradians * earthRadius;
                        double Deltalongitudeinmetres = Deltalongitudeinradians * earthRadius;
                        double Deltaheightinmetres = z1-z2;
                        double result = Math.sqrt((Deltalatitudeinmetres*Deltalatitudeinmetres)+(Deltalongitudeinmetres*Deltalongitudeinmetres)+(Deltaheightinmetres*Deltaheightinmetres));
                        return result;
                }
                        }

}
