package soft.uni.models.viewModels.game;

import soft.uni.entities.api.GameType;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Venelin on 28.7.2017 г..
 */
public class GameDetailsView implements GameType {

    private String title;
    private BigDecimal price;
    private Double size;
    private String trailer;
    private String thumbnailURL;
    private String description;
    private Date releaseDate;

    public GameDetailsView() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public String getThumbnailURL() {
        return thumbnailURL;
    }

    public void setThumbnailURL(String thumbnailURL) {
        this.thumbnailURL = thumbnailURL;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Title: %s\n", this.getTitle()));
        sb.append(String.format("Price: %s\n", this.getPrice()));
        sb.append(String.format("Size: %s\n", this.getSize()));
        sb.append(String.format("Trailer: https://www.youtube.com/watch?v=%s\n", this.getTrailer()));
        sb.append(String.format("Thumbnail URL: %s\n", this.getThumbnailURL()));
        sb.append(String.format("Description: %s\n", this.getDescription()));
        String releaseDate = String.format("Release date: %s\n", this.getReleaseDate());
        releaseDate = releaseDate.substring(0, releaseDate.lastIndexOf(" "));
        sb.append(releaseDate);

        return sb.toString();
    }
// .substring(0, this.getReleaseDate().toString().lastIndexOf(" ")
}
