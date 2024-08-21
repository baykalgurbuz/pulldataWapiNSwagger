package com.pulldataNswagger;

import com.pulldataNswagger.controllers.CalculatorController;
import com.pulldataNswagger.controllers.PostController;
import com.pulldataNswagger.services.CalculatorService;
import com.pulldataNswagger.services.CommentService;
import com.pulldataNswagger.services.PostService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CalculatorController.class)
public class CalculatorControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private CalculatorService calculatorService;

    @Test
    public void testAddOperation_Success() throws Exception {
        Mockito.when(calculatorService.add(3, 2)).thenReturn(5);

        mockMvc.perform(get("/soap/add")
                        .param("firstValue", "3")
                        .param("secondValue", "2")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("5"));
    }

    @Test
    public void testSubtractOperation_Success() throws Exception {
        Mockito.when(calculatorService.subtract(5, 3)).thenReturn(2);

        mockMvc.perform(get("/soap/subtract")
                        .param("firstValue", "5")
                        .param("secondValue", "3")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("2"));
    }

    @Test
    public void testMultiplyOperation_Success() throws Exception {
        Mockito.when(calculatorService.multiply(4, 3)).thenReturn(12);

        mockMvc.perform(get("/soap/multiply")
                        .param("firstValue", "4")
                        .param("secondValue", "3")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("12"));
    }

    @Test
    public void testDivideOperation_Success() throws Exception {
        Mockito.when(calculatorService.divide(10, 2)).thenReturn(5);

        mockMvc.perform(get("/soap/divide")
                        .param("firstValue", "10")
                        .param("secondValue", "2")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("5"));
    }

    @Test
    public void testDivideOperation_ZeroDivision() throws Exception {
        Mockito.when(calculatorService.divide(10, 0)).thenThrow(new ArithmeticException("Division by zero"));

        mockMvc.perform(get("/soap/divide")
                        .param("firstValue", "10")
                        .param("secondValue", "0")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }
}
