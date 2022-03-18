package Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import javax.persistence.Table;

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

    Criminoso(Builder builder) {
        this.nome = builder.nome;
    }

    public int getId() {
        return id;
    }

    public static class Builder {

        public String nome;
        public Builder setNome(String nome) {
            this.nome = nome;
            return this;
        }

        public Criminoso build() {
            return new Criminoso(this);
        }
    }

    @Override
    public String toString() {
        return "Criminoso{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}