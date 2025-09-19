package ge.tbc.testautomation.data;

public class LocationModel {
    private int id;
    private String area;
    private int expectedMinResults;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getArea() { return area; }
    public void setArea(String area) { this.area = area; }

    public int getExpectedMinResults() { return expectedMinResults; }
    public void setExpectedMinResults(int expectedMinResults) { this.expectedMinResults = expectedMinResults; }

    @Override
    public String toString() {
        return "LocationModel{" +
                "id=" + id +
                ", area='" + area + '\'' +
                ", expectedMinResults=" + expectedMinResults +
                '}';
    }
}
