package br.com.sandes.MyApi.data.vo.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serializable;
import java.util.Objects;

@JsonPropertyOrder({"id", "firstName", "gender", "address"})
public class PersonDTO implements Serializable {

    private final static long serialVersionUID = 1L;

    @JsonProperty("id")
    private Long key;

    private String name;
    private String gender;
    private String address;

    public Long getKey() {
        return key;
    }

    public void setKey(Long key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public PersonDTO(Long key, String name, String gender, String address) {
        this.key = key;
        this.name = name;
        this.gender = gender;
        this.address = address;
    }

    public PersonDTO(){
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonDTO personDTO = (PersonDTO) o;

        if (!key.equals(personDTO.key)) return false;
        if (!Objects.equals(name, personDTO.name)) return false;
        if (!Objects.equals(gender, personDTO.gender)) return false;
        return Objects.equals(address, personDTO.address);
    }

    @Override
    public int hashCode() {
        int result = key.hashCode();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }
}