package com.example.projetoexpo.data.repository

import com.example.projetoexpo.domain.model.CareerTrail
import com.example.projetoexpo.domain.model.JobOpportunity
import com.example.projetoexpo.domain.model.SkillLevel
import com.example.projetoexpo.domain.model.TrailStep

/**
 * Repositório Mock completo com 10 Trilhas de Carreira para o "GPS de Carreira".
 * Cada trilha inclui:
 * - 5 passos didáticos detalhados com dicas práticas.
 * - Faixa salarial inicial estimada no mercado brasileiro.
 * - Indicador de demanda e tags de competências.
 * - 2 Vagas simuladas (Estágio / Júnior) para reforçar o impacto de empregabilidade (ODS 8).
 */
class CareerMockRepository {

    // 1. Trilha: Front-end Web
    private val frontendTrail = CareerTrail(
        id = "trilha-frontend",
        title = "Desenvolvedor(a) Front-end Web",
        targetRole = "Desenvolvedor Web Júnior",
        description = "Mapeamento completo para construir interfaces web modernas, interativas e acessíveis utilizando HTML, CSS, JavaScript e React.",
        category = "Desenvolvimento & Software",
        estimatedMonths = 6,
        level = SkillLevel.INICIANTE,
        salaryRange = "R$ 2.800 - R$ 4.500",
        marketDemand = "Alta Demanda 🔥",
        keySkills = listOf("HTML5/CSS3", "JavaScript ES6+", "React.js", "Git/GitHub", "APIs REST"),
        mockJobs = listOf(
            JobOpportunity(
                id = "job-fe-1",
                title = "Estágio em Desenvolvimento Front-end",
                company = "TechNext Soluções Digitais",
                location = "100% Remoto",
                salary = "R$ 1.800 + Benefícios",
                matchScore = 98
            ),
            JobOpportunity(
                id = "job-fe-2",
                title = "Desenvolvedor Web Júnior (React)",
                company = "InovaHub Tecnologia",
                location = "Híbrido - São Paulo",
                salary = "R$ 3.500 CLT",
                matchScore = 92
            )
        ),
        steps = listOf(
            TrailStep(
                id = "fe-1",
                title = "1. Fundamentos da Web & Versionamento",
                description = "Entenda como a internet funciona (DNS, HTTP/HTTPS, navegadores), lógica de algoritmos e controle de versão profissional com Git & GitHub.",
                category = "Fundamentos",
                estimatedHours = 20,
                resourceTip = "Dica: Crie uma conta no GitHub e suba seus primeiros códigos versionados."
            ),
            TrailStep(
                id = "fe-2",
                title = "2. HTML5 Semântico & CSS3 Moderno",
                description = "Domine acessibilidade (a11y), tags semânticas, layouts responsivos para celular e desktop utilizando Flexbox e CSS Grid.",
                category = "Interface",
                estimatedHours = 35,
                resourceTip = "Dica: Pratique recriando a landing page de um produto real como Spotify ou Netflix."
            ),
            TrailStep(
                id = "fe-3",
                title = "3. JavaScript Moderno (ES6+)",
                description = "Manipulação do DOM, funções assíncronas (Promises/Async-Await), consumo de APIs REST públicas e boas práticas de lógica.",
                category = "Lógica & Dinamismo",
                estimatedHours = 50,
                resourceTip = "Dica: Construa um aplicativo de consulta de CEP e clima consumindo APIs públicas gratuitas."
            ),
            TrailStep(
                id = "fe-4",
                title = "4. Criação de SPAs com React.js",
                description = "Componentização, props, gerenciamento de estado reativo com hooks (useState, useEffect) e navegação entre páginas.",
                category = "Frameworks",
                estimatedHours = 60,
                resourceTip = "Dica: Estruture componentes limpos e reutilizáveis separando lógica de UI."
            ),
            TrailStep(
                id = "fe-5",
                title = "5. Projeto Final & Portfólio de Empregabilidade",
                description = "Construção de um portfólio completo hospedado na Vercel com 3 projetos práticos e preparação do perfil do LinkedIn para vagas júnior.",
                category = "Portfólio & Carreira",
                estimatedHours = 30,
                resourceTip = "Dica: Grave um vídeo pitch de 2 minutos demonstrando seus projetos em funcionamento."
            )
        )
    )

