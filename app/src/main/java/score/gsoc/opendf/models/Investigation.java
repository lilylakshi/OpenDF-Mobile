package score.gsoc.opendf.models;

/**
 * Created by lilan on 3/22/16.
 */
public class Investigation {
    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDateOfCreation(String dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    private String title;
    private String description;
    private String dateOfCreation;

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getDateOfCreation() {
        return dateOfCreation;
    }
}
