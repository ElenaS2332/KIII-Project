package com.example.demo.model;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
@Table(name = "wineries")
public class Wineries {
    @Id
    @JsonProperty("id")
    public long id;

    public Double latitude;
    public Double longitude;

    @Column(length = 1000)

    public String name;

    @Column(length = 1000)
    public String location;
    @Column(length = 1000)
    public String rating;

    @Column(length = 5000)
    public String description;
    public String phone;

    @OneToMany(mappedBy = "winery")
    private List<Review> reviews;
    @JsonProperty("img")
    @Column(length = 1000)
    public String image;

    public Wineries() {
    }

    public Wineries(@JsonProperty("id") long id,
                    @JsonProperty("latitude") Double latitude,
                    @JsonProperty("longitude") Double longitude,
                    @JsonProperty("name") String name,
                    @JsonProperty("img") String image,
                    @JsonProperty("location") String location,
                    @JsonProperty("rating") String rating,
                    @JsonProperty("description")String description,
                    @JsonProperty("phone")String phone){
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.name = name;
        this.image = image;
        this.location = location;
        this.rating=rating;
        this.description=description;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getRating() {
        return rating;
    }

    public long getId() {
        return id;
    }


    public String getLocation() {
        return location;
    }
}
