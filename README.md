# 🌱 Testes Automatizados — Projeto ESG  

### 🧪 Qualidade de Software • FIAP • 2025  
**Autor:** Octavio Marim Franco Martins  

---

## 💡 Sobre o Projeto  

Este projeto tem como objetivo aplicar **práticas de Testes Automatizados** em um sistema **ESG (Environmental, Social & Governance)**, garantindo **rastreabilidade, confiabilidade e governança ambiental**.  

O foco foi desenvolver testes automatizados de **API** com **cenários BDD (Behavior Driven Development)** utilizando **Cucumber** e **RestAssured**, assegurando que as principais funcionalidades da aplicação respondam corretamente a interações positivas (caminhos felizes) e negativas (falhas).  

---

## 🧩 Estrutura do Projeto  

```
📦 Testes_Automatizados_ESG
├── features/
│   ├── residuo.feature
│   ├── pontos_de_descarte.feature
│   └── alertas.feature
│
├── schemas/
│   ├── Residuo.json
│   ├── PontoDeDescarte.json
│   ├── Coleta.json
│   └── Alerta.json
│
├── src/test/java/
│   ├── steps/
│   ├── runners/
│   └── utils/
│
├── pom.xml
├── README.md
└── ...
```

---

## 🧠 Tecnologias Utilizadas  

| Tecnologia | Função |
|-------------|--------|
| 🥒 **Cucumber (BDD)** | Escrita dos cenários em Gherkin (Given/When/Then) |
| ☕ **Java + JUnit** | Execução dos testes automatizados |
| 🌐 **RestAssured** | Testes de API REST e validação de respostas |
| 📄 **JSON Schema Validator** | Garantia de contrato entre requisição e resposta |
| ⚙️ **Maven** | Gerenciamento de dependências e build |
| 🚀 **GitHub Actions (CI/CD)** | Execução automatizada dos testes no pipeline |

---

## 🧪 Cenários de Teste BDD  

### 1️⃣ Gestão de Resíduos (`residuo.feature`)
- ✅ Criar resíduo com dados válidos (caminho feliz)  
- ❌ Criar resíduo com campo obrigatório ausente (caminho negativo)

### 2️⃣ Pontos de Descarte (`pontos_de_descarte.feature`)
- 🏗️ Criar ponto de descarte  
- 🗑️ Deletar ponto de descarte e verificar remoção

### 3️⃣ Alertas (`alertas.feature`)
- 🚨 Criar alerta associado a uma coleta existente  

Todos os cenários seguem a estrutura **Given / When / Then**, misturando português e inglês de forma técnica, garantindo clareza e rastreabilidade.

---

## ⚙️ Execução dos Testes  

### 🔹 **1. Clonar o repositório**
```bash
git clone https://github.com/SEU_USUARIO/Testes_Automatizados_ESG.git
cd Testes_Automatizados_ESG
```

### 🔹 **2. Executar localmente (via Maven)**
```bash
mvn clean test
```

### 🔹 **3. Gerar relatório Cucumber**
Após a execução, o relatório será gerado em:
```
target/cucumber-reports/
```

### 🔹 **4. Execução em pipeline (CI/CD)**
O projeto possui configuração compatível com **GitHub Actions**, permitindo integração automática e validação contínua.

---

## 🧾 Evidências  

O relatório e os prints anexados demonstram:  
✅ Execução bem-sucedida dos cenários;  
✅ Validação dos contratos JSON Schema;  
✅ Respostas HTTP com códigos esperados (200, 201, 400, 404);  
✅ Integração contínua via GitHub Actions.

---

## 🌍 Impacto ESG  

A automação de testes aqui implementada reforça a **governança e transparência** em aplicações que lidam com sustentabilidade, rastreabilidade de resíduos e gestão ambiental.  
Com testes automatizados e pipelines contínuos, garantimos **qualidade e confiabilidade** no ciclo de vida da aplicação.  

---

## 👨‍💻 Autor  

**Octavio Marim Franco Martins**  
📧 octavio.marim@fiap.com.br  
🎓 Faculdade de Informática e Administração Paulista (FIAP)  
📅 2025  

---

> _“Qualidade de software é sustentabilidade digital: o código que cuida do planeta.”_ 🌎✨
