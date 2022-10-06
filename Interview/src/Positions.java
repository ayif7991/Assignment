import java.util.Scanner;

public class Positions
{

    private double latitude;
    private double longitude;
    private double height;
    Scanner in = new Scanner(System.in);

    //Setting values to positions using constructor
    public Positions() {
        setLatitude();
        setLongitude();
        setHeight();
    }
    public Positions(double a, double b, double c) {
        this.latitude = a;
        this.longitude = b;
        this.height = c;
    }

    public double getLatitude() {
        return latitude;
    }
    //User inputs the value for latitude and checks whether the value is within range
    public void setLatitude() {
        System.out.println("Enter the latitude of the coordinates in degrees:");
        double value = in.nextDouble();
        if (((value >= -90) && (value <= 90))) {
            this.latitude = value;
        }
        else {
            System.out.println("Please enter a value between -90 and 90");
            setLatitude();
        }
    }

    public double getLongitude() {
        return longitude;
    }
    //User inputs the value for longitude and checks whether the value is within range
    public void setLongitude() {
        System.out.println("Enter the Longitude of the coordinates in degrees:");
        double value = in.nextDouble();
        if (((value >= -180) && (value <= 180))) {
            this.longitude=value;
        }
        else{
            System.out.println("Please enter a value between -180 and 180");
            setLongitude();
        }
    }

    public double getHeight() {
        return height;
    }
    //User inputs the value for height
    public void setHeight() {
        System.out.println("Enter the height of the coordinates in meters:");
        this.height=in.nextDouble();
    }

    //printValue function is called to display the value of positions
    public String printValues(){
        String coord = "["+this.latitude + "," + this.longitude + "," + this.height+"]";
        return coord;
    }
}
