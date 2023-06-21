package cat.itacademy.barcelonactiva.mohamedAli.bilal.s05.t01.n01.model.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "sucursalsDTO")
public class SucursalDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer pk_SucursalID;
    @Column(name = "nomSucursal")
    private String nomSucursal;
    @Column(name = "paisSucursal")
    private String paisSucursal;
    @Column(name = "tipusSucursal")
    private String tipusSucursal;

    //private List<String> paisosUE = Arrays.asList("Ukraine","France","Spain","Sweden","Germany","Finland","Norway","Poland","Italy","United Kingdom","Romania","Belarus","Greece","Bulgaria","Iceland","Portugal","Czech Republic","Denmark","Hungary","Serbia","Austria","Ireland","Lithuania","Latvia","Croatia","Bosnia and Herzegovina","Slovakia","Estonia","Netherlands","Switzerland","Moldova","Belgium","Albania","Macedonia","Slovenia","Montenegro","Cyprus","Luxembourg","Faroe Is.","Andorra","Malta","Liechtenstein","Guernsey","San Marino","Gibraltar","Monaco","Vatican City");


    public SucursalDTO(Integer pk_SucursalID, String nomSucursal, String paisSucursal) {
        this.pk_SucursalID = pk_SucursalID;
        this.nomSucursal = nomSucursal;
        this.paisSucursal = paisSucursal;
        this.tipusSucursal = definirTipusSucursal(paisSucursal);
    }

    public SucursalDTO(String nomSucursal, String paisSucursal) {
        this.nomSucursal = nomSucursal;
        this.paisSucursal = paisSucursal;
        this.tipusSucursal = definirTipusSucursal(paisSucursal);
    }

    public SucursalDTO(Sucursal sucursal) {
        this.pk_SucursalID = sucursal.getPk_SucursalID();
        this.nomSucursal = sucursal.getNomSucursal();
        this.paisSucursal = sucursal.getPaisSucursal();
        this.tipusSucursal = definirTipusSucursal(paisSucursal);
    }

    public SucursalDTO() {
    }

    private String definirTipusSucursal(String paisSucursal) {
        List<String> paisesUE = Arrays.asList("Ukraine","France","Spain","Sweden","Germany","Finland","Norway","Poland","Italy","United Kingdom","Romania","Belarus","Greece","Bulgaria","Iceland","Portugal","Czech Republic","Denmark","Hungary","Serbia","Austria","Ireland","Lithuania","Latvia","Croatia","Bosnia and Herzegovina","Slovakia","Estonia","Netherlands","Switzerland","Moldova","Belgium","Albania","Macedonia","Slovenia","Montenegro","Cyprus","Luxembourg","Faroe Is.","Andorra","Malta","Liechtenstein","Guernsey","San Marino","Gibraltar","Monaco","Vatican City");
        if (paisesUE.stream().anyMatch(str ->str.equalsIgnoreCase(paisSucursal))){
            return "UE";
        }else {return "No UE";}
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

    public String getTipusSucursal() {
        return tipusSucursal;
    }

    public void setTipusSucursal(String tipusSucursal) {
        this.tipusSucursal = tipusSucursal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SucursalDTO that = (SucursalDTO) o;
        return Objects.equals(pk_SucursalID, that.pk_SucursalID) && Objects.equals(nomSucursal, that.nomSucursal) && Objects.equals(paisSucursal, that.paisSucursal) && Objects.equals(tipusSucursal, that.tipusSucursal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pk_SucursalID, nomSucursal, paisSucursal, tipusSucursal);
    }

    @Override
    public String toString() {
        return "SucursalDTO{" +
                "pk_SucursalID=" + pk_SucursalID +
                ", nomSucursal='" + nomSucursal + '\'' +
                ", paisSucursal='" + paisSucursal + '\'' +
                ", tipusSucursal='" + tipusSucursal + '\'' +
                '}';
    }
}
