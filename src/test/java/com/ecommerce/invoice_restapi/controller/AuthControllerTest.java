// package com.ecommerce.invoice_restapi.controller;

// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.boot.test.mock.mockito.MockBean;
// import org.springframework.boot.test.web.client.TestRestTemplate;
// import org.springframework.boot.test.web.server.LocalServerPort;
// import org.springframework.http.HttpEntity;
// import org.springframework.http.HttpHeaders;
// import org.springframework.http.HttpMethod;
// import org.springframework.http.ResponseEntity;

// import com.ecommerce.invoice_restapi.dao.BlackListedJWTTokenRepository;
// import com.ecommerce.invoice_restapi.filter.JWTReqeustFilter;
// import com.ecommerce.invoice_restapi.service.AuthService;


// @SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
// public class AuthControllerTest {
//     @LocalServerPort
//     private int port;
//     private TestRestTemplate restTemplateTester = new TestRestTemplate();
//     private HttpHeaders headers = new HttpHeaders();
    
//     @Autowired
//     private AuthService authService;
//     @MockBean
//     private BlackListedJWTTokenRepository blackListedJWTTokenRepository;
    
//     @BeforeEach
//     public void setup() {}

//     @Test
//     public void testHello() {
//         HttpEntity<String> entity = new HttpEntity<String>(null, headers);

//         ResponseEntity<String> response = restTemplateTester.exchange(
//           createURLWithPort("/"), HttpMethod.GET, entity, String.class);
//     }

//     private String createURLWithPort(String uri) {
//         return "http://localhost:" + port + uri;
//     }

  

// }