    // 2. Trilha: Back-end & APIs
    private val backendTrail = CareerTrail(
        id = "trilha-backend",
        title = "Desenvolvedor(a) Back-end & APIs",
        targetRole = "Desenvolvedor Back-end Júnior",
        description = "Aprenda a estruturar servidores seguros, criar APIs REST robustas, modelar bancos de dados relacionais e implementar autenticação.",
        category = "Desenvolvimento & Software",
        estimatedMonths = 6,
        level = SkillLevel.INICIANTE,
        salaryRange = "R$ 3.000 - R$ 5.000",
        marketDemand = "Alta Demanda 🔥",
        keySkills = listOf("Node.js / Java", "SQL / PostgreSQL", "APIs RESTful", "JWT & Auth", "Docker"),
        mockJobs = listOf(
            JobOpportunity(
                id = "job-be-1",
                title = "Desenvolvedor Back-end Jr (Node.js)",
                company = "CloudScale Sistemas",
                location = "100% Remoto",
                salary = "R$ 3.800 CLT",
                matchScore = 95
            ),
            JobOpportunity(
                id = "job-be-2",
                title = "Estágio em Engenharia de Software (Back-end)",
                company = "Banco Digital Alpha",
                location = "Híbrido - Barueri / SP",
                salary = "R$ 2.400 + Auxílio",
                matchScore = 90
            )
        ),
        steps = listOf(
            TrailStep(
                id = "be-1",
                title = "1. Lógica Avançada & POO",
                description = "Programação orientada a objetos (POO), tipos de dados, maps, estruturas de dados e manipulação de arquivos com Node.js ou Java/Kotlin.",
                category = "Fundamentos",
                estimatedHours = 25,
                resourceTip = "Dica: Resolva exercícios práticos de lógica em plataformas como LeetCode ou Beecrowd."
            ),
            TrailStep(
                id = "be-2",
                title = "2. Modelagem de Bancos de Dados Relacionais (SQL)",
                description = "Criação de tabelas, chaves primárias e estrangeiras, consultas SQL (SELECT, JOIN, GROUP BY) usando PostgreSQL ou MySQL.",
                category = "Banco de Dados",
                estimatedHours = 35,
                resourceTip = "Dica: Desenhe o diagrama Entidade-Relacionamento (DER) de um sistema de e-commerce."
            ),
            TrailStep(
                id = "be-3",
                title = "3. Construção de APIs RESTful",
                description = "Arquitetura MVC, rotas HTTP (GET, POST, PUT, DELETE), códigos de status (200, 400, 404, 500) e validação de payloads JSON.",
                category = "APIs & Serviços",
                estimatedHours = 45,
                resourceTip = "Dica: Use o Postman ou Insomnia para testar e documentar todos os endpoints da sua API."
            ),
            TrailStep(
                id = "be-4",
                title = "4. Autenticação, Autorização & Segurança (JWT)",
                description = "Criptografia de senhas (bcrypt), emissão de tokens JWT, middlewares de proteção de rotas e prevenção contra ataques comuns (SQL Injection, CORS).",
                category = "Segurança",
                estimatedHours = 40,
                resourceTip = "Dica: Implemente um fluxo completo de login e registro com expiração de token."
            ),
            TrailStep(
                id = "be-5",
                title = "5. Deploy em Nuvem & Containerização com Docker",
                description = "Criação de containers Docker para a aplicação e o banco, e deploy gratuito em serviços como Render ou Railway.",
                category = "DevOps & Deploy",
                estimatedHours = 30,
                resourceTip = "Dica: Disponibilize sua API online com Swagger/OpenAPI para recrutadores testarem."
            )
        )
    )

    // 3. Trilha: Mobile Android (Kotlin & Compose)
    private val mobileTrail = CareerTrail(
        id = "trilha-mobile",
        title = "Desenvolvedor(a) Mobile Android Nativo",
        targetRole = "Desenvolvedor Android Júnior",
        description = "Aprenda a construir aplicativos modernos para smartphones Android utilizando a linguagem Kotlin, Jetpack Compose, MVVM e Coroutines.",
        category = "Mobile & Aplicativos",
        estimatedMonths = 6,
        level = SkillLevel.INICIANTE,
        salaryRange = "R$ 3.200 - R$ 5.200",
        marketDemand = "Alta Demanda 🔥",
        keySkills = listOf("Kotlin", "Jetpack Compose", "MVVM / Clean", "Coroutines & Flow", "DataStore / Room"),
        mockJobs = listOf(
            JobOpportunity(
                id = "job-mob-1",
                title = "Desenvolvedor Android Jr (Kotlin)",
                company = "AppMasters Studio",
                location = "100% Remoto",
                salary = "R$ 4.000 CLT",
                matchScore = 96
            ),
            JobOpportunity(
                id = "job-mob-2",
                title = "Estágio em Desenvolvimento Android",
                company = "Fintech Moeda Ágil",
                location = "Híbrido - Curitiba / PR",
                salary = "R$ 2.000 + Benefícios",
                matchScore = 91
            )
        ),
        steps = listOf(
            TrailStep(
                id = "mob-1",
                title = "1. Fundamentos da Linguagem Kotlin",
                description = "Variáveis, null safety (validação de nulos), data classes, lambdas, funções de extensão e coleções no Kotlin.",
                category = "Linguagem",
                estimatedHours = 25,
                resourceTip = "Dica: Pratique resolvendo desafios no Kotlin Playground online."
            ),
            TrailStep(
                id = "mob-2",
                title = "2. UI Moderna com Jetpack Compose",
                description = "Paradigma declarativo, funções @Composable, Layouts (Column, Row, Box, LazyColumn), Material 3 e temas.",
                category = "Interface",
                estimatedHours = 40,
                resourceTip = "Dica: Construa a réplica visual de telas populares de aplicativos como Uber ou Twitter."
            ),
            TrailStep(
                id = "mob-3",
                title = "3. Arquitetura MVVM, StateFlow & Navegação",
                description = "Separação de responsabilidades com ViewModel, gerenciamento de estado reativo com StateFlow e rotas com Navigation Compose.",
                category = "Arquitetura",
                estimatedHours = 45,
                resourceTip = "Dica: Garanta o fluxo unidirecional de dados (UDF) nas suas telas."
            ),
            TrailStep(
                id = "mob-4",
                title = "4. Persistência Local & Consumo de APIs (Retrofit)",
                description = "Armazenamento local com DataStore/Room e consumo assíncrono de APIs REST usando Coroutines e Retrofit.",
                category = "Dados & Rede",
                estimatedHours = 45,
                resourceTip = "Dica: Crie um app offline-first que salva as notícias lidas no banco local."
            ),
            TrailStep(
                id = "mob-5",
                title = "5. Publicação na Google Play & Portfólio no GitHub",
                description = "Geração de APK/AAB assinado, boas práticas de segurança, criação de README profissional com GIFs dos apps.",
                category = "Portfólio & Carreira",
                estimatedHours = 25,
                resourceTip = "Dica: Suba ao menos 2 apps completos com código limpo e arquitetura MVVM no seu GitHub."
            )
        )
    )

