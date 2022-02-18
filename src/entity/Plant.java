package entity;

public class Plant {
	
	private String plantName;
	private String familyName;
	private int dogs;
	private int cats;
	private String plantType;
	private String toxicityLevel;
	private String symptoms;

    public Plant(String plantName, String familyName, int dogs, int cats, String plantType, String toxicityLevel, String symptoms) {
        this.plantName = plantName;
        this.familyName = familyName;
        this.dogs = dogs; 
        this.cats = cats; 
        this.plantType = plantType;
        this.toxicityLevel = toxicityLevel;
        this.symptoms = symptoms; 	
    }
    
    public String getPlantName() {
        return plantName;
    }

    public void setPlantName(String plantName) {
        this.plantName = plantName;
    }
    
    public String setFamilyName() {
        return familyName;
    }

    public void getFamilyName(String familyName) {
        this.familyName = familyName;
    }
    
    public int setDogs() {
        return dogs;
    }

    public void getDogs(int dogs) {
        this.dogs = dogs;
    }
    
    public int setCats() {
        return cats;
    }

    public void getCats(int cats) {
        this.cats = cats;
    }
    
    public void setPlantType(String plantType) {
        this.plantType = plantType;
    }
    
    public String getPlantType() {
        return plantType;
    }
    
    public void setToxicityLevel(String toxicityLevel) {
        this.toxicityLevel = toxicityLevel;
    }
    
    public String getToxicityLevel() {
        return toxicityLevel;
    }
    
    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }
    
    public String getSymptoms() {
        return symptoms;
    }
}
    
    
