package SM;

import java.io.Serializable;

public class Coordenadas implements Serializable {

    private double latitude;
    private double longitude;

    /**
     * Construtor de Coordenadas
     * 
     * @param latitude  latitude das coordenadas
     * @param longitude longitude das coordenadas
     * 
     * 
     */
    public Coordenadas(double latitude, double longitude) {

        this.latitude = latitude;
        this.longitude = longitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLongitude() {
        return longitude;
    }

    /**
     * Método que retorna informação coordenadas
     * 
     * @return informação coordenadas
     */
    public String toString() {
        return (int) latitude + "º"
                + (int) Double.parseDouble(Double.toString(latitude).substring(3, 5)) + "´"
                + (int) Double.parseDouble(Double.toString(latitude).substring(5, 7)) + "."
                + (int) Double.parseDouble(Double.toString(latitude).substring(7, 9)) + "´N "
                + (int) longitude + "º"
                + (int) Double.parseDouble(Double.toString(longitude).substring(
                        (Double.toString(longitude).length()) - 6, (Double.toString(longitude).length()) - 4))
                + "´"
                + (int) Double
                        .parseDouble(Double.toString(longitude).substring(
                                (Double.toString(longitude).length()) - 4, (Double.toString(longitude).length()) - 2))
                + "."
                + (int) Double.parseDouble(Double.toString(longitude)
                        .substring((Double.toString(longitude).length()) - 2, (Double.toString(longitude).length())))
                + "´W ";
    }
}
