package mx.com.unam.listamascotas.pojo;

/**
 * Created by frodriguez on 27/06/16.
 */
public class Mascota {
    private String name;
    private int rating;
    private  int foto;
    private int id;

    public Mascota() {
    }

    public Mascota(int id, String name, int rating , int foto ) {
        this.setName(name);
        this.setRating(rating);
        this.setFoto(foto);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
