
Feature: Pontos de Descarte
  Scenario: Criar e depois deletar um ponto de descarte
    Given que a API está disponível em "{BASE_URL}"
    When eu envio um POST para "/api/PontosDeDescarte" com body:
      """
{
  "nome": "Ponto Central",
  "endereco": "Rua A, 123",
  "cidade": "São Paulo",
  "estado": "SP",
  "quantidadeAtualKg": 0
}
"""

    Then o status HTTP deve ser 201
    And responda com "id" do ponto
    When eu envio um DELETE para "/api/PontosDeDescarte/{id}"
    Then o status HTTP deve ser 200
    And a consulta GET para "/api/PontosDeDescarte/{id}" deve retornar 404
