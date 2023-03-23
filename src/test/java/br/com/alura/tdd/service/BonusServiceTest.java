package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BonusServiceTest {

    @Test
    void bonusDeveriaSerZeroParaFuncionarioComSalariaAlto(){
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(new Funcionario("Dorinaldo", LocalDate.now(),new BigDecimal("25000")));

        assertEquals(new BigDecimal("0.00"),bonus);
    }

    @Test
    void bonusDeveriaSerDezPorCentoDoSalario(){
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(new Funcionario("Dorinaldo", LocalDate.now(),new BigDecimal("2500")));

        assertEquals(new BigDecimal("250.00"),bonus);
    }

    @Test
    void bonusDeveriaSerDezPorCentoParaSalarioDe10000(){
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(new Funcionario("Dorinaldo", LocalDate.now(),new BigDecimal("1000")));

        assertEquals(new BigDecimal("100.00"),bonus);
    }
}