    // 4. Trilha: Suporte Técnico & Infraestrutura
    private val suporteTechTrail = CareerTrail(
        id = "trilha-suporte",
        title = "Analista de Suporte Técnico & Redes",
        targetRole = "Técnico de Suporte TI / Helpdesk N1",
        description = "Capacitação prática para diagnóstico e manutenção de computadores, redes locais, sistemas operacionais e atendimento humanizado ao usuário.",
        category = "Infraestrutura & Suporte",
        estimatedMonths = 4,
        level = SkillLevel.INICIANTE,
        salaryRange = "R$ 2.000 - R$ 3.200",
        marketDemand = "Porta de Entrada Rápida 🚀",
        keySkills = listOf("Hardware & PCs", "Windows & Linux", "Redes IP / DNS", "Helpdesk ITIL", "Backup & Segurança"),
        mockJobs = listOf(
            JobOpportunity(
                id = "job-sup-1",
                title = "Analista de Suporte N1 (Helpdesk)",
                company = "Global Service Desk",
                location = "Híbrido - Centro",
                salary = "R$ 2.400 CLT + VR",
                matchScore = 97
            ),
            JobOpportunity(
                id = "job-sup-2",
                title = "Técnico de Campo & Redes",
                company = "InfraTech Redes",
                location = "Presencial - Zona Sul",
                salary = "R$ 2.600 + Periculosidade",
                matchScore = 89
            )
        ),
        steps = listOf(
            TrailStep(
                id = "sup-1",
                title = "1. Arquitetura de Computadores & Hardware",
                description = "Identificação de componentes, montagem, manutenção preventiva/corretiva de desktops e substituição de periféricos.",
                category = "Hardware",
                estimatedHours = 20,
                resourceTip = "Dica: Pratique diagnosticar defeitos comuns como problemas de memória RAM e fonte de alimentação."
            ),
            TrailStep(
                id = "sup-2",
                title = "2. Sistemas Operacionais (Windows & Linux)",
                description = "Instalação, formatação, gerenciamento de contas de usuário, permissões de pastas e automação básica com terminal (CMD/PowerShell/Bash).",
                category = "Sistemas Operacionais",
                estimatedHours = 35,
                resourceTip = "Dica: Crie uma máquina virtual Linux no VirtualBox para treinar comandos de terminal."
            ),
            TrailStep(
                id = "sup-3",
                title = "3. Fundamentos de Redes de Computadores",
                description = "Endereçamento IP (IPv4/IPv6), máscaras de rede, roteadores, switches, servidores DHCP, DNS e crimpagem de cabos de rede RJ-45.",
                category = "Redes",
                estimatedHours = 40,
                resourceTip = "Dica: Use o simulador Cisco Packet Tracer para montar uma rede corporativa fictícia."
            ),
            TrailStep(
                id = "sup-4",
                title = "4. Ferramentas de Helpdesk & Boas Práticas ITIL",
                description = "Gestão de chamados (SLA, prioridades, abertura e fechamento de tickets), comunicação assertiva e atendimento ao cliente.",
                category = "Processos & Atendimento",
                estimatedHours = 25,
                resourceTip = "Dica: Estude os conceitos de Incidentes vs Requisições no padrão ITIL."
            ),
            TrailStep(
                id = "sup-5",
                title = "5. Segurança da Informação & Rotinas de Backup",
                description = "Configuração de antivírus corporativo, políticas de backup em nuvem, prevenção contra phishing e roteiros de suporte preventivo.",
                category = "Segurança",
                estimatedHours = 30,
                resourceTip = "Dica: Monte um checklist padrão de segurança para auditoria em estações de trabalho."
            )
        )
    )

