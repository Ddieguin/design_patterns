package Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.Table;

@Entity
@Table(name = "VITIMA")
public class Vitima {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nome")
    private String nome;

    Vitima() {}

    Vitima(Builder builder) {
        this.nome = builder.nome;
    }

    public static class Builder {
        public String nome;
        public int id;

        public Builder setNome(String nome) {
            this.nome = nome;
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