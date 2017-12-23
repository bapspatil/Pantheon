package bapspatil.pantheon.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by bapspatil
 */

public class UpdatesResponse implements Parcelable {
    @SerializedName("title") private String title;
    @SerializedName("body") private String body;
    @SerializedName("timestamp") private String timestamp;

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

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public UpdatesResponse() {

    }

    public UpdatesResponse(String title, String body, String timestamp) {

        this.title = title;
        this.body = body;
        this.timestamp = timestamp;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeString(this.body);
        dest.writeString(this.timestamp);
    }

    protected UpdatesResponse(Parcel in) {
        this.title = in.readString();
        this.body = in.readString();
        this.timestamp = in.readString();
    }

    public static final Parcelable.Creator<UpdatesResponse> CREATOR = new Parcelable.Creator<UpdatesResponse>() {
        @Override
        public UpdatesResponse createFromParcel(Parcel source) {
            return new UpdatesResponse(source);
        }

        @Override
        public UpdatesResponse[] newArray(int size) {
            return new UpdatesResponse[size];
        }
    };
}
