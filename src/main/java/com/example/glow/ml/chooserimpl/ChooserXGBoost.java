package com.example.glow.ml.chooserimpl;

import com.example.glow.ml.Chooser;
import com.example.glow.ml.ClientForm;
import com.example.glow.ml.ClientLoanApprove;

import java.util.Random;

public class ChooserXGBoost implements Chooser {

    private static Random random = new Random();

    @Override
    public ClientLoanApprove chooseForClient(ClientForm form) {
        return ClientLoanApprove.values()[random.nextInt(3)];
    }
}
