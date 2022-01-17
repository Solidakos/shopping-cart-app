package com.shoppingcartapp.entities;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class DVD {
    private @Id @GeneratedValue int id;
    private String title;
    private String[] actors;
    private String director;
    private String genre;
    private int runtime;
    private int stock;

    public DVD() {
    }

    public DVD(String title, String[] actors, String director, String genre, int runtime, int stock) {
        this.title = title;
        this.actors = actors;
        this.director = director;
        this.genre = genre;
        this.runtime = runtime;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String[] getActors() {
        return actors;
    }

    public void setActors(String[] actors) {
        this.actors = actors;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Arrays.hashCode(actors);
        result = prime * result + ((director == null) ? 0 : director.hashCode());
        result = prime * result + ((genre == null) ? 0 : genre.hashCode());
        result = prime * result + id;
        result = prime * result + runtime;
        result = prime * result + stock;
        result = prime * result + ((title == null) ? 0 : title.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DVD other = (DVD) obj;
        if (!Arrays.equals(actors, other.actors))
            return false;
        if (director == null) {
            if (other.director != null)
                return false;
        } else if (!director.equals(other.director))
            return false;
        if (genre == null) {
            if (other.genre != null)
                return false;
        } else if (!genre.equals(other.genre))
            return false;
        if (id != other.id)
            return false;
        if (runtime != other.runtime)
            return false;
        if (stock != other.stock)
            return false;
        if (title == null) {
            if (other.title != null)
                return false;
        } else if (!title.equals(other.title))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "DVD [actors=" + Arrays.toString(actors) + ", director=" + director + ", genre=" + genre + ", id=" + id
                + ", runtime=" + runtime + ", stock=" + stock + ", title=" + title + "]";
    }

    

}
