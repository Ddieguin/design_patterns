package Entity;

import javax.persistence.*;

@Entity
@Table(name = "CRIME")
public class Crime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "criminoso_id")
    private Criminoso criminoso;

    @ManyToOne
    @JoinColumn(name = "vitima_id")
    private Vitima vitima;

    @ManyToOne
    @JoinColumn(name = "arma_id")
    private Arma arma;

    Crime(Builder builder) {
        this.vitima = builder.vitima;
        this.arma = builder.arma;
        this.criminoso = builder.criminoso;
    }

    public static class Builder {
        public Criminoso criminoso;
        public Vitima vitima;
        public Arma arma;

        public Builder setCriminoso(Criminoso criminoso) {
            this.criminoso = criminoso;
            return this;
        }

        public Builder setVitima(Vitima vitima) {
            this.vitima = vitima;
            return this;
        }

        public Builder setArma(Arma arma) {
            this.arma = arma;
            return this;
        }

        public Crime build() {
            return new Crime(this);
        }

    }

    public int getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Crime{" +
                "id=" + id +
                ", criminoso=" + criminoso +
                ", vitima=" + vitima +
                ", arma=" + arma +
                '}';
    }

    public Criminoso getCriminoso() {
        return this.criminoso;
    }

    public Vitima getVitima() {
        return this.vitima;
    }

    public Arma getArma() {
        return this.arma;
    }

}
