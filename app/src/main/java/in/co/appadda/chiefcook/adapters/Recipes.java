package in.co.appadda.chiefcook.adapters;

/**
 * Created by dewangankisslove on 09-01-2016.
 */
public class Recipes {

    private int id;
    private String recipe_name;
    private String time;
    private String serve;

    public Recipes() {
        super();
    }

    public Recipes(int id, String name, String time, String serve) {
        super();
        this.id = id;
        this.recipe_name = name;
        this.time = time;
        this.serve = serve;
    }

    public String getName() {
        return recipe_name;
    }

    public void setName(String name) {
        this.recipe_name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getServe() {
        return serve;
    }

    public void setServe(String serve) {
        this.serve = serve;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Recipes other = (Recipes) obj;
        if (id != other.id)
            return false;
        return true;
    }
}
