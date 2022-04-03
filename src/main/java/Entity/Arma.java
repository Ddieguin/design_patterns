package Entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ARMA")
public class Arma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "classe")
    private String classe;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "arma")
    private List<Crime> crimes;

    public List<Crime> getCrimes() {
        return this.crimes;
    }

    Arma(Builder builder) {
        this.nome = builder.nome;
        this.classe = builder.classe;
    }

    public static class Builder {
        public String nome;
        public String classe;
        public List<Crime> crimes;


        public Builder setNome(String nome) {
            this.nome = nome;
            return this;
        }

        public Builder setClasse(String classe) {
            this.classe = classe;
            return this;
        }

        public Builder setCrimes(List<Crime> crimes) {
            this.crimes = crimes;
            return this;
        }

        public Arma build() {
            return new Arma(this);
        }

    }

    public String getClasse() {
        return this.classe;
    }

    public String getNome() {
        return this.nome;
    }

    public int getId() {
        return this.id;
    }


    @Override
    public String toString() {
        return "Arma{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", classe='" + classe + '\'' +
                '}';
    }
}