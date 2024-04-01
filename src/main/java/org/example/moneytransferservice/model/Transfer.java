package org.example.moneytransferservice.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
public class Transfer {
    @NotBlank(message = "Введите номер карты")
    @Digits(integer = 16, fraction = 0, message = "Некорректный номер карты")
    private String cardFromNumber;

    @NotBlank(message = "Введите срок действия карты")
    @Pattern(regexp = "(0[1-9]|1[0-2])/([0-9]{2})", message = "Некорректная дата")
    private String cardFromValidTill;

    @NotBlank(message = "Введите CVV")
    @Digits(integer = 3, fraction = 0, message = "Некорректный формат CVV")
    private String cardFromCVV;

    @NotBlank(message = "Введите номер карты")
    @Digits(integer = 16, fraction = 0, message = "Некорректный номер карты")
    private String cardToNumber;

    @Valid
    private Amount amount;

    @Setter
    private long id;

    @Setter
    private boolean isConfirmed;
}
