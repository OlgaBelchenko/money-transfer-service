package org.example.moneytransferservice.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Transfer {
    @NotBlank(message = "Не введен номер карты")
    @Digits(integer = 16, fraction = 0, message = "Некорректный номер карты")
    private String cardFromNumber;

    @NotBlank(message = "Не введен срок действия карты")
    @Pattern(regexp = "(0[1-9]|1[0-2])/([0-9]{2})", message = "Некорректная дата")
    private String cardFromValidTill;

    @NotBlank(message = "Не введен CVV")
    @Digits(integer = 3, fraction = 0, message = "Некорректный формат CVV")
    private String cardFromCVV;

    @NotBlank(message = "Не введен номер карты")
    @Digits(integer = 16, fraction = 0, message = "Некорректный номер карты")
    private String cardToNumber;

    @Valid
    private Amount amount;

    private String id;

    String confirmationCode;

    @Override
    public String toString() {
        return "Transfer{\n" +
                "cardFromNumber='" + cardFromNumber + "\n" +
                ", cardFromValidTill='" + cardFromValidTill + "\n" +
                ", cardFromCVV='" + cardFromCVV + "\n" +
                ", cardToNumber='" + cardToNumber + "\n" +
                ", amount=" + amount + "\n" +
                ", id='" + id + "\n" +
                '}';
    }
}
