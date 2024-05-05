package LibraryManagement.models;

public class EducationalKit implements LibraryItem {

    private String name;
    private String description;
    private String category; //  STEM, language learning, art, etc.

    // Constructor
    public EducationalKit(String name, String description, String category) {
        this.name = name;
        this.description = description;
        this.category = category;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


    @Override
    public String toString() {
        return "EducationalKit: " +
                "name = " + name +
                ", description = " + description +
                ", category = " + category;
    }

    @Override
    public String getDisplayName() {
        return name + " - " + category;
    }

    @Override
    public String getType() {
        return "Educational Kit";
    }
}

