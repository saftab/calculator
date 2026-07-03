package fullStack.calculator.service;

import fullStack.calculator.controller.CalculatorController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CalculatorController.class)
public class CalculatorControllerTest {


    @Autowired
    private MockMvc mockMvc;


    @MockBean
    private CalculatorService calculatorService;


    @Test
    void shouldAddNumbers() throws Exception {


        when(calculatorService.add(2.0, 3.0))
                .thenReturn(5.0);

        mockMvc.perform(
                        post("/api/calculator/add")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content("""
                        {
                          "num1": 2,
                          "num2": 3
                        }
                        """))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result")
                        .value(5.0));
    }
}