    // 5. Trilha: Análise de Dados & BI
    private val dataAnalyticsTrail = CareerTrail(
        id = "trilha-dados",
        title = "Analista de Dados & Business Intelligence (BI)",
        targetRole = "Analista de Dados Júnior",
        description = "Capacitação para coletar, tratar e transformar dados brutos em dashboards visuais interativos que apoiam tomadas de decisão estratégicas.",
        category = "Dados & Inteligência",
        estimatedMonths = 5,
        level = SkillLevel.INICIANTE,
        salaryRange = "R$ 3.000 - R$ 4.800",
        marketDemand = "Alta Demanda 🔥",
        keySkills = listOf("Excel Avançado", "SQL Analítico", "Power BI / DAX", "Python / Pandas", "Storytelling"),
        mockJobs = listOf(
            JobOpportunity(
                id = "job-da-1",
                title = "Analista de BI Júnior (Power BI)",
                company = "DataMetrics Consultoria",
                location = "100% Remoto",
                salary = "R$ 3.600 CLT",
                matchScore = 95
            ),
            JobOpportunity(
                id = "job-da-2",
                title = "Estágio em Inteligência de Mercado / Dados",
                company = "Grupo Varejo Brasil",
                location = "Híbrido - SP",
                salary = "R$ 2.100 + Benefícios",
                matchScore = 93
            )
        ),
        steps = listOf(
            TrailStep(
                id = "da-1",
                title = "1. Excel Avançado & Manipulação de Planilhas",
                description = "Fórmulas avançadas (PROCV, XLOOKUP, SE/SEERRO), tabelas dinâmicas, gráficos comparativos e limpeza inicial de dados.",
                category = "Fundamentos",
                estimatedHours = 20,
                resourceTip = "Dica: Crie uma planilha automatizada de controle financeiro mensal com gráficos interativos."
            ),
            TrailStep(
                id = "da-2",
                title = "2. SQL para Extração e Análise de Dados",
                description = "Consultas analíticas com filtros complexos, agregações estatísticas (SUM, AVG, COUNT), agrupamentos e subqueries.",
                category = "Banco de Dados",
                estimatedHours = 35,
                resourceTip = "Dica: Pratique em datasets públicos do Kaggle sobre vendas e comportamento de clientes."
            ),
            TrailStep(
                id = "da-3",
                title = "3. Criação de Dashboards com Power BI",
                description = "Importação de múltiplas fontes de dados, modelagem estrela (Star Schema), criação de medidas em linguagem DAX e design de relatórios.",
                category = "Visualização de Dados",
                estimatedHours = 45,
                resourceTip = "Dica: Desenvolva um dashboard executivo com indicadores-chave de desempenho (KPIs)."
            ),
            TrailStep(
                id = "da-4",
                title = "4. Introdução a Python para Análise de Dados (Pandas)",
                description = "Uso de Jupyter Notebooks, importação de arquivos CSV, filtragem e tratamento de dados faltantes com a biblioteca Pandas.",
                category = "Programação Analítica",
                estimatedHours = 40,
                resourceTip = "Dica: Escreva um script em Python que identifique padrões e tendências em uma base de vendas."
            ),
            TrailStep(
                id = "da-5",
                title = "5. Storytelling com Dados & Apresentação de Insights",
                description = "Técnicas de comunicação executiva, escolha assertiva de gráficos para cada tipo de problema e elaboração de relatórios de impacto.",
                category = "Negócios & Apresentação",
                estimatedHours = 25,
                resourceTip = "Dica: Publique um estudo de caso no LinkedIn explicando os insights descobertos no seu dashboard."
            )
        )
    )

