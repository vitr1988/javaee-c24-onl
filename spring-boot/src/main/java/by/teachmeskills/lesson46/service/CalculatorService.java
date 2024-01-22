package by.teachmeskills.lesson46.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    public int summa(int a, int b) {
        return a + b;
    }

    public int minus(int a, int b) {
        return summa(a, -b);
    }
}
