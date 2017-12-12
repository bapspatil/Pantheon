package bapspatil.pantheon.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by bapspatil
 */

public class TeamResponse implements Parcelable {
    @SerializedName("tech") private ArrayList<Team> techTeam;

    public ArrayList<Team> getTechTeam() {

        return techTeam;
    }

    public void setTechTeam(ArrayList<Team> techTeam) {
        this.techTeam = techTeam;
    }

    public TeamResponse() {
    }

    public TeamResponse(ArrayList<Team> techTeam) {

        this.techTeam = techTeam;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(this.techTeam);
    }

    protected TeamResponse(Parcel in) {
        this.techTeam = new ArrayList<Team>();
        in.readList(this.techTeam, Team.class.getClassLoader());
    }

    public static final Creator<TeamResponse> CREATOR = new Creator<TeamResponse>() {
        @Override
        public TeamResponse createFromParcel(Parcel source) {
            return new TeamResponse(source);
        }

        @Override
        public TeamResponse[] newArray(int size) {
            return new TeamResponse[size];
        }
    };
}
