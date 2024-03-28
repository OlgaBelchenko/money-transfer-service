package org.example.moneytransferservice.repository;

import org.example.moneytransferservice.model.Amount;

public class Transfer {
    private String cardFromNumber;
    private String cardFromValidTill;
    private String cardFromCVV;
    private String cardToNumber;
    private Amount amount;
}
