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
    private int index;

    private final String [] enums = {"APPROVE", "NOTHING", "DENIED"};

    public ClientLoanApprove(int index){
        this.index = index;
    }

    public String getPersonalDecision() {
        return enums[index];
    }
}
