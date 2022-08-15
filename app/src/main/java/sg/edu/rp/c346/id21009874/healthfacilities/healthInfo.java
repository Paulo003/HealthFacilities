package sg.edu.rp.c346.id21009874.healthfacilities;

import androidx.appcompat.app.AppCompatActivity;

public class healthInfo extends AppCompatActivity {
    private String beds;
    private String facilities;
    private String institution;
    private String year;
    private String facility;

    public healthInfo(String beds, String facilities, String institution, String year, String facility){
        this.beds = beds;
        this.facilities = facilities;
        this.institution = institution;
        this.year = year;
        this.facility = facility;
    }
    public String getBeds(){
        return beds;
    }
    public String getFacilities(){
        return facilities;
    }
    public String getInstitution(){
        return institution;
    }
    public String getYear(){
        return year;
    }
    public String getFacility(){
        return facility;
    }
    public void setBeds(String beds){
        this.beds = beds;
    }
    public void setFacilities(String facilities){
        this.facilities = facilities;
    }
    public void setInstitution(String institution){
        this.institution = institution;
    }
    public void setYear(String year){
        this.year = year;
    }
    public void setFacility(String facility){
        this.facility = facility;
    }
    @Override
    public String toString(){
        return "No. of Beds : " + beds + "\n"
                + "No. of Facilities : " + facilities + "\n" +
                "institution_type : " + institution + "\n"
                + "Year : " + year + "\n" +
                "Facility type : " + facility;
    }


}
