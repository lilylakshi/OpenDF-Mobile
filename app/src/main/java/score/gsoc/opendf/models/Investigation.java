package score.gsoc.opendf.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by lilan on 3/22/16.
 */
public class Investigation implements Parcelable {

    public Investigation() {
    }

    protected Investigation(Parcel in) {
        title = in.readString();
        description = in.readString();
        dateOfCreation = in.readString();
    }

    public static final Creator<Investigation> CREATOR = new Creator<Investigation>() {
        @Override
        public Investigation createFromParcel(Parcel in) {
            return new Investigation(in);
        }

        @Override
        public Investigation[] newArray(int size) {
            return new Investigation[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(description);
        dest.writeString(dateOfCreation);
    }
}
