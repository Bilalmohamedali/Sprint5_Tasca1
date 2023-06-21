package cat.itacademy.barcelonactiva.mohamedAli.bilal.s05.t01.n01.model.domain;


import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "sucursals")
public class Sucursal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer pk_SucursalID;
    @Column(name = "nomSucursal")
    String nomSucursal;
    @Column(name = "paisSucursal")
    String paisSucursal;

    public Sucursal(Integer pk_SucursalID, String nomSucursal, String paisSucursal) {
        this.pk_SucursalID = pk_SucursalID;
        this.nomSucursal = nomSucursal;
        this.paisSucursal = paisSucursal;
    }

    public Sucursal(String nomSucursal, String paisSucursal) {
        this.nomSucursal = nomSucursal;
        this.paisSucursal = paisSucursal;
    }

    public Sucursal() {
    }

    public Integer getPk_SucursalID() {
        return pk_SucursalID;
    }

    public void setPk_SucursalID(Integer pk_SucursalID) {
        this.pk_SucursalID = pk_SucursalID;
    }

    public String getNomSucursal() {
        return nomSucursal;
    }

    public void setNomSucursal(String nomSucursal) {
        this.nomSucursal = nomSucursal;
    }

    public String getPaisSucursal() {
        return paisSucursal;
    }

    public void setPaisSucursal(String paisSucursal) {
        this.paisSucursal = paisSucursal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sucursal sucursal = (Sucursal) o;
        return Objects.equals(pk_SucursalID, sucursal.pk_SucursalID) && Objects.equals(nomSucursal, sucursal.nomSucursal) && Objects.equals(paisSucursal, sucursal.paisSucursal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pk_SucursalID, nomSucursal, paisSucursal);
    }

    @Override
    public String toString() {
        return "Sucursal{" +
                "pk_SucursalID=" + pk_SucursalID +
                ", nomSucursal='" + nomSucursal + '\'' +
                ", paisSucursal='" + paisSucursal + '\'' +
                '}';
    }
}
