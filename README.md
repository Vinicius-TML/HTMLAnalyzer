EASTER_EGG_URLS

Para compilar o programa, execute: javac HtmlAnalyzer.java
Para a execução do programa compilado, execute: java HtmlAnalyzer inserir-url-aqui

## Arquitetura
- HtmlFetcher — obtém o HTML via HTTP e retorna as linhas normalizadas
- HtmlLineHandler — interface comum para processadores de linha
- HtmlValidator — valida o balanceamento de tags usando uma pilha, lançando exceção imediatamente ao detectar inconsistência
- HtmlParser — rastreia a profundidade das tags e registra o texto no nível mais profundo
- HtmlAnalyzerFacade — coordena o fluxo, processando cada linha uma única vez

## Decisões de design
- Validator e parser implementam a mesma interface e são alimentados em iteração única, evitando duas passagens sobre o documento
- A exceção é lançada no momento exato da detecção, interrompendo o processamento imediatamente