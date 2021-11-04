package com.example.glow.ml.chooserimpl;

import com.example.glow.ml.Chooser;
import com.example.glow.ml.ClientForm;
import com.example.glow.ml.ClientLoanApprove;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class ChooserXGBoost implements Chooser {

    private static Random random = new Random();

    @Override
    public ClientLoanApprove chooseForClient(ClientForm form) {
        return new ClientLoanApprove();
    }
}
