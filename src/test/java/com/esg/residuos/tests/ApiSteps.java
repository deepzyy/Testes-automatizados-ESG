package com.esg.residuos.tests;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Quando;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Então;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.junit.jupiter.api.Assertions.*;

import java.io.InputStream;

public class ApiSteps {
    private Response response;
    private String baseUrl;

    @Dado("que a API está disponível em {string}")
    public void base_url(String url) {
        this.baseUrl = url;
        RestAssured.baseURI = url;
    }

    @Quando("eu envio um POST para {string} com body:")
    public void post_com_body(String path, String body) {
        response = RestAssured.given()
            .header("Content-Type", "application/json")
            .body(body)
            .when()
            .post(path)
            .then()
            .extract().response();
    }

    @Quando("eu envio um DELETE para {string}")
    public void delete_path(String path) {
        response = RestAssured.given()
            .when()
            .delete(path)
            .then().extract().response();
    }

    @Quando("eu envio um DELETE para {string} com id {int}")
    public void delete_with_id(String path, int id) {
        String resolved = path.replace("{id}", String.valueOf(id));
        response = RestAssured.given().when().delete(resolved).then().extract().response();
    }

    @Entao("o status HTTP deve ser {int}")
    public void verifica_status(int status) {
        assertEquals(status, response.getStatusCode(), "HTTP status diferente do esperado. Body: " + response.asString());
    }

    @Entao("a resposta deve conter a propriedade {string}")
    public void resposta_contem_propriedade(String prop) {
        assertTrue(response.jsonPath().getMap("$").containsKey(prop), "Resposta não contém a propriedade: " + prop);
    }

    @Entao("a resposta deve validar contra o JSON Schema {string}")
    public void validar_schema(String schemaName) {
        InputStream is = getClass().getClassLoader().getResourceAsStream("schemas/" + schemaName + ".json");
        assertNotNull(is, "Schema não encontrado: " + schemaName + ".json");
        response.then().assertThat().body(matchesJsonSchemaInClasspath("schemas/" + schemaName + ".json"));
    }

    @Entao("a mensagem de erro deve indicar que 'nome' é obrigatório")
    public void mensagem_nome_obrigatorio() {
        String body = response.asString();
        assertTrue(body.toLowerCase().contains("nome") || body.toLowerCase().contains("required"), "Mensagem de erro não indica campo 'nome' obrigatório. Body: " + body);
    }

    @Quando("eu envio um POST para {string} com body salvo como {string}")
    public void post_with_saved_body(String path, String bodyResource) {
        InputStream is = getClass().getClassLoader().getResourceAsStream(bodyResource);
        String body = new java.util.Scanner(is, "UTF-8").useDelimiter("\\A").next();
        response = RestAssured.given().header("Content-Type", "application/json").body(body).post(path).then().extract().response();
    }

    @Entao("responda com {string} do ponto")
    public void resposta_com_id(String prop) {
        // just validate id exists
        assertTrue(response.jsonPath().getMap("$").containsKey("id"), "Resposta não contém id");
    }

    @Quando("eu envio um DELETE para {string} com o id retornado")
    public void delete_with_returned_id(String path) {
        Integer id = response.jsonPath().getInt("id");
        assertNotNull(id, "ID retornado é nulo");
        String resolved = path.replace("{id}", id.toString());
        response = RestAssured.given().when().delete(resolved).then().extract().response();
    }

    @Quando("eu enviar POST para {string} com body:")
    public void quando_enviar_post(String path, String body) {
        post_com_body(path, body);
    }

    @Entao("o alerta retornado deve ter {string} igual a {string}")
    public void alerta_mensagem_igual(String field, String expected) {
        assertEquals(expected, response.jsonPath().getString(field));
    }
}