    // 6. Trilha: Design UI/UX
    private val uiUxDesignTrail = CareerTrail(
        id = "trilha-ux",
        title = "Designer de Interface & Experiência (UI/UX)",
        targetRole = "Designer UI/UX Júnior",
        description = "Aprenda a pesquisar necessidades de usuários, desenhar fluxos intuitivos, criar protótipos interativos no Figma e construir Design Systems.",
        category = "Design & Produto",
        estimatedMonths = 4,
        level = SkillLevel.INICIANTE,
        salaryRange = "R$ 2.800 - R$ 4.500",
        marketDemand = "Em Expansão 🌟",
        keySkills = listOf("Figma", "Design Thinking", "Wireframing", "Acessibilidade (WCAG)", "Prototipagem"),
        mockJobs = listOf(
            JobOpportunity(
                id = "job-ux-1",
                title = "Designer UI/UX Júnior",
                company = "PixelCraft Design Studio",
                location = "100% Remoto",
                salary = "R$ 3.400 PJ",
                matchScore = 96
            ),
            JobOpportunity(
                id = "job-ux-2",
                title = "Estágio em Product Design",
                company = "EduTech Brasil",
                location = "Híbrido - Florianópolis / SC",
                salary = "R$ 1.900 + Bolsa",
                matchScore = 90
            )
        ),
        steps = listOf(
            TrailStep(
                id = "ux-1",
                title = "1. Fundamentos de UX & Pesquisa com Usuários",
                description = "Etapas do Design Thinking, mapeamento de personas, jornadas do usuário, entrevistas e identificação de dores reais.",
                category = "Pesquisa & UX",
                estimatedHours = 20,
                resourceTip = "Dica: Faça uma pesquisa rápida com 3 pessoas para entender dificuldades em um app conhecido."
            ),
            TrailStep(
                id = "ux-2",
                title = "2. Arquitetura de Informação & Wireframes",
                description = "Organização de menus, fluxogramas de navegação (User Flows) e criação de wireframes de baixa fidelidade para validar ideias.",
                category = "Estrutura",
                estimatedHours = 25,
                resourceTip = "Dica: Desenhe a estrutura de telas de um app de entregas no papel antes de ir para o software."
            ),
            TrailStep(
                id = "ux-3",
                title = "3. Design Visual (UI) no Figma",
                description = "Domínio de auto-layout, componentes, variantes, tipografia, contraste de cores (WCAG) e grids para web e mobile.",
                category = "Interface Visual",
                estimatedHours = 45,
                resourceTip = "Dica: Crie uma biblioteca de botões, inputs e cards reutilizáveis no Figma."
            ),
            TrailStep(
                id = "ux-4",
                title = "4. Prototipagem Interativa & Testes de Usabilidade",
                description = "Criação de transições animadas entre telas, micro-interações, condução de testes de usabilidade e coleta de feedback.",
                category = "Prototipagem",
                estimatedHours = 30,
                resourceTip = "Dica: Envie o link do protótipo navegável para amigos testarem e observe onde eles clicam."
            ),
            TrailStep(
                id = "ux-5",
                title = "5. Montagem de Case de Estudo & Portfólio (Behance/Notion)",
                description = "Estruturação de um case completo explicando o problema, o processo de pesquisa, as iterações e a solução final aprovada.",
                category = "Portfólio & Carreira",
                estimatedHours = 25,
                resourceTip = "Dica: Publique o estudo de caso no Behance ou Notion com imagens de alta qualidade."
            )
        )
    )

    // 7. Trilha: Qualidade de Software & Testes (QA)
    private val qaTrail = CareerTrail(
        id = "trilha-qa",
        title = "Analista de Qualidade de Software & Testes (QA)",
        targetRole = "Analista de QA Júnior",
        description = "Aprenda a garantir a qualidade de sistemas digitais através de planos de testes manuais, testes de API no Postman e automação básica.",
        category = "Qualidade & Testes",
        estimatedMonths = 4,
        level = SkillLevel.INICIANTE,
        salaryRange = "R$ 2.800 - R$ 4.200",
        marketDemand = "Alta Demanda 🔥",
        keySkills = listOf("Planos de Testes", "Testes Manuais / E2E", "Postman / APIs", "Jira / Bug Tracking", "Automação Básica"),
        mockJobs = listOf(
            JobOpportunity(
                id = "job-qa-1",
                title = "Analista de Testes / QA Júnior",
                company = "QualiCode Soluções",
                location = "100% Remoto",
                salary = "R$ 3.200 CLT",
                matchScore = 97
            ),
            JobOpportunity(
                id = "job-qa-2",
                title = "Estágio em Garantia de Qualidade",
                company = "E-Commerce Prime",
                location = "Híbrido - Belo Horizonte / MG",
                salary = "R$ 1.850 + VR",
                matchScore = 91
            )
        ),
        steps = listOf(
            TrailStep(
                id = "qa-1",
                title = "1. Fundamentos do Teste de Software & Ciclo de Vida (STLC)",
                description = "Conceitos de defeito, falha, erro, pirâmide de testes e tipos de testes (funcionais, regressão, fumaça e carga).",
                category = "Fundamentos",
                estimatedHours = 20,
                resourceTip = "Dica: Estude os princípios básicos do syllabus do ISTQB para testes de software."
            ),
            TrailStep(
                id = "qa-2",
                title = "2. Criação de Planos de Testes e Cenários de Teste",
                description = "Elaboração de casos de testes detalhados com BDD (Gherkin: Dado/Quando/Então) e critérios de aceitação.",
                category = "Processos",
                estimatedHours = 25,
                resourceTip = "Dica: Escreva os cenários de teste para a funcionalidade de checkout de uma loja online."
            ),
            TrailStep(
                id = "qa-3",
                title = "3. Gestão de Bugs com Jira e Trello",
                description = "Como reportar bugs de forma clara (passos para reproduzir, comportamento esperado vs obtido, evidências e logs).",
                category = "Gestão",
                estimatedHours = 20,
                resourceTip = "Dica: Crie um relatório de bug exemplar com capturas de tela e passos precisos."
            ),
            TrailStep(
                id = "qa-4",
                title = "4. Testes de APIs REST com Postman",
                description = "Envio de requisições, validação de códigos de resposta HTTP, testes de contrato JSON e escrita de asserções em JavaScript.",
                category = "Testes de API",
                estimatedHours = 35,
                resourceTip = "Dica: Crie uma coleção automatizada no Postman que executa testes em sequência."
            ),
            TrailStep(
                id = "qa-5",
                title = "5. Introdução à Automação de Testes (Cypress / Selenium)",
                description = "Configuração do ambiente Cypress, escrita de testes automatizados de ponta a ponta (E2E) para telas de login e formulários.",
                category = "Automação",
                estimatedHours = 35,
                resourceTip = "Dica: Grave um vídeo curto demonstrando seu script do Cypress rodando testes sozinho."
            )
        )
    )

