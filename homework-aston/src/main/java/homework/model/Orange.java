package homework.model;

public class Orange implements Comparable<Orange>{

    protected int id;
    protected String sort;
    protected int weight;

    public Orange(int id, String sort, int weight) {
        this.id = id;
        this.sort = sort;
        this.weight = weight;
    }

    public Orange() {
    }

    public Integer getId() {
        return id;
    }

    public String getSort() {
        return sort;
    }

    public Integer getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Orange{" +
                "id=" + id +
                ", sort='" + sort + '\'' +
                ", weight=" + weight +
                '}';
    }

    @Override
    public int compareTo(Orange o) {
        return this.getId().compareTo(o.getId());
    }
}
