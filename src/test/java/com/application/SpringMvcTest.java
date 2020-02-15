package com.application;

import com.application.controller.AooController;
import com.application.interfaces.Aoo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockitoTestExecutionListener;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.web.servlet.MockMvc;
import org.testng.annotations.Test;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author shenjies88
 * @since 2020/2/15-1:16 PM
 */
@WebMvcTest(controllers = AooController.class)
@TestExecutionListeners(listeners = MockitoTestExecutionListener.class)
public class SpringMvcTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private Aoo aoo;

    @Test
    public void testController() throws Exception {

        when(aoo.checkCodeDuplicate(anyString())).thenReturn(true);

        this.mvc.perform(get("/foo/check-code-dup").param("code", "123"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("true"));

    }
}