    // 8. Trilha: Segurança da Informação & Cibersegurança
    private val cyberSecurityTrail = CareerTrail(
        id = "trilha-ciberseguranca",
        title = "Analista de Cibersegurança & SOC N1",
        targetRole = "Analista de Segurança Júnior",
        description = "Capacitação em proteção de redes, análise de vulnerabilidades, monitoramento de incidentes de segurança e conformidade (LGPD).",
        category = "Segurança & Infraestrutura",
        estimatedMonths = 6,
        level = SkillLevel.INICIANTE,
        salaryRange = "R$ 3.500 - R$ 5.500",
        marketDemand = "Altíssima Demanda 🚀",
        keySkills = listOf("Criptografia", "Redes & Firewalls", "Monitoramento de Logs / SIEM", "LGPD / Compliance", "Análise de Vulnerabilidades"),
        mockJobs = listOf(
            JobOpportunity(
                id = "job-sec-1",
                title = "Operador de SOC N1 (Segurança)",
                company = "CyberShield Brasil",
                location = "Híbrido - São Paulo / SP",
                salary = "R$ 3.900 CLT + Noturno",
                matchScore = 96
            ),
            JobOpportunity(
                id = "job-sec-2",
                title = "Estágio em Segurança da Informação",
                company = "Seguradora Protege",
                location = "100% Remoto",
                salary = "R$ 2.200 + Seguro",
                matchScore = 92
            )
        ),
        steps = listOf(
            TrailStep(
                id = "sec-1",
                title = "1. Fundamentos da Cibersegurança & Tríade CIA",
                description = "Confidencialidade, Integridade, Disponibilidade, engenharia social, tipos de malware (Ransomware, Trojan) e ameaças modernas.",
                category = "Fundamentos",
                estimatedHours = 25,
                resourceTip = "Dica: Complete o curso introdutório gratuito do Cisco Networking Academy sobre Cybersecurity."
            ),
            TrailStep(
                id = "sec-2",
                title = "2. Redes Seguras, Firewalls e Criptografia",
                description = "Protocolos seguros (HTTPS, SSH, VPNs), chaves simétricas e assimétricas, certificados digitais e regras de firewall.",
                category = "Redes & Defesa",
                estimatedHours = 40,
                resourceTip = "Dica: Use o Wireshark para analisar tráfego de rede e identificar pacotes não criptografados."
            ),
            TrailStep(
                id = "sec-3",
                title = "3. Análise de Vulnerabilidades & Hardening",
                description = "Identificação de brechas comuns (OWASP Top 10), aplicação de patches de segurança e endurecimento (hardening) de servidores.",
                category = "Prevenção",
                estimatedHours = 35,
                resourceTip = "Dica: Pratique desafios éticos em plataformas seguras como TryHackMe e OverTheWire."
            ),
            TrailStep(
                id = "sec-4",
                title = "4. Monitoramento de Incidentes (SOC) e Leitura de Logs",
                description = "Análise de logs de autenticação, alertas de segurança, identificação de acessos suspeitos e uso de ferramentas SIEM.",
                category = "Detecção",
                estimatedHours = 35,
                resourceTip = "Dica: Simule a triagem de um alerta de ataque de força bruta em logs de servidor."
            ),
            TrailStep(
                id = "sec-5",
                title = "5. Governança, LGPD e Resposta a Incidentes",
                description = "Princípios da Lei Geral de Proteção de Dados (LGPD), planos de continuidade de negócios e protocolos de contenção de crises.",
                category = "Governança & Carreira",
                estimatedHours = 25,
                resourceTip = "Dica: Monte um plano resumido de resposta para um incidente fictício de vazamento de dados."
            )
        )
    )

