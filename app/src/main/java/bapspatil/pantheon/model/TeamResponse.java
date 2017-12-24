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
    @SerializedName("deco") private ArrayList<Team> decoTeam;
    @SerializedName("logistics") private ArrayList<Team> logisticsTeam;

    public ArrayList<Team> getTechTeam() {
        return techTeam;
    }

    public void setTechTeam(ArrayList<Team> techTeam) {
        this.techTeam = techTeam;
    }

    public ArrayList<Team> getDecoTeam() {
        return decoTeam;
    }

    public void setDecoTeam(ArrayList<Team> decoTeam) {
        this.decoTeam = decoTeam;
    }

    public ArrayList<Team> getLogisticsTeam() {
        return logisticsTeam;
    }

    public void setLogisticsTeam(ArrayList<Team> logisticsTeam) {
        this.logisticsTeam = logisticsTeam;
    }

    public TeamResponse() {

    }

    public TeamResponse(ArrayList<Team> techTeam, ArrayList<Team> decoTeam, ArrayList<Team> logisticsTeam) {

        this.techTeam = techTeam;
        this.decoTeam = decoTeam;
        this.logisticsTeam = logisticsTeam;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(this.techTeam);
        dest.writeTypedList(this.decoTeam);
        dest.writeTypedList(this.logisticsTeam);
    }

    protected TeamResponse(Parcel in) {
        this.techTeam = in.createTypedArrayList(Team.CREATOR);
        this.decoTeam = in.createTypedArrayList(Team.CREATOR);
        this.logisticsTeam = in.createTypedArrayList(Team.CREATOR);
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
