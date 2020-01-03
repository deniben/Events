package model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Date;
import java.util.List;

public class Event {



    private int id;
    @Size(min=5, max=255, message="Your name event should be between 5 - 255 characters.")
    @NotEmpty(message = "Name can not to be empty")
    private String name;
    @NotEmpty(message = "Location can not to be empty")
    private String location;
    @NotEmpty(message = "Tag can not to be empty")
    private String tag;
    @Future(message = "The date must be future from this time")
    private Date timeOfBegin;
    @NotEmpty(message = "Description can not to be empty")
    @Size(min=25, max=10000, message="Description of event should be between 25 - 10000 characters.")
    private String description;
//    @NotNull(message = "One tag must be exist")
    private List<Tag> tags; // didn't realize


    public Event(int id, String name, String location, String tag, Date timeOfBegin, String description) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.tag = tag;
        this.timeOfBegin = timeOfBegin;
        this.description = description;
    }

    public Event(String name, String location, String tag, Date startOfBegin, String descrption) {
        this.name = name;
        this.location = location;
        this.tag = tag;
        this.timeOfBegin = startOfBegin;
        this.description=descrption;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Date getTimeOfBegin() {
        return timeOfBegin;
    }

    public void setTimeOfBegin(Date timeOfBegin) {
        this.timeOfBegin = timeOfBegin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public Event (){

    }

}