    // 9. Trilha: DevOps & Cloud Computing
    private val devOpsTrail = CareerTrail(
        id = "trilha-devops",
        title = "Analista Cloud & Fundamentos DevOps",
        targetRole = "Analista Cloud / DevOps Júnior",
        description = "Aprenda a automatizar entregas de software, gerenciar servidores em nuvem (AWS/Azure) e criar pipelines de integração contínua (CI/CD).",
        category = "Cloud & Infraestrutura",
        estimatedMonths = 5,
        level = SkillLevel.INICIANTE,
        salaryRange = "R$ 3.500 - R$ 5.500",
        marketDemand = "Alta Demanda 🔥",
        keySkills = listOf("Linux Avançado", "Docker & Containers", "AWS / Azure Básico", "GitHub Actions / CI-CD", "Infra as Code"),
        mockJobs = listOf(
            JobOpportunity(
                id = "job-devops-1",
                title = "Analista Cloud Júnior (AWS)",
                company = "CloudOps Soluções",
                location = "100% Remoto",
                salary = "R$ 4.200 CLT",
                matchScore = 95
            ),
            JobOpportunity(
                id = "job-devops-2",
                title = "Estágio em Automação DevOps",
                company = "Software House Alfa",
                location = "Híbrido - Campinas / SP",
                salary = "R$ 2.300 + Benefícios",
                matchScore = 90
            )
        ),
        steps = listOf(
            TrailStep(
                id = "do-1",
                title = "1. Administração Linux & Scripting com Bash",
                description = "Navegação avançada no terminal, gerenciamento de processos, automação de tarefas rotineiras com scripts Bash e permissões.",
                category = "Fundamentos",
                estimatedHours = 25,
                resourceTip = "Dica: Escreva um script em Bash que faz backup automático de uma pasta para outro diretório."
            ),
            TrailStep(
                id = "do-2",
                title = "2. Containerização com Docker",
                description = "Criação de Dockerfiles otimizados, gerenciamento de imagens, volumes, redes virtuais e orquestração local com Docker Compose.",
                category = "Containers",
                estimatedHours = 35,
                resourceTip = "Dica: Crie um ambiente multi-container rodando uma API Node.js e um banco PostgreSQL."
            ),
            TrailStep(
                id = "do-3",
                title = "3. Fundamentos de Cloud Computing (AWS)",
                description = "Serviços essenciais da AWS: instâncias EC2 (máquinas virtuais), armazenamento S3, redes VPC e grupos de segurança (Security Groups).",
                category = "Nuvem",
                estimatedHours = 40,
                resourceTip = "Dica: Suba um servidor web gratuito no nível gratuito (Free Tier) da AWS."
            ),
            TrailStep(
                id = "do-4",
                title = "4. Pipelines de Integração e Entrega Contínua (CI/CD)",
                description = "Automação de testes e build com GitHub Actions sempre que um novo código é enviado para a branch principal.",
                category = "Automação",
                estimatedHours = 35,
                resourceTip = "Dica: Crie um workflow no GitHub Actions que executa testes unitários automaticamente."
            ),
            TrailStep(
                id = "do-5",
                title = "5. Monitoramento, Logs e Preparação para Certificação",
                description = "Monitoramento de uso de CPU/Memória, leitura de métricas com Prometheus/Grafana e preparação para certificações Cloud Practitioner.",
                category = "Operações & Carreira",
                estimatedHours = 25,
                resourceTip = "Dica: Realize simulados gratuitos da certificação AWS Certified Cloud Practitioner."
            )
        )
    )

