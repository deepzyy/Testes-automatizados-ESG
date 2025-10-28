
Feature: Gestão de Resíduos
  Como operador do sistema
  Quero criar e consultar resíduos
  Para garantir rastreabilidade e controle de peso (ESG - gestão de resíduos)

  Scenario: Criar resíduo com dados válidos (caminho feliz)
    Given que a API está disponível em "{BASE_URL}"
    When eu envio um POST para "/api/Residuo" com body:
      """
{
  "nome": "Plástico PET",
  "descricao": "Garrafa plástica",
  "peso": 1.2
}
"""

    Then o status HTTP deve ser 201
    And a resposta deve conter a propriedade "id"
    And a resposta deve validar contra o JSON Schema "Residuo"

  Scenario: Tentar criar resíduo sem campo obrigatório (caminho negativo)
    Given que a API está disponível em "{BASE_URL}"
    When eu envio um POST para "/api/Residuo" com body:
      """
{
  "descricao": "Sem nome",
  "peso": 0.5
}
"""

    Then o status HTTP deve ser 400
    And a mensagem de erro deve indicar que 'nome' é obrigatório
