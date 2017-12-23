package bapspatil.pantheon.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by bapspatil
 */

public class EventsResponse implements Parcelable {
    @SerializedName("day_one") private ArrayList<Events> dayOneEvents;
    @SerializedName("day_two") private ArrayList<Events> dayTwoEvents;

    public ArrayList<Events> getDayOneEvents() {
        return dayOneEvents;
    }

    public void setDayOneEvents(ArrayList<Events> dayOneEvents) {
        this.dayOneEvents = dayOneEvents;
    }

    public ArrayList<Events> getDayTwoEvents() {
        return dayTwoEvents;
    }

    public void setDayTwoEvents(ArrayList<Events> dayTwoEvents) {
        this.dayTwoEvents = dayTwoEvents;
    }

    public EventsResponse() {

    }

    public EventsResponse(ArrayList<Events> dayOneEvents, ArrayList<Events> dayTwoEvents) {

        this.dayOneEvents = dayOneEvents;
        this.dayTwoEvents = dayTwoEvents;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(this.dayOneEvents);
        dest.writeTypedList(this.dayTwoEvents);
    }

    protected EventsResponse(Parcel in) {
        this.dayOneEvents = in.createTypedArrayList(Events.CREATOR);
        this.dayTwoEvents = in.createTypedArrayList(Events.CREATOR);
    }

    public static final Creator<EventsResponse> CREATOR = new Creator<EventsResponse>() {
        @Override
        public EventsResponse createFromParcel(Parcel source) {
            return new EventsResponse(source);
        }

        @Override
        public EventsResponse[] newArray(int size) {
            return new EventsResponse[size];
        }
    };
}