    // 10. Trilha: Marketing Digital & Redes Sociais
    private val marketingDigitalTrail = CareerTrail(
        id = "trilha-marketing",
        title = "Especialista em Marketing Digital & Redes Sociais",
        targetRole = "Assistente de Marketing Digital",
        description = "Aprenda a planejar estratégias de atração, produzir conteúdo persuasivo para redes sociais, gerenciar tráfego pago e analisar conversões.",
        category = "Comunicação & Vendas",
        estimatedMonths = 3,
        level = SkillLevel.INICIANTE,
        salaryRange = "R$ 2.200 - R$ 3.500",
        marketDemand = "Porta de Entrada Rápida 🚀",
        keySkills = listOf("Inbound Marketing", "Copywriting", "Canva / Design", "Meta Ads", "Google Analytics"),
        mockJobs = listOf(
            JobOpportunity(
                id = "job-mkt-1",
                title = "Assistente de Mídias Sociais & Conteúdo",
                company = "Agência Impacto Digital",
                location = "100% Remoto",
                salary = "R$ 2.500 CLT",
                matchScore = 98
            ),
            JobOpportunity(
                id = "job-mkt-2",
                title = "Estágio em Tráfego Pago & Marketing",
                company = "E-Commerce Moda Jovem",
                location = "Híbrido - Rio de Janeiro / RJ",
                salary = "R$ 1.800 + VT/VR",
                matchScore = 92
            )
        ),
        steps = listOf(
            TrailStep(
                id = "mkt-1",
                title = "1. Introdução ao Inbound Marketing & Funil de Vendas",
                description = "Etapas do funil (Atração, Consideração, Decisão), definição de público-alvo e propostas de valor diferenciadas.",
                category = "Fundamentos",
                estimatedHours = 15,
                resourceTip = "Dica: Mapeie os conteúdos necessários para cada fase do funil de uma marca fictícia."
            ),
            TrailStep(
                id = "mkt-2",
                title = "2. Copywriting & Criação de Conteúdo",
                description = "Técnicas de escrita persuasiva (AIDA), criação de chamadas para ação (CTAs), roteiros de vídeos curtos e artes com Canva.",
                category = "Criação & Conteúdo",
                estimatedHours = 25,
                resourceTip = "Dica: Escreva 5 variações de títulos persuasivos para o anúncio de um curso profissionalizante."
            ),
            TrailStep(
                id = "mkt-3",
                title = "3. Tráfego Pago com Meta Ads (Instagram/Facebook)",
                description = "Estrutura de campanhas, conjuntos de anúncios, segmentação por interesse e localização, e controle de orçamento diário.",
                category = "Tráfego Pago",
                estimatedHours = 30,
                resourceTip = "Dica: Explore o Gerenciador de Anúncios da Meta para entender os objetivos de campanha."
            ),
            TrailStep(
                id = "mkt-4",
                title = "4. Métricas de Desempenho & Google Analytics",
                description = "Análise de métricas fundamentais: CTR (Taxa de Cliques), CPC (Custo por Clique), CPA (Custo por Aquisição) e ROI/ROAS.",
                category = "Métricas & Análise",
                estimatedHours = 20,
                resourceTip = "Dica: Monte um relatório semanal em Excel com o desempenho de cliques e engajamento."
            ),
            TrailStep(
                id = "mkt-5",
                title = "5. Projeto Prático: Plano de Marketing Completo",
                description = "Desenvolvimento de um plano de marketing de 30 dias para um pequeno comércio local ou projeto de impacto social.",
                category = "Projeto Final",
                estimatedHours = 20,
                resourceTip = "Dica: Apresente o plano com metas claras de crescimento e orçamento simulado."
            )
        )
    )

    /**
     * Retorna todas as 10 trilhas do catálogo.
     */
    fun getAllTrails(): List<CareerTrail> {
        return listOf(
            frontendTrail,
            backendTrail,
            mobileTrail,
            suporteTechTrail,
            dataAnalyticsTrail,
            uiUxDesignTrail,
            qaTrail,
            cyberSecurityTrail,
            devOpsTrail,
            marketingDigitalTrail
        )
    }

    /**
     * Busca uma trilha específica pelo ID único.
     */
    fun getTrailById(id: String): CareerTrail? {
        return getAllTrails().find { it.id == id }
    }

    /**
     * Motor de Recomendação Inteligente (Mock):
     * Mapeia o interesse do usuário com base em palavras-chave para a trilha mais adequada.
     */
    fun getRecommendedTrail(chosenArea: String): CareerTrail {
        return getRecommendedTrailForInterest(chosenArea)
    }

    fun getRecommendedTrailForInterest(interest: String): CareerTrail {
        val lower = interest.lowercase()
        return when {
            lower.contains("mobile") || lower.contains("android") || lower.contains("kotlin") || lower.contains("app") -> mobileTrail
            lower.contains("front") || lower.contains("web") || lower.contains("react") -> frontendTrail
            lower.contains("back") || lower.contains("api") || lower.contains("servidor") -> backendTrail
            lower.contains("suporte") || lower.contains("rede") || lower.contains("infra") || lower.contains("hardware") || lower.contains("helpdesk") -> suporteTechTrail
            lower.contains("dado") || lower.contains("bi") || lower.contains("analis") || lower.contains("power bi") -> dataAnalyticsTrail
            lower.contains("ux") || lower.contains("ui") || lower.contains("design") || lower.contains("figma") -> uiUxDesignTrail
            lower.contains("qa") || lower.contains("teste") || lower.contains("qualidade") || lower.contains("cypress") -> qaTrail
            lower.contains("segurança") || lower.contains("ciber") || lower.contains("cyber") || lower.contains("soc") || lower.contains("hacker") -> cyberSecurityTrail
            lower.contains("devops") || lower.contains("cloud") || lower.contains("aws") || lower.contains("docker") -> devOpsTrail
            lower.contains("mkt") || lower.contains("marketing") || lower.contains("social") || lower.contains("tráfego") -> marketingDigitalTrail
            else -> frontendTrail // Trilha padrão
        }
    }
}
