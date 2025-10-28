
Feature: Alertas
  Scenario: Criar alerta associado a uma coleta existente
    Given existe uma coleta com id 10
    And a API está disponível em "{BASE_URL}"
    When eu enviar POST para "/api/Alerta" com body:
      """
{
  "mensagem": "Coleta atrasada",
  "coletaId": 10
}
"""

    Then o status deve ser 201
    And o alerta retornado deve ter "mensagem" igual a "Coleta atrasada"
    And a resposta valida contra o JSON Schema "Alerta"
