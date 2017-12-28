package bapspatil.pantheon.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by bapspatil
 */

public class Event implements Parcelable {
    @SerializedName("time") private String time;
    @SerializedName("title") private String title;
    @SerializedName("body") private String body;
    @SerializedName("location") private String location;
    @SerializedName("maxMembers") private String maxMembers;
    @SerializedName("contact") private String contact;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getMaxMembers() {
        return maxMembers;
    }

    public void setMaxMembers(String maxMembers) {
        this.maxMembers = maxMembers;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Event() {

    }

    public Event(String time, String title, String body, String location, String maxMembers, String contact) {

        this.time = time;
        this.title = title;
        this.body = body;
        this.location = location;
        this.maxMembers = maxMembers;
        this.contact = contact;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.time);
        dest.writeString(this.title);
        dest.writeString(this.body);
        dest.writeString(this.location);
        dest.writeString(this.maxMembers);
        dest.writeString(this.contact);
    }

    protected Event(Parcel in) {
        this.time = in.readString();
        this.title = in.readString();
        this.body = in.readString();
        this.location = in.readString();
        this.maxMembers = in.readString();
        this.contact = in.readString();
    }

    public static final Creator<Event> CREATOR = new Creator<Event>() {
        @Override
        public Event createFromParcel(Parcel source) {
            return new Event(source);
        }

        @Override
        public Event[] newArray(int size) {
            return new Event[size];
        }
    };
}
