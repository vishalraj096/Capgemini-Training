public class EarthVolume {
    public static void main(String[] args) {
        int radiusKm = 6378;
        double PI = Math.PI;

        double volumeKm = (4.0 / 3) * PI * Math.pow(radiusKm, 3);

        double milesPerKm = 1.6;
        double radiusMiles = radiusKm * milesPerKm;
        double volumeMiles = (4.0 / 3) * PI * Math.pow(radiusMiles, 3);

        System.out.println(
                "The volume of earth in cubic kilometers is " + volumeKm +
                        " and cubic miles is " + volumeMiles);
    }
}
