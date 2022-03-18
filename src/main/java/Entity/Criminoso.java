package Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "CRIMINOSO")
public class Criminoso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nome")
    private String nome;

    public String getNome() {
        return this.nome;
    }

    public List<Crime> getCrimes() {
        return this.crimes;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "criminoso", fetch = FetchType.EAGER)
    private List<Crime> crimes;

    Criminoso(Builder builder) {
        this.nome = builder.nome;
        this.crimes = builder.crimes;
    }

    public int getId() {
        return id;
    }

    public static class Builder {

        public String nome;
        public List<Crime> crimes = new ArrayList<>();

        public Builder setNome(String nome) {
            this.nome = nome;
            return this;
        }

        public Builder setListCrimes(List<Crime> crimes) {
            this.crimes = crimes;
            return this;
        }

        public Criminoso build() {
            return new Criminoso(this);
        }
    }

    public void setCrimes(List<Crime> crimes) {
        this.crimes = crimes;
    }


    @Override
    public String toString() {
        return "Criminoso{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}