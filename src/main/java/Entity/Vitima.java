package Entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "VITIMA")
public class Vitima {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nome")
    private String nome;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "vitima")
    private List<Crime> crimes;

    Vitima() {}

    Vitima(Builder builder) {
        this.nome = builder.nome;
    }

    public static class Builder {
        public String nome;
        public int id;
        public List<Crime> crimes;

        public Builder setNome(String nome) {
            this.nome = nome;
            return this;
        }

        public Builder setCrimes(List<Crime> crimes) {
            this.crimes = crimes;
            return this;
        }

        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public Vitima build() {
            return new Vitima(this);
        }
    }

    public int getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    @Override
    public String toString() {
        return "Vitima{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}