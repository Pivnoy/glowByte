package com.example.glow.ml;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Random;
//
//@Component
//public enum ClientLoanApprove {
//    APPROVE("APPROVE"),
//    NOTHING,
//    DENIED;
//}


public class ClientLoanApprove {
    private static Random random = new Random();

    private final String [] enums = {"APPROVE", "NOTHING", "DENIED"};

    public String getPersonalDecision() {
        return enums[random.nextInt(3)];
    }
}
