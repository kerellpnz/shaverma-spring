package com.kerellpnz.shavermaspring.domain;

import com.datastax.oss.driver.api.core.uuid.Uuids;
import com.kerellpnz.shavermaspring.domain.cassandra.ShavermaUDRUtils;
import com.kerellpnz.shavermaspring.domain.cassandra.ShavermaUDT;
import lombok.Data;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Data
@Table("orders")
public class ShavermaOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    @PrimaryKey
    private UUID id = Uuids.timeBased();
    @NotBlank
    private String deliveryName;
    @NotBlank
    private String deliveryStreet;
    @NotBlank
    private String deliveryCity;
    @NotBlank
    private String deliveryState;
    @NotBlank
    private String deliveryZip;
//    @CreditCardNumber(message="Not a valid credit card number")
    private String ccNumber;
    @Pattern(regexp="^(0[1-9]|1[0-2])([\\/])([2-9][0-9])$",
            message="Must be formatted MM/YY")
    private String ccExpiration;
    @Digits(integer=3, fraction=0, message="Invalid CVV")
    private String ccCVV;
    private Date placedAt;

    @Column("shavermas")
    private List<ShavermaUDT> shavermas = new ArrayList<>();

    public void addShaverma(Shaverma shaverma) {
        this.shavermas.add(ShavermaUDRUtils.toShavermaUDT(shaverma));
    }
}
