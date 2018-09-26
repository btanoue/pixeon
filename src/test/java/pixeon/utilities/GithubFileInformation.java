package pixeon.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;

public class GithubFileInformation {
    String nameFileString,commitMessageString,dateString;

    public GithubFileInformation(String nameFileString, String commitMessageString, String dateString){
        this.nameFileString = nameFileString;
        this.commitMessageString = commitMessageString;
        this.dateString = dateString;
    }

    public String getNameFileString() {
        return nameFileString;
    }

    public String getCommitMessageString() {
        return commitMessageString;
    }

    public String getDateString() {
        return dateString;
    }

    public Date getDate(){
        SimpleDateFormat formatter;
        Date date;

        date = new Date();
        formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
        try {
            date = formatter.parse(getDateString().replaceAll("Z$", "+0000"));
            return date;
        } catch(ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
    @Override
    public String toString() {
        return   " File='" + getNameFileString() + '\'' +
                ", commitMesssage='" + getCommitMessageString() + '\'' +
                ", date='" + getDateString() + '\'';

    }
}
