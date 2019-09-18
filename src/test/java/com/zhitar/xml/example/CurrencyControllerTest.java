package com.zhitar.xml.example;

import com.zhitar.xml.example.config.WebConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfig.class)
public class CurrencyControllerTest {

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;
    private TestUtil testUtil = new TestUtil();

    @Before
    public void setUp() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void handleXMLPostRequest() throws Exception {
        mockMvc.perform(post("/currency")
                .contentType(MediaType.APPLICATION_XML)
                .content(createExchangeInXml()))
                .andDo(print())
                .andExpect(status().isCreated());

        this.mockMvc.perform(get("/currency")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isOk());
    }

    private String createExchangeInXml() {
        return testUtil.getXmlFromFile("exchange.xml");
    }

}