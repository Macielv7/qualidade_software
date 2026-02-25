# CHANGELOG

## [0.2.0] - 2026-02-25

### Atualizado
- Cobertura de testes expandida com novos cenarios unitarios, web MVC e end-to-end.
- Configuracao de cobertura com JaCoCo adicionada ao Maven.
- Relatorio HTML de cobertura gerado em `target/site/jacoco/index.html`.
- Documentacao de diagramas UML de sequencia dos testes E2E criada em `docs/e2e-sequence-diagrams.md`.
- Remocao do arquivo `rtm.md`.

### Novos Testes
- `src/test/java/com/example/educationalqualityproject/service/TeacherServiceTest.java`
  - Cobre `getAllTeachers`, `getTeacherById`, `saveTeacher`, `deleteTeacher`, `existsByEmail`.
- `src/test/java/com/example/educationalqualityproject/controller/StudentControllerTest.java`
  - Cobre listagem, formulario de criacao, criacao, edicao, atualizacao e exclusao.
- `src/test/java/com/example/educationalqualityproject/controller/TeacherControllerTest.java`
  - Cobre listagem, formulario de criacao, criacao, edicao, atualizacao e exclusao.
- `src/test/java/com/example/educationalqualityproject/e2e/StudentApiE2ETest.java`
  - Cobre fluxos E2E de API para lista, criacao com sucesso, conflito por email, atualizacao inexistente e exclusao.
- `src/test/java/com/example/educationalqualityproject/e2e/TeacherApiE2ETest.java`
  - Cobre fluxos E2E de API para lista, criacao com sucesso, conflito por email, atualizacao inexistente e exclusao.
- `src/test/java/com/example/educationalqualityproject/e2e/StudentApiE2ETest.java`
  - Adicionado 1 teste E2E de desafio (`challengeTestShouldFailOnPurpose`) quebrado propositalmente, para o aluno corrigir a expectativa de status HTTP.
  - Comando para executar somente o teste quebrado: `mvn -q -Dtest=StudentApiE2ETest#challengeTestShouldFailOnPurpose test`

### Ajustes Tecnicos
- `pom.xml`
  - Inclusao do plugin `jacoco-maven-plugin` com `prepare-agent` e `report` na fase `verify`.

### Execucao e Resultado
- Comando executado: `mvn clean verify`
- Status: **SUCESSO**
- Cobertura global (JaCoCo):
  - Instrucoes: **74.23%** (484/652)
  - Branches: **30.00%** (12/40)
  - Metodos: **93.24%** (69/74)